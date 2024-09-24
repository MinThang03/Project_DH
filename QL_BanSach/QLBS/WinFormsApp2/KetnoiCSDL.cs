using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Data.SqlClient;
using System.Data;
using System.Drawing;
using static Azure.Core.HttpHeader;
using System.Collections;

namespace WinFormsApp2
{
    internal class KetnoiCSDL
    {
        SqlConnection connec;
        string sql = @"Data Source=ADMIN-PC;Initial Catalog=QLBH;Integrated Security=True";
        public void Moketnoi()
        {
            connec = new SqlConnection(sql);
            connec.Open();
        }
        public void Dongketnoi()
        {
            connec.Close();
        }
        public DataTable dsNhanVien()
        {
            Moketnoi();
            string query = "select * from tblNhanVien";
            SqlCommand cmd = new SqlCommand(query, connec);
            SqlDataReader r = cmd.ExecuteReader();
            DataTable bang = new DataTable();
            bang.Load(r);
            Dongketnoi();
            return bang;
        }
        public DataTable dsKhachhang()
        {
            Moketnoi();
            string query = "select * from tblKhachHang";
            SqlCommand cmd = new SqlCommand(query, connec);
            SqlDataReader r = cmd.ExecuteReader();
            DataTable bang = new DataTable();
            bang.Load(r);
            Dongketnoi();
            return bang;
        }
        public DataTable dsLoaisach()
        {
            Moketnoi();
            string query = "select * from tblLoaiSach";
            SqlCommand cmd = new SqlCommand(query, connec);
            SqlDataReader r = cmd.ExecuteReader();
            DataTable bang = new DataTable();
            bang.Load(r);
            Dongketnoi();
            return bang;
        }
        public DataTable dsSach()
        {
            Moketnoi();
            string query = "select * from tblSach";
            SqlCommand cmd = new SqlCommand(query, connec);
            SqlDataReader r = cmd.ExecuteReader();
            DataTable bang = new DataTable();
            bang.Load(r);
            Dongketnoi();
            return bang;
        }
        public DataTable dsTKS(string maloai)
        {
            Moketnoi();
            string query = "select * from tblSach where MaLoai =@ma ";
            SqlCommand cmd = new SqlCommand(query, connec);
            cmd.Parameters.AddWithValue("@ma", maloai);
            SqlDataReader r = cmd.ExecuteReader();
            DataTable bang = new DataTable();
            bang.Load(r);
            Dongketnoi();
            return bang;
        }
        public DataTable dsTKDT( string sohd)
        {
            Moketnoi();
            string query = "SELECT HDBan.*, CTHDBan.MaSach, CTHDBan.SoLuong " +
                       "FROM tblHDBan HDBan " +
                       "INNER JOIN tblCTHDBan CTHDBan ON HDBan.SoHD = CTHDBan.SoHD " +
                       "WHERE HDBan.SoHD = @so";
            SqlCommand cmd = new SqlCommand(query, connec);
            cmd.Parameters.AddWithValue("@so", sohd);
            SqlDataReader r = cmd.ExecuteReader();
            DataTable bang = new DataTable();
            bang.Load(r);
            Dongketnoi(); 
            return bang;
        }
        public DataTable dsQLNS()
        {
            Moketnoi();
            string query = "SELECT PhieuMuaHang.*, CTPhieuMua.MaLoai, CTPhieuMua.SoLuong, CTPhieuMua.GiaMua, CTPhieuMua.GhiChu " +
                           "FROM tblPhieuMuaHang AS PhieuMuaHang " +
                           "INNER JOIN tblCTPhieuMua AS CTPhieuMua ON PhieuMuaHang.SoPhieu = CTPhieuMua.SoPhieu";

            using (SqlCommand cmd = new SqlCommand(query, connec))
            {
                SqlDataReader r = cmd.ExecuteReader();
                DataTable bang = new DataTable();
                bang.Load(r);
                Dongketnoi();
                return bang;
            }
        }
        public DataTable dsQLBS()
        {
            Moketnoi();
            string query = "SELECT HDBan.*, CTHDBan.MaSach, CTHDBan.SoLuong " +
                       "FROM tblHDBan HDBan " +
                       "INNER JOIN tblCTHDBan CTHDBan ON HDBan.SoHD = CTHDBan.SoHD ";
            SqlCommand cmd = new SqlCommand(query, connec);
            SqlDataReader r = cmd.ExecuteReader();
            DataTable bang = new DataTable();
            bang.Load(r);
            Dongketnoi();
            return bang;
        }
        public bool tontaiNhanVien(string maNV)
        {
            Moketnoi();
            string query = "select * from tblNhanVien where MaNV = @ma";
            SqlCommand cmd = new SqlCommand(query, connec);
            cmd.Parameters.AddWithValue("ma", maNV);
            SqlDataReader r = cmd.ExecuteReader();
            bool kt = false;
            if (r.HasRows) kt = true;
            Dongketnoi();
            return kt;
        }
        public bool tontaiKhachHang(string maKH)
        {
            Moketnoi();
            string query = "select * from tblKhachHang where MaKH = @ma";
            SqlCommand cmd = new SqlCommand(query, connec);
            cmd.Parameters.AddWithValue("ma", maKH);
            SqlDataReader r = cmd.ExecuteReader();
            bool kt = false;
            if (r.HasRows) kt = true;
            Dongketnoi();
            return kt;
        }
        public bool tontaiLoaisach(string maSach)
        {
            Moketnoi();
            string query = "select * from tblLoaiSach where maloai = @ma";
            SqlCommand cmd = new SqlCommand(query, connec);
            cmd.Parameters.AddWithValue("ma", maSach);
            SqlDataReader r = cmd.ExecuteReader();
            bool kt = false;
            if (r.HasRows) kt = true;
            Dongketnoi();
            return kt;
        }
        public bool tontaiSach(string tensach)
        {
            Moketnoi();
            string query = "select * from tblSach where tensach = @ten";
            SqlCommand cmd = new SqlCommand(query, connec);
            cmd.Parameters.AddWithValue("ten", tensach);
            SqlDataReader r = cmd.ExecuteReader();
            bool kt = false;
            if (r.HasRows) kt = true;
            Dongketnoi();
            return kt;
        }
        public bool tontaiSophieu(string sophieu)
        {
            Moketnoi();
            string query = "select * from tblPhieuMuaHang where SoPhieu = @so";
            SqlCommand cmd = new SqlCommand(query, connec);
            cmd.Parameters.AddWithValue("so", sophieu);
            SqlDataReader r = cmd.ExecuteReader();
            bool kt = false;
            if (r.HasRows) kt = true;
            Dongketnoi();
            return kt;
        }
        public bool tontaihoadon(string hd)
        {
            Moketnoi();
            string query = "select * from tblHDBan where SoHD = @hd";
            SqlCommand cmd = new SqlCommand(query, connec);
            cmd.Parameters.AddWithValue("hd", hd);
            SqlDataReader r = cmd.ExecuteReader();
            bool kt = false;
            if (r.HasRows) kt = true;
            Dongketnoi();
            return kt;
        }
        public void themNhanVien(string ma, string ht, DateTime ns, string gt, string dc, string dt)
        {
            Moketnoi();
            string query = "insert into tblNhanVien values (@ma,@hoten,@ngaysinh,@gioitinh,@diachi,@dienthoai)";
            SqlCommand cmd = new SqlCommand(query, connec);
            cmd.Parameters.AddWithValue("ma", ma);
            cmd.Parameters.AddWithValue("hoten", ht);
            cmd.Parameters.AddWithValue("ngaysinh", ns);
            cmd.Parameters.AddWithValue("gioitinh", gt);
            cmd.Parameters.AddWithValue("diachi", dc);
            cmd.Parameters.AddWithValue("dienthoai", dt);
            cmd.ExecuteNonQuery();
            Dongketnoi();
        }
        public void themKhachHang(string ma, string ht, string dc, string dt)
        {
            Moketnoi();
            string query = "insert into tblKhachHang values (@ma,@hoten,@diachi,@dienthoai)";
            SqlCommand cmd = new SqlCommand(query, connec);
            cmd.Parameters.AddWithValue("ma", ma);
            cmd.Parameters.AddWithValue("hoten", ht);
            cmd.Parameters.AddWithValue("diachi", dc);
            cmd.Parameters.AddWithValue("dienthoai", dt);
            cmd.ExecuteNonQuery();
            Dongketnoi();
        }
        public void themLoaisach(string ma, string ten)
        {
            Moketnoi();
            string query = "insert into tblLoaiSach values (@maloai,@tenloai)";
            SqlCommand cmd = new SqlCommand(query, connec);
            cmd.Parameters.AddWithValue("maloai", ma);
            cmd.Parameters.AddWithValue("tenloai", ten);
            cmd.ExecuteNonQuery();
            Dongketnoi();
        }
        public void themSach(string mloai, string tsach, string tloai, string tgia, string NXB2, int NammXB, int Strang, float Gban, string ndung, int sluong)
        {
            Moketnoi();
            string query = "insert into tblSach values (@maloai,@tensach,@tenloai,@tacgia,@NXB,@NamXB,@sotrang,@giaban,@noidung,@soluong)";
            SqlCommand cmd = new SqlCommand(query, connec);
            cmd.Parameters.AddWithValue("maloai", mloai);
            cmd.Parameters.AddWithValue("tensach", tsach);
            cmd.Parameters.AddWithValue("tenloai", tloai);
            cmd.Parameters.AddWithValue("tacgia", tgia);
            cmd.Parameters.AddWithValue("NXB", NXB2);
            cmd.Parameters.AddWithValue("NamXB", NammXB);
            cmd.Parameters.AddWithValue("sotrang", Strang);
            cmd.Parameters.AddWithValue("giaban", Gban);
            cmd.Parameters.AddWithValue("noidung", ndung);
            cmd.Parameters.AddWithValue("soluong", sluong);
            cmd.ExecuteNonQuery();
            Dongketnoi();
        }
        public void ThemPhieuMuaHang(string soPhieu1, DateTime ngay, string tenNCC, string maNV, string soPhieu2, string MaLoai, int SoLuong, int GiaMua, string GhiChu)
        {
            Moketnoi();

            // Thêm dữ liệu vào tblPhieuMuaHang
            string queryPhieuMuaHang = "INSERT INTO tblPhieuMuaHang VALUES (@soPhieu, @ngay, @tenNCC, @maNV)";
            SqlCommand cmdPhieuMuaHang = new SqlCommand(queryPhieuMuaHang, connec);
            cmdPhieuMuaHang.Parameters.AddWithValue("soPhieu", soPhieu1);
            cmdPhieuMuaHang.Parameters.AddWithValue("ngay", ngay);
            cmdPhieuMuaHang.Parameters.AddWithValue("tenNCC", tenNCC);
            cmdPhieuMuaHang.Parameters.AddWithValue("maNV", maNV);
            cmdPhieuMuaHang.ExecuteNonQuery();

            // Thêm dữ liệu vào tblCTPhieuMua
                string queryCTPhieuMua = "INSERT INTO tblCTPhieuMua VALUES (@soPhieu, @maLoai, @soLuong, @giaMua, @ghiChu)";
                SqlCommand cmdCTPhieuMua = new SqlCommand(queryCTPhieuMua, connec);
                cmdCTPhieuMua.Parameters.AddWithValue("soPhieu", soPhieu2);
                cmdCTPhieuMua.Parameters.AddWithValue("maLoai", MaLoai);
                cmdCTPhieuMua.Parameters.AddWithValue("soLuong", SoLuong);
                cmdCTPhieuMua.Parameters.AddWithValue("giaMua", GiaMua);
                cmdCTPhieuMua.Parameters.AddWithValue("ghiChu", GhiChu);
                cmdCTPhieuMua.ExecuteNonQuery();

            Dongketnoi();
        }
        public void themHD(string hd1, DateTime ngayhd, string makh, string maNV, string ghichu, string hd2, string maloai, int soluong)
        {
            Moketnoi();

            // Thêm dữ liệu vào tblPhieuMuaHang
            string query1 = "INSERT INTO tblHDBan VALUES (@HD1, @ngay, @MAkh, @Manv,@Ghichu)";
            SqlCommand cmd1 = new SqlCommand(query1, connec);
            cmd1.Parameters.AddWithValue("HD1", hd1);
            cmd1.Parameters.AddWithValue("ngay", ngayhd);
            cmd1.Parameters.AddWithValue("MAkh", makh);
            cmd1.Parameters.AddWithValue("Manv", maNV);
            cmd1.Parameters.AddWithValue("Ghichu", ghichu);
            cmd1.ExecuteNonQuery();

            // Thêm dữ liệu vào tblCTPhieuMua
            string query2 = "INSERT INTO tblCTHDBan VALUES (@hd2, @maLoai, @soLuong)";
            SqlCommand cmd2 = new SqlCommand(query2, connec);
            cmd2.Parameters.AddWithValue("hd2", hd2);
            cmd2.Parameters.AddWithValue("maLoai", maloai);
            cmd2.Parameters.AddWithValue("soLuong", soluong);
            cmd2.ExecuteNonQuery();

            Dongketnoi();
        }

        public void suaNhanVien(string ma, string ht, DateTime ns, string gt, string dc, string dt)
        {
            Moketnoi();
            string query = "update tblNhanVien set TenNV=@hoten,NgaysinhNV=@ngaysinh,GioiTinh=@gioitinh,DiaChiNV=@diachi,DienThoaiNV=@dienthoai where MaNV=@ma";
            SqlCommand cmd = new SqlCommand(query, connec);
            cmd.Parameters.AddWithValue("ma", ma);
            cmd.Parameters.AddWithValue("hoten", ht);
            cmd.Parameters.AddWithValue("ngaysinh", ns);
            cmd.Parameters.AddWithValue("gioitinh", gt);
            cmd.Parameters.AddWithValue("diachi", dc);
            cmd.Parameters.AddWithValue("dienthoai", dt);
            cmd.ExecuteNonQuery();
            Dongketnoi();
        }
        public void suaQLNS(string sophieu1, DateTime ngay, string tenNCC, string maNV, string sophieu2, string maloai, int soluong, int giamua, string ghichu)
        {
            Moketnoi();
            string query = "UPDATE tblPhieuMuaHang SET Ngay=@ngay, TenNCC=@tenNCC, MaNV=@maNV WHERE SoPhieu=@sophieu1";
            SqlCommand cmd = new SqlCommand(query, connec);
            cmd.Parameters.AddWithValue("sophieu1", sophieu1);
            cmd.Parameters.AddWithValue("ngay", ngay);
            cmd.Parameters.AddWithValue("tenNCC", tenNCC);
            cmd.Parameters.AddWithValue("maNV", maNV);
            cmd.ExecuteNonQuery();

            // Cập nhật thông tin trong tblCTPhieuMua
            string queryCTPhieuMua = "UPDATE tblCTPhieuMua SET SoLuong=@soluong, GiaMua=@giamua, GhiChu=@ghichu WHERE SoPhieu=@sophieu2 AND MaLoai=@maloai";
            SqlCommand cmdCTPhieuMua = new SqlCommand(queryCTPhieuMua, connec);
            cmdCTPhieuMua.Parameters.AddWithValue("sophieu2", sophieu2);
            cmdCTPhieuMua.Parameters.AddWithValue("maloai", maloai);
            cmdCTPhieuMua.Parameters.AddWithValue("soluong", soluong);
            cmdCTPhieuMua.Parameters.AddWithValue("giamua", giamua);
            cmdCTPhieuMua.Parameters.AddWithValue("ghichu", ghichu);
            cmdCTPhieuMua.ExecuteNonQuery();

            Dongketnoi();
        }

        public void suaQLBS(string hd1, DateTime ngayhd, string makh, string maNV, string ghichu, string hd2, string maloai, int soluong)
        {
            Moketnoi();
            string query = "UPDATE tblHDBan SET NgayHD=@ngay, MaKH=@makh, MaNV=@maNV, GhiChu=@ghichu WHERE SoHD=@sohd";
            SqlCommand cmd = new SqlCommand(query, connec);
            cmd.Parameters.AddWithValue("sohd", hd1);
            cmd.Parameters.AddWithValue("ngay", ngayhd);
            cmd.Parameters.AddWithValue("makh", makh);
            cmd.Parameters.AddWithValue("maNV", maNV);
            cmd.Parameters.AddWithValue("ghichu", ghichu);
            cmd.ExecuteNonQuery();

            // Cập nhật thông tin trong tblCTPhieuMua
            string queryCTPhieuMua = "UPDATE tblCTHDBan SET MaSach=@maloai, SoLuong=@soluong WHERE SoHD=@hd";
            SqlCommand cmdCTPhieuMua = new SqlCommand(queryCTPhieuMua, connec);
            cmdCTPhieuMua.Parameters.AddWithValue("hd", hd2);
            cmdCTPhieuMua.Parameters.AddWithValue("maloai", maloai);
            cmdCTPhieuMua.Parameters.AddWithValue("soluong", soluong);
            cmdCTPhieuMua.ExecuteNonQuery();

            Dongketnoi();
        }
        public void suaKhachHang(string ma, string ht, string dc, string dt)
        {
            Moketnoi();
            string query = "update tblKhachHang set TenKH=@hoten,DiaChiKH=@diachi,DienThoaiKH=@dienthoai where MaKH=@ma";
            SqlCommand cmd = new SqlCommand(query, connec);
            cmd.Parameters.AddWithValue("ma", ma);
            cmd.Parameters.AddWithValue("hoten", ht);
            cmd.Parameters.AddWithValue("diachi", dc);
            cmd.Parameters.AddWithValue("dienthoai", dt);
            cmd.ExecuteNonQuery();
            Dongketnoi();
        }
        public void suaLoaisach(string ma, string ten)
        {
            Moketnoi();
            string query = "update tblLoaiSach set tenloai=@ten where maloai=@ma";
            SqlCommand cmd = new SqlCommand(query, connec);
            cmd.Parameters.AddWithValue("ma", ma);
            cmd.Parameters.AddWithValue("ten", ten);
            cmd.ExecuteNonQuery();
            Dongketnoi();
        }
        public void suaSach(string mloai, string tsach, string tloai, string tgia, string NXB2, int NammXB, int Strang, float Gban, string ndung, int sluong)
        {
            Moketnoi();
            string query = "update tblSach set maloai=@ma,tenloai=@loai,tacgia=@tg,NXB=@NXB,NamXB=@NamXB,sotrang=@strang,giaban=@gban,noidung=@ndung,soluong=@sl where tensach=@ten";
            SqlCommand cmd = new SqlCommand(query, connec);
            cmd.Parameters.AddWithValue("ma", mloai);
            cmd.Parameters.AddWithValue("ten", tsach);
            cmd.Parameters.AddWithValue("loai", tloai);
            cmd.Parameters.AddWithValue("tg", tgia);
            cmd.Parameters.AddWithValue("NXB", NXB2);
            cmd.Parameters.AddWithValue("NamXB", NammXB);
            cmd.Parameters.AddWithValue("strang", Strang);
            cmd.Parameters.AddWithValue("gban", Gban);
            cmd.Parameters.AddWithValue("ndung", ndung);
            cmd.Parameters.AddWithValue("sl", sluong);
            cmd.ExecuteNonQuery();
            Dongketnoi();
        }
        public void xoaNhanVien( string maNV)
        {
            Moketnoi();
            string query = "DELETE FROM tblNhanVien WHERE MaNV = @ma";
            SqlCommand cmd = new SqlCommand(query, connec);
            cmd.Parameters.AddWithValue("@ma", maNV);
            cmd.ExecuteNonQuery();
            Dongketnoi();
        }
        public void xoaQLNS(string sophieu)
        {
            Moketnoi();
            string query1 = "DELETE FROM tblPhieuMuaHang WHERE SoPhieu = @so";
            SqlCommand cmd1 = new SqlCommand(query1, connec);
            cmd1.Parameters.AddWithValue("@so", sophieu);
            cmd1.ExecuteNonQuery();

            string query2 = "DELETE FROM tblCTPhieuMua WHERE SoPhieu = @so";
            SqlCommand cmd2 = new SqlCommand(query2, connec);
            cmd2.Parameters.AddWithValue("@so", sophieu);
            cmd2.ExecuteNonQuery();

            Dongketnoi();
        }
        public void xoaQLBS(string sohd)
        {
            Moketnoi();
            string query1 = "DELETE FROM tblHDBan WHERE SoHD = @so";
            SqlCommand cmd1 = new SqlCommand(query1, connec);
            cmd1.Parameters.AddWithValue("@so", sohd);
            cmd1.ExecuteNonQuery();

            string query2 = "DELETE FROM tblCTHDBan WHERE SoHD = @so";
            SqlCommand cmd2 = new SqlCommand(query2, connec);
            cmd2.Parameters.AddWithValue("@so", sohd);
            cmd2.ExecuteNonQuery();

            Dongketnoi();
        }
        public void xoaKhachHang(string maKH)
        {
            Moketnoi();
            string query = "DELETE FROM tblKhachHang WHERE MaKH = @ma";
            SqlCommand cmd = new SqlCommand(query, connec);
            cmd.Parameters.AddWithValue("@ma", maKH);
            cmd.ExecuteNonQuery();
            Dongketnoi();
        }
        public void xoaLoaisach(string maloai)
        {
            Moketnoi();
            string query = "DELETE FROM tblLoaiSach WHERE maloai = @ma";
            SqlCommand cmd = new SqlCommand(query, connec);
            cmd.Parameters.AddWithValue("@ma", maloai);
            cmd.ExecuteNonQuery();
            Dongketnoi();
        }
        public void xoaSach(string tensach)
        {
            Moketnoi();
            string query = "DELETE FROM tblSach WHERE tensach = @ten";
            SqlCommand cmd = new SqlCommand(query, connec);
            cmd.Parameters.AddWithValue("@ten", tensach);
            cmd.ExecuteNonQuery();
            Dongketnoi();
        }
        public bool tontaiNguoiDung(string ten, string mk)
        {
            bool kt = false;
            Moketnoi();
            string query = "select * from tblDangNhap where tendangnhap =@tendn and matkhau=@matkhau";
            SqlCommand cmd = new SqlCommand(query, connec);
            cmd.Parameters.AddWithValue("tendn", ten);
            cmd.Parameters.AddWithValue("matkhau", mk);
            SqlDataReader r = cmd.ExecuteReader();
            if (r.HasRows) kt = true;
            Dongketnoi(); 
            return kt;
        }
        public string Tenloai(string maloai)
        {
            Moketnoi();
            string query = "SELECT tenloai FROM tblLoaiSach WHERE maloai = @ma";

            using (SqlCommand cmd = new SqlCommand(query, connec))
            {
                cmd.Parameters.AddWithValue("@ma", maloai);

                using (SqlDataReader reader = cmd.ExecuteReader())
                {
                    if (reader.Read())
                    {
                        // Kiểm tra xem có dữ liệu trước khi truy cập
                        return reader["tenloai"].ToString();
                    }
                }
            }

            Dongketnoi();

            // Nếu không tìm thấy, trả về chuỗi trống hoặc giá trị mặc định khác tùy vào yêu cầu của bạn
            return "";
        }
    }
}
