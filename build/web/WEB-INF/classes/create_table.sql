-- User Table
CREATE TABLE users (
    id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    full_name VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    phone_number VARCHAR(20),
    user_type VARCHAR(255) NOT NULL CHECK(user_type IN ('customer', 'staff', 'system_admin')),
    active_status SMALLINT NOT NULL
);

/* -- Access Log Table
CREATE TABLE access_logs (
    id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    user_id INT NOT NULL,
    login_datetime TIMESTAMP NOT NULL,
    logout_datetime TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES users(id)
);

-- IoT Device Table
CREATE TABLE iot_devices (
    id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    type VARCHAR(255) NOT NULL,
    unit_price DECIMAL(10,2) NOT NULL,
    quantity INT NOT NULL
);

-- Order Table
CREATE TABLE orders (
    id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    customer_id INT NOT NULL,
    order_date TIMESTAMP NOT NULL,
    order_status VARCHAR(255) NOT NULL CHECK(order_status IN ('created', 'submitted', 'cancelled')),
    FOREIGN KEY (customer_id) REFERENCES users(id)
);

-- Order Detail Table
CREATE TABLE order_details (
    id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    order_id INT NOT NULL,
    iot_device_id INT NOT NULL,
    quantity INT NOT NULL,
    FOREIGN KEY (order_id) REFERENCES orders(id),
    FOREIGN KEY (iot_device_id) REFERENCES iot_devices(id)
);

-- Payment Table
CREATE TABLE payments (
    id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    order_id INT NOT NULL,
    payment_method VARCHAR(255) NOT NULL,
    credit_card_details VARCHAR(255) NOT NULL,
    amount DECIMAL(10,2) NOT NULL,
    payment_date TIMESTAMP NOT NULL,
    payment_status VARCHAR(255) NOT NULL CHECK(payment_status IN ('created', 'submitted', 'cancelled')),
    FOREIGN KEY (order_id) REFERENCES orders(id)
);

-- Shipment Table
CREATE TABLE shipments (
    id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    order_id INT NOT NULL,
    shipment_method VARCHAR(255) NOT NULL,
    shipment_date TIMESTAMP NOT NULL,
    address VARCHAR(255) NOT NULL,
    shipment_status VARCHAR(255) NOT NULL CHECK(shipment_status IN ('created', 'finalised', 'cancelled')),
    FOREIGN KEY (order_id) REFERENCES orders(id)
); */

