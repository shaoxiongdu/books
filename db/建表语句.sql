create table book(
                     `id` int primary key auto_increment,
                     `name` varchar(100),
                     `price` decimal(11,2),
                     `author` varchar(100),
                     `sales` int,
                     `stock` int,
                     `img_path` varchar(200)
)default charset utf8;


create table `order`(
                        `order_id` varchar(50) primary key,
                        `create_time` datetime,
                        `price` decimal(11,2),
                        `status` varchar(255),
                        `user_id` int
)default charset utf8 ;

create table order_item(
                           `id` int primary key auto_increment,
                           `name` varchar(100),
                           `count` int,
                           `price` decimal(11,2),
                           `total_price` decimal(11,2),
                           `order_id` varchar(50)
)default charset utf8;
