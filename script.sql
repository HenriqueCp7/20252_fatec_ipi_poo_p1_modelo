SELECT * FROM historico_ataques;

SELECT * FROM resultados_rodada;

CREATE TABLE historico_ataques (
    id_personagem SERIAL PRIMARY KEY,
    nome_personagem VARCHAR(100) NOT NULL,
    nome_arma VARCHAR(100) NOT NULL,
    vezes_usada INTEGER
);

CREATE TABLE resultados_rodada (
    id_resultado SERIAL PRIMARY KEY,
    data_atual TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    nome_personagem VARCHAR(100) NOT NULL,
    resultado TEXT NOT NULL,
    rodada INTEGER NOT NULL
);
