CREATE TABLE IF NOT EXISTS aluno 
( id INT AUTO_INCREMENT PRIMARY KEY ,   
 nome VARCHAR(45) NULL ,   
 sexo VARCHAR(1) NULL ,  
 rg VARCHAR(45) NULL ,   
 dataNascimento DATE NULL ,   
 situacao VARCHAR(1) NULL ,  
 email VARCHAR(45) NULL ,   
 endereco VARCHAR(45) NULL ,   
 telefone VARCHAR(45) NULL );
 
CREATE TABLE IF NOT EXISTS usuario 
( id_usuario INT AUTO_INCREMENT PRIMARY KEY , 
 nome VARCHAR(45) NOT NULL , 
 senha VARCHAR(45) NOT NULL , 
 login VARCHAR(45) NOT NULL );
