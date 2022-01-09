DROP TABLE IF EXISTS drink CASCADE;
CREATE TABLE `drink` (
  `id` int NOT NULL AUTO_INCREMENT,
  `contains_sugar` bit(1) NOT NULL,
  `fizzy` bit(1) NOT NULL,
  `manufacturer` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `volume` int NOT NULL,
  `year_introduced` int NOT NULL,
  PRIMARY KEY (`id`)
);