insert into orders (order_id, customer_id, customer_name, status, created_at, last_modified_at)
values
    (1, 'youdongk', 'Dongkyun', 'S', current_timestamp, current_timestamp),
    (2, 'kukim', 'Kunwoong', 'S', current_timestamp, current_timestamp),
    (3, 'joosungk', 'Joosung', 'S', current_timestamp, current_timestamp),
    (4, 'minjaele', 'Minjae', 'S', current_timestamp, current_timestamp),
    (5, 'jungmink', 'Jungmin', 'S', current_timestamp, current_timestamp);

insert into order_items (order_id, line_no, currency, amount, product_no, product_name)
values
    (1, 0, 'KRW', 1000, 'AEKKJ', 'ADONTKNOW'),
    (2, 0, 'KRW', 2000, 'BEKKJ', 'BDONTKNOW'),
    (3, 0, 'KRW', 3000, 'CEKKJ', 'CDONTKNOW'),
    (4, 0, 'KRW', 4000, 'DEKKJ', 'DDONTKNOW'),
    (5, 0, 'KRW', 5000, 'EEKKJ', 'EDONTKNOW');
