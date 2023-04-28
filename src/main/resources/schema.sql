

CREATE TABLE IF NOT EXISTS `articulos` (
  `id` bigint auto_increment,
  `nombre` varchar(30) NOT NULL DEFAULT '',
  `precio` float NOT NULL DEFAULT '0',
  `codigo` varchar(7) NOT NULL DEFAULT '',
  `grupo` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
);


CREATE TABLE IF NOT EXISTS `clientes` (
  `id`  bigint auto_increment,
  `nombre` varchar(60) NOT NULL DEFAULT '',
  `direccion` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`id`)
);


CREATE TABLE IF NOT EXISTS `facturas` (
  `id`  bigint auto_increment,
  `fecha` date DEFAULT NULL,
  `cliente` int(11) NOT NULL DEFAULT '0',
  `vendedor` int(11) NOT NULL,
  `formapago` varchar(20) DEFAULT 'Contado',
  PRIMARY KEY (`id`)
);


CREATE TABLE IF NOT EXISTS `grupos` (
  `id`  bigint auto_increment,
  `descripcion` varchar(15) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
);


CREATE TABLE IF NOT EXISTS `lineas_factura` (
  `linea` int(11) NOT NULL,
  `factura` int(11) NOT NULL DEFAULT '0',
  `articulo` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `importe` float NOT NULL DEFAULT '0',
  PRIMARY KEY (`linea`,`factura`)
) ;


CREATE TABLE IF NOT EXISTS `vendedores` (
  `id`  bigint auto_increment,
  `nombre` varchar(50) NOT NULL DEFAULT '',
  `fecha_ingreso` date NOT NULL,
  `salario` float NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ;

CREATE TABLE IF NOT EXISTS `sagas` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`nombre` VARCHAR(50) NOT NULL,
	`anyoinicio` INT,
	`anyofinal` INT,
	PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `peliculas` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`nombre` VARCHAR(100) NOT NULL,
	`saga` INT NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `demo` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`texto` VARCHAR(100),
	`numero` INT,
	`decimal` DOUBLE,
	`fechastamp` TIMESTAMP,
	`fecha` DATE,
	`hora` TIME,
	PRIMARY KEY (`id`)
);


