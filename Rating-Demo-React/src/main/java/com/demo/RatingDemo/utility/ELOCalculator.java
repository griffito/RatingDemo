package com.demo.RatingDemo.utility;

import com.demo.RatingDemo.entity.Player;

public class ELOCalculator {

    private static int MULT_CONST = 200;

    public static void updateRatings(Player winner, Player loser) {
        double winnerProb = calculateProbability(winner.getRating(), loser.getRating());
        double loserProb = calculateProbability(loser.getRating(), winner.getRating());

        double winnerRating = winner.getRating() + MULT_CONST * (1 - winnerProb);
        double loserRating = loser.getRating() + MULT_CONST * (0 - loserProb);

        winner.setRating((int) winnerRating);
        loser.setRating((int) loserRating);
    }

    private static double calculateProbability(int ratingToCalculate, int opponentRating) {
        return 1.0f * 1.0f / (1 + 1.0f) * Math.pow(10, 1.0f * (opponentRating - ratingToCalculate) / 400);
    }
}
