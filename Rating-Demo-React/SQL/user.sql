DROP USER if exists 'springuser'@'localhost';

CREATE USER 'springuser'@'localhost' IDENTIFIED BY 'springuser';

GRANT ALL PRIVILEGES ON * . * TO 'springuser'@'localhost';