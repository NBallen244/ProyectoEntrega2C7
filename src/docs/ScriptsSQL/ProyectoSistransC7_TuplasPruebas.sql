alter session set current_schema = ISIS2304C22202420;
ALTER SESSION SET NLS_DATE_FORMAT='YYYY-MM-DD';

delete from productosorden;
delete from ordenes;
delete from ofertas;
delete from proveedores;
delete from almacenajes;
delete from productos;
delete from categorias;
delete from bodegas;
delete from sucursales;
delete from ciudades;

--base ciudades random
insert into ciudades (nombre, id) values ('Saribudolok', 1);
insert into ciudades (nombre, id) values ('Dongqinggou', 2);
insert into ciudades (nombre, id) values ('Nesterovskaya', 3);
insert into ciudades (nombre, id) values ('Alhambra', 4);
insert into ciudades (nombre, id) values ('Kaom', 5);
insert into ciudades (nombre, id) values ('Dubravica', 6);
insert into ciudades (nombre, id) values ('S?r?s', 7);
insert into ciudades (nombre, id) values ('Puerto L�pez', 8);
insert into ciudades (nombre, id) values ('Semikarakorsk', 9);
insert into ciudades (nombre, id) values ('Itambacuri', 10);

--base sucursales random
insert into sucursales (nombre, id, tamaño, direccion, ciudad, telefono) values ('Onsgard', 1, '8', '957 Michigan Court', 2, '803391057');
insert into sucursales (nombre, id, tamaño, direccion, ciudad, telefono) values ('Ruskin', 2, '6', '046 Kedzie Hill', 2, '839676064');
insert into sucursales (nombre, id, tamaño, direccion, ciudad, telefono) values ('Hovde', 3, '77549', '4880 Hoepker Point', 3, '855610553');
insert into sucursales (nombre, id, tamaño, direccion, ciudad, telefono) values ('Rigney', 4, '4', '837 Johnson Place', 5, '912388172');
insert into sucursales (nombre, id, tamaño, direccion, ciudad, telefono) values ('Redwing', 5, '19', '6 Lien Junction', 1, '721465833');
insert into sucursales (nombre, id, tamaño, direccion, ciudad, telefono) values ('Mendota', 6, '98', '3 Oneill Street', 1, '808734931');
insert into sucursales (nombre, id, tamaño, direccion, ciudad, telefono) values ('Spohn', 7, '23', '224 Lien Point', 10, '614240346');
insert into sucursales (nombre, id, tamaño, direccion, ciudad, telefono) values ('Shoshone', 8, '19549', '11476 Bluestem Drive', 9, '156879693');
insert into sucursales (nombre, id, tamaño, direccion, ciudad, telefono) values ('Banding', 9, '21058', '0 Dryden Hill', 9, '392382624');
insert into sucursales (nombre, id, tamaño, direccion, ciudad, telefono) values ('Shoshone', 10, '2702', '95343 Green Ridge Avenue', 5, '831449879');

--base bodegas random
insert into bodegas (id, tamaño, nombre, sucursal) values (1, '3805', 'Little Purple Monkeyflower', 1);
insert into bodegas (id, tamaño, nombre, sucursal) values (2, '2', 'Melaspilea Lichen', 2);
insert into bodegas (id, tamaño, nombre, sucursal) values (3, '198', 'Oregon Checkerbloom', 3);
insert into bodegas (id, tamaño, nombre, sucursal) values (4, '3', 'Longleaf Groundcherry', 10);
insert into bodegas (id, tamaño, nombre, sucursal) values (5, '2594', 'Lemmon''s Poppy', 5);
insert into bodegas (id, tamaño, nombre, sucursal) values (6, '6', 'Fendler''s Drymary', 5);
insert into bodegas (id, tamaño, nombre, sucursal) values (7, '55', 'Mountain Arnica', 1);
insert into bodegas (id, tamaño, nombre, sucursal) values (8, '710', 'Star Sedge', 8);
insert into bodegas (id, tamaño, nombre, sucursal) values (9, '4921', 'Mucronate Sprangletop', 8);
insert into bodegas (id, tamaño, nombre, sucursal) values (10, '645', 'Small Matweed', 10);

--categorias
insert into categorias (codigo, nombre, descripcion, caracteristicas) values (1, 'Ventosanzap', 'CEFTRIAXONE', 'BenQ-Siemens');
insert into categorias (codigo, nombre, descripcion, caracteristicas) values (2, 'Daltfresh', 'Emerald Green Neutral pH Anti-Bacterial Hand', 'Benefon');
insert into categorias (codigo, nombre, descripcion, caracteristicas) values (3, 'Redhold', 'Aplisol', 'Oppo');
insert into categorias (codigo, nombre, descripcion, caracteristicas) values (4, 'Tampflex', 'Matzim LA', 'LG');
insert into categorias (codigo, nombre, descripcion, caracteristicas) values (5, 'Bigtax', 'Ciprofloxacin', 'Honor');
insert into categorias (codigo, nombre, descripcion, caracteristicas) values (6, 'Quo Lux', 'Levetiracetam', 'BLU');
insert into categorias (codigo, nombre, descripcion, caracteristicas) values (7, 'Fintone', 'Pink Eye', 'Gigabyte');
insert into categorias (codigo, nombre, descripcion, caracteristicas) values (8, 'Zaam-Dox', 'Levofloxacin', 'Philips');
insert into categorias (codigo, nombre, descripcion, caracteristicas) values (9, 'Wrapsafe', 'cold relief', 'Qtek');
insert into categorias (codigo, nombre, descripcion, caracteristicas) values (10, 'Cardguard', 'ADVAIRDISKUS', 'Sharp');

--productos
insert into productos (cod_barras, nombre, costo_bodega, precio_unitario, presentacion, unidad_medida, peso, volumen, fecha_vencimiento, categoria, cantidad_presentacion) values (1, 'Bitwolf', '8', '375', 'Ephipplorhynchus senegalensis', 'SRR', '78626', '78626', '2023-03-15', 1, 2);
insert into productos (cod_barras, nombre, costo_bodega, precio_unitario, presentacion, unidad_medida, peso, volumen, fecha_vencimiento, categoria, cantidad_presentacion) values (2, 'Zathin', '38', '7610', 'Pytilia melba', 'PIF', '78626', '78626', '2023-11-11', 1, 2);
insert into productos (cod_barras, nombre, costo_bodega, precio_unitario, presentacion, unidad_medida, peso, volumen, fecha_vencimiento, categoria, cantidad_presentacion) values (3, 'Flowdesk', '0', '48167', 'Lamprotornis nitens', 'TND', '78626', '78626', '2023-06-23', 3, 2);
insert into productos (cod_barras, nombre, costo_bodega, precio_unitario, presentacion, unidad_medida, peso, volumen, fecha_vencimiento, categoria, cantidad_presentacion) values (4, 'Zoolab', '27', '4', 'Ateles paniscus', 'SUG', '78626', '78626', '2024-11-03', 4, 2);
insert into productos (cod_barras, nombre, costo_bodega, precio_unitario, presentacion, unidad_medida, peso, volumen, fecha_vencimiento, categoria, cantidad_presentacion) values (5, 'Wrapsafe', '4', '49', 'Anthropoides paradisea', 'KDQ', '78626', '78626', '2025-03-04', 5, 2);
insert into productos (cod_barras, nombre, costo_bodega, precio_unitario, presentacion, unidad_medida, peso, volumen, fecha_vencimiento, categoria, cantidad_presentacion) values (6, 'Stim', '12', '6105', 'Vanellus armatus', 'SKA', '78626', '78626', '2023-06-03', 6, 2);
insert into productos (cod_barras, nombre, costo_bodega, precio_unitario, presentacion, unidad_medida, peso, volumen, fecha_vencimiento, categoria, cantidad_presentacion) values (7, 'Lotlux', '443', '419', 'Dasypus septemcincus', 'ENW', '78626', '78626', '2024-08-18', 7, 2);
insert into productos (cod_barras, nombre, costo_bodega, precio_unitario, presentacion, unidad_medida, peso, volumen, fecha_vencimiento, categoria, cantidad_presentacion) values (8, 'Alphazap', '31147', '894', 'Certotrichas paena', 'CPO', '78626', '78626', '2024-03-25', 8, 2);
insert into productos (cod_barras, nombre, costo_bodega, precio_unitario, presentacion, unidad_medida, peso, volumen, fecha_vencimiento, categoria, cantidad_presentacion) values (9, 'Gembucket', '17852', '3', 'Ovis orientalis', 'SRQ', '78626', '78626', '2023-09-21', 9, 2);
insert into productos (cod_barras, nombre, costo_bodega, precio_unitario, presentacion, unidad_medida, peso, volumen, fecha_vencimiento, categoria, cantidad_presentacion) values (10, 'Solarbreeze', '233', '5552', 'Corvus albicollis', 'BOR', '78626', '78626', '2024-05-29', 10, 2);
insert into productos (cod_barras, nombre, costo_bodega, precio_unitario, presentacion, unidad_medida, peso, volumen, fecha_vencimiento, categoria, cantidad_presentacion) values (11, 'Zathin', '18', '6', 'Tockus erythrorhyncus', 'MYX', '78626', '78626', '2023-09-09', 10, 2);
insert into productos (cod_barras, nombre, costo_bodega, precio_unitario, presentacion, unidad_medida, peso, volumen, fecha_vencimiento, categoria, cantidad_presentacion) values (12, 'Sonair', '1790', '635', 'Hystrix indica', 'TMO', '78626', '78626', '2024-02-18', 2, 2);
insert into productos (cod_barras, nombre, costo_bodega, precio_unitario, presentacion, unidad_medida, peso, volumen, fecha_vencimiento, categoria, cantidad_presentacion) values (13, 'Pannier', '6', '69', 'Lepilemur rufescens', 'ARO', '78626', '78626', '2025-02-11', 4, 2);
insert into productos (cod_barras, nombre, costo_bodega, precio_unitario, presentacion, unidad_medida, peso, volumen, fecha_vencimiento, categoria, cantidad_presentacion) values (14, 'Voltsillam', '046', '2392', 'Choloepus hoffmani', 'AEQ', '78626', '78626', '2023-06-05', 9, 2);
insert into productos (cod_barras, nombre, costo_bodega, precio_unitario, presentacion, unidad_medida, peso, volumen, fecha_vencimiento, categoria, cantidad_presentacion) values (15, 'Quo Lux', '8', '585', 'Phalacrocorax carbo', 'VDP', '78626', '78626', '2024-01-06', 3, 2);
insert into productos (cod_barras, nombre, costo_bodega, precio_unitario, presentacion, unidad_medida, peso, volumen, fecha_vencimiento, categoria, cantidad_presentacion) values (16, 'Flowdesk', '3', '2605', 'Felis silvestris lybica', 'CPL', '78626', '78626', '2023-03-09', 5, 2);
insert into productos (cod_barras, nombre, costo_bodega, precio_unitario, presentacion, unidad_medida, peso, volumen, fecha_vencimiento, categoria, cantidad_presentacion) values (17, 'Gembucket', '3132', '56', 'Canis lupus lycaon', 'DZN', '78626', '78626', '2023-08-02', 5, 2);
insert into productos (cod_barras, nombre, costo_bodega, precio_unitario, presentacion, unidad_medida, peso, volumen, fecha_vencimiento, categoria, cantidad_presentacion) values (18, 'Zamit', '48', '12185', 'Pavo cristatus', 'CXL', '78626', '78626', '2025-01-26', 4, 2);

--proveedores
insert into proveedores (nit, nombre, contacto, tel_contacto, direccion) values (1, 'Flowdesk', 'Olanzapine', '1408265517', '1 Alpine Crossing');
insert into proveedores (nit, nombre, contacto, tel_contacto, direccion) values (2, 'Fixflex', 'hydroxyzine pamoate', '6667322344', '72541 Canary Circle');
insert into proveedores (nit, nombre, contacto, tel_contacto, direccion) values (3, 'Sonair', 'Bromocriptine mesylate', '7681911808', '5 Luster Court');
insert into proveedores (nit, nombre, contacto, tel_contacto, direccion) values (4, 'Flowdesk', 'Verapamil Hydrochloride', '9385739373', '1453 Petterle Place');
insert into proveedores (nit, nombre, contacto, tel_contacto, direccion) values (5, 'Holdlamis', 'Quinine Sulfate', '2173471499', '9216 Reinke Hill');
insert into proveedores (nit, nombre, contacto, tel_contacto, direccion) values (6, 'Trippledex', 'Garnier Fructis Antidandruff', '1794381739', '9 Melby Hill');
insert into proveedores (nit, nombre, contacto, tel_contacto, direccion) values (7, 'Job', 'Cepacol', '4522831991', '30 Arapahoe Terrace');
insert into proveedores (nit, nombre, contacto, tel_contacto, direccion) values (8, 'Treeflex', 'Xylocaine', '8249311316', '86 Glendale Avenue');
insert into proveedores (nit, nombre, contacto, tel_contacto, direccion) values (9, 'Flexidy', 'HEADACHE', '8232051295', '964 Truax Hill');
insert into proveedores (nit, nombre, contacto, tel_contacto, direccion) values (10, 'Ronstring', 'HELMINTHOSPORIUM SOLANI', '2325948036', '88379 Morning Center');

--almacenajes
insert into almacenajes (bodega, producto, cantidad, capacidad, costo_promedio, nivel_minimo) values ('7', '2', '6213', '78174', '58621', '8637');
insert into almacenajes (bodega, producto, cantidad, capacidad, costo_promedio, nivel_minimo) values ('8', '1', '0063', '60414', '02226', '7120');
insert into almacenajes (bodega, producto, cantidad, capacidad, costo_promedio, nivel_minimo) values ('9', '6', '7215', '43579', '44103', '8796');
insert into almacenajes (bodega, producto, cantidad, capacidad, costo_promedio, nivel_minimo) values ('9', '4', '2417', '08748', '83921', '8152');
insert into almacenajes (bodega, producto, cantidad, capacidad, costo_promedio, nivel_minimo) values ('8', '2', '9804', '32525', '42661', '7216');
insert into almacenajes (bodega, producto, cantidad, capacidad, costo_promedio, nivel_minimo) values ('9', '5', '0436', '97352', '54288', '5344');
insert into almacenajes (bodega, producto, cantidad, capacidad, costo_promedio, nivel_minimo) values ('7', '3', '9949', '86176', '89286', '7195');
insert into almacenajes (bodega, producto, cantidad, capacidad, costo_promedio, nivel_minimo) values ('5', '3', '9197', '42421', '77351', '7366');
insert into almacenajes (bodega, producto, cantidad, capacidad, costo_promedio, nivel_minimo) values ('6', '1', '6971', '34164', '47930', '0021');
insert into almacenajes (bodega, producto, cantidad, capacidad, costo_promedio, nivel_minimo) values ('5', '1', '8778', '21344', '24414', '9968');
insert into almacenajes (bodega, producto, cantidad, capacidad, costo_promedio, nivel_minimo) values ('1', '8', '1840', '58922', '02076', '1467');
insert into almacenajes (bodega, producto, cantidad, capacidad, costo_promedio, nivel_minimo) values ('5', '5', '3730', '36430', '53332', '5740');
insert into almacenajes (bodega, producto, cantidad, capacidad, costo_promedio, nivel_minimo) values ('1', '2', '3707', '95693', '78850', '6613');
insert into almacenajes (bodega, producto, cantidad, capacidad, costo_promedio, nivel_minimo) values ('6', '8', '8863', '79593', '31760', '3262');

--ofertas
insert into ofertas (proveedor, producto) values ('3', '7');
insert into ofertas (proveedor, producto) values ('6', '3');
insert into ofertas (proveedor, producto) values ('9', '4');
insert into ofertas (proveedor, producto) values ('1', '6');
insert into ofertas (proveedor, producto) values ('6', '4');
insert into ofertas (proveedor, producto) values ('1', '9');
insert into ofertas (proveedor, producto) values ('7', '5');
insert into ofertas (proveedor, producto) values ('1', '4');
insert into ofertas (proveedor, producto) values ('2', '1');
insert into ofertas (proveedor, producto) values ('3', '3');
insert into ofertas (proveedor, producto) values ('9', '3');
insert into ofertas (proveedor, producto) values ('8', '8');
insert into ofertas (proveedor, producto) values ('9', '2');
insert into ofertas (proveedor, producto) values ('7', '3');

--ordenes

insert into ordenes (id, proveedor, fecha_creacion, fecha_estimada, sucursal_destino, estado) values (1, '4', '2024-05-28', '2024-01-08', '8', 'vigente');
insert into ordenes (id, proveedor, fecha_creacion, fecha_estimada, sucursal_destino, estado) values (2, '4', '2024-09-20', '2023-12-11', '7', 'vigente');
insert into ordenes (id, proveedor, fecha_creacion, fecha_estimada, sucursal_destino, estado) values (3, '7', '2023-10-27', '2024-05-24', '2', 'vigente');
insert into ordenes (id, proveedor, fecha_creacion, fecha_estimada, sucursal_destino, estado) values (4, '2', '2024-02-09', '2024-08-04', '2', 'vigente');
insert into ordenes (id, proveedor, fecha_creacion, fecha_estimada, sucursal_destino, estado) values (5, '2', '2024-07-31', '2024-08-06', '3', 'vigente');
insert into ordenes (id, proveedor, fecha_creacion, fecha_estimada, sucursal_destino, estado) values (6, '9', '2024-02-29', '2024-07-26', '6', 'vigente');
insert into ordenes (id, proveedor, fecha_creacion, fecha_estimada, sucursal_destino, estado) values (7, '4', '2024-04-28', '2024-04-17', '6', 'vigente');
insert into ordenes (id, proveedor, fecha_creacion, fecha_estimada, sucursal_destino, estado) values (8, '3', '2024-09-20', '2023-10-22', '6', 'vigente');
insert into ordenes (id, proveedor, fecha_creacion, fecha_estimada, sucursal_destino, estado) values (9, '3', '2024-02-16', '2023-12-22', '1', 'vigente');
insert into ordenes (id, proveedor, fecha_creacion, fecha_estimada, sucursal_destino, estado) values (10, '1', '2024-09-19', '2023-12-29', '7', 'vigente');
insert into ordenes (id, proveedor, fecha_creacion, fecha_estimada, sucursal_destino, estado) values (11, '8', '2024-04-28', '2023-11-27', '9', 'vigente');
--productos ordenes

insert into productosOrden (orden, producto, cantidad, precio_acordado) values (1, 9, '410', '108');
insert into productosorden (orden, producto, cantidad, precio_acordado) values (2, 4, '784', '439');
insert into productosorden (orden, producto, cantidad, precio_acordado) values (3, 9, '368', '190');
insert into productosorden (orden, producto, cantidad, precio_acordado) values (4, 2, '735', '320');
insert into productosorden (orden, producto, cantidad, precio_acordado) values (5, 1, '399', '349');
insert into productosorden (orden, producto, cantidad, precio_acordado) values (6, 5, '655', '351');
insert into productosorden (orden, producto, cantidad, precio_acordado) values (7, 5, '652', '987');
insert into productosorden (orden, producto, cantidad, precio_acordado) values (8, 8, '646', '159');
insert into productosorden (orden, producto, cantidad, precio_acordado) values (9, 9, '805', '143');
insert into productosorden (orden, producto, cantidad, precio_acordado) values (10, 4, '799', '250');
insert into productosorden (orden, producto, cantidad, precio_acordado) values (11, 1, '225', '743');
insert into productosorden (orden, producto, cantidad, precio_acordado) values (10, 5, '680', '141');

commit;
