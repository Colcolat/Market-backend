-- Esquema de la base de datos de market-backend.
-- Generado a partir de las entidades JPA en persistence/entity.
-- Uso:
--   psql -h localhost -U postgres -d market-api-3-b-26-2 -f database/schema.sql

-- Categoria
CREATE TABLE IF NOT EXISTS categorias (
    id_categoria SERIAL PRIMARY KEY,
    descripcion  VARCHAR(45) NOT NULL,
    estado       BOOLEAN     NOT NULL DEFAULT TRUE
);

-- Producto
CREATE TABLE IF NOT EXISTS productos (
    id_producto    SERIAL PRIMARY KEY,
    nombre         VARCHAR(45)    NOT NULL,
    id_categoria   INTEGER        NOT NULL REFERENCES categorias (id_categoria),
    codigo_barras  VARCHAR(150),
    precio_venta   NUMERIC(16, 2) NOT NULL,
    cantidad_stock INTEGER        NOT NULL DEFAULT 0,
    estado         BOOLEAN        NOT NULL DEFAULT TRUE
);

-- Cliente (el id es un String asignado por la aplicación, no autogenerado)
CREATE TABLE IF NOT EXISTS clientes (
    id                 VARCHAR(20) PRIMARY KEY,
    nombre             VARCHAR(40),
    apellidos          VARCHAR(100),
    celular            VARCHAR(20),
    direccion          VARCHAR(80),
    correo_electronico VARCHAR(70)
);

-- Compra
CREATE TABLE IF NOT EXISTS compras (
    id_compra  SERIAL PRIMARY KEY,
    id_cliente VARCHAR(20) NOT NULL REFERENCES clientes (id),
    fecha      TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP,
    medio_pago VARCHAR(20),
    comentario VARCHAR(300),
    estado     VARCHAR(20)
);

-- CompraProducto (llave compuesta CompraProductoPK: id_compra + id_producto)
CREATE TABLE IF NOT EXISTS compras_productos (
    id_compra   INTEGER        NOT NULL REFERENCES compras (id_compra),
    id_producto INTEGER        NOT NULL REFERENCES productos (id_producto),
    cantidad    INTEGER        NOT NULL,
    total       NUMERIC(16, 2) NOT NULL,
    estado      BOOLEAN        NOT NULL DEFAULT TRUE,
    PRIMARY KEY (id_compra, id_producto)
);
