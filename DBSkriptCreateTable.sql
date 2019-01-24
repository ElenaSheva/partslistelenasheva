USE test;

DROP TABLE IF EXISTS part;

CREATE TABLE part (
  id INT(11) NOT NULL AUTO_INCREMENT,
  Partname VARCHAR(255) NOT NULL UNIQUE,
  Necessary BIT(1) NOT NULL DEFAULT b'0',
  Quantity INT(8) NOT NULL,
  PRIMARY KEY (id))
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;
  
INSERT INTO part (Partname, Necessary, Quantity) VALUES ('Motherboard',1,15);
INSERT INTO part (Partname, Necessary, Quantity) VALUES ('Hard drive',1,150);
INSERT INTO part (Partname, Necessary, Quantity) VALUES ('Power supply',1,200);
INSERT INTO part (Partname, Necessary, Quantity) VALUES ('CPU',1,45);
INSERT INTO part (Partname, Necessary, Quantity) VALUES ('RAM',1,487);
INSERT INTO part (Partname, Necessary, Quantity) VALUES ('Optical drive',0,47);
INSERT INTO part (Partname, Necessary, Quantity) VALUES ('Card reader',0,0);
INSERT INTO part (Partname, Necessary, Quantity) VALUES ('Case',1,55);
INSERT INTO part (Partname, Necessary, Quantity) VALUES ('Network card',0,145);
INSERT INTO part (Partname, Necessary, Quantity) VALUES ('Monitor',1,143);
INSERT INTO part (Partname, Necessary, Quantity) VALUES ('Cooling',0,500);
INSERT INTO part (Partname, Necessary, Quantity) VALUES ('SSD',0,12);
INSERT INTO part (Partname, Necessary, Quantity) VALUES ('Graphic Card',0,23);
INSERT INTO part (Partname, Necessary, Quantity) VALUES ('Heatsink',0,45);
INSERT INTO part (Partname, Necessary, Quantity) VALUES ('Keyboard',0,74);
INSERT INTO part (Partname, Necessary, Quantity) VALUES ('Printer',0,100);
INSERT INTO part (Partname, Necessary, Quantity) VALUES ('Mouse',0,900);
INSERT INTO part (Partname, Necessary, Quantity) VALUES ('Scanner',0,58);
INSERT INTO part (Partname, Necessary, Quantity) VALUES ('Webcam',0,77);
INSERT INTO part (Partname, Necessary, Quantity) VALUES ('Touchpad',0,12);
INSERT INTO part (Partname, Necessary, Quantity) VALUES ('Microphone',0,88);
INSERT INTO part (Partname, Necessary, Quantity) VALUES ('Digital pen',0,100);