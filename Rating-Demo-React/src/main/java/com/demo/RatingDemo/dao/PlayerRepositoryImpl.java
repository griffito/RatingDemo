package com.demo.RatingDemo.dao;

import com.demo.RatingDemo.entity.Player;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class PlayerRepositoryImpl implements  CustomizedPlayerRepository{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Player> findPlayersByName(String name) {
        TypedQuery<Player> query = entityManager.createQuery(
                "FROM Player WHERE name=:nameParam", Player.class);
        query.setParameter("nameParam", name);
        return query.getResultList();
    }
}
