CREATE TABLE join_contest (
	id serial PRIMARY KEY,
	uuid UUID,
	match_id UUID,
	user_id UUID,
	contest_id UUID,
	created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP
);