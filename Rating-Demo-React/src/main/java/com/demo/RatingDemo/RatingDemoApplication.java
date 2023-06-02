package com.demo.RatingDemo;

import com.demo.RatingDemo.entity.Game;
import com.demo.RatingDemo.entity.Player;
import com.demo.RatingDemo.service.GameService;
import com.demo.RatingDemo.service.PlayerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class RatingDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RatingDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(GameService gameService, PlayerService playerService) {
		return runner -> {
			System.out.println("Hello world");
			createSampleData(gameService, playerService);
		};
	}

	private void createSampleData(GameService gameService, PlayerService playerService) {
		List<Player> players = new ArrayList<>();

		players.add(new Player("David", 1000));
		players.add(new Player("Steven", 1000));
		players.add(new Player("Mary", 1000));

		for(Player player : players) {
			playerService.savePlayer(player);
		}

		int player1ID = playerService.findPlayersByName("David").get(0).getId();
		int player2ID = playerService.findPlayersByName("Steven").get(0).getId();
		int player3ID = playerService.findPlayersByName("Mary").get(0).getId();

		List<Game> games = new ArrayList<>();
		games.add(new Game(player1ID, player2ID));
		games.add(new Game(player1ID, player3ID));
		games.add(new Game(player2ID, player3ID));

		for(Game game: games) {
			gameService.save(game);
		}

		playerService.regenerateRatings(gameService);
	}
}
