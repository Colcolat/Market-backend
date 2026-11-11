-- Datos de ejemplo para probar los endpoints. Ejecutar después de schema.sql:
--   psql -h localhost -U postgres -d market-api-3-b-26-2 -f database/data.sql

INSERT INTO categorias (descripcion, estado) VALUES
    ('Frutas y verduras', TRUE),
    ('Lácteos', TRUE),
    ('Bebidas', TRUE);

INSERT INTO productos (nombre, id_categoria, codigo_barras, precio_venta, cantidad_stock, estado) VALUES
    ('Manzana',      1, '7501000000011', 12.50, 100, TRUE),
    ('Plátano',      1, '7501000000028',  8.00,   5, TRUE),
    ('Leche entera', 2, '7501000000035', 28.90,  40, TRUE),
    ('Yogur natural',2, '7501000000042', 15.00,   3, TRUE),
    ('Agua 1L',      3, '7501000000059', 10.00, 200, TRUE);

INSERT INTO clientes (id, nombre, apellidos, celular, direccion, correo_electronico) VALUES
    ('1001', 'Cliente', 'De Prueba', '5550000000', 'Calle Falsa 123', 'cliente@ejemplo.com');
