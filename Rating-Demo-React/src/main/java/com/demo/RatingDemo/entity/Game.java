package com.demo.RatingDemo.entity;

import jakarta.persistence.*;

@Entity
@Table(name="games")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="loser_id")
    private int loserID;

    @Column(name="winner_id")
    private int winnerID;

    public Game() {

    }

    public Game(int loserID, int winnerID) {
        this.loserID = loserID;
        this.winnerID = winnerID;
    }

    public int getWinnerID() {
        return winnerID;
    }

    public void setWinnerID(int winnerID) {
        this.winnerID = winnerID;
    }

    public int getLoserID() {
        return loserID;
    }

    public void setLoserID(int loserID) {
        this.loserID = loserID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
