package com.demo.RatingDemo.rest;

import com.demo.RatingDemo.entity.Game;
import com.demo.RatingDemo.entity.Player;
import com.demo.RatingDemo.service.GameService;
import com.demo.RatingDemo.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RatingRestController {

    private GameService gameService;
    private PlayerService playerService;

    @Autowired
    public RatingRestController(GameService gameService, PlayerService playerService) {
        this.gameService = gameService;
        this.playerService = playerService;
    }

    @GetMapping("/players")
    public List<Player> getAllPlayers() {
        return playerService.findAllPlayers();
    }

    @GetMapping("/players/{playerID}")
    public Player getPlayer(@PathVariable int playerID) {
        Player player = playerService.findPlayerByID(playerID);
        if(player == null) {
            throw new RuntimeException("Player not found: " + playerID);
        }
        return player;
    }

    @GetMapping("/games")
    public List<Game> getAllGames() {
        return gameService.findAllGames();
    }

    @GetMapping("/games/{gameID}")
    public Game getGame(@PathVariable int gameID) {
        Game game = gameService.findGame(gameID);
        if(game == null) {
            throw new RuntimeException("Player not found: " + gameID);
        }
        return game;
    }

    @GetMapping("/regenerate")
    public List<Player> regenerateRatings() {
        playerService.regenerateRatings(gameService);
        return getAllPlayers();
    }

    @PostMapping("/players")
    public Player addPlayer(@RequestBody Player player) {
        player.setId(0);
        Player persistedPlayer = playerService.savePlayer(player);
        playerService.regenerateRatings(gameService);
        return persistedPlayer;
    }

    @PostMapping("/games")
    public Game addGame(@RequestBody Game game) {
        game.setId(0);
        Game persistedGame = gameService.save(game);
        playerService.regenerateRatings(gameService);
        return persistedGame;
    }

    @PutMapping("/players")
    public Player updatePlayer(@RequestBody Player player) {
        Player persistedPlayer = playerService.savePlayer(player);
        playerService.regenerateRatings(gameService);
        return persistedPlayer;
    }

    @PutMapping("/games")
    public Game updateGame(@RequestBody Game game) {
        Game persistedGame = gameService.save(game);
        playerService.regenerateRatings(gameService);
        return persistedGame;
    }

    @DeleteMapping("/players/{playerID}")
    public String deletePlayer(@PathVariable int playerID) {
        Player player = playerService.findPlayerByID(playerID);
        if(player == null) {
            throw new RuntimeException("Player not found: " + playerID);
        }
        playerService.safeDeletePlayer(gameService, playerID);
        return "Deleted player: " + playerID;
    }

    @DeleteMapping("/games/{gameID}")
    public String deleteGame(@PathVariable int gameID) {
        Game game = gameService.findGame(gameID);
        if(game == null) {
            throw new RuntimeException("Player not found: " + gameID);
        }
        gameService.deleteGame(gameID);
        playerService.regenerateRatings(gameService);
        return "Deleted game: " + game;
    }
}
