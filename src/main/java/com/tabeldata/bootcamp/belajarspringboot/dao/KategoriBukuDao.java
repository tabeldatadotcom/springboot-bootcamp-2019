package com.tabeldata.bootcamp.belajarspringboot.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tabeldata.bootcamp.belajarspringboot.model.Buku;
import com.tabeldata.bootcamp.belajarspringboot.model.Kategori;

@Repository
@Transactional(readOnly = true)
public class KategoriBukuDao {

	@Autowired
	private JdbcTemplate jdbc;

	public List<Kategori> daftarList() {
		String sql = "select * from kategori_buku";
		return this.jdbc.query(sql, new KategoriRowMapper());
	}
	
	public List<Kategori> daftarKategoriByBuku(Buku buku) {
		String sql = "select k.id, k.nama, k.keterangan from kategori_buku k join daftar_kategori_buku d on k.id = d.kategori_id where d.buku_id = ?";
		return this.jdbc.query(sql, new KategoriRowMapper(), new Object[] {buku.getId()});
	}

	public Kategori findById(String primaryKey) throws EmptyResultDataAccessException {
		String sql = "select * from kategori_buku where id = ?";
		return this.jdbc.queryForObject(sql, new KategoriRowMapper(), new Object[] { primaryKey });
	}

	@Transactional
	public void save(Kategori buku) {
		String sql = "insert into kategori_buku(id, nama, keterangan) values (?, ?, ?)";
		this.jdbc.update(sql, new InsertKategoriBuku(buku));
	}

	@Transactional
	public void update(Kategori buku) {
		String sql = "update buku set " + "nama = ?, " + "keterangan = ?, " + "where id = ?";
		this.jdbc.update(sql, new UpdateKategoriBuku(buku));
	}

	@Transactional
	public void delete(String id) {
		String sql = "delete from buku where id = ?";
		this.jdbc.update(sql, new Object[] { id });
	}

	public class UpdateKategoriBuku implements PreparedStatementSetter {

		final Kategori kategori;

		public UpdateKategoriBuku(Kategori kategori) {
			this.kategori = kategori;
		}

		@Override
		public void setValues(PreparedStatement ps) throws SQLException {
			ps.setString(1, kategori.getNama());
			ps.setString(2, kategori.getKeterangan());
			ps.setString(3, kategori.getId());
		}

	}

	public class InsertKategoriBuku implements PreparedStatementSetter {

		final Kategori kategori;

		public InsertKategoriBuku(Kategori kategori) {
			this.kategori = kategori;
		}

		@Override
		public void setValues(PreparedStatement ps) throws SQLException {
			ps.setString(1, kategori.getId());
			ps.setString(2, kategori.getNama());
			ps.setString(3, kategori.getKeterangan());
		}

	}

	private class KategoriRowMapper implements RowMapper<Kategori> {

		@Override
		public Kategori mapRow(ResultSet rs, int rowNum) throws SQLException {
			Kategori kategori = new Kategori();
			kategori.setId(rs.getString("id"));
			kategori.setNama(rs.getString("nama"));
			kategori.setKeterangan(rs.getString("keterangan"));
			return kategori;
		}

	}

}
