DROP DATABASE CAKEPHP;
CREATE DATABASE CAKEPHP;
USE CAKEPHP;

CREATE TABLE usuario(
	ID INT AUTO_INCREMENT PRIMARY KEY,
	NOME VARCHAR(25) NOT NULL,
	SENHA TEXT NOT NULL,
	EMAIL VARCHAR(50) NOT NULL,
	ENDERECO VARCHAR(150) NOT NULL,
	ADMINISTRADOR BOOLEAN NOT NULL DEFAULT FALSE
);

CREATE TABLE ARQUIVOS(
	ID INT AUTO_INCREMENT PRIMARY KEY,
	ID_USUARIO INT NOT NULL,
	NOME VARCHAR(50) NOT NULL,
	DIRETORIO VARCHAR(255) NOT NULL,
	FORMATO VARCHAR(25) NOT NULL,
	FOREIGN KEY (ID_USUARIO) REFERENCES USUARIO(ID)
);