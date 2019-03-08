create table transaksi(
	id character varying(64) not null primary key,
	anggota_id character varying (64) not null,
	tanggal date not null default now(),
	created_date timestamp not null default now(),
	created_by character varying(64)
);

alter table transaksi
add constraint fk_transaksi_anggota_id foreign key (anggota_id)
references anggota(id) on update cascade on delete restrict;

create table transaksi_detail(
	id character varying(64) not null primary key,
	transaksi_id character varying(64) not null,
	buku_id character varying(64) not null,
	kembali boolean default false
);

alter table transaksi_detail
add constraint fk_transaksi_detail_transaksi_id foreign key (transaksi_id)
references transaksi(id) on update cascade on delete cascade;

alter table transaksi_detail
add constraint fk_transaksi_detail_buku_id foreign key (buku_id)
references buku(id) on update cascade on delete restrict;

