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