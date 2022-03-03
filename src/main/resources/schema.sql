DROP TABLE IF EXISTS computer;
CREATE TABLE computer (
                      id INT AUTO_INCREMENT  PRIMARY KEY,
                      name VARCHAR(255) ,
                      date_accounting DATE,
                      price_USD float,
                      price_PLN float
);