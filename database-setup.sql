CREATE TABLE user(
    user_id INT NOT NULL auto_increment, 
    username VARCHAR(50) NOT NULL,
    firstname VARCHAR(100) NOT NULL,
    lastname VARCHAR(100) NOT NULL,
    date_of_birth DATE NOT NULL,
    email VARCHAR(256) NOT NULL,
    phone VARCHAR(50),
    mobile VARCHAR(50),
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;