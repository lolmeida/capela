update sql7509759.tCargas set EURM3 = 0 where EURM3 is null;
update sql7509759.tCargas set Peso = 0 where Peso is null;
update sql7509759.tCargas set Valor = 0 where Valor is null;

delete  from nccargas.tClientes;
insert into nccargas.tClientes
(IdCliente,
Cliente,
Telefone,
Morada,
Nota,
-- Data,
Activo,
Tipo,
Email)
select tClientes.IdCliente,
    tClientes.Cliente,
    tClientes.Telefone,
    tClientes.Morada,
    tClientes.Nota,
    -- tClientes.Data,
    1,
    'CLI',
    tClientes.Email
from sql7509759.tClientes;
insert into nccargas.tClientes
(IdCliente,
Cliente,
Telefone,
Morada,
Nota,
-- Data,
Tipo,
Activo,
Email)
select tDestinatarios.IdDestinatario,
    tDestinatarios.Destinatario,
    tDestinatarios.Telefone,
    tDestinatarios.Morada,
    tDestinatarios.Nota,
    -- tDestinatarios.Date,
    'DES',
    1,
    tDestinatarios.Email
from sql7509759.tDestinatarios
where IdDestinatario not in (
select distinct IdCliente from nccargas.tClientes);

delete from nccargas.tCargas_tDimensoes;
insert into nccargas.tCargas_tDimensoes(Carga_Guia,IdDimensoes_IdDimensoes)
select Guia, IdDimensoes from tDimensoes;



delete from nccargas.tDimensoes;
insert into nccargas.tDimensoes
(Guia,
IdDimensoes,
Vol,
Comprimento,
Altura,
Largura,
Nota,
Activo,
Foto)
select tDimensoes.Guia,
    tDimensoes.IdDimensoes,
    tDimensoes.Vol,
    tDimensoes.Comprimento,
    tDimensoes.Altura,
    tDimensoes.Largura,
    tDimensoes.Nota,
    1,
    tDimensoes.Foto
from sql7509759.tDimensoes;

insert into nccargas.tCargas
(IdRegisto,
Guia,
Data,
Cliente,
Destinatario,
vReceber,
ListaArnaud,
CodigoDespacho,
M3Arnaud,
ListaEnvio,
Foto,
Descricao,
Nota,
Status,
Confiavel,
EURM3,
EURM3Arnaud,
Counter,
Utilizador,
Quantidade,
Peso,
Tipo,
Valor,
Activo,
BL)
select tCargas.IdRegisto,
    tCargas.Guia,
    tCargas.Data,
    tCargas.Cliente,
    tCargas.Destinatario,
    tCargas.vReceber,
    tCargas.ListaArnaud,
    tCargas.CodigoDespacho,
    tCargas.M3Arnaud,
    tCargas.ListaEnvio,
    tCargas.Foto,
    tCargas.Descricao,
    tCargas.Nota,
    tCargas.Status,
    tCargas.Confiavel,
    tCargas.EURM3,
    tCargas.EURM3Arnaud,
    tCargas.Counter,
    tCargas.Utilizador,
    tCargas.Quantidade,
    tCargas.Peso,
    tCargas.Tipo,
    tCargas.Valor,
    1,
    tCargas.BL
from sql7509759.tCargas;

