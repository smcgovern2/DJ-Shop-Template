create table item (
    item_id int identity primary key,
    name varchar(200) not null,
    price float not null,
    description varchar(200),
    inventory int default(0),
    image_file_name varchar(200)
);

create table cart_item (
    item_id int primary key,
    quantity int default (0),
    CONSTRAINT fk_item_cartitem_id
    FOREIGN KEY (item_id) REFERENCES item(item_id)

);