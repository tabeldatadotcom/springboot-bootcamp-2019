create table rak(
	id character varying(64) not null primary key,
	nama character varying(64) not null,
	nomor int not null default 0
);

alter table buku
add column rak_id character varying(64);

alter table buku
add constraint fk_buku_rak foreign key (rak_id)
references rak(id) on update cascade on delete restrict;

insert into rak(id, nama, nomor) values 
('001', 'Komputer', 1), 
('002', 'Komputer', 2), 
('003', 'Matematika', 1);

update buku set rak_id = '001' where id = 'prog-java';