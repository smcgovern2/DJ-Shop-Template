create table Item (
    item_id int primary key,
    name varchar(200) not null,
    price int not null,
    description varchar(200),
    inventory int default(0),
    image_file_name varchar(200)
);