-- Inserir Categorias
INSERT INTO category (category_id, name) VALUES (1, 'Eletrônicos');
INSERT INTO category (category_id, name) VALUES (2, 'Alimentos');
INSERT INTO category (category_id, name) VALUES (3, 'Roupas');
INSERT INTO category (category_id, name) VALUES (4, 'Livros');
INSERT INTO category (category_id, name) VALUES (5, 'Móveis');

-- Inserir Usuários
INSERT INTO users (user_id, name, email, password, role) VALUES (1, 'Camila Kfouri', 'camila@email.com', 'admin123', 'ADMIN');
INSERT INTO users (user_id, name, email, password, role) VALUES (2, 'Pedro Santos', 'pedro@email.com', 'manager123', 'MANAGER');
INSERT INTO users (user_id, name, email, password, role) VALUES (3, 'Ana Costa', 'ana@email.com', 'user123', 'USER');
INSERT INTO users (user_id, name, email, password, role) VALUES (4, 'Lucas Oliveira', 'lucas@email.com', 'user123', 'USER');
INSERT INTO users (user_id, name, email, password, role) VALUES (5, 'Mariana Lima', 'mariana@email.com', 'manager123', 'MANAGER');

-- Inserir Produtos
INSERT INTO product (product_id, name, price, description, amount, category_id) VALUES (1, 'Notebook Dell', 3500.00, 'Notebook Dell Inspiron 15', 10, 1);
INSERT INTO product (product_id, name, price, description, amount, category_id) VALUES (2, 'Mouse Logitech', 150.00, 'Mouse Logitech MX Master 3', 25, 1);
INSERT INTO product (product_id, name, price, description, amount, category_id) VALUES (3, 'Arroz Integral', 25.00, 'Arroz Integral 1kg', 100, 2);
INSERT INTO product (product_id, name, price, description, amount, category_id) VALUES (4, 'Camiseta Básica', 49.90, 'Camiseta 100% Algodão', 50, 3);
INSERT INTO product (product_id, name, price, description, amount, category_id) VALUES (5, 'Clean Code', 89.90, 'Livro Clean Code - Robert Martin', 15, 4);
INSERT INTO product (product_id, name, price, description, amount, category_id) VALUES (6, 'Mesa de Escritório', 850.00, 'Mesa de Escritório em MDF', 8, 5);
INSERT INTO product (product_id, name, price, description, amount, category_id) VALUES (7, 'Feijão Preto', 12.00, 'Feijão Preto 1kg', 80, 2);
INSERT INTO product (product_id, name, price, description, amount, category_id) VALUES (8, 'Teclado Mecânico', 450.00, 'Teclado Mecânico RGB', 20, 1);