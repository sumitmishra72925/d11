CREATE TABLE wallet (
	id serial PRIMARY KEY,
	uuid UUID,
	user_id UUID,
	winning_amount VARCHAR(255),
	amount_added VARCHAR(255),
	total_amount VARCHAR(255),
	created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP
);