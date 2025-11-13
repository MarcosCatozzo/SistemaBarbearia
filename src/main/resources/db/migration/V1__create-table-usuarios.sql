create table usuarios(
    id bigint not null auto_increment,
    nome varchar(100) not null unique,
    email varchar(100) not null unique,
    telefone varchar(50) not null unique,
    senha varchar(250) not null,
    primary key(ID)
)