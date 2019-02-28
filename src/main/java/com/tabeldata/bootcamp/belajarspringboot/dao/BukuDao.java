package com.tabeldata.bootcamp.belajarspringboot.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
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
		return this.jdbc.query(sql, new RowMapper<Buku>() {

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

		});
	}
	
	private class BukuRowMapper implements RowMapper<Buku>{

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
