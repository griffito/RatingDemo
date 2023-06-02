package com.demo.RatingDemo.dao;

import com.demo.RatingDemo.entity.Game;

import java.util.List;

public interface CustomizedGameRepository {

    List<Game> findGamesByPlayerID(int id);
}
