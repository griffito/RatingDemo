package com.demo.RatingDemo.service;

import com.demo.RatingDemo.entity.Game;

import java.util.List;

public interface GameService {
    Game save(Game game);

    void deleteGame(int id);

    void deleteAllGames();

    void deleteGamesByPlayer(int id);

    Game findGame(int id);

    List<Game> findAllGames();

    List<Game> findGamesByPlayerID(int id);

    void safeAddGame(String winner, String loser);
}
