package com.tabeldata.bootcamp.belajarspringboot.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public class TransaksiDao {

//	@Autowired
//	private JdbcTemplate jdbcTemplate;
//
//	@Transactional
//	public void save(Transaksi trx) {
//		String transaksiQuery = "insert into transaksi(id, anggota_id, created_by) values (?, ?, ? )";
//		String idTransaksi = UUID.randomUUID().toString();
//		this.jdbcTemplate.update(transaksiQuery, new PreparedStatementSetter() {
//
//			@Override
//			public void setValues(PreparedStatement ps) throws SQLException {
//				ps.setString(1, idTransaksi);
//				ps.setString(2, trx.getAnggota().getId());
//				ps.setString(3, trx.getCreatedBy());
//			}
//
//		});
//
//		String detailTransaksiQuery = "insert into transaksi_detail(id, transaksi_id, buku_id) values (?, ?, ?)";
//		this.jdbcTemplate.batchUpdate(detailTransaksiQuery, new BatchPreparedStatementSetter() {
//
//			@Override
//			public void setValues(PreparedStatement ps, int i) throws SQLException {
//				TransaksiDetail detail = trx.getDetail().get(i);
//				ps.setString(1, UUID.randomUUID().toString());
//				ps.setString(2, idTransaksi);
//				ps.setString(3, detail.getBuku().getId());
//			}
//
//			@Override
//			public int getBatchSize() {
//				return trx.getDetail().size();
//			}
//		});
//	}

}
