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
    public partial class FormCNLoaiSach : Form
    {
        KetnoiCSDL kn = new KetnoiCSDL();
        public void loadLS()
        {
            dgvCNLS.DataSource = kn.dsLoaisach();
        }
        public FormCNLoaiSach()
        {
            InitializeComponent();
            loadLS();
        }
        bool KT_rong()
        {
            if (txtMaLoaiLS.Text == "") return false;
            if (txtTenLoaiLS.Text == "") return false;
            return true;
        }
        void resetThongtin()
        {
            txtMaLoaiLS.Text = "";
            txtTenLoaiLS.Text = "";
            txtMaLoaiLS.Focus();
        }
        private void buttonThemCNLS_Click(object sender, EventArgs e)
        {
            if (!KT_rong())
            {
                MessageBox.Show("Chưa nhập đủ thông tin!", "Thông báo");
                return;
            }
            if (kn.tontaiNhanVien(txtMaLoaiLS.Text.Trim()))
            {
                MessageBox.Show("Mã Loại Sách đã tồn tại, hãy nhập mã khác!", "Thông báo");
                return;
            }
            kn.themLoaisach(txtMaLoaiLS.Text.ToUpper(), txtTenLoaiLS.Text);
            loadLS();
            resetThongtin();
        }

        private void buttonLuuCNLS_Click(object sender, EventArgs e)
        {
            if (!KT_rong())
            {
                MessageBox.Show("Chưa nhập đủ thông tin!");
                return;
            }
            kn.suaLoaisach(txtMaLoaiLS.Text.Trim(), txtTenLoaiLS.Text);
            txtMaLoaiLS.Enabled = true;
            buttonThemCNLS.Enabled = true;
            buttonXoaCNLS.Enabled = true;
            loadLS();
            MessageBox.Show("Sửa thông tin thành công!");
        }

        private void buttonXoaCNLS_Click(object sender, EventArgs e)
        {
            if (!kn.tontaiLoaisach(txtMaLoaiLS.Text.Trim()))
            {
                MessageBox.Show("Mã Loại Sách không tồn tại!");
                return;
            }
            if (MessageBox.Show("Có chắc chắn xóa không?", "Thông báo", MessageBoxButtons.YesNo) == DialogResult.Yes)
            {
                kn.xoaLoaisach(txtMaLoaiLS.Text.Trim());
                resetThongtin();
                loadLS();
                MessageBox.Show("Xóa thành công!");
            }
        }

        private void buttonSuaCNLS_Click(object sender, EventArgs e)
        {
            if (txtMaLoaiLS.Text == "")
            {
                MessageBox.Show("Chưa nhập đủ thông tin để sửa");
                return;
            }
            if (!kn.tontaiLoaisach(txtMaLoaiLS.Text.Trim()))
            {
                MessageBox.Show("Mã Loại Sách không tồn tại!");
                return;
            }
            txtMaLoaiLS.Enabled = false;
            buttonThemCNLS.Enabled = false;
            buttonXoaCNLS.Enabled = false;
            txtMaLoaiLS.Focus();
        }

        private void buttonThoatCNLS_Click(object sender, EventArgs e)
        {
            DialogResult result = MessageBox.Show("Bạn có chắc chắn muốn thoát không ?", "Thông báo", MessageBoxButtons.YesNo, MessageBoxIcon.Question);
            if (result == DialogResult.Yes)
            {
                this.Close();
            }
        }
    }
}
