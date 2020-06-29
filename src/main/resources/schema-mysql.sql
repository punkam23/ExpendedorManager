DROP TABLE IF EXISTS detalle;
DROP TABLE IF EXISTS articulo;
DROP TABLE IF EXISTS factura;
DROP TABLE IF EXISTS expendedor;

CREATE TABLE articulo (
  id_articulo INT AUTO_INCREMENT,
  nombre_articulo VARCHAR(255) DEFAULT NULL,
  precio INT DEFAULT NULL,
  PRIMARY KEY(id_articulo)
);


CREATE TABLE expendedor (
  id_expendedor INT AUTO_INCREMENT,
  nombre_expendedor VARCHAR(255) DEFAULT NULL,
  ubicacion VARCHAR(255) DEFAULT NULL,
  modelo VARCHAR(255) DEFAULT NULL,
  PRIMARY KEY(id_expendedor)
);

DROP TABLE IF EXISTS factura;
CREATE TABLE factura (
  id_factura INT AUTO_INCREMENT,
  id_expendedor INT DEFAULT NULL,
  fecha DATE DEFAULT NULL,
  PRIMARY KEY (id_factura),
  CONSTRAINT FK5jx5ffsjle0xh63xkmacxjcca FOREIGN KEY (id_expendedor)
  REFERENCES expendedor (id_expendedor)
);


CREATE TABLE detalle (
  id_detalle INT AUTO_INCREMENT,
  cantidad INT DEFAULT NULL,
  id_articulo INT,
  id_factura INT,
  PRIMARY KEY (id_detalle),
  CONSTRAINT FKdx52pxbvxsubfbu9wsjy66bsl FOREIGN KEY (id_factura)
  REFERENCES factura (id_factura),
  CONSTRAINT FKlmc9v4wcq8waya098eoh7lc5v FOREIGN KEY (id_articulo)
  REFERENCES articulo (id_articulo)
);