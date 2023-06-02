package com.demo.RatingDemo.dao;

import com.demo.RatingDemo.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Integer>, CustomizedPlayerRepository {

}
