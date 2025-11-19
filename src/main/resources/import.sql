-- Inserir Categorias (SEM IDs fixos)
INSERT INTO category (name) VALUES ('Eletrônicos');
INSERT INTO category (name) VALUES ('Alimentos');
INSERT INTO category (name) VALUES ('Roupas');
INSERT INTO category (name) VALUES ('Livros');
INSERT INTO category (name) VALUES ('Móveis');

-- Inserir Usuários (SEM IDs fixos)
INSERT INTO users (name, email, password, role) VALUES ('Camila Kfouri', 'camila@email.com', 'admin123', 'ADMIN');
INSERT INTO users (name, email, password, role) VALUES ('Pedro Santos', 'pedro@email.com', 'manager123', 'MANAGER');
INSERT INTO users (name, email, password, role) VALUES ('Ana Costa', 'ana@email.com', 'user123', 'USER');
INSERT INTO users (name, email, password, role) VALUES ('Lucas Oliveira', 'lucas@email.com', 'user123', 'USER');
INSERT INTO users (name, email, password, role) VALUES ('Mariana Lima', 'mariana@email.com', 'manager123', 'MANAGER');

-- Inserir Produtos (SEM product_id fixo, mas COM category_id)
INSERT INTO product (name, price, description, amount, category_id) VALUES ('Notebook Dell', 3500.00, 'Notebook Dell Inspiron 15', 10, 1);
INSERT INTO product (name, price, description, amount, category_id) VALUES ('Mouse Logitech', 150.00, 'Mouse Logitech MX Master 3', 25, 1);
INSERT INTO product (name, price, description, amount, category_id) VALUES ('Arroz Integral', 25.00, 'Arroz Integral 1kg', 100, 2);
INSERT INTO product (name, price, description, amount, category_id) VALUES ('Camiseta Básica', 49.90, 'Camiseta 100% Algodão', 50, 3);
INSERT INTO product (name, price, description, amount, category_id) VALUES ('Clean Code', 89.90, 'Livro Clean Code - Robert Martin', 15, 4);
INSERT INTO product (name, price, description, amount, category_id) VALUES ('Mesa de Escritório', 850.00, 'Mesa de Escritório em MDF', 8, 5);
INSERT INTO product (name, price, description, amount, category_id) VALUES ('Feijão Preto', 12.00, 'Feijão Preto 1kg', 80, 2);
INSERT INTO product (name, price, description, amount, category_id) VALUES ('Teclado Mecânico', 450.00, 'Teclado Mecânico RGB', 20, 1);