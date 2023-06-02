package com.demo.RatingDemo.service;

import com.demo.RatingDemo.dao.GameRepository;
import com.demo.RatingDemo.entity.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameServiceImpl implements GameService {

    private GameRepository gameRepository;

    @Autowired
    public GameServiceImpl(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Override
    public Game save(Game game) {
        return gameRepository.save(game);
    }

    @Override
    public void deleteGame(int id) {
        gameRepository.deleteById(id);
    }

    @Override
    public void deleteAllGames() {
        gameRepository.deleteAll();
    }

    @Override
    public void deleteGamesByPlayer(int id) {
        List<Game> gamesToDelete = gameRepository.findGamesByPlayerID(id);
        gameRepository.deleteAll(gamesToDelete);
    }

    @Override
    public Game findGame(int id) {
        return gameRepository.findById(id).get();
    }

    @Override
    public List<Game> findAllGames() {
        return gameRepository.findAll();
    }

    @Override
    public List<Game> findGamesByPlayerID(int id) {
        return gameRepository.findGamesByPlayerID(id);
    }

    @Override
    public void safeAddGame(String winner, String loser) {

    }
}
