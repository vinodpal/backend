CREATE TABLE crossover.product (
  code INT NOT NULL AUTO_INCREMENT,
  description VARCHAR(45) NULL,
  price DECIMAL NOT NULL,
  quantity INT NOT NULL,
  PRIMARY KEY (code));

CREATE TABLE crossover.customer (
  code INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(45) NOT NULL,
  address VARCHAR(100) NOT NULL,
  phone1 VARCHAR(45) NOT NULL,
  phone2 VARCHAR(45) NULL,
  credit_limit DECIMAL NOT NULL,
  current_credit DECIMAL NOT NULL,
  PRIMARY KEY (code));
  
