ALTER TABLE IF EXISTS t_articles
    RENAME COLUMN positive_review_rating TO positive_article_rating;

ALTER TABLE IF EXISTS t_articles
    RENAME COLUMN  negative_review_rating TO negative_article_rating;

ALTER TABLE IF EXISTS t_comments
    RENAME COLUMN positive_review_rating TO positive_comment_rating;

ALTER TABLE IF EXISTS t_comments
    RENAME COLUMN negative_review_rating TO negative_comment_rating;

ALTER TABLE IF EXISTS t_movies ADD COLUMN image varchar(150);
