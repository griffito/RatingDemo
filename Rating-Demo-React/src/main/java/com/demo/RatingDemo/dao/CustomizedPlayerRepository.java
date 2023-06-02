package com.demo.RatingDemo.dao;

import com.demo.RatingDemo.entity.Player;

import java.util.List;

public interface CustomizedPlayerRepository {
    List<Player> findPlayersByName(String name);
}
