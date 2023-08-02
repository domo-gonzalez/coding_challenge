insert into users(name, email, password) values (
    'vansh', 'vansh@db.com', 'cheese'
);

-- insert into security(unit_price, coupon_percent, bond_currency, cusip, face_value_mn,isin,
--                      issuer_name, bond_maturity_date, status, type)(
--     select unit_price, coupon_percent, bond_currency, cusip, `face value (mn)`,isin,
--             issuer_name, bond_maturity_date, status, type FROM total
-- );


-- insert into counter_party(bond_holder)(
--     select bond_holder FROM total where rownum > 1
-- );

