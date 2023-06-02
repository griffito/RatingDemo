package com.demo.RatingDemo.dao;

import com.demo.RatingDemo.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Integer>, CustomizedGameRepository {

}
