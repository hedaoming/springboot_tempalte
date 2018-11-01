CREATE TABLE pets (
  id         integer PRIMARY KEY auto_increment,
  name       VARCHAR(30),
  birth_date DATE,
  type_id    INTEGER NOT NULL,
  owner_id   INTEGER NOT NULL
);