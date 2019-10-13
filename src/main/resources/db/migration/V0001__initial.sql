DROP TABLE IF EXISTS test_data, movie, rating, catalog_item;


CREATE TABLE test_data (
 value VARCHAR(25) NOT NULL PRIMARY KEY
);

CREATE TABLE movie(
  movie_id INTEGER PRIMARY KEY,
  name VARCHAR(25),
  description VARCHAR(25)
);

CREATE TABLE rating(
  movie_id INTEGER,
  rating INTEGER PRIMARY KEY,
  user_id INTEGER,
  FOREIGN KEY (movie_id) REFERENCES public.movie (movie_id)
);

CREATE TABLE catalog_item (
 movie_id INTEGER,
 name VARCHAR(25),
 description VARCHAR(25),
 rating INTEGER,
 FOREIGN KEY (movie_id) REFERENCES public.movie (movie_id),
 FOREIGN KEY (rating) REFERENCES public.rating (rating)
);

insert into movie (movie_id, name, description) values (101,'Movie-1', 'movie-1-desc');
insert into movie (movie_id, name, description) values (102,'Movie-2', 'movie-2-desc');
insert into movie (movie_id, name, description) values (103,'Movie-3', 'movie-3-desc');
insert into movie (movie_id, name, description) values (104,'Movie-4', 'movie-4-desc');
insert into movie (movie_id, name, description) values (105,'Movie-5', 'movie-5-desc');

insert into rating (movie_id, rating, user_id) values (101,11,501);
insert into rating (movie_id, rating, user_id) values (102,12,502);
insert into rating (movie_id, rating, user_id) values (103,13,503);
insert into rating (movie_id, rating, user_id) values (104,14,504);
insert into rating (movie_id, rating, user_id) values (105,15,505);

insert into catalog_item (movie_id, name, description, rating) values (101,'Movie-1', 'movie-1-desc',11);
insert into catalog_item (movie_id, name, description, rating) values (102,'Movie-2', 'movie-2-desc',12);
insert into catalog_item (movie_id, name, description, rating) values (103,'Movie-3', 'movie-3-desc',13);
insert into catalog_item (movie_id, name, description, rating) values (104,'Movie-4', 'movie-4-desc',14);
insert into catalog_item (movie_id, name, description, rating) values (105,'Movie-5', 'movie-5-desc',15);
