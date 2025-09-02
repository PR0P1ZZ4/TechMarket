create schema serralheria;

create table serralheria.fornecedor (

	id_fornecedor int primary key generated always as identity,
	nome text not null

);
create table serralheria.materia_prima(

	id_item int primary key generated always as identity,
	nome text not null,
	estoque int not null,
	unidade_medida text not null,
	custo_unitario int not null,
	id_fornecedor int not null references serralheria.fornecedor(id.fornecedor)

);
create table serralheria.material_necessario (

	id_material int primary key generated always as identity,
	chapa text not null,
	fixacoes text not null,
	tinta text not null

);





