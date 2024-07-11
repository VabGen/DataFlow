SET SCHEMA 'data_flow';
CREATE TABLE IF NOT EXISTS post
(
    id   UUID PRIMARY KEY,
    code INT  NOT NULL UNIQUE,
    post_name VARCHAR(255) NOT NULL,
    create_date TIMESTAMP(6) WITH TIME ZONE
    );

CREATE TABLE IF NOT EXISTS employee
(
    id          UUID PRIMARY KEY,
    first_name  VARCHAR(255) NOT NULL,
    middle_name VARCHAR(255),
    last_name   VARCHAR(255) NOT NULL,
    post_id     UUID,
    address     VARCHAR(255),
    email       VARCHAR(255),
    phone       INT,
    passport    INT,
    create_date TIMESTAMP(6) WITH TIME ZONE,
    FOREIGN KEY (post_id) REFERENCES post (id)
);