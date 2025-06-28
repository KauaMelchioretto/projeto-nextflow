CREATE SCHEMA IF NOT EXISTS projeto_nextflow;

USE projeto_nextflow;

CREATE TABLE IF NOT EXISTS postagens (
    uuid BINARY(16) PRIMARY KEY NOT NULL UNIQUE,
    titulo VARCHAR(120) NOT NULL,
    conteudo VARCHAR(255) NOT NULL,
    autor VARCHAR(255) NOT NULL,
    curtidas INTEGER,
    palavras_chave VARCHAR(255),
    publicado_em DATE,
    alterado_em DATE
    );
