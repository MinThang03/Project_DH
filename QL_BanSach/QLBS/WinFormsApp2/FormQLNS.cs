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
    public partial class FormQLNS : Form
    {
        KetnoiCSDL kn = new KetnoiCSDL();
        public void loadQLNS()
        {
            dgvQLNS.DataSource = kn.dsQLNS();
        }
        public FormQLNS()
        {
            InitializeComponent();
            LoadManv();
            LoadMaloai();
            loadQLNS();
        }
        void LoadManv()
        {
            cboManvNS.Items.Clear();
            foreach (DataRow dr in kn.dsNhanVien().Rows)
            {
                cboManvNS.Items.Add(dr[0].ToString());
            }
        }
        void LoadMaloai()
        {
            cboMaloaiNS.Items.Clear();
            foreach (DataRow dr in kn.dsSach().Rows)
            {
                cboMaloaiNS.Items.Add(dr[0].ToString());
            }
        }
        private void label10_Click(object sender, EventArgs e)
        {

        }

        private void label7_Click(object sender, EventArgs e)
        {

        }

        private void cboManvNS_SelectedValueChanged(object sender, EventArgs e)
        {

        }

        private void buttonThemQLNS_Click(object sender, EventArgs e)
        {
            kn.ThemPhieuMuaHang(txtSophieu1.Text.ToUpper(), DateTime.Parse(dtpNgay.Text), txtTenNCC.Text, cboManvNS.Text, txtSophieu2.Text, cboMaloaiNS.Text, Convert.ToInt32(txtSoluongNS.Text), Convert.ToInt32(txtGiamuaNS.Text), txtGhichuNS.Text);
            loadQLNS();
        }

        private void txtSophieu1_TextChanged(object sender, EventArgs e)
        {
            txtSophieu2.Text = txtSophieu1.Text;
        }

        private void buttonThoatQLNS_Click(object sender, EventArgs e)
        {
            DialogResult result = MessageBox.Show("Bạn có chắc chắn muốn thoát không ?", "Thông báo", MessageBoxButtons.YesNo, MessageBoxIcon.Question);
            if (result == DialogResult.Yes)
            {
                this.Close();
            }
        }

        private void buttonSuaQLNS_Click(object sender, EventArgs e)
        {
            if (txtSophieu1.Text == "")
            {
                MessageBox.Show("Chưa nhập đủ thông tin để sửa");
                return;
            }
            if (!kn.tontaiSophieu(txtSophieu1.Text.Trim()))
            {
                MessageBox.Show("Số phiếu không tồn tại!");
                return;
            }
            txtSophieu1.Enabled = false;
            buttonThemQLNS.Enabled = false;
            buttonXoaQLNS.Enabled = false;
            txtSophieu1.Focus();
        }

        private void buttonLuuQLNS_Click(object sender, EventArgs e)
        {
            if (string.IsNullOrEmpty(txtSophieu1.Text) || string.IsNullOrEmpty(dtpNgay.Text) || string.IsNullOrEmpty(txtTenNCC.Text) ||
        string.IsNullOrEmpty(cboManvNS.Text) || string.IsNullOrEmpty(txtSophieu2.Text) || string.IsNullOrEmpty(cboMaloaiNS.Text) ||
        string.IsNullOrEmpty(txtSoluongNS.Text) || string.IsNullOrEmpty(txtGiamuaNS.Text) || string.IsNullOrEmpty(txtGhichuNS.Text))
            {
                MessageBox.Show("Vui lòng nhập đầy đủ thông tin!", "Thông báo");
                return;
            }

            // Thực hiện sửa thông tin trong cơ sở dữ liệu
            kn.suaQLNS(txtSophieu1.Text.ToUpper(), DateTime.Parse(dtpNgay.Text), txtTenNCC.Text, cboManvNS.Text, txtSophieu2.Text, cboMaloaiNS.Text, Convert.ToInt32(txtSoluongNS.Text), Convert.ToInt32(txtGiamuaNS.Text), txtGhichuNS.Text);

            // Enable các controls và nút sau khi sửa thông tin
            txtSophieu1.Enabled = true;
            buttonThemQLNS.Enabled = true;
            buttonXoaQLNS.Enabled = true;

            // Tải lại danh sách sau khi sửa thông tin
            loadQLNS();

            // Thông báo thành công
            MessageBox.Show("Sửa thông tin thành công!");
        }

        private void buttonXoaQLNS_Click(object sender, EventArgs e)
        {
            if (!kn.tontaiSophieu(txtSophieu1.Text.Trim()))
            {
                MessageBox.Show("Số phiếu không tồn tại!");
                return;
            }
            if (MessageBox.Show("Có chắc chắn xóa không?", "Thông báo", MessageBoxButtons.YesNo) == DialogResult.Yes)
            {
                kn.xoaQLNS(txtSophieu1.Text.Trim());
                loadQLNS();
                MessageBox.Show("Xóa thành công!");
            }
        }
    }
}
