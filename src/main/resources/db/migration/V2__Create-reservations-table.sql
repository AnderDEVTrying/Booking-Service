CREATE TABLE reservations (
    id SERIAL PRIMARY KEY,
    customers_emails VARCHAR(200) NOT NULL,
    rooms_id INTEGER NOT NULL,
    check_in DATE NOT NULL,
    check_out DATE NOT NULL,
    status VARCHAR(255) NOT NULL,
    total_price Float NOT NULL,
    CONSTRAINT fk_rooms FOREIGN KEY (rooms_id) REFERENCES rooms (id)
);
