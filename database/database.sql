create database gameland;

use gameland;

# Vendedor: id, nome, senha, cargo, qtd_venda
create table admins (
admin_id varchar(30) not null,
# Nome
admin_name varchar(100) not null,
# Senha
admin_password varchar(100) not null,
# Cargo
admin_job smallint not null,
# Quantidade de vendas realizadas
admin_sales int,
primary key (admin_id)
);

# Jogos: código do produto, nome preço, quantidade, descrição
create table games (
game_id int not null auto_increment,
game_name varchar(100) not null,
# Preço
game_price real,
# Quantidade disponível
game_amount int,
# Genero
game_genre varchar(50),
# Data lançamento
game_release varchar(30),

primary key (game_id)
);



insert into admins values ("admin_victor", "Victor Pontes", "admvictor", 0, 0);
insert into admins values ("admin_danielle", "Danielle Alves", "admdanielle", 0, 0);
insert into admins values ("admin_rodrigo", "Rodrigo Cerqueira", "admrodrigo", 0, 0);
insert into admins values ("admin_jociara", "Jociara", "admjociada", 0, 0);
insert into admins values ("emp_vendedor1", "Vendedor 1", "vendedor1", 1, 0);
insert into admins values ("emp_vendedor2", "Vendedor 2", "vendedor2", 1, 0);
insert into admins values ("emp_vendedor3", "Vendedor 3", "vendedor3", 1, 0);
insert into admins values ("emp_vendedor4", "Vendedor 4", "vendedor4", 1, 0);
insert into admins values ("emp_vendedor5", "Vendedor 5", "vendedor5", 1, 0);
insert into admins values ("emp_vendedor6", "Vendedor 6", "vendedor6", 1, 0);

select * from admins;