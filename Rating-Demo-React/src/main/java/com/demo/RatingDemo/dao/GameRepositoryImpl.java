package com.demo.RatingDemo.dao;

import com.demo.RatingDemo.entity.Game;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class GameRepositoryImpl implements  CustomizedGameRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Game> findGamesByPlayerID(int id) {
        TypedQuery<Game> query = entityManager.createQuery(
                "FROM Game WHERE loserID=:idParam OR winnerID=:idParam", Game.class);
        query.setParameter("idParam", id);
        return query.getResultList();
    }
}
