CREATE DATABASE PaisesFJCO_DB

USE PaisesFJCO_DB

-- Crear tabla 'Paises'
CREATE TABLE Paises (
    ID INT PRIMARY KEY IDENTITY(1,1),
    Nombre VARCHAR(100),
    Descripcion VARCHAR(255),
    Continente VARCHAR(50)
);

-- Crear tabla 'Ciudades'
CREATE TABLE Ciudades (
    ID INT PRIMARY KEY IDENTITY(1,1),
    Nombre VARCHAR(100),
    Descripcion VARCHAR(255),
    Poblacion INT CHECK (Poblacion >0),
    PaisID INT,
    CONSTRAINT FK_Ciucades_Paises FOREIGN KEY (PaisID) REFERENCES Paises(ID)
);