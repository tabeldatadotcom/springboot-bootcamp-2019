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
				
-- mencari buku dan join ke tabel rak
select 
	b.id buku_id, 
	b.nama as nama_buku, 
	r.id as rak_id, 
	r.nama as rak_nama 
from 
	buku b join rak r on b.rak_id = r.id 
	join daftar_kategori_buku d on d.buku_id = b.id 
	join kategori_buku k on k.id = d.kategori_id;