CREATE SEQUENCE
    hibernate_sequence
    INCREMENT BY 1
    MINVALUE 1
    NO CYCLE;


CREATE TABLE  t_persons (
    id BIGSERIAL PRIMARY KEY,
    first_name varchar(150) NOT NULL,
    last_name varchar(150) NOT NULL,
    gender varchar(150) NOT NULL,
    biography varchar(2048),
    person_height REAL,
    photo varchar,
    country VARCHAR,
    birth_place VARCHAR,
    birth_date DATE NOT NULL,
    death_date DATE,
    place_of_death VARCHAR
);


CREATE TABLE t_roles(
    id BIGSERIAL PRIMARY KEY,
    role_name varchar(100) NOT NULL UNIQUE
);


CREATE TABLE t_person_roles(
    id BIGSERIAL PRIMARY KEY,
    person_id int8 NOT NULL,
    role_id int8 NOT NULL
);


CREATE TABLE t_movies(
    id BIGSERIAL PRIMARY KEY,
    movie_title varchar(150) NOT NULL,
    description varchar(2048) NOT NULL,
    slogan varchar(400) NOT NULL,
    budget int8,
    duration int4,
    premiere_date date,
    year_of_production date NOT NULL,
    rating_mppa varchar(30),
    original_language varchar(50),
    box_office int8 NOT NULL
);


CREATE TABLE t_movies_t_persons_roles(
    id BIGSERIAL PRIMARY KEY,
    person_roles_id int8 NOT NULL,
    movie_id int8 NOT NULL,
    personage_name varchar(150)
);


CREATE TABLE t_countries(
    id BIGSERIAL PRIMARY KEY,
    country_name varchar(100) NOT NULL
);


CREATE TABLE t_genres(
    id BIGSERIAL PRIMARY KEY,
    genre_name varchar(100) NOT NULL
);


CREATE TABLE t_persons_countries(
    id BIGSERIAL PRIMARY KEY,
    country_id int8 NOT NULL,
    person_id int8 NOT NULL
);


CREATE TABLE t_movies_countries(
    id BIGSERIAL PRIMARY KEY,
    country_id int8 NOT NULL,
    movie_id int8 NOT NULL
);


CREATE TABLE t_movies_genres(
    id BIGSERIAL PRIMARY KEY,
    genre_id int8 NOT NULL,
    movie_id int8 NOT NULL
);


CREATE TABLE t_companies(
    id BIGSERIAL PRIMARY KEY,
    company_name varchar(100) NOT NULL
);


CREATE TABLE t_movies_companies(
    id BIGSERIAL PRIMARY KEY,
    movie_id int8 NOT NULL,
    company_id int8 NOT NULL,
    company_function varchar(100) NOT NULL
);


CREATE TABLE t_users(
    id BIGSERIAL PRIMARY KEY,
    email varchar(150) NOT NULL,
    first_name varchar (150) NOT NULL,
    last_name varchar (150) NOT NULL,
    username varchar (150) NOT NULL,
    user_role_id int8 NOT NULL
);


CREATE TABLE t_users_movie_ratings(
    id BIGSERIAL PRIMARY KEY,
    movie_id int8 NOT NULL,
    user_id int8 NOT NULL,
    score real NOT NULL
);


CREATE TABLE t_users_movie_preferences(
    id BIGSERIAL PRIMARY KEY,
    movie_id int8 NOT NULL,
    user_id int8 NOT NULL,
    preference_decision varchar(100) NOT NULL
);



CREATE TABLE t_user_roles(
    id BIGSERIAL PRIMARY KEY,
    role_type varchar(100) NOT NULL
);


CREATE TABLE t_users_t_user_roles(
    id BIGSERIAL PRIMARY KEY,
    user_id int8 NOT NULL,
    role_id int8 NOT NULL
);

CREATE TABLE t_articles(
    id BIGSERIAL PRIMARY KEY,
    article_title varchar (100) NOT NULL,
    content varchar(2048) NOT NULL,
    movie_id int8 NOT NULL,
    user_id int8 NOT NULL,
    movie_score int4 NOT NULL,
    publication_date date NOT NULL,
    positive_review_rating int8,
    negative_review_rating int8
);


CREATE TABLE t_comments(
    id BIGSERIAL PRIMARY KEY,
    user_id int8 NOT NULL,
    comment_date date NOT NULL,
    content varchar(2048) NOT NULL,
    is_deleted boolean,
    positive_review_rating int8,
    negative_review_rating int8
);


CREATE TABLE t_reviews(
    id BIGSERIAL PRIMARY KEY,
    review_title varchar (100) NOT NULL,
    content varchar(2048) NOT NULL,
    movie_id int8 NOT NULL,
    user_id int8 NOT NULL,
    movie_score int4 NOT NULL,
    publication_date DATE NOT NULL,
    positive_review_rating int8,
    negative_review_rating int8
);


CREATE TABLE t_review_comments(
    id BIGSERIAL PRIMARY KEY,
    comment_id int8 NOT NULL,
    review_id int8 NOT NULL
);


CREATE TABLE t_article_comments(
    id BIGSERIAL PRIMARY KEY,
    comment_id int8 NOT NULL UNIQUE,
    article_id int8 NOT NULL
);

ALTER TABLE IF EXISTS t_users_t_user_roles ADD CONSTRAINT fk_t_users_user_role_user_id FOREIGN KEY (user_id) REFERENCES t_users;
ALTER TABLE IF EXISTS t_users_t_user_roles ADD CONSTRAINT fk_t_users_user_role_role_id FOREIGN KEY (role_id) REFERENCES t_user_roles;
ALTER TABLE IF EXISTS t_person_roles ADD CONSTRAINT fk_t_person_roles_person_id FOREIGN KEY (person_id) REFERENCES t_persons;
ALTER TABLE IF EXISTS t_person_roles ADD CONSTRAINT fk_t_person_roles_role_id FOREIGN KEY (role_id) REFERENCES t_roles;
ALTER TABLE IF EXISTS t_movies_t_persons_roles ADD CONSTRAINT fk_t_mpr_person_roles_id FOREIGN KEY(person_roles_id) REFERENCES t_person_roles;
ALTER TABLE IF EXISTS t_movies_t_persons_roles ADD CONSTRAINT fk_t_mpr_movie_id FOREIGN KEY(movie_id) REFERENCES t_movies;
ALTER TABLE IF EXISTS t_persons_countries ADD CONSTRAINT fk_t_persons_countries_person_id FOREIGN KEY (person_id) REFERENCES t_persons;
ALTER TABLE IF EXISTS t_persons_countries ADD CONSTRAINT fk_t_persons_countries_country_id FOREIGN KEY (country_id) REFERENCES t_countries;
ALTER TABLE IF EXISTS t_movies_countries ADD CONSTRAINT fk_t_movies_countries_movie_id FOREIGN KEY (movie_id) REFERENCES t_movies;
ALTER TABLE IF EXISTS t_movies_countries ADD CONSTRAINT fk_t_movies_countries_country_id FOREIGN KEY (country_id) REFERENCES t_countries;
ALTER TABLE IF EXISTS t_movies_genres ADD CONSTRAINT fk_t_movies_genres_movie_id FOREIGN KEY (movie_id) REFERENCES t_movies;
ALTER TABLE IF EXISTS t_movies_genres ADD CONSTRAINT fk_t_movies_genres_genre_id FOREIGN KEY (genre_id) REFERENCES t_genres;
ALTER TABLE IF EXISTS t_movies_companies ADD CONSTRAINT fk_t_movies_companies_movie_id FOREIGN KEY(movie_id) REFERENCES t_movies;
ALTER TABLE IF EXISTS t_movies_companies ADD CONSTRAINT fk_t_movies_companies_company_id FOREIGN KEY(company_id) REFERENCES t_companies;
ALTER TABLE IF EXISTS t_users_movie_ratings ADD CONSTRAINT fk_t_umr_user_id FOREIGN KEY (user_id) REFERENCES t_users;
ALTER TABLE IF EXISTS t_users_movie_ratings ADD CONSTRAINT fk_t_umr_movie_id FOREIGN KEY (movie_id) REFERENCES t_movies;
ALTER TABLE IF EXISTS t_users_movie_preferences ADD CONSTRAINT fk_t_ump_user_id FOREIGN KEY (user_id) REFERENCES t_users;
ALTER TABLE IF EXISTS t_users_movie_preferences ADD CONSTRAINT fk_t_ump_movie_id FOREIGN KEY (movie_id) REFERENCES t_movies;
ALTER TABLE IF EXISTS t_articles ADD CONSTRAINT fk_t_articles_user_id FOREIGN KEY (user_id) REFERENCES t_users;
ALTER TABLE IF EXISTS t_articles ADD CONSTRAINT fk_t_articles_movie_id FOREIGN KEY (movie_id) REFERENCES t_movies;
ALTER TABLE IF EXISTS t_comments ADD CONSTRAINT fk_t_comments_user_id FOREIGN KEY(user_id) REFERENCES t_users;
ALTER TABLE IF EXISTS t_reviews ADD CONSTRAINT fk_t_reviews_user_id FOREIGN KEY(user_id) REFERENCES t_users;
ALTER TABLE IF EXISTS t_reviews ADD CONSTRAINT fk_t_reviews_movie_id FOREIGN KEY(movie_id) REFERENCES t_movies;
ALTER TABLE IF EXISTS t_review_comments ADD CONSTRAINT fk_t_review_comments_review_id  FOREIGN KEY (review_id) REFERENCES t_reviews;
ALTER TABLE IF EXISTS t_review_comments ADD CONSTRAINT fk_t_review_comments_comment_id FOREIGN KEY (comment_id) REFERENCES t_comments;
ALTER TABLE IF EXISTS t_article_comments ADD CONSTRAINT fk_t_article_comments_article_id  FOREIGN KEY (article_id) REFERENCES t_articles;
ALTER TABLE IF EXISTS t_article_comments ADD CONSTRAINT fk_t_article_comments_comment_id FOREIGN KEY (comment_id) REFERENCES t_comments;



