CREATE TABLE match (
	id serial PRIMARY KEY,
	uuid UUID,
	match_name VARCHAR(255),
	team1_id UUID,
	team2_id UUID,
	prize_pool VARCHAR(255),
	start_time TIMESTAMP,
	is_live BOOLEAN,
	is_completed BOOLEAN,
	created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP
);
