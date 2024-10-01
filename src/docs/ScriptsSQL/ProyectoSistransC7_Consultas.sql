--RFC1
SELECT almacenajes.bodega b, almacenajes.producto p, productos.volumen*almacenajes.cantidad/almacenajes.capacidad indice_ocupacion FROM almacenajes INNER JOIN productos ON almacenajes.producto = productos.cod_barras INNER JOIN bodegas on almacenajes.bodega = bodegas.id WHERE bodegas.sucursal = 1;

--RFC2.1
SELECT * FROM productos WHERE precio_unitario BETWEEN 500 AND 5000;
--RFC2.2
SELECT * FROM productos WHERE fecha_vencimiento > TO_DATE('2024-01-01', 'YYYY-MM-DD');
--RFC2.3
SELECT * FROM productos WHERE fecha_vencimiento < TO_DATE('2024-01-01', 'YYYY-MM-DD');
--RFC2.4
SELECT * FROM productos INNER JOIN almacenajes ON productos.cod_barras=almacenajes.producto INNER JOIN bodegas ON bodegas.id=almacenajes.bodega WHERE bodegas.sucursal = 5;
--RFC2.5
SELECT * FROM productos INNER JOIN categorias ON productos.categoria=categorias.codigo WHERE categorias.codigo = 3;

--RFC3
SELECT * FROM almacenajes WHERE almacenajes.bodega = 6;
--RFC4
SELECT * FROM sucursales INNER JOIN bodegas ON bodegas.sucursal=sucursales.id INNER JOIN almacenajes on bodegas.id=almacenajes.bodega WHERE almacenajes.producto = 1;

--RFC5
SELECT productos.cod_barras id, productos.nombre nombre, almacenajes.bodega bodega, ofertas.proveedor proveedor, bodegas.sucursal sucursal, almacenajes.cantidad cantidad FROM productos INNER JOIN almacenajes ON productos.cod_barras=almacenajes.producto INNER JOIN bodegas ON bodegas.id = almacenajes.bodega INNER JOIN ofertas ON productos.cod_barras=ofertas.producto WHERE almacenajes.cantidad<almacenajes.nivel_minimo;