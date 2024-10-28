CREATE TABLE rooms (
    id SERIAL PRIMARY KEY,
    room_number VARCHAR(255) NOT NULL,
    type VARCHAR(255) NOT NULL,
    price decimal NOT NULL
);
