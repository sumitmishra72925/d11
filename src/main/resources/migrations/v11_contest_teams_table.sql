CREATE TABLE contest_team (
	id serial PRIMARY KEY,
	uuid UUID,
	joined_contest_id UUID,
	team_id UUID,
	created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP
);