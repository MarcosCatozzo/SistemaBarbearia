CREATE TABLE agendamento(
    id BIGINT NOT NULL AUTO_INCREMENT,
    cliente_id BIGINT NOT NULL,
    barbeiro_id BIGINT NOT NULL,
    data DATETIME NOT NULL,

    PRIMARY KEY(id),
    CONSTRAINT fk_agendamento_cliente_id FOREIGN KEY(cliente_id) REFERENCES usuarios(ID),
    CONSTRAINT fk_agendamento_barbeiro_id_id FOREIGN KEY(barbeiro_id) REFERENCES barbeiro(ID)
 );