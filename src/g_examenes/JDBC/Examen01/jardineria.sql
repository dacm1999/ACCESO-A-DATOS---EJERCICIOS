DROP DATABASE IF EXISTS `jardineria`;
CREATE DATABASE IF NOT EXISTS `jardineria`;
USE `jardineria`;

CREATE TABLE cliente (
  codigo_cliente INTEGER NOT NULL,
  nombre_cliente VARCHAR(50) NOT NULL,
  nombre_contacto VARCHAR(30) DEFAULT NULL,
  apellido_contacto VARCHAR(30) DEFAULT NULL,
  telefono VARCHAR(15) DEFAULT NULL,
  fax VARCHAR(15) DEFAULT NULL,
  linea_direccion1 VARCHAR(50) DEFAULT NULL,
  linea_direccion2 VARCHAR(50) DEFAULT NULL,
  ciudad VARCHAR(50) DEFAULT NULL,
  region VARCHAR(50) DEFAULT NULL,
  pais VARCHAR(50) DEFAULT NULL,
  codigo_postal VARCHAR(10) DEFAULT NULL,
  limite_credito NUMERIC(15,2) DEFAULT NULL,
  PRIMARY KEY (codigo_cliente)
);


CREATE TABLE pago (
  codigo_cliente INTEGER NOT NULL,
  forma_pago VARCHAR(40) NOT NULL,
  id_pago VARCHAR(50) NOT NULL,
  fecha_pago date NOT NULL,
  total NUMERIC(15,2) NOT NULL,
  PRIMARY KEY (id_pago)
);

ALTER TABLE `pago`
  
  ADD KEY `codigo_cliente` (`codigo_cliente`);

ALTER TABLE `pago`
  ADD CONSTRAINT `fk1` FOREIGN KEY (`codigo_cliente`) REFERENCES `cliente` (`codigo_cliente`) ON DELETE CASCADE ON UPDATE CASCADE;



INSERT INTO cliente VALUES (1,'GoldFish Garden','Daniel G','GoldFish','5556901745','5556901746','False Street 52 2 A',NULL,'San Francisco',NULL,'USA','24006',3000);
INSERT INTO cliente VALUES (3,'Gardening Associates','Anne','Wright','5557410345','5557410346','Wall-e Avenue',NULL,'Miami','Miami','USA','24010',6000);
INSERT INTO cliente VALUES (4,'Gerudo Valley','Link','Flaute','5552323129','5552323128','Oaks Avenue nº22',NULL,'New York',NULL,'USA','85495',12000);
INSERT INTO cliente VALUES (5,'Tendo Garden','Akane','Tendo','55591233210','55591233211','Null Street nº69',NULL,'Miami',NULL,'USA','696969',600000);
INSERT INTO cliente VALUES (6,'Lasas S.A.','Antonio','Lasas','34916540145','34914851312','C/Leganes 15',NULL,'Fuenlabrada','Madrid','Spain','28945',154310);
INSERT INTO cliente VALUES (7,'Beragua','Jose','Bermejo','654987321','916549872','C/pintor segundo','Getafe','Madrid','Madrid','Spain','28942',20000);
INSERT INTO cliente VALUES (8,'Club Golf Puerta del hierro','Paco','Lopez','62456810','919535678','C/sinesio delgado','Madrid','Madrid','Madrid','Spain','28930',40000);
INSERT INTO cliente VALUES (9,'Naturagua','Guillermo','Rengifo','689234750','916428956','C/majadahonda','Boadilla','Madrid','Madrid','Spain','28947',32000);
INSERT INTO cliente VALUES (10,'DaraDistribuciones','David','Serrano','675598001','916421756','C/azores','Fuenlabrada','Madrid','Madrid','Spain','28946',50000);
INSERT INTO cliente VALUES (11,'Madrileña de riegos','Jose','Tacaño','655983045','916689215','C/Lagañas','Fuenlabrada','Madrid','Madrid','Spain','28943',20000);
INSERT INTO cliente VALUES (12,'Lasas S.A.','Antonio','Lasas','34916540145','34914851312','C/Leganes 15',NULL,'Fuenlabrada','Madrid','Spain','28945',154310);
INSERT INTO cliente VALUES (13,'Camunas Jardines S.L.','Pedro','Camunas','34914873241','34914871541','C/Virgenes 45','C/Princesas 2 1ºB','San Lorenzo del Escorial','Madrid','Spain','28145',16481);
INSERT INTO cliente VALUES (14,'Dardena S.A.','Juan','Rodriguez','34912453217','34912484764','C/Nueva York 74',NULL,'Madrid','Madrid','Spain','28003',321000);
INSERT INTO cliente VALUES (15,'Jardin de Flores','Javier','Villar','654865643','914538776','C/ Oña 34',NULL,'Madrid','Madrid','Spain','28950',40000);
INSERT INTO cliente VALUES (16,'Flores Marivi','Maria','Rodriguez','666555444','912458657','C/Leganes24',NULL,'Fuenlabrada','Madrid','Spain','28945',1500);
INSERT INTO cliente VALUES (17,'Flowers, S.A','Beatriz','Fernandez','698754159','978453216','C/Luis Salquillo4',NULL,'Montornes del valles','Barcelona','Spain','24586',3500);
INSERT INTO cliente VALUES (18,'Naturajardin','Victoria','Cruz','612343529','916548735','Plaza Magallón 15',NULL,'Madrid','Madrid','Spain','28011',5050);
INSERT INTO cliente VALUES (19,'Golf S.A.','Luis','Martinez','916458762','912354475','C/Estancado',NULL,'Santa cruz de Tenerife','Islas Canarias','Spain','38297',30000);
INSERT INTO cliente VALUES (20,'Americh Golf Management SL','Mario','Suarez','964493072','964493063','C/Letardo',NULL,'Barcelona','Cataluña','Spain','12320',20000);


INSERT INTO pago VALUES (1,'PayPal','ak-std-000001','2021-11-10',2000);
INSERT INTO pago VALUES (1,'PayPal','ak-std-000002','2021-12-10',2000);
INSERT INTO pago VALUES (3,'PayPal','ak-std-000003','2021-01-16',5000);
INSERT INTO pago VALUES (3,'PayPal','ak-std-000004','2021-02-16',5000);
INSERT INTO pago VALUES (3,'PayPal','ak-std-000005','2021-02-19',926);
INSERT INTO pago VALUES (4,'PayPal','ak-std-000006','2021-01-08',20000);
INSERT INTO pago VALUES (4,'PayPal','ak-std-000007','2021-01-08',20000);
INSERT INTO pago VALUES (4,'PayPal','ak-std-000008','2021-01-08',20000);
INSERT INTO pago VALUES (4,'PayPal','ak-std-000009','2021-01-08',20000);
INSERT INTO pago VALUES (4,'PayPal','ak-std-000010','2021-01-08',1849);
INSERT INTO pago VALUES (5,'Transferencia','ak-std-000011','2021-01-18',23794);
INSERT INTO pago VALUES (7,'Cheque','ak-std-000012','2021-01-13',2390);
INSERT INTO pago VALUES (9,'PayPal','ak-std-000013','2021-01-06',929);
INSERT INTO pago VALUES (13,'PayPal','ak-std-000014','2021-08-04',2246);
INSERT INTO pago VALUES (14,'PayPal','ak-std-000015','2021-07-15',4160);
INSERT INTO pago VALUES (15,'PayPal','ak-std-000016','2021-01-15',2081);
INSERT INTO pago VALUES (15,'PayPal','ak-std-000035','2021-02-15',10000);
INSERT INTO pago VALUES (16,'PayPal','ak-std-000017','2021-02-16',4399);
INSERT INTO pago VALUES (19,'PayPal','ak-std-000018','2021-03-06',232);
