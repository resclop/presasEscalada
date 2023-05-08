drop table presas if exists;
drop table dificultad if exists;
drop sequence if exists hibernate_sequence;
create sequence hibernate_secuence start with 100 increment by 1;

create table grado (
	id bigint not null,
	nombre varchar (200),
primary key (id)
);

create table presas (
	id bigint not null,
	nombre varchar (512),
	precio float not null,
imagen varchar (512),
grado_id bigint,
primary key (id)
);

create table calidad (
	id bigint not null auto_increment,
	composicion varchar(400),
	presas_id bigint,
	primary key (id)
);

alter table presas add constraint fk_presas_grado foreign key (grado_id) references grado;
alter table calidad add constraint fk_calidad_presas foreign key (presas_id) references presas;
