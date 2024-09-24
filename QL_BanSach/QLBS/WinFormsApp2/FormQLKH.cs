using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace WinFormsApp2
{
    public partial class FormQLKH : Form
    {
        KetnoiCSDL kn = new KetnoiCSDL();
        public void loadKH()
        {
            dgvKH.DataSource = kn.dsKhachhang();
        }
        public FormQLKH()
        {
            InitializeComponent();
            loadKH();
        }
        bool KT_rongKH()
        {
            if (txtMaKH.Text == "") return false;
            if (txtTenKH.Text == "") return false;
            if (txtDiachiKH.Text == "") return false;
            if (txtDienthoaiKH.Text == "") return false;
            return true;
        }
        void resetThongtinKH()
        {
            txtMaKH.Text = "";
            txtTenKH.Text = "";
            txtDiachiKH.Text = "";
            txtDienthoaiKH.Text = "";
            txtMaKH.Focus();
        }

        private void buttonThemKH_Click(object sender, EventArgs e)
        {
            if (!KT_rongKH())
            {
                MessageBox.Show("Chưa nhập đủ thông tin!", "Thông báo");
                return;
            }
            if (kn.tontaiKhachHang(txtMaKH.Text.Trim()))
            {
                MessageBox.Show("Mã khách hàng đã tồn tại, hãy nhập mã khác!", "Thông báo");
                return;
            }
            kn.themKhachHang(txtMaKH.Text.ToUpper(), txtTenKH.Text, txtDiachiKH.Text, txtDienthoaiKH.Text);
            loadKH();
            resetThongtinKH();
        }

        private void buttonThoatKH_Click(object sender, EventArgs e)
        {
            DialogResult result = MessageBox.Show("Bạn có chắc chắn muốn thoát không ?", "Thông báo", MessageBoxButtons.YesNo, MessageBoxIcon.Question);
            if (result == DialogResult.Yes)
            {
                this.Close();
            }
        }

        private void buttonSuaKH_Click(object sender, EventArgs e)
        {
            if (txtMaKH.Text == "")
            {
                MessageBox.Show("Chưa nhập đủ thông tin để sửa");
                return;
            }
            if (!kn.tontaiKhachHang(txtMaKH.Text.Trim()))
            {
                MessageBox.Show("Mã khách hàng không tồn tại!");
                return;
            }
            txtMaKH.Enabled = false;
            buttonThemKH.Enabled = false;
            buttonXoaKH.Enabled = false;
            txtMaKH.Focus();
        }

        private void buttonXoaKH_Click(object sender, EventArgs e)
        {
            if (!kn.tontaiKhachHang(txtMaKH.Text.Trim()))
            {
                MessageBox.Show("Mã khách hàng không tồn tại!");
                return;
            }
            if (MessageBox.Show("Có chắc chắn xóa không?", "Thông báo", MessageBoxButtons.YesNo) == DialogResult.Yes)
            {
                kn.xoaKhachHang(txtMaKH.Text.Trim());
                resetThongtinKH();
                loadKH();
                MessageBox.Show("Xóa thành công!");
            }
        }

        private void buttonLuuKH_Click(object sender, EventArgs e)
        {
            if (!KT_rongKH())
            {
                MessageBox.Show("Chưa nhập đủ thông tin!");
                return;
            }
            kn.suaKhachHang(txtMaKH.Text.Trim(), txtTenKH.Text, txtDiachiKH.Text, txtDienthoaiKH.Text);
            txtMaKH.Enabled = true;
            buttonThemKH.Enabled = true;
            buttonXoaKH.Enabled = true;
            loadKH();
            MessageBox.Show("Sửa thông tin thành công!");
        }

        private void dgvKH_CellClick(object sender, DataGridViewCellEventArgs e)
        {
            int i = e.RowIndex;
            if (i < 0)
            {
                return;
            }
            DataGridViewRow row = new DataGridViewRow();
            row = dgvKH.Rows[i];
            txtMaKH.Text = row.Cells[0].Value.ToString();
            txtTenKH.Text = row.Cells[1].Value.ToString();
            txtDiachiKH.Text = row.Cells[2].Value.ToString();
            txtDienthoaiKH.Text = row.Cells[3].Value.ToString();
        }
    }
}
