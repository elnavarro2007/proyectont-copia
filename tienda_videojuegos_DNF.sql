-- Base de datos de tienda de juegos




-- CREO LA BASE SI NO EXISTE
CREATE DATABASE if not EXISTS tiendaVideojuegos;

USE tiendaVideojuegos;



CREATE TABLE tienda (
	id int PRIMARY key Auto_increment,
	nombre_tienda VARCHAR(40) NOT NULL,
	telefono int(9) not NULL,
	stock INT DEFAULT 0,
	ubicacion VARCHAR(80)
	
	
);

CREATE TABLE empleado (
	
	dni CHAR(9) PRIMARY KEY,
	nombre VARCHAR(30) not NULL,
	apellidos VARCHAR(50) not NULL,
	telefono INT(9),
	id_tienda INT ,
	dni_supervisor CHAR(9),
	
	CONSTRAINT FK_IDENTIFICACION_TIENDA FOREIGN KEY (id_tienda) REFERENCES tienda (id)
	
	
);

CREATE table dependiente (
	
	dni_dependiente CHAR(9) PRIMARY KEY,
	
	CONSTRAINT fk_dni_dependiente FOREIGN KEY (dni_dependiente) REFERENCES empleado (dni)


);

CREATE table reponedor (
	
	dni_reponedor CHAR(9) PRIMARY KEY,
	
	CONSTRAINT fk_dni_reponedor FOREIGN KEY (dni_reponedor) REFERENCES empleado (dni)


);

CREATE table cliente (

	dni CHAR(9) PRIMARY KEY,
	nombre VARCHAR(30) not NULL,
	apellidos VARCHAR(50) not NULL,
	telefono CHAR(9),
	correo VARCHAR(50) UNIQUE,
	dni_dependiente CHAR(9),
	CONSTRAINT fk_dni_dependiente_atiende FOREIGN KEY (dni_dependiente) REFERENCES dependiente (dni_dependiente)



);

create table proveedor (

	id INT PRIMARY KEY Auto_increment,
	nombre_proveedor VARCHAR(40) NOT NULL unique ,
	telefono INT(9) not NULL,
	ubicacion VARCHAR(80)


);

create table videojuego (

	numero_serie CHAR(9)  PRIMARY KEY UNIQUE,
	nombre VARCHAR(50) not null UNIQUE,
	genero VARCHAR(20),
	id_proveedor int,
	precio DECIMAL(4,2),
	
	
	CONSTRAINT fk_id_proveedor FOREIGN KEY (id_proveedor) REFERENCES proveedor (id)




);

create table ficha (

	id_registro INT Primary Key Auto_increment,
	fecha_entrada DATE not null,
	fecha_Salida DATE not  null,
	dni_empleado CHAR(9),
	
	
	CONSTRAINT fk_dni_empleado FOREIGN KEY (dni_empleado) REFERENCES empleado (dni)


);

CREATE TABLE TIENDA_VIDEOJUEGO (
    id_tienda INT,
    num_serie CHAR(9),    
    PRIMARY KEY (id_tienda, num_serie),
	
	CONSTRAINT FK_ID_TIENDA FOREIGN KEY (id_tienda) REFERENCES tienda (id),
	CONSTRAINT FK_NUM_TIENDA FOREIGN KEY (num_serie) REFERENCES videojuego (numero_serie)
	
	

);


create table cliente_videojuego (

	dni_cliente CHAR(9) ,
    numero_serie CHAR(9) ,
    
    PRIMARY KEY (dni_cliente, numero_serie),
	
	CONSTRAINT FK_DNI_CLIENTE FOREIGN KEY (dni_cliente) REFERENCES cliente (dni),
	CONSTRAINT FK_NUMERO_SERIE FOREIGN KEY (numero_serie) REFERENCES videojuego (numero_serie)
	
	
  


);

-- Inserciones de tabla

INSERT INTO tienda (nombre_tienda, telefono, ubicacion) VALUES
('GAME', '978345678', 'Calle del señorito 14'),
('FNAC', '978567890', 'Avenida del abuelo 23');


INSERT INTO proveedor (nombre_proveedor, telefono, ubicacion) VALUES
('LEVEL-5', '910011037', 'Calle de paris 23, Francia'),
('SEGA America', '900333444', 'Avenida las vegas 45, USA'),
('Spike Chunsoft', '900011037', 'Calle de los buenos, Japon');


INSERT INTO empleado (dni, nombre, apellidos, telefono, id_tienda) VALUES
('12345678A', 'Carlos', ' Lopez', '600232312', 1),
('87654321B', 'Cristopher', 'Martinez', '600336744', 1),
('87654121B', 'Peter', 'Martinez', '600126744', 1),
('11223344C', 'Martin', 'Fernández ', '600555646', 2);

INSERT INTO dependiente(dni_dependiente) VALUES ('12345678A'), ('87654321B');
INSERT INTO reponedor (dni_reponedor) VALUES ('11223344C');


INSERT INTO cliente (dni, nombre, apellidos,telefono ,correo, dni_dependiente) VALUES
('11111345X', 'Juan', 'Marzo ', '678678678','juanMarzo@email.com', '12345678A'),
('22222222Y', 'Martin', 'Galve ','671671671' ,'MartinbGalve@email.com', '87654321B'),
('22222212C', 'María', 'Lopez ','689689912' ,'lopez24@email.com', '87654321B');


INSERT INTO videojuego (numero_serie, nombre, genero, id_proveedor, precio) VALUES
('12312312A', 'Inazuma Eleven', 'Deportes', 1, 69.99),
('89898989Z', 'Persona 3 FES', 'Aventura', 2, 49.99),
('00900900Z', 'Zero Escape', 'Visual novel', 3, 19.99);


-- Tablas relaciones muchos a muchos

INSERT INTO tienda_videojuego (id_tienda,num_serie) VALUES 
(1, '12312312A'),
(1, '89898989Z'),
(2, '00900900Z');

INSERT INTO cliente_videojuego (dni_cliente, numero_serie) VALUES
('11111345X', '12312312A'),
('22222212C', '00900900Z');

INSERT INTO ficha (fecha_entrada, fecha_Salida, dni_empleado) VALUES
('2026-04-10 10:20:34', '2026-04-10 18:31:04', '12345678A');