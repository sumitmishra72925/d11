CREATE TABLE users (
	id serial PRIMARY KEY,
	uuid UUID,
	user_name VARCHAR(255),
	email VARCHAR(255),
	auth_token VARCHAR(255),
	created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP
);