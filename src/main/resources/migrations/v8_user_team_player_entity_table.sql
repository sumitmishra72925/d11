CREATE TABLE user_team_player (
	id serial PRIMARY KEY,
	uuid UUID,
	user_team_id UUID,
	player_id UUID,
	is_captain BOOLEAN,
	is_vice_captain BOOLEAN,
	points_scored float,
	created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP
);
ALTER TABLE user_team_player ALTER COLUMN is_captain SET DEFAULT FALSE;
ALTER TABLE user_team_player ALTER COLUMN is_vice_captain SET DEFAULT FALSE;
ALTER TABLE user_team_player ALTER COLUMN points_scored SET DEFAULT 0.0;
