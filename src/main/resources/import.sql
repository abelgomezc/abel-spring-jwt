INSERT INTO roles (name) VALUES ('CUSTOMER');
INSERT INTO roles (name) VALUES ('ADMIN')

INSERT INTO users (id, username, email,password) VALUES (1, 'abel', 'abel@gmail.com',  '$2a$10$jKL90T4RXsKBI2Y5CTjJ4u7f7XBabF06Q0nrbq5rMl8srmS/sRVeS');
INSERT INTO users (id, username, email, password) VALUES (2, 'admin', 'admin@gmail.com', '$2a$10$jKL90T4RXsKBI2Y5CTjJ4u7f7XBabF06Q0nrbq5rMl8srmS/sRVeS');
INSERT INTO users (id, username, email, password) VALUES (3, 'orejitas', 'orejitas@gmail.com', '$2a$10$jKL90T4RXsKBI2Y5CTjJ4u7f7XBabF06Q0nrbq5rMl8srmS/sRVeS');

INSERT INTO users_roles (user_id, role_id) VALUES (1, 1);
INSERT INTO users_roles (user_id, role_id) VALUES (2, 2);
INSERT INTO users_roles (user_id, role_id) VALUES (2, 1);
INSERT INTO users_roles (user_id, role_id) VALUES (3, 2);




-- Inserta datos en la tabla 'Factura'
INSERT INTO factura (id, fecha, total, user_id) VALUES (1, '2024-10-21', 500.00, 1);
INSERT INTO factura (id, fecha, total, user_id) VALUES (2, '2024-10-22', 300.00, 2);


-- Inserta datos en la tabla 'Producto'
INSERT INTO producto (id, nombre, descripcion, precio_unitario,stock) VALUES (1, 'Producto A', 'Descripción del producto A', 50.00,50);
INSERT INTO producto (id, nombre, descripcion, precio_unitario,stock) VALUES (2, 'Producto B', 'Descripción del producto B', 100.00, 30);
INSERT INTO producto (id, nombre, descripcion, precio_unitario,stock) VALUES (3, 'Producto C', 'Descripción del producto C', 150.00, 20);


-- Inserta datos en la tabla 'DetalleFactura'



-- Inserta datos en la tabla 'DetalleFactura'
INSERT INTO detalle_factura (id, cantidad,  factura_id, producto_id ) VALUES (1, 2,1, 1);
INSERT INTO detalle_factura (id, cantidad,  factura_id, producto_id) VALUES (2, 3,1, 2);
INSERT INTO detalle_factura (id, cantidad,  factura_id, producto_id) VALUES (3, 1, 2, 3);




