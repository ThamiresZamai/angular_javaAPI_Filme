CREATE TABLE sugestaofilme.detalhes
(
  imdbid varchar(100) primary key,
  duracao varchar (30) NULL,
  genero varchar(500) NULL,
  diretor varchar(500) NULL,
  atores varchar(1000) NULL,
  sinopse varchar(1500) NULL
);


CREATE TABLE sugestaofilme.filme
(
  nome varchar(100) NULL,
  ano varchar(200) NULL,
  imdbID varchar(200)primary key NULL,
  imdbID_detalhe varchar(200),
  CONSTRAINT fk_filme_detalhes FOREIGN KEY (imdbID_detalhe)
      REFERENCES sugestaofilme.detalhes (imdbid)
  
);


