DROP TABLE IF EXISTS clients;
CREATE TABLE clients (
  id       INTEGER NOT NULL AUTO_INCREMENT,
  name VARCHAR(50) NOT NULL,
  PRIMARY KEY (id)
);