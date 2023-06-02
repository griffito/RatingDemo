package com.demo.RatingDemo.service;

import com.demo.RatingDemo.dao.PlayerRepository;
import com.demo.RatingDemo.entity.Game;
import com.demo.RatingDemo.entity.Player;
import com.demo.RatingDemo.utility.ELOCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerServiceImpl implements  PlayerService {

    private static final int BASE_RATING = 1000;
    private static final int RATING_INCREMENT = 50;

    private PlayerRepository playerRepository;

    @Autowired
    public PlayerServiceImpl(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public Player savePlayer(Player player) {
        return playerRepository.save(player);
    }

    @Override
    public void updatePlayer(Player player) {
        playerRepository.save(player);
    }

    @Override
    public void deleteAllPlayers() {
        playerRepository.deleteAll();
    }

    @Override
    public void deletePlayer(int id) {
        playerRepository.deleteById(id);
    }

    @Override
    public Player findPlayerByID(int id) {
        return playerRepository.findById(id).get();
    }

    @Override
    public List<Player> findAllPlayers() {
        return playerRepository.findAll();
    }

    @Override
    public List<Player> findPlayersByName(String name) {
        return playerRepository.findPlayersByName(name);
    }

    @Override
    public void regenerateRatings(GameService gameService) {
        for(Player player : findAllPlayers()) {
            player.setRating(BASE_RATING);
            playerRepository.save(player);
        }

        for(Game game : gameService.findAllGames()) {
            Player loser = findPlayerByID(game.getLoserID());
            Player winner = findPlayerByID(game.getWinnerID());
            updateRatingsForPlayers(loser, winner);
        }
    }

    @Override
    public void safeDeletePlayer(GameService gameService, int playerIDToDelete) {
         for(Game game : gameService.findGamesByPlayerID(playerIDToDelete)) {
             gameService.deleteGame(game.getId());
         }
         playerRepository.deleteById(playerIDToDelete);
         regenerateRatings(gameService);
    }

    @Override
    public void updateRatingsForPlayers(Player loser, Player winner) {

        ELOCalculator.updateRatings(winner, loser);
        playerRepository.save(loser);

        playerRepository.save(winner);
    }

}
