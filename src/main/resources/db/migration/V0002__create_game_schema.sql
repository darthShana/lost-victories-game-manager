CREATE TABLE games(
  id varchar(36) PRIMARY KEY,
  name VARCHAR(255),
  creation_date DATE
);

CREATE TABLE players(
  id varchar(36) PRIMARY KEY,
  fk_game VARCHAR(36),
  fk_user VARCHAR(36),
  country VARCHAR(100)
);

ALTER TABLE players ADD CONSTRAINT fk_user FOREIGN KEY (fk_user) REFERENCES users(id);
ALTER TABLE players ADD CONSTRAINT fk_game FOREIGN KEY (fk_game) REFERENCES games(id);