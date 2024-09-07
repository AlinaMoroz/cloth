CREATE TABLE news_lines
(
    id        BIGSERIAL PRIMARY KEY,
    post_date TIMESTAMP,
    like_count      int,
    dislike_count   int
);

CREATE TABLE sets
(
    id           BIGSERIAL PRIMARY KEY,
    description  VARCHAR(255),
    news_line_id BIGINT REFERENCES news_lines (id),
    name         VARCHAR(128)
);

CREATE TABLE users
(
    id       BIGSERIAL PRIMARY KEY,
    name     VARCHAR(128),
    email    VARCHAR(255) UNIQUE,
    password VARCHAR(255),
    avatar   VARCHAR(255),
    size     VARCHAR(16)
);

CREATE TABLE comments
(
    id           BIGSERIAL PRIMARY KEY,
    user_id      BIGINT REFERENCES users(id),
    text         VARCHAR(512),
    date_post    TIMESTAMP,
    news_line_id BIGINT REFERENCES news_lines(id)
);

CREATE TABLE clothes
(
    id         BIGSERIAL PRIMARY KEY,
    user_id   BIGINT REFERENCES users(id) ,
    link_photo varchar(255),
    season     varchar(32),
    type       varchar(64)
);

CREATE TABLE sets_clothes
(
    id       BIGSERIAL PRIMARY KEY ,
    set_id   BIGINT REFERENCES sets(id),
    cloth_id BIGINT REFERENCES clothes(id)
);

drop table sets_clothes;
drop table clothes;
drop table comments;
drop table users;
drop table sets;
drop table news_lines;

ALTER TABLE sets
    ADD column user_id BIGINT REFERENCES users(id)


