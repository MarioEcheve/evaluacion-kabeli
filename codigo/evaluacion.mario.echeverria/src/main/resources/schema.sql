CREATE TABLE USERS (
	id_user int PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR ( 100 ) NOT NULL,
	password VARCHAR ( 100 )  NOT NULL,
	email VARCHAR ( 100 ) NOT NULL,
	created date,
	modified date,
	last_login date,
	isactive boolean
);

CREATE TABLE PHONE (
	id_phone int PRIMARY KEY AUTO_INCREMENT,
	number_phone VARCHAR ( 100 ) NOT NULL,
	citycode VARCHAR ( 100 )  NOT NULL,
	contrycode VARCHAR ( 100 ) NOT NULL,
	id_user  int,
	FOREIGN KEY (id_user)
      REFERENCES USERS (id_user)
);