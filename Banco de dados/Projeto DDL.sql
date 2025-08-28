create schema ecommerce;
-- create table <schema>.<nome_da_tabela>
create table ecommerce.cliente (
    -- informar_colunas
	-- nome_da_coluna_e_depois_tipo_de_dados
    id_cliente int primary key generated always as identity,
	nome_completo text unique not null,
	email text unique not null,
	senha varchar (15) unique not null,
	telefone varchar (11) unique not null,
	data_cadastro timestamptz not null
	
);
alter table ecommerce.cliente
add column data_cadastro timestamp with time zone default now(); -- caso nao coloque a data o sistema colocara automaticamente
create table ecommerce.produto (

       id_produto int primary key generated always as identity,
	   nome_produto text not null,
	   descricao text,
	   preco numeric (12,2) not null,
	   estoque_disponivel int not null,
	   imagem_url text
);
create table ecommerce.pedido (
	   id_pedido int primary key generated always as identity,
	   -- maneira extensa de fazer a chave estrangeira
	   id_cliente int,
	   foreign key (id_cliente) references ecommerce.cliente(id_cliente),
	   data_pedido timestamptz not null,
		valor_total numeric (14,4) not null,
		status text not null
);
create table ecommerce.pagamento(
	   id_pagamento int primary key generated always as identity,
	   id_pedido int,
	   foreign key (id_pedido) references ecommerce.pedido(id_pedido),
	   forma_pagamento text not null,
	   status text not null,
	   DATA_PAGAMENTO timestamptz not null 	
);
create table ecommerce.item_do_pedido(
	   id_item int,
	   id_produto int,
	   foreign key (id_produto) references ecommerce.produto(id_produto),
	   id_pedido int references ecommerce.pedido (id_pedido),
	   quantidade int not null

);
alter table ecommerce.cliente
add column cpf varchar (14) unique;
-- APAGAR TABELA - DROP TABLE
/*DROP TABLE ecommerce.cliente;
drop table ecommerce.produto;
drop table ecommerce.pedido;
alter table
rename to
renomear tabela
*/
create schema clinica;
create table clinica.medico (
    id_medico int primary key generated always as identity,
	nome text not null,
	crm text not null,
	especialidade text not null
);
create table clinica.paciente (
    cpf varchar (11) unique,
	nome text not null,
	idade int not null,
	data_nascimento timestamptz not null
);
alter table clinica.paciente
add constraint chk_data_nascimento
check (

	data_nascimento > 1930 and
	data_nascimento <= extract (year from current_date) -- Pega o ano atual
)

create table clinica.clinica (
    id_clinica int primary key generated always as identity,
	nome text not null,
	endereco text not null,
	descricao text
);
create table clinica.consulta (
    id_consulta int primary key generated always as identity,
	data timestamptz not null,
	id_medico int references clinica.medico (id_medico),
	id_clinica int references clinica.clinica (id_clinica),
	cpf varchar (11) not null references clinica.paciente (cpf),
	valor numeric (10,4)
);
/*
set search_path to clinica;
usado pra colocar sua tabela em algum schema
if not exists; por do lado schema e so vai criar se caso o schema nao existir
*/

