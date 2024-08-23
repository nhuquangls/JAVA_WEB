CREATE DATABASE motel_management;
USE motel_management;

CREATE TABLE payment_type (
	id INT PRIMARY KEY AUTO_INCREMENT,
    paymentType VARCHAR(255) NOT NULL
);
CREATE TABLE motel_rooms (
	id INT PRIMARY KEY AUTO_INCREMENT,
    tenantName VARCHAR(255) NOT NULL,
    phone VARCHAR(255) NOT NULL,
    rentalDate DATE NOT NULL,
    payment_type_id INT NOT NULL,
    note VARCHAR(255) NULL,
    FOREIGN KEY (payment_type_id) REFERENCES payment_type(id)
);

INSERT INTO payment_type (paymentType)
VALUE ('Payment By Month'), ('Payment By Quarter'), ('Payment By Year');

