DROP SCHEMA IF EXISTS tablas ;

CREATE SCHEMA IF NOT EXISTS tablas DEFAULT CHARACTER SET utf8 ;
USE tablas;

-- -----------------------------------------------------
-- Table producto
-- -----------------------------------------------------
DROP TABLE IF EXISTS producto;
CREATE TABLE IF NOT EXISTS producto (
  idproducto INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(45) NOT NULL unique,
  precio FLOAT NOT NULL,
  PRIMARY KEY (idproducto)
);

-- -----------------------------------------------------
-- Table Bodega
-- -----------------------------------------------------
DROP TABLE IF EXISTS bodega;
CREATE TABLE IF NOT EXISTS bodega (
  idBodega INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(45) NOT NULL,
  direccion VARCHAR(45) NOT NULL,
  PRIMARY KEY (idBodega)
);

-- -----------------------------------------------------
-- Table empleado
-- -----------------------------------------------------
DROP TABLE IF EXISTS empleado;
CREATE TABLE IF NOT EXISTS empleado (
  idBodega INT NOT NULL,
  idempleado INT NOT NULL AUTO_INCREMENT,
  nombre VARCHAR(45) NOT NULL,
  edad INT NOT NULL,
  PRIMARY KEY (idempleado),
  FOREIGN KEY (idBodega) REFERENCES bodega (idBodega)
);

-- -----------------------------------------------------
-- Table `mydb`.`almacena`
-- -----------------------------------------------------
DROP TABLE IF EXISTS almacena;
CREATE TABLE IF NOT EXISTS almacena (
  idBodega INT NOT NULL AUTO_INCREMENT,
  idproducto INT NOT NULL,
  cantidad INT NOT NULL,
  PRIMARY KEY (idBodega,idproducto),
  FOREIGN KEY (idBodega) REFERENCES bodega (idBodega),
  FOREIGN KEY (idproducto) REFERENCES producto (idproducto)
);

INSERT INTO producto (nombre,precio) VALUES ("tornillo el general",93277.00);
INSERT INTO producto (nombre,precio) VALUES ("champagne",15728.00);
INSERT INTO producto (nombre,precio) VALUES ("mora",63781.00);
INSERT INTO producto (nombre,precio) VALUES ("cereal",33796.00);
INSERT INTO producto (nombre,precio) VALUES ("garbanzo",86495.00);
INSERT INTO producto (nombre,precio) VALUES ("vino espumoso",47392.00);
INSERT INTO producto (nombre,precio) VALUES ("arroz",67370.00);
INSERT INTO producto (nombre,precio) VALUES ("aguardiente",69188.00);
INSERT INTO producto (nombre,precio) VALUES ("condimentos mixtos",3025.00);
INSERT INTO producto (nombre,precio) VALUES ("cerezas dulces",96453.00);

INSERT INTO bodega (nombre,direccion) VALUES ("la amistad","Cra 78 # 85 -45");
INSERT INTO bodega (nombre,direccion) VALUES ("santa isabel","Calle 34 # 45 -85");
INSERT INTO bodega (nombre,direccion) VALUES ("santa cecilia","Cra 89 # 54 – 39");

INSERT INTO empleado (nombre,idBodega,edad) VALUES ("Sylvester Leonard",1,24);
INSERT INTO empleado (nombre,idBodega,edad) VALUES ("Ferdinand Dixon",1,23);
INSERT INTO empleado (nombre,idBodega,edad) VALUES ("Amanda Ayala",1,18);
INSERT INTO empleado (nombre,idBodega,edad) VALUES ("Stephen I. Caldwell",1,18);
INSERT INTO empleado (nombre,idBodega,edad) VALUES ("Abraham Shepherd",1,19);
INSERT INTO empleado (nombre,idBodega,edad) VALUES ("Libby J. Hendricks",2,51);
INSERT INTO empleado (nombre,idBodega,edad) VALUES ("Sebastian C. Fleming",2,50);
INSERT INTO empleado (nombre,idBodega,edad) VALUES ("Taylor Z. Oliver",3,37);
INSERT INTO empleado (nombre,idBodega,edad) VALUES ("Nora D. Erickson",3,32);
INSERT INTO empleado (nombre,idBodega,edad) VALUES ("Leila Huffman",3,34);
INSERT INTO empleado (nombre,idBodega,edad) VALUES ("Colby M. Stephenson",3,31);

INSERT INTO almacena (idBodega,cantidad,idproducto) VALUES (1,65,1);
INSERT INTO almacena (idBodega,cantidad,idproducto) VALUES (1,11,4);
INSERT INTO almacena (idBodega,cantidad,idproducto) VALUES (1,48,10);
INSERT INTO almacena (idBodega,cantidad,idproducto) VALUES (2,63,2);
INSERT INTO almacena (idBodega,cantidad,idproducto) VALUES (2,35,3);
INSERT INTO almacena (idBodega,cantidad,idproducto) VALUES (2,85,6);
INSERT INTO almacena (idBodega,cantidad,idproducto) VALUES (3,11,2);
INSERT INTO almacena (idBodega,cantidad,idproducto) VALUES (3,13,3);
INSERT INTO almacena (idBodega,cantidad,idproducto) VALUES (3,19,7);
INSERT INTO almacena (idBodega,cantidad,idproducto) VALUES (3,24,8);