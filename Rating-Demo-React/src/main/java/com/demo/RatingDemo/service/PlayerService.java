package com.demo.RatingDemo.service;

import com.demo.RatingDemo.entity.Player;

import java.util.List;

public interface PlayerService {
    Player savePlayer(Player player);

    void updatePlayer(Player player);

    void deleteAllPlayers();

    void deletePlayer(int id);

    Player findPlayerByID(int id);

    List<Player> findAllPlayers();

    List<Player> findPlayersByName(String name);

    void regenerateRatings(GameService gameService);

    void updateRatingsForPlayers(Player loser, Player winner);

    void safeDeletePlayer(GameService gameService, int playerIDToDelete);
}
