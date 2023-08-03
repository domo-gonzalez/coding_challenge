insert into users(name, email, password, role) values (
    'vansh', 'vansh@db.com', 'cheese', 'admin'
);

insert into security(coupon_percent, bond_currency, cusip,face_value_mn,isin,
                     issuer_name, bond_maturity_date, status, type)(
    select coupon_percent, bond_currency, cusip, "face_value (mn)",isin,
            issuer_name, bond_maturity_date, status, type FROM total
);



 insert into counter_party(bond_holder)(
     select distinct lower(bond_holder) FROM total
 );


INSERT into book(book_name)(
    SELECT DISTINCT LOWER(book_name) FROM total
);

--INSERT into trade (trade_type, trade_currency, quantity, unit_price, trade_settlement_date,
--                       trade_status, trade_date)(
--    SELECT trade_type, trade_currency, quantity, unit_price, trade_settlement_date,
--    trade_status, trade_date FROM total
--);
INSERT INTO trade (trade_type, trade_currency, quantity, unit_price, trade_settlement_date,
trade_status, trade_date, book_name, counter_party)
SELECT t.trade_type, t.trade_currency, t.quantity, t.unit_price, t.trade_settlement_date,
t.trade_status, t.trade_date, b.book_name, c.bond_holder
FROM total t
LEFT OUTER JOIN book b ON lower(t.book_name) = b.book_name
LEFT OUTER JOIN counter_party c ON lower(t.bond_holder) = c.bond_holder;




INSERT into book_user(book_id, users_id)(
   SELECT book.id, users.id FROM book,users
);
