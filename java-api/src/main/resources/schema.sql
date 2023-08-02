DROP DATABASE IF EXISTS bonds;
CREATE DATABASE bonds;
use bonds;

CREATE TABLE users(
    id long AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(250) NOT NULL,
    email VARCHAR(250) NOT NULL,
    password VARCHAR(250) NOT NULL
);

CREATE TABLE book(
    id long AUTO_INCREMENT PRIMARY KEY,
    book_name VARCHAR(250) NOT NULL,
    trade_id LONG,
    FOREIGN KEY (trade_id) REFERENCES trade(id)
    -- put trade id in here as foreign key
);

CREATE TABLE trade(
    id long AUTO_INCREMENT PRIMARY KEY,
    trade_type VARCHAR(50),
    trade_currency VARCHAR(50),
    quantity int,
    trade_settlement_date VARCHAR(250),
    trade_status VARCHAR(250),
    trade_date VARCHAR(250),
    security_id LONG,
    counter_party_id LONG,
    FOREIGN KEY (security_id) REFERENCES security(id),
    FOREIGN KEY (counter_party_id) REFERENCES counter_party(id)
    -- unit price maybe here
    -- counter_party_id
);

create TABLE security(
    id long AUTO_INCREMENT PRIMARY KEY,
    unit_price DOUBLE,
    coupon_percent DOUBLE,
    -- might need constraints on coupon_percent
    bond_currency VARCHAR(50),
    cusip VARCHAR(250),
    face_value_mn int,
    isin VARCHAR(250),
    issuer_name VARCHAR(250),
    bond_maturity_date VARCHAR(250),
    status VARCHAR(50),
    type VARCHAR(50),
    trade_id LONG,
    FOREIGN KEY (trade_id) REFERENCES trade(id)
);

CREATE TABLE book_user (
   id long AUTO_INCREMENT PRIMARY KEY,
   users_id long NOT NULL,
   book_id long NOT NULL,
   FOREIGN KEY (users_id) REFERENCES users(id),
   FOREIGN KEY (book_id) REFERENCES book(id)
);

-- could possibly be bond_holder
CREATE TABLE counter_party (
    id long AUTO_INCREMENT PRIMARY KEY,
    bond_holder VARCHAR(250) NOT NULL
);

