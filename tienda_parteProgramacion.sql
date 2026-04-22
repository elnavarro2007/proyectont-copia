-- Base de datos de tienda de juegos parte de programaciob




-- CREO LA BASE SI NO EXISTE
CREATE DATABASE if not EXISTS tiendaDeVideojuegos;

USE tiendaDeVideojuegos;


CREATE TABLE tienda (
	id int PRIMARY key AUTO_INCREMENT,
	nombre_tienda VARCHAR(30) NOT NULL,
	telefono int(9) NOT NULL,
	ubicacion VARCHAR(40) NOT NULL,
	correo varchar(50) NOT NULL UNIQUE
	
);

CREATE table cliente (

	dni CHAR(9) PRIMARY KEY,
	nombre VARCHAR(30) NOT NULL,
	apellidos VARCHAR(50) NOT NULL,
	telefono CHAR(9) NOT NULL,
	correo VARCHAR(150)NOT NULL UNIQUE




);


create table videojuego (

	numero_serie CHAR(9)  PRIMARY KEY UNIQUE,
	nombre VARCHAR(30) not null UNIQUE,
	genero VARCHAR(20) NOT NULL,
	precio DECIMAL(4,2) NOT NULL DEFAULT 0

);

CREATE TABLE TIENDA_VIDEOJUEGO (
    id_tienda INT,
    num_serie CHAR(9),    
	stock INT NOT NULL DEFAULT 0,
    PRIMARY KEY (id_tienda, num_serie),
	
	CONSTRAINT FK_ID_TIENDA FOREIGN KEY (id_tienda) REFERENCES tienda (id) on delete cascade ,
	CONSTRAINT FK_NUMSERIE_TIENDA FOREIGN KEY (num_serie) REFERENCES videojuego (numero_serie) on delete restrict
	
	

);


create table cliente_videojuego (

	dni_cliente CHAR(9) ,
    numero_serie CHAR(9) ,
    
    PRIMARY KEY (dni_cliente, numero_serie),
	
	CONSTRAINT FK_DNI_CLIENTE FOREIGN KEY (dni_cliente) REFERENCES cliente (dni) on delete restrict ,
	CONSTRAINT FK_NUMERO_SERIE FOREIGN KEY (numero_serie) REFERENCES videojuego (numero_serie) on delete restrict
	
	
  


);

 CREATE TABLE usuarios (
     id INT AUTO_INCREMENT PRIMARY KEY,
     nombre VARCHAR(75) NOT NULL ,
     password VARCHAR(75) NOT NULL,
	 correo varchar (150),
	 
	 CONSTRAINT fk_user_cliente FOREIGN KEY (correo) REFERENCES cliente(correo) ON DELETE CASCADE
	 
	 
	);
INSERT INTO usuarios (nombre, password) VALUES ('admin', '1234');

ALTER TABLE usuarios MODIFY COLUMN correo VARCHAR(150) UNIQUE;