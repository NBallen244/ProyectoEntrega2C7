alter session set current_schema = ISIS2304C22202420;
ALTER SESSION SET NLS_DATE_FORMAT='YYYY-MM-DD';


drop table registros;
drop table productosOrden;
drop table ordenes;
drop table ofertas;
drop table almacenajes;
drop table proveedores;
drop table productos;
drop table categorias;
drop table bodegas;
drop table sucursales;
drop table ciudades;


create table ciudades (
    id number(5,0),
    nombre varchar(50) not null ,
    primary key(id)
);

create table sucursales (
    id number(5,0),
    nombre varchar(50) not null ,
    tamaño number(5,0) not null,
    ciudad number(5,0) not null,
    telefono number (10,0) not null,
    direccion varchar(50) not null,
    primary key(id),
    foreign key (ciudad) references ciudades(id)
);


create table bodegas(
    id number(5,0),
    nombre varchar(50) not null ,
    tamaño number(5,0) not null,
    sucursal number(5,0) not null,
    primary key(id),
    foreign key (sucursal) references sucursales(id)
);

create table categorias(
    codigo number(5,0),
    nombre varchar(50),
    descripcion varchar(200),
    caracteristicas varchar(200),
    primary key (codigo)
);

create table productos(
    cod_barras number(5,0),
    nombre varchar(50) not null,
    costo_bodega number(5,0) not null,
    precio_unitario number(5,0) not null,
    presentacion varchar(50) not null,
    cantidad_presentacion number(10,0) not null,
    unidad_medida varchar(50) not null,
    peso number(10,0) not null,
    volumen number(10,0) not null,
    fecha_vencimiento date not null,
    categoria number(5,0) not null,
    primary key (cod_barras),
    foreign key (categoria) references categorias(codigo)
);

create table proveedores (
    nit number(9,0),
    nombre varchar(50) not null,
    contacto varchar (50) not null,
    direccion varchar (50) not null,
    tel_contacto number(10,0) not null,
    primary key (nit)
);

create table almacenajes(
    bodega number(5,0),
    producto number(5,0),
    capacidad number(10,0) not null,
    cantidad number(10,0) not null,
    costo_promedio number(10,0)not null,
    nivel_minimo number(10,0) not null,
    primary key (bodega, producto),
    foreign key (bodega) references bodegas(id),
    foreign key (producto) references productos(cod_barras)
);

create table ofertas(
    proveedor number(9,0),
    producto number(5,0),
    primary key (proveedor, producto),
    foreign key (proveedor) references proveedores(nit),
    foreign key (producto) references productos(cod_barras)
);

create table ordenes(
    id number(5,0),
    fecha_creacion date not null,
    proveedor number(9,0)not null,
    fecha_estimada date not null,
    estado varchar(25) not null,
    sucursal_destino number(5,0) not null,
    primary key (id),
    foreign key (proveedor) references proveedores(nit),
    foreign key (sucursal_destino) references sucursales(id)
);
alter table ordenes add constraint ck_estado check (estado in ('vigente', 'anulada','entregada'));

create table productosOrden (
    orden number(5,0),
    producto number(5,0),
    cantidad number(10,0) not null,
    precio_acordado number(10,0) not null,
    primary key (orden, producto),
    foreign key (orden) references ordenes(id),
    foreign key (producto) references productos(cod_barras)
);

create table registros(
    orden number(5,0),
    fecha_ingreso date not null,
    bodega number(5,0) not null,
    primary key (orden),
    foreign key (orden) references ordenes(id)
);

commit;




