CREATE TABLE user_team (
	id serial PRIMARY KEY,
	uuid UUID,
	user_id UUID,
	match_id UUID,
	total_points float,
	team_name VARCHAR(255),
	created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP
);
ALTER TABLE user_team ALTER COLUMN total_points SET DEFAULT 0.0;