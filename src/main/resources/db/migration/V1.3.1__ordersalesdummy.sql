insert into crossover.salesorder (order_number, customer, total_price) values('ORDER002', 1, 120.00);
insert into crossover.salesorder (order_number, customer, total_price) values('ORDER001', 2, 130.00);
insert into crossover.salesorder (order_number, customer, total_price) values('ORDER003', 3, 140.00);

insert into crossover.orderline (product,sales_order,quantity,unit_price,total_price) values(1, 'ORDER002', 1, 50.00, 50.00);
insert into crossover.orderline (product,sales_order,quantity,unit_price,total_price) values(2, 'ORDER003', 1, 70.00, 70.00);
insert into crossover.orderline (product,sales_order,quantity,unit_price,total_price) values(3, 'ORDER001', 1, 20.00, 20.00);
insert into crossover.orderline (product,sales_order,quantity,unit_price,total_price) values(3, 'ORDER002', 1, 40.00, 40.00);
insert into crossover.orderline (product,sales_order,quantity,unit_price,total_price) values(3, 'ORDER001', 1, 30.00, 30.00);