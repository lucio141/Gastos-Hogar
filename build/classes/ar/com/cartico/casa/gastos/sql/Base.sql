drop database gastos;
create database gastos;
use gastos;

drop table persona;
create table persona(
    id integer auto_increment primary key,
    nombre varchar (20),
    implicanciag integer,
    implicanciagf integer
);

drop table gasto_fijo;
create table gasto_fijo(
    id integer auto_increment primary key,
    año     integer unsigned not null,
    mes     enum('Enero','Febrero','Marzo','Abril','Mayo','Junio','Julio',
                        'Agosto','Septiembre','Octubre','Noviembre','Diciembre')not null,
    detalle varchar(30) not null,
    idpersona integer not null,
    monto integer not null
);

alter table gasto_fijo
add constraint FK_gasto_persona
foreign key(idpersona)
references persona(id);

drop table gasto;
create table gasto(
    id integer auto_increment primary key,
    año     integer unsigned not null,
    mes     enum('Enero','Febrero','Marzo','Abril','Mayo','Junio','Julio',
                        'Agosto','Septiembre','Octubre','Noviembre','Diciembre')not null,
    detalle varchar(30) not null,
    idpersona integer not null,
    monto integer not null
);

alter table gasto
add constraint FK_gasto_persona
foreign key(idpersona)
references persona(id);

drop table casa;
create table casa(
id integer auto_increment primary key,
nombre varchar(30)
);

insert into casa(nombre) values ("cartico");
select* from casa;

update gasto set detalle = 'Super' where detalle ='dia';

select * from persona;
select * from gasto;
select * from gasto_fijo;

insert into gasto_fijo (año, mes, detalle, idpersona, monto) values 
(2019,  'Febrero',	'Expensas',	1,	2904),
(2019,	'Febrero',	'Alquiler',	1,	5950),
(2019,	'Febrero',	'Alquiler',	2,	4618),
(2019,	'Febrero',	'Edenor',	2,	394),
(2019,	'Febrero',	'Tarjeta',	2,	2373),
(2019,	'Febrero',	'ABL',          2,	700),
(2019,	'Enero',	'ABL',          2,	559),
(2019,	'Enero',	'Alquiler',	2,	5325),
(2019,	'Enero',	'Edenor',	2,	385),
(2019,	'Enero',	'Tarjeta',	2,	2015),
(2019,	'Enero',	'Expensas',	1,	3800),
(2019,	'Enero',	'Alquiler',	1,	5325),
(2019,	'Febrero',	'Expensas',	2,	1529),
(2019,	'Marzo',	'Tarjeta',	2,	3976),
(2019,	'Marzo',	'ABL',          2,	699),
(2019,	'Marzo',	'Expensas',	1,	4511);
