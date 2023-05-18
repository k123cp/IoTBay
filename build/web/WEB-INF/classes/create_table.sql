/* 1.Open Apache NetBean.
   2.Select "Service" .
   3. Extend Database window
   4. Right click "Java DB" and "Create Database".
   5.Type Name user name ,password what you prefered.Click "OK".
   6.Right click "jdbc:derby://localhost:1527/DBName [Username on USERNAME]",and "Connect"
   7.Extend "Other schemas" window and set "APP" as Default Schemas.
   8.Extend "APP" and right click "Table",them "Execute Command"
   9.Copy the following create statement one by one,and right click the command window select "Run Statement".
   10.Keep creating all tables. /*

CREATE TABLE users (
    id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    email VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    user_type VARCHAR(255) NOT NULL CHECK(user_type IN ('customer', 'staff', 'system_admin')),
    active_status SMALLINT NOT NULL
);
/* create the table one by one, delete the create table statement once a table created. */
/* -- Customer Table
CREATE TABLE customers (
    id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    user_id INT UNIQUE NOT NULL,
    full_name VARCHAR(255) NOT NULL,
    phone_number VARCHAR(20),
    address VARCHAR(255),
    FOREIGN KEY (user_id) REFERENCES users(id)
);

-- Staff Table
CREATE TABLE staff (
    id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    user_id INT UNIQUE NOT NULL,
    full_name VARCHAR(255) NOT NULL,
    phone_number VARCHAR(20),
    job_title VARCHAR(255) NOT NULL,
    department VARCHAR(255) NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id)
);

-- Access Log Table
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

-- Orders Table
CREATE TABLE orders (
    id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    customer_id INT NOT NULL,
    order_date TIMESTAMP NOT NULL,
    order_status VARCHAR(255) NOT NULL CHECK(order_status IN ('created', 'submitted', 'cancelled')),
    FOREIGN KEY (customer_id) REFERENCES customers(id)
);

-- Order Details Table
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
);*/
 
