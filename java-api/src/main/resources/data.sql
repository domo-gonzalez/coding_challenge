insert into users(name, email, password) values (
    'vansh', 'vansh@db.com', 'cheese'
);

-- insert into security(unit_price, coupon_percent, bond_currency, cusip, face_value_mn,isin,
--                      issuer_name, bond_maturity_date, status, type)(
--     select unit_price, coupon_percent, bond_currency, cusip, `face value (mn)`,isin,
--             issuer_name, bond_maturity_date, status, type FROM total
-- );


 insert into counter_party(bond_holder)(
     select bond_holder FROM total
 );

INSERT into trade (trade_type, trade_currency, quantity, trade_settlement_date,
                       trade_status, trade_date)(
    SELECT trade_type, trade_currency, quantity, trade_settlement_date,
    trade_status, trade_date FROM total
);

INSERT into book(book_name)(
    SELECT book_name FROM total
);

--INSERT into book_user(book_id, user_id)(
--    SELECT book_id, user_id FROM users
--);
