drop table presa if exists;
drop table grado if exists;
drop sequence if exists hibernate_sequence;
create sequence hibernate_secuence start with 100 increment by 1;

create table grado (
	id bigint not null,
	nombre varchar (200),
	destacada boolean not null,
primary key (id)
);

create table presa (
	id bigint not null,
	nombre varchar (512),
	precio float not null,
imagen varchar (512),
grado_id bigint,
primary key (id)
);

create table calidad (
	id bigint not null auto_increment,
	composicion varchar(40),
	presa_id bigint,
	primary key (id)
);

alter table presas add constraint fk_presa_grado foreign key (grado_id) references grado on delete cascade on update cascade;
alter table calidad add constraint fk_calidad_presa foreign key (presa_id) references presa on delete cascade on update cascade;

CREATE INDEX presas_indice ON presa(nombre);
CREATE INDEX grado_indice ON grado(nombre);
