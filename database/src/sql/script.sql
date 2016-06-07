-- URL JDBC para acessar o banco de dados.
--jdbc:derby:C:\\banco-de-teste;create=true

create table produto (
  numero int,
  tipo int,
  nome varchar(255)
)

select numero, tipo, nome from produto

insert into produto (numero, tipo, nome) values (1, 1, 'Sabão')
insert into produto (numero, tipo, nome) values (2, 1, 'Sabonete')
insert into produto (numero, tipo, nome) values (3, 2, 'Arroz')

create table tipo (
  numero int,
  nome varchar(255)
)

insert into tipo (numero, nome) values (1, 'Limpeza')
insert into tipo (numero, nome) values (2, 'Alimento')

select numero, nome from tipo

select
    t.nome as nome_tipo,
    p.nome as nome_produto
from
    produto as p,
    tipo as t
where
    p.tipo = t.numero

select
    t.nome as nome_tipo,
    p.nome as nome_produto
from
    produto as p,
    tipo as t
where
    p.tipo = t.numero
    and
    t.nome = 'Limpeza'
    
select
    count(*) as quantidade
from
    produto

update tipo set nome = 'Alimentício' where nome = 'Alimento'

delete from produto where nome = 'Sabonete'

drop table produto

drop table tipo