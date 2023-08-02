DROP TABLE IF EXISTS book_user;
DROP TABLE IF EXISTS book;
DROP TABLE IF EXISTS trade;
DROP TABLE IF EXISTS security;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS counter_party;
DROP TABLE IF EXISTS dogs;
DROP TABLE IF EXISTS total;

CREATE TABLE total AS SELECT * FROM CSVREAD
    ('java-api/src/main/resources/other/db-bonds-data.csv');

CREATE TABLE users(
    id long AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(250) NOT NULL,
    email VARCHAR(250) NOT NULL,
    password VARCHAR(250) NOT NULL
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
     type VARCHAR(50)
);

-- could possibly be bond_holder
CREATE TABLE counter_party (
       id long AUTO_INCREMENT PRIMARY KEY,
       bond_holder VARCHAR(250) NOT NULL
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

CREATE TABLE book(
    id long AUTO_INCREMENT PRIMARY KEY,
    book_name VARCHAR(250) NOT NULL,
    trade_id LONG,
    FOREIGN KEY (trade_id) REFERENCES trade(id)
    -- put trade id in here as foreign key
);


CREATE TABLE book_user (
   id long AUTO_INCREMENT PRIMARY KEY,
   users_id long NOT NULL,
   book_id long NOT NULL,
   FOREIGN KEY (users_id) REFERENCES users(id),
   FOREIGN KEY (book_id) REFERENCES book(id)
);



