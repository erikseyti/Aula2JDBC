drop table if exists itemConta;
drop table if exists conta;
drop table if exists cliente;

create table cliente(
id serial not null
,nome varchar(50)
,constraint pk_cliente primary key (id)
);

insert into cliente (nome) values ('João');
insert into cliente (nome) values ('Joaquina');

select * from cliente;

create table conta(
id serial not null
,saldo numeric(7,2) default 0 not null
,cliente_id int not null
,constraint pk_conta primary key (id)
,constraint fk_cliente foreign key (cliente_id) references cliente
);


insert into conta(saldo,cliente_id) values (1000,1);
insert into conta (saldo,cliente_id) values (2000,2);

select * from conta;

INSERT INTO CLIENTE (NOME) VALUES ('666');

create table itemConta(
id serial not null
,natureza char
,conta_id int not null
,constraint pk_itemConta primary key (id)
,constraint fk_conta foreign key (conta_id) references conta
);

select * from itemConta;