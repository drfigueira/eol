insert into role (id, name, created_at, updated_at) values (1, 'ROLE_USER', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
insert into role (id, name, created_at, updated_at) values (2, 'ROLE_INSTALLER', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
insert into role (id, name, created_at, updated_at) values (3, 'ROLE_ADMIN', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

delete from user;
--Senha do admin = 123123
insert into user (id, username, password, name, email, phone, created_at, updated_at) values (1, 'vini', '$2y$10$UTKb.mhBCyBlg/P3vAAOv.zXy2OJngp0HZd5EuHIJs4gLzRVrqdRm', 'Vinicius Villa', 'vinicius.villa@ifsp.com', '16 123456789', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

--ordem de servico para testes

insert into endereco(id, cidade, bairro, rua) values (1, 'cidade', 'bairro', 'rua');
insert into ordem_servico(id, usuario_id, endereco_id, instalador_id, plano, data_criacao, data_atribuicao, dentro_prazo) values (1, 1, 1, 1, 'MONO', '2019-11-10', '2019-11-15', true);

insert into endereco(id, cidade, bairro, rua) values (2, 'cidade', 'bairro', 'rua');
insert into ordem_servico(id, usuario_id, endereco_id, instalador_id, plano, data_criacao, data_atribuicao, dentro_prazo) values (2, 1, 2, 1, 'MONO', '2019-11-10', '2019-11-15', true);

insert into endereco(id, cidade, bairro, rua) values (3, 'cidade', 'bairro', 'rua');
insert into ordem_servico(id, usuario_id, endereco_id, instalador_id, plano, data_criacao, data_atribuicao, dentro_prazo) values (3, 1, 3, 1, 'MONO', '2019-11-10', '2019-11-15', true);

insert into endereco(id, cidade, bairro, rua) values (4, 'cidade', 'bairro', 'rua');
insert into ordem_servico(id, usuario_id, endereco_id, instalador_id, plano, data_criacao, data_atribuicao, dentro_prazo) values (4, 1, 4, 1, 'MONO', '2019-11-10', '2019-11-15', true);

insert into user_roles values(1,1);
insert into user_roles values(1,3);