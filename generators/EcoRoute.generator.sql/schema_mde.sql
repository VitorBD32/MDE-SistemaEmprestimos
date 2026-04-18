-- Schema gerado automaticamente via Eclipse/Acceleo M2T
-- Projeto: EcoRoute-Agro

CREATE TABLE caminhao (
    id SERIAL PRIMARY KEY,
    peso_carga VARCHAR(255),
    consumo_base_litro_km VARCHAR(255),
    rota VARCHAR(255)
);

CREATE TABLE rota (
    id SERIAL PRIMARY KEY,
    id VARCHAR(255),
    trecho VARCHAR(255)
);

CREATE TABLE trecho (
    id SERIAL PRIMARY KEY,
    geometry VARCHAR(255),
    distancia_km VARCHAR(255),
    declividate_percent VARCHAR(255),
    cost VARCHAR(255)
);

CREATE TABLE ponto (
    id SERIAL PRIMARY KEY,
    coordenadas VARCHAR(255),
    trecho VARCHAR(255)
);

CREATE TABLE modelocusto (
    id SERIAL PRIMARY KEY,
    fator_correcao VARCHAR(255),
    modelocusto VARCHAR(255)
);

