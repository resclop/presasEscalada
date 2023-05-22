drop table presa if exists;
drop table calidad if exists;	
drop table grado if exists; 
drop sequence if exists hibernate_sequence;
create sequence hibernate_sequence start with 100 increment by 1;

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
calidad_id bigint,
primary key (id)
);

create table calidad (
	id bigint not null auto_increment,
	composicion varchar(40),
	primary key (id)
);

alter table presa add constraint fk_presa_grado foreign key (grado_id) references grado(id) on delete cascade on update cascade;
alter table presa add constraint fk_presa_calidad foreign key (calidad_id) references calidad(id) on delete cascade on update cascade;

CREATE INDEX presa_indice ON presa(nombre);
CREATE INDEX grado_indice ON grado(nombre);
