CREATE TABLE contest (
	id serial PRIMARY KEY,
	uuid UUID,
	match_id UUID,
	prize_pool VARCHAR(255),
	entry_fee VARCHAR(255),
	total_spot VARCHAR(255),
	remaining_spot VARCHAR(255),
	first_prize VARCHAR(255),
	is_full BOOLEAN DEFAULT FALSE,
	created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP
);