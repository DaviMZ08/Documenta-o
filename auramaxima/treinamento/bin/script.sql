-- 1. Criar o Banco de Dados
CREATE DATABASE controle_frequencia;

-- (Atenção: Conecte-se ao banco de dados "controle_frequencia" antes de criar as tabelas abaixo)

-- 2. Criar a Tabela de Usuários
CREATE TABLE usuario (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    data_nascimento DATE
);

-- 3. Criar a Tabela de Categorias
CREATE TABLE categoria (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL
);

-- 4. Criar a Tabela de Produtos (com chave estrangeira para Categoria)
CREATE TABLE produto (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    preco NUMERIC(10, 2),
    categoria_id INTEGER,
    FOREIGN KEY (categoria_id) REFERENCES categoria(id)
);