ALTER TABLE public.rating DROP CONSTRAINT rating_pkey CASCADE;

insert into rating (movie_id, rating, user_id) values (102,12,501);
