alter table anggota
add column created_date timestamp not null default now();