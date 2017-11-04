CREATE TABLE users (
  id        BIGINT GENERATED BY DEFAULT AS IDENTITY (START WITH 1),
  email     VARCHAR(255),
  password  VARCHAR(255),
  PRIMARY KEY (id)
);

CREATE TABLE movies (
  id        BIGINT GENERATED BY DEFAULT AS IDENTITY (START WITH 1),
  title     VARCHAR(255),
  price     INT,
  PRIMARY KEY (id)
);

CREATE TABLE rooms (
  id        BIGINT GENERATED BY DEFAULT AS IDENTITY (START WITH 1),
  number    INT,
  capacity  INT,
  PRIMARY KEY (id)
);

CREATE TABLE shows (
  id        BIGINT GENERATED BY DEFAULT AS IDENTITY (START WITH 1),
  date      TIMESTAMP,
  room_id   BIGINT,
  movie_id  BIGINT,
  PRIMARY KEY (id),
  CONSTRAINT FKT1333520 FOREIGN KEY (room_id) REFERENCES rooms(id),
  CONSTRAINT FKT1333521 FOREIGN KEY (movie_id) REFERENCES movies(id)
);

CREATE TABLE reservations (
  id        BIGINT GENERATED BY DEFAULT AS IDENTITY (START WITH 1),
  status    VARCHAR(255),
  user_id   BIGINT,
  show_id   BIGINT,
  PRIMARY KEY (id),
  CONSTRAINT FKT1333522 FOREIGN KEY (user_id) REFERENCES users(id),
  CONSTRAINT FKT1333523 FOREIGN KEY (show_id) REFERENCES shows(id)
);