CREATE TABLE players (
	id serial PRIMARY KEY,
	uuid UUID,
	team_id UUID,
	full_name VARCHAR(255),
	short_name VARCHAR(255),
	role VARCHAR(255),
	is_playing BOOLEAN DEFAULT TRUE,
	created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP
);