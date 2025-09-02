-- DDL (Data Manipulation Language)
-- INSERT (Cadastrar)
-- UPDATE (Atualizar)
-- DELETE (Apaga)

-- OPCIONAL
-- set search_patch to clinica;
-- clinica.paciente -> paciente


-- INSERT INTO <SCHEMA>.<TABELA> (COLUNA) VALUES
insert into clinica.medico(nome, especialidade, crm) values 
('Samuel', 'Ortopedia', '123456'),
('Guilherme', 'Cardiologista', '123455'),
('Julia', 'Dentista', '123454')


--DQL (Data Query Language) - linguagem de consulta de dados
-- SELECT
-- SELECT <quais_colunas> FROM <schema.tabela>
select * from clinica.medico;

insert into ecommerce.cliente (nome_completo, email, senha, telefone, data_cadastro, cpf) values
('Samuel','samsantos1508@gmail.com','samuel1231sasas',11912341234,'2004-08-15',12312312344)
select * from ecommerce.cliente;

insert into ecommerce.pedido (data_pedido,valor_total,status) values
('2023-09-23',2340.40,'entregue'),
('2024-09-23',234.40,'entregue'),
('2025-01-23',34.40,'entregue')

select * from ecommerce.pedido;

insert into clinica.paciente(nome, cpf, idade, data_nascimento) values 
('Samuel', '12312312345', 21, '2004-08-15'),
('Julia', '12345612323', 19, '2006-11-13')
select * from clinica.paciente;

insert into clinica.clinica(nome,descricao,endereco) values
('Clinica Tiradentes', 'A clinica da zona leste', 'Rua da sorte')
select * from clinica.clinica;


insert into clinica.consulta(data,valor,id_medico,id_clinica,cpf) values
('28-08-2025 19:00:00-03', 120.50, 1, 1, 12312312345)
select * from clinica.consulta;

update clinica.consulta set valor = 200.50
where id_consulta = 1;

update clinica.consulta
set valor = 500
where valor > 500 and valor < 1000;
                -- or   

delete from clinica.medico
where especialidade = 'Ortopedia';

select 
cs.data,
cs.valor,
med.nome
from clinica.consulta as cs
join 
clinica.medico as med
on cs.id_medico = med.id_medico

select
pd.id_pedido,
cl.nome_completo

from ecommerce.pedido as pd
join ecommerce.cliente as cl
on pd.id_cliente = cl.id_cliente

select
ecommerce.id_pedido
