-- DROP DATABASE IF EXISTS `bonds`;
-- CREATE DATABASE `bonds`;
-- use bonds;
drop table if exists book;
drop table if exists `user`;
drop table if exists `counterparty`;
drop table if exists `trades`;
drop table if exists `book_user`;
drop table if exists `security`;

CREATE TABLE book (
                        id int NOT NULL AUTO_INCREMENT,
                        name varchar(255) NOT NULL,
                        PRIMARY KEY (id)
);

CREATE TABLE `user` (
                        `id` int NOT NULL AUTO_INCREMENT,
                        `name` varchar(255) NOT NULL,
                        `email` varchar(255) NOT NULL,
                        `role` varchar(255) NOT NULL,
                        PRIMARY KEY (`id`)
);

CREATE TABLE `counterparty` (
                                `id` int NOT NULL AUTO_INCREMENT,
                                `name` varchar(255) NOT NULL,
                                PRIMARY KEY (`id`)
) ;

CREATE TABLE book_user (
                             book_id int NOT NULL,
                             user_id int NOT NULL,
                             FOREIGN KEY (user_id) REFERENCES user(id),
                             FOREIGN KEY (book_id) REFERENCES book(id)
) ;


CREATE TABLE `security` (
                            `id` int NOT NULL AUTO_INCREMENT,
                            `isin` varchar(50) DEFAULT NULL,
                            `cusip` varchar(50) DEFAULT NULL,
                            `issuer_name` varchar(255) NOT NULL,
                            `maturity_date` datetime NOT NULL,
                            `coupon` float NOT NULL,
                            `type` varchar(255) NOT NULL,
                            `face_value` float NOT NULL,
                            `currency` varchar(10) NOT NULL,
                            `status` varchar(32) DEFAULT NULL,
                            PRIMARY KEY (`id`)
);

CREATE TABLE `trades` (
                          `id` int NOT NULL AUTO_INCREMENT,
                          `book_id` int NOT NULL,
                          `security_id` int NOT NULL,
                          `counterparty_id` int NOT NULL,
                          `currency` varchar(10) NOT NULL,
                          `status` varchar(32) NOT NULL,
                          `quantity` int NOT NULL,
                          `unit_price` float NOT NULL,
                          `buy_sell` varchar(32) NOT NULL,
                          `trade_date` datetime NOT NULL,
                          `settlement_date` datetime NOT NULL,
                          PRIMARY KEY (`id`),
                          KEY `FK_security_id` (`security_id`),
                          KEY `FK_counterparty_id` (`counterparty_id`),
                          KEY `FK_book_id` (`book_id`)
);


ALTER TABLE book_user ADD PRIMARY KEY(book_id, user_id);
