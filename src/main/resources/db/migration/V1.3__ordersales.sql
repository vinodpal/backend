CREATE TABLE crossover.salesorder (
  order_number VARCHAR(15) NOT NULL,
  customer INT NULL,
  total_price DECIMAL NULL,
  PRIMARY KEY (order_number));
  
  ALTER TABLE crossover.salesorder 
ADD INDEX fk_salesorder_1_idx (customer ASC);
ALTER TABLE crossover.salesorder 
ADD CONSTRAINT fk_salesorder_1
  FOREIGN KEY (customer)
  REFERENCES crossover.customer (code)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;
  
  CREATE TABLE crossover.orderline (
  id INT NOT NULL AUTO_INCREMENT,
  product INT NOT NULL,
  sales_order VARCHAR(15),
  quantity INT NOT NULL,
  unit_price DECIMAL NOT NULL,
  total_price DECIMAL NOT NULL,
  PRIMARY KEY (id));
  
ALTER TABLE crossover.orderline 
ADD INDEX fk_orderline_2_idx (sales_order ASC);
ALTER TABLE crossover.orderline 
ADD CONSTRAINT fk_orderline_2
  FOREIGN KEY (sales_order)
  REFERENCES crossover.salesorder (order_number)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;
  
ALTER TABLE crossover.orderline 
ADD INDEX fk_orderline_1_idx (product ASC);
ALTER TABLE crossover.orderline 
ADD CONSTRAINT fk_orderline_1
  FOREIGN KEY (product)
  REFERENCES crossover.product (code)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;
  
