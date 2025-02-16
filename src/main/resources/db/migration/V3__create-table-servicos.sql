create table servicos(
    ID bigint not null auto_increment,
    NOME_SERVICO varchar(250) not null unique,
    VALOR double not null,

    primary key(ID)
)