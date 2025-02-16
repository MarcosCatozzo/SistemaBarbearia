create table Usuarios(
    ID bigint not null auto_increment,
    NOME varchar(100) not null unique,
    EMAIL varchar(100) not null unique,
    CPF varchar(20) not null unique,

    primary key(ID)
)