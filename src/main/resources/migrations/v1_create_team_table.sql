CREATE TABLE teams (
	id serial PRIMARY KEY,
	uuid UUID,
	team_name VARCHAR(255),
	address VARCHAR(255),
    short_name VARCHAR(255),
	team_logo VARCHAR(255),
	created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP
);