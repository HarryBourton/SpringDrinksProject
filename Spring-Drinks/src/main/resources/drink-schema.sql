CREATE TABLE `drink` (
  `id` int NOT NULL AUTO_INCREMENT,
  `contains_sugar` bit(1) NOT NULL,
  `is_fizzy` bit(1) NOT NULL,
  `manufacturer` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `volume` int NOT NULL,
  `year_introduced` int NOT NULL,
  `fizzy` bit(1) NOT NULL,
  PRIMARY KEY (`id`)
);