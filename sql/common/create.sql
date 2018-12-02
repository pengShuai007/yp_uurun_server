create database uu_server;
CREATE TABLE IF NOT EXISTS hello (
  ID INT PRIMARY KEY AUTO_INCREMENT,
  username VARCHAR (50),
  usersex VARCHAR (2),
  userage INT (3),
  address VARCHAR (100),
  job VARCHAR (50)
) ENGINE = INNODB CHARSET = utf8 ;
