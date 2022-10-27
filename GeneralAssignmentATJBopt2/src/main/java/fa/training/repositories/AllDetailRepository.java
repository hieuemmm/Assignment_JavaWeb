package fa.training.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import fa.training.dto.IAllDetailDTO;
import fa.training.entites.KhachHang;
import fa.training.entites.SuDungDichVu;

@Repository
public interface AllDetailRepository extends JpaRepository<KhachHang, String>{
	//"SELECT kh.maKH, kh.tenKH, sdm.maMay, m.viTri, m.trangThai, sdm.ngayBatDauSuDung, sdm.gioBatDauSuDung, sdm.thoiGianSuDung, sddv.maDV, sddv.ngaySuDung, sddv.gioSuDung, sddv.soLuong, dv.donGia " +
	@Query(value = 
				"SELECT kh.maKH, kh.tenKH, sdm.maMay, m.viTri, m.trangThai, sdm.ngayBatDauSuDung, sdm.gioBatDauSuDung, sdm.thoiGianSuDung, SUM(sddv.soLuong * dv.donGia) tongCong " +
				"FROM KhachHang kh " +
				"LEFT JOIN SuDungDichVu sddv ON kh.maKH = sddv.maKH " +
				"LEFT JOIN DichVu dv ON dv.maDV = sddv.maDV " +
	            "INNER JOIN SuDungMay sdm ON kh.maKH = sdm.maKH " +
				"INNER JOIN May m ON m.maMay = sdm.maMay " +
				"WHERE sddv.ngaySuDung = sdm.ngayBatDauSuDung " +
	            "GROUP BY  kh.maKH, kh.tenKH, sdm.maMay, m.viTri, m.trangThai, sdm.ngayBatDauSuDung, sdm.gioBatDauSuDung, sdm.thoiGianSuDung " +
				"ORDER BY sdm.ngayBatDauSuDung DESC, trangThai DESC OFFSET ?1 ROWS FETCH NEXT ?2 ROWS ONLY;",
			nativeQuery = true)
	List<IAllDetailDTO> getAllDetail(int start, int size);
	
	@Query(value = 
			"SELECT kh.maKH, kh.tenKH, sdm.maMay, m.viTri, m.trangThai, sdm.ngayBatDauSuDung, sdm.gioBatDauSuDung, sdm.thoiGianSuDung, sdm.trangThaiThanhToan, SUM(sddv.soLuong * dv.donGia) tongCong " +
			"FROM KhachHang kh " +
			"LEFT JOIN SuDungDichVu sddv ON kh.maKH = sddv.maKH " +
			"LEFT JOIN DichVu dv ON dv.maDV = sddv.maDV " +
            "INNER JOIN SuDungMay sdm ON kh.maKH = sdm.maKH " +
			"INNER JOIN May m ON m.maMay = sdm.maMay " +
			"WHERE sdm.trangThaiThanhToan = ?3 " +
            "GROUP BY  kh.maKH, kh.tenKH, sdm.maMay, m.viTri, m.trangThai, sdm.ngayBatDauSuDung, sdm.gioBatDauSuDung, sdm.thoiGianSuDung, sdm.trangThaiThanhToan " +
			"ORDER BY sdm.ngayBatDauSuDung DESC, trangThai DESC OFFSET ?1 ROWS FETCH NEXT ?2 ROWS ONLY;",
		nativeQuery = true)
	List<IAllDetailDTO> getAllDetail_All(int i, int pageSize, boolean statusPayment);
}
