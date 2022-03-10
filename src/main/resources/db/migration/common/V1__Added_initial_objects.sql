create table orders
(
    order_id         bigint auto_increment primary key,
    customer_id      varchar(255),
    customer_name    varchar(255),
    status           varchar(255),
    created_at       datetime,
    last_modified_at datetime
);

create index ix01_orders on orders (customer_id);

create table order_items
(
    order_id     bigint       not null,
    line_no      int,
    currency     varchar(255),
    amount       int,
    product_no   varchar(255),
    product_name varchar(255),
    primary key (order_id, line_no)
);
