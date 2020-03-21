INSERT INTO `estudomorpheos`.`TbPerfilAcesso` (`idPerfilAcesso`,`dsPerfil`) VALUES (1,'Master');
INSERT INTO `estudomorpheos`.`TbPerfilAcesso` (`idPerfilAcesso`,`dsPerfil`) VALUES (2,'Cadastro');
INSERT INTO `estudomorpheos`.`TbPerfilAcesso` (`idPerfilAcesso`,`dsPerfil`) VALUES (3,'Consulta');
INSERT INTO `estudomorpheos`.`TbPerfilAcesso` (`idPerfilAcesso`,`dsPerfil`) VALUES (4,'Aprovador');


INSERT INTO `estudomorpheos`.`TbUnidadePesquisa` (`idUnidadePesquisa`,`dsUnidade`,`siglaUnidade`,`telUnidade`,`endereco`,`cidade`,`uf`,`cep`,`investigador`,`coordenador`,`email`,`nuUnidade`)VALUES(1,'Centro Coordenador - Instituto do Coração, InCor','HCFMUSP','','','São Paulo','SP','','Prof Dr Geraldo Lorenzi Filho','Daniel Barboza Cava Queiróz e  Gabriela Areias de Souza','estudomorpheos@yahoo.com.br',1);
INSERT INTO `estudomorpheos`.`TbUnidadePesquisa` (`idUnidadePesquisa`,`dsUnidade`,`siglaUnidade`,`telUnidade`,`endereco`,`cidade`,`uf`,`cep`,`investigador`,`coordenador`,`email`,`nuUnidade`)VALUES(2,'Hospital Universitário','USP','','','São Paulo','SP','','Dr. Luciano Drager','','luciano.drager@incor.usp.br',2);


INSERT INTO `estudomorpheos`.`TbUsuarioSistema`(`idUsuarioSistema`,`idUnidadePesquisa`,`idPerfil`,`username`,`nome`,`senha`,`email`,`flSenhaTemporaria`,`flAtivo`,`fone`,`dtInclusao`,`admin`)VALUES(1,1,1,'admin','Usuario Admin','711be3iidqb6lrsln0avp0v21u','',0,1,null,now(),null)