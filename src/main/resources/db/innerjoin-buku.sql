-- mencari data buku menggunakan inner join
select 
	b.id as buku_id, 
	b.nama as nama_buku, 
	k.id as kategori_id, 
	k.nama as kategori_nama 
from 
buku b join daftar_kategori_buku d on (b.id = d.buku_id) 
		join kategori_buku k on (d.kategori_id = k.id);
		
-- mencari data buku menggunakan outer join left
select 
	b.id as buku_id, 
	b.nama as nama_buku, 
	k.id as kategori_id, 
	k.nama as kategori_nama 
from 
buku b left join daftar_kategori_buku d on (b.id = d.buku_id) 
		left join kategori_buku k on (d.kategori_id = k.id);
		
-- mencari data buku menggunakan outer join right
select 
	b.id as buku_id, 
	b.nama as nama_buku, 
	k.id as kategori_id, 
	k.nama as kategori_nama 
from 
buku b right join daftar_kategori_buku d on (b.id = d.buku_id) 
		right join kategori_buku k on (d.kategori_id = k.id);