package com.demo.RatingDemo.rest;


import java.util.List;

import com.demo.RatingDemo.entity.Game;
import com.demo.RatingDemo.entity.Player;
import com.demo.RatingDemo.service.GameService;
import com.demo.RatingDemo.service.PlayerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/rating")
public class RatingController {

    private GameService gameService;
    private PlayerService playerService;

    public RatingController(GameService gameService, PlayerService playerService) {
        this.gameService = gameService;
        this.playerService = playerService;
    }

    @GetMapping("/playerlist")
    public String list(Model model) {
        List<Player> players = playerService.findAllPlayers();
        model.addAttribute("players", players);
        return "players/list-players";
    }

    @GetMapping("/regenerate")
    public String regenerateRatings() {
        playerService.regenerateRatings(gameService);
        return "redirect:/rating/playerlist";
    }

    @GetMapping("/deleteplayer")
    public String deletePlayer(@RequestParam("playerID") int id) {
        playerService.safeDeletePlayer(gameService, id);
        return "redirect:/rating/playerlist";
    }

    @GetMapping("/updateplayer")
    public String updatePlayerForm(@RequestParam("playerID") int id, Model model) {
        Player player = playerService.findPlayerByID(id);
        model.addAttribute("player", player);
        return "players/player-form";
    }

    @PostMapping("/saveplayer")
    public String savePlayer(@ModelAttribute("player") Player player) {
        playerService.savePlayer(player);
        playerService.regenerateRatings(gameService);
        return "redirect:/rating/playerlist";
    }

    @GetMapping("/gamelist")
    public String gameList(Model model) {
        List<Game> games = gameService.findAllGames();
        model.addAttribute("games", games);
        List<Player> players = playerService.findAllPlayers();
        model.addAttribute("players", players);
        return "games/list-games";
    }

    @GetMapping("/deletegame")
    public String deleteGame(@RequestParam("gameID") int id) {
        gameService.deleteGame(id);
        playerService.regenerateRatings(gameService);
        return "redirect:/rating/gamelist";
    }

    @GetMapping("/savegameform")
    public String saveGameForm(Model model) {
        Game newGame = new Game();
        model.addAttribute("game", newGame);
        return "games/game-form";
    }

    @PostMapping("/savegame")
    public String saveGame(@ModelAttribute("game") Game game) {
        gameService.save(game);
        playerService.regenerateRatings(gameService);
        return "redirect:/rating/gamelist";
    }

}
