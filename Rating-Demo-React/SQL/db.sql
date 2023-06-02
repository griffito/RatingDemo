CREATE DATABASE IF NOT EXISTS `rating_db`;
USE `rating_db`;

DROP TABLE IF EXISTS `players`;

CREATE TABLE `players` (
    `id` int NOT NULL AUTO_INCREMENT,
    `name` varchar(60) NOT NULL,
    `rating` int NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin;

DROP TABLE IF EXISTS `games`;

CREATE TABLE `games` (
    `id` int NOT NULL AUTO_INCREMENT,
    `loser_id` int NOT NULL,
    `winner_id` int NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (loser_id) REFERENCES players(id),
    FOREIGN KEY (winner_id) REFERENCES players(id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin;

