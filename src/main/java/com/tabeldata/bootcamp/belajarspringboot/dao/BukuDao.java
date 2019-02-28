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

@Repository
@Transactional(readOnly = true)
public class BukuDao {

	@Autowired
	private JdbcTemplate jdbc;

	public List<Buku> daftarList() {
		String sql = "select * from buku";
		return this.jdbc.query(sql, new BukuRowMapper());
	}

	public Buku findById(String primaryKey) throws EmptyResultDataAccessException {
		String sql = "select * from buku where id = ?";
		return this.jdbc.queryForObject(sql, new BukuRowMapper(), new Object[] { primaryKey });
	}

	public List<Buku> findByNamaAndNamaPengarang(String nama, String pengarang) {
		String sql = "select * from buku where nama like ? and nama_pengarang like ?";
		return this.jdbc.query(sql, new BukuRowMapper(),
				new Object[] { new StringBuilder("%").append(nama).append("%").toString(),
						new StringBuilder().append(pengarang).append("%").toString() });
	}

	@Transactional
	public void save(Buku buku) {
		String sql = "insert into buku(id, nama, isbn, nama_pengarang, penerbit, tahun_terbit, created_by) values (?, ?, ?, ?, ?, ?, ?)";
		this.jdbc.update(sql, new InsertBuku(buku));
	}

	public class InsertBuku implements PreparedStatementSetter {

		final Buku buku;

		public InsertBuku(Buku buku) {
			this.buku = buku;
		}

		@Override
		public void setValues(PreparedStatement ps) throws SQLException {
			ps.setString(1, buku.getId());
			ps.setString(2, buku.getNama());
			ps.setString(3, buku.getIsbn());
			ps.setString(4, buku.getNamaPengarang());
			ps.setString(5, buku.getPenerbit());
			ps.setInt(6, buku.getTahunTerbit());
			ps.setString(7, buku.getCreatedBy());
		}

	}

	private class BukuRowMapper implements RowMapper<Buku> {

		@Override
		public Buku mapRow(ResultSet rs, int rowNum) throws SQLException {
			Buku aBuku = new Buku();
			aBuku.setId(rs.getString("id"));
			aBuku.setNama(rs.getString("nama"));
			aBuku.setIsbn(rs.getString("isbn"));
			aBuku.setTahunTerbit(rs.getInt("tahun_terbit"));
			aBuku.setNamaPengarang(rs.getString("nama_pengarang"));
			aBuku.setPenerbit(rs.getString("penerbit"));
			aBuku.setCreatedDate(rs.getTimestamp("created_date"));
			aBuku.setLastUpdatedDate(rs.getTimestamp("last_updated_date"));
			aBuku.setLastUpdatedBy(rs.getString("last_updated_by"));
			return aBuku;
		}

	}

}
