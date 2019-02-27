# Springboot

Buat user dan database di postgresql dengan perintah:

Login to postgresql:

```bash
psql -h localhost -U postgres
```

Membuat user dan database:

```bash 
-- create user schema di database postgresql
create user bootcamp with superuser login password 'bootcamp';

-- create database
create database bootcamp;
```