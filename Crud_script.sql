create database crud_erick;
use crud_erick;

create table Personas(
	Id_persona int primary key auto_increment,
    Username varchar(100),
	Nombre varchar(100),
    Apellido varchar(100), 
    Telefono varchar(100),
    Password varchar(100)
);

create table Productos(
	Id_producto int primary key not null auto_increment,
    NombreProducto varchar(100) not null,
    MarcaProducto varchar(100) not null,
    CategoriaProducto varchar(100) not null,
    PrecioProducto int not null,
    StockProducto int not null
);

drop table productos;

select * from personas;