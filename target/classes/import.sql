INSERT INTO tienda (localidad, direccion, encargado, fecha_inicio) VALUES ('Centro', 'Av. Principal 123', 'Juan Perez', '2024-01-01');
INSERT INTO cliente (nombre, apellido, celular, cedula, correo) VALUES ('Maria', 'Gonzalez', '123456789', '01020304', 'maria@example.com');
INSERT INTO comida ( nombre_comida, bebida, cantidad_comida, cantidad_bebida, precio_comida, precio_bebida) VALUES ('Empanada de trigo mixta', 'Avena', 1, 2, 4200, 4000);
INSERT INTO empleado (nombre, apellido, cedula, turno, telefono, tienda_id) VALUES ('Carlos', 'Lopez', '12345678', 'Mañana', '987654321', 1);
INSERT INTO tienda (localidad, direccion, encargado, fecha_inicio) VALUES ('Centro', 'Av. Principal 123', 'Juan Perez', '2024-01-01');
INSERT INTO cliente (nombre, apellido, celular, cedula, correo) VALUES ('Maria', 'Gonzalez', '123456789', '01020304', 'maria@example.com');
INSERT INTO comida (nombre_comida, bebida, cantidad_comida, cantidad_bebida, precio_comida, precio_bebida) VALUES ('Empanada de trigo mixta', 'Avena', 1, 2, 4200, 4000);
INSERT INTO empleado (nombre, apellido, cedula, turno, telefono, tienda_id) VALUES ('Carlos', 'Lopez', '12345678', 'Mañana', '987654321', 1);

-- Inserciones en la tabla pedido
INSERT INTO pedido (cliente_id, comida_id, empleado_id, direccion, envio_local) VALUES ( 1, 1, 1,'Mi casa','Local');
INSERT INTO pedido (cliente_id, comida_id, empleado_id, direccion, envio_local) VALUES ( 2, 2, 2,'Tu casa','Local');

-- Inserciones en la tabla tiendaPedido
INSERT INTO PEDIDO_TIENDA  (pedido_id, tienda_id) VALUES (1, 1);
INSERT INTO PEDIDO_TIENDA  (pedido_id, tienda_id) VALUES (2, 2);