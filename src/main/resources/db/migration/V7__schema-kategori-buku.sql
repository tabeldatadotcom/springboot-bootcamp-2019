create table kategori_buku(
	id character varying(64) not null primary key,
	nama character varying(100) not null,
	keterangan text
);

insert into kategori_buku(id, nama) values 
('001', 'Pemograman'), 
('002','Ilmu Komputer'), 
('003', 'Matematik'), 
('004', 'Fisika');

create table daftar_kategori_buku(
	id character varying(64) not null primary key,
	buku_id character varying(64) not null,
	kategori_id character varying(64) not null
);

alter table daftar_kategori_buku
add constraint fk_daftar_buku_id foreign key (buku_id)
references buku(id) on update cascade on delete cascade;

alter table daftar_kategori_buku
add constraint fk_daftar_kategori_id foreign key (kategori_id)
references kategori_buku(id) on update cascade on delete cascade;


insert into daftar_kategori_buku(id, buku_id, kategori_id) values 
('001','prog-java', '001'), 
('002','prog-java', '002');