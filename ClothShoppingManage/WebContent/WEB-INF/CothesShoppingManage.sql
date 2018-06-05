SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE IF EXISTS consumer;
DROP TABLE IF EXISTS goods;
DROP TABLE IF EXISTS manager;

truncate consumer;
truncate manager;



/* Create Tables */

CREATE TABLE consumer
(
	consumer_id int NOT NULL,
	consumer_name varchar(20),
	consumer_pwd varchar(50) NOT NULL,
	consumer_img varchar(100),
	consumer_tel varchar(20) NOT NULL,
	consumer_sex char(5),
	consumer_introduce text,
	PRIMARY KEY (consumer_id)
);


CREATE TABLE goods
(
	goods_id int NOT NULL AUTO_INCREMENT,
	goods_type varchar(15),
	goods_brand varchar(10) NOT NULL,
	goods_class varchar(10) NOT NULL,
	goods_name varchar(20) NOT NULL,
	goods_person int NOT NULL,
	goods_price float DEFAULT 0 NOT NULL,
	goods_store int DEFAULT 0 NOT NULL,
	goods_des text,
	goods_imgid varchar(100),
	PRIMARY KEY (goods_id),
	UNIQUE (goods_id)
);


CREATE TABLE manager
(
	manager_id int NOT NULL AUTO_INCREMENT,
	manager_name varchar(20) NOT NULL,
	manager_nickname varchar(20),
	manager_pwd varchar(50) NOT NULL,
	manager_tel varchar(20) NOT NULL,
	manager_img varchar(100),
	manager_power char(5),
	create_date date NOT NULL,
	PRIMARY KEY (manager_id)
);


