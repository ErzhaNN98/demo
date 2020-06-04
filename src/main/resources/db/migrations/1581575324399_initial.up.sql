CREATE TABLE IF NOT EXISTS firm
(
    id          SERIAL PRIMARY KEY,
    name        TEXT NOT NULL
);

CREATE TABLE IF NOT EXISTS user0
(
    id          SERIAL PRIMARY KEY,
    firm_id     INT NOT NULL,
    name        TEXT NOT NULL,
    surname     TEXT NOT NULL,
    phone       TEXT NOT NULL,
    position    INT NOT NULL
);

CREATE TABLE IF NOT EXISTS user_stat
(
    id          SERIAL PRIMARY KEY,
    user_id     INT NOT NULL,
    name        TEXT NOT NULL,
    is_success  BOOLEAN NOT NULL
);

CREATE TABLE IF NOT EXISTS log_info
(
    id          SERIAL PRIMARY KEY,
    user_id     INT NOT NULL,
    log         TEXT NOT NULL,
    create_time timestamptz NOT NULL
);