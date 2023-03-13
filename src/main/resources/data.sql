CREATE TABLE estados
(
    id IDENTITY NOT NULL PRIMARY KEY,
    nome_estado VARCHAR(50) NOT NULL,
    nome_pais VARCHAR(50) NOT NULL
);

INSERT INTO estados (id, nome_estado, nome_pais) VALUES (1,'São Paulo', 'Brasil');
INSERT INTO estados (id, nome_estado, nome_pais) VALUES (2,'Rio de Janeiro', 'Brasil');
INSERT INTO estados (id, nome_estado, nome_pais) VALUES (3,'Goiânia', 'Brasil');
