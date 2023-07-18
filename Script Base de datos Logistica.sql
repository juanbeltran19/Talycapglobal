-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         5.5.46 - MySQL Community Server (GPL)
-- SO del servidor:              Win64
-- HeidiSQL Versión:             11.0.0.5919
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Volcando estructura de base de datos para bdlogistica
CREATE DATABASE IF NOT EXISTS `bdlogistica` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `bdlogistica`;

-- Volcando estructura para tabla bdlogistica.cliente
CREATE TABLE IF NOT EXISTS `cliente` (
  `IDENTIFICACION` varchar(10) NOT NULL DEFAULT '',
  `NOMBRES` varchar(20) DEFAULT NULL,
  `APELLIDOS` varchar(20) DEFAULT NULL,
  `DIRECCION` varchar(50) DEFAULT NULL,
  `TELEFONO` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`IDENTIFICACION`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla bdlogistica.cliente: ~5 rows (aproximadamente)
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` (`IDENTIFICACION`, `NOMBRES`, `APELLIDOS`, `DIRECCION`, `TELEFONO`) VALUES
	('1', 'Tania', 'Ramos', 'Calle 8', '3219876543'),
	('2', 'Juan', 'Beltran', 'Calle 49 DD #86-9', '3013807123'),
	('3', 'Roberto', 'Merlano', 'Sincelejo', '3013807123'),
	('4', 'Karen', 'Talicap', 'Calle 10', '3219876543'),
	('5', 'Lina', 'Talcap', 'Calle 11', '3219876543');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;

-- Volcando estructura para tabla bdlogistica.envioclientemaritima
CREATE TABLE IF NOT EXISTS `envioclientemaritima` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `IDENTIFICACION` varchar(10) DEFAULT NULL,
  `NUMEROFLOTA` varchar(8) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla bdlogistica.envioclientemaritima: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `envioclientemaritima` DISABLE KEYS */;
/*!40000 ALTER TABLE `envioclientemaritima` ENABLE KEYS */;

-- Volcando estructura para tabla bdlogistica.envioclienteterrestre
CREATE TABLE IF NOT EXISTS `envioclienteterrestre` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `IDENTIFICACION` varchar(10) DEFAULT NULL,
  `PLACAVEHICULO` varchar(6) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla bdlogistica.envioclienteterrestre: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `envioclienteterrestre` DISABLE KEYS */;
/*!40000 ALTER TABLE `envioclienteterrestre` ENABLE KEYS */;

-- Volcando estructura para tabla bdlogistica.logisticamaritima
CREATE TABLE IF NOT EXISTS `logisticamaritima` (
  `TIPODEPRODUCTO` varchar(50) DEFAULT NULL,
  `CANTIDADPRODUCTO` int(10) DEFAULT NULL,
  `FECHAREGISTRO` varchar(10) DEFAULT NULL,
  `FECHAENTREGA` varchar(10) DEFAULT NULL,
  `PUERTOENTREGA` varchar(50) DEFAULT NULL,
  `PRECIOENVIO` int(10) DEFAULT NULL,
  `NUMEROFLOTA` varchar(8) NOT NULL DEFAULT '',
  `NUMEROGUIA` varchar(10) DEFAULT NULL,
  `DESCUENTO` int(10) DEFAULT NULL,
  PRIMARY KEY (`NUMEROFLOTA`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla bdlogistica.logisticamaritima: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `logisticamaritima` DISABLE KEYS */;
INSERT INTO `logisticamaritima` (`TIPODEPRODUCTO`, `CANTIDADPRODUCTO`, `FECHAREGISTRO`, `FECHAENTREGA`, `PUERTOENTREGA`, `PRECIOENVIO`, `NUMEROFLOTA`, `NUMEROGUIA`, `DESCUENTO`) VALUES
	('Maritima', 5, '18/07/2023', '18/07/2023', 'Medellin', 50000, 'ABC0000D', 'A123456789', 0),
	('Maritima', 12, '18/07/2023', '18/07/2023', 'Medellin', 20000, 'ABC1234D', 'A987654321', 1000);
/*!40000 ALTER TABLE `logisticamaritima` ENABLE KEYS */;

-- Volcando estructura para tabla bdlogistica.logisticaterrestre
CREATE TABLE IF NOT EXISTS `logisticaterrestre` (
  `TIPODEPRODUCTO` varchar(50) DEFAULT NULL,
  `CANTIDADPRODUCTO` int(10) DEFAULT NULL,
  `FECHAREGISTRO` varchar(10) DEFAULT NULL,
  `FECHAENTREGA` varchar(10) DEFAULT NULL,
  `BODEGAENTREGA` varchar(50) DEFAULT NULL,
  `PRECIOENVIO` int(10) DEFAULT NULL,
  `PLACAVEHICULO` varchar(6) NOT NULL DEFAULT '',
  `NUMEROGUIA` varchar(10) DEFAULT NULL,
  `DESCUENTO` int(10) DEFAULT NULL,
  PRIMARY KEY (`PLACAVEHICULO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla bdlogistica.logisticaterrestre: ~4 rows (aproximadamente)
/*!40000 ALTER TABLE `logisticaterrestre` DISABLE KEYS */;
INSERT INTO `logisticaterrestre` (`TIPODEPRODUCTO`, `CANTIDADPRODUCTO`, `FECHAREGISTRO`, `FECHAENTREGA`, `BODEGAENTREGA`, `PRECIOENVIO`, `PLACAVEHICULO`, `NUMEROGUIA`, `DESCUENTO`) VALUES
	('Terrestre', 11, '17/07/2023', '17/07/2023', 'Medellin', 10000, 'ABC012', 'A987654321', 500),
	('Terrestre', 1, '17/07/2023', '17/07/2023', 'Medellin', 10000, 'ABC123', 'A123456789', 0),
	('Terrestre', 5, '17/07/2023', '17/07/2023', 'Medellin', 10000, 'DEF012', 'A987654321', 0),
	('Terrestre', 11, '17/07/2023', '17/07/2023', 'Medellin', 10000, 'DEF123', 'A987654321', 500);
/*!40000 ALTER TABLE `logisticaterrestre` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
