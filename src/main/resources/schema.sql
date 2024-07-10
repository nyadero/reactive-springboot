-- Check if database exists
SELECT datname FROM pg_catalog.pg_database WHERE datname = 'spring_reactive';

-- Connect to the database
--c spring_reactive;

CREATE TABLE  IF NOT EXISTS posts(
    id SERIAL PRIMARY KEY,
    description TEXT NOT NULL,
    post_type VARCHAR(50),
    post_audience VARCHAR(50),
    tags VARCHAR(255),
    mentioned_users VARCHAR(255),
    mentioned_businesses VARCHAR(255),
    business_id UUID,
    forum_id UUID
);

CREATE TABLE  IF NOT EXISTS classifieds(
    id SERIAL PRIMARY KEY,
    description TEXT NOT NULL,
    name VARCHAR(50),
    category VARCHAR(50),
    price INTEGER
);

