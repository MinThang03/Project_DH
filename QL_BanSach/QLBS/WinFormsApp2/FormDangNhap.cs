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
    public partial class FormDangNhap : Form
    {
        KetnoiCSDL kn = new KetnoiCSDL();

        public FormDangNhap()
        {
            InitializeComponent();
        }

        private void buttonDN_Click(object sender, EventArgs e)
        {
            if (txtTenDN.Text == "")
            {
                MessageBox.Show("Chưa nhập Tên đăng nhập!");
                txtTenDN.Focus();
                return;
            }
            if (txtMK.Text == "")
            {
                MessageBox.Show("Chưa nhập Mật khẩu!");
                txtMK.Focus();
                return;
            }
            if (!kn.tontaiNguoiDung(txtTenDN.Text.Trim(), txtMK.Text))
            {
                MessageBox.Show("Sai Tên đăng nhập hoặc Mật khẩu!", "Thông báo");
                return;
            }
            FormMain main = new FormMain();
            main.Show();
            main.labelTenDN.Text = txtTenDN.Text;
            this.Hide();
        }

        private void buttonThoat_Click(object sender, EventArgs e)
        {
            DialogResult result = MessageBox.Show("Bạn có chắc chắn muốn thoát không ?", "Thông báo", MessageBoxButtons.YesNo, MessageBoxIcon.Question);
            if (result == DialogResult.Yes)
            {
                this.Close();
            }
        }

        private void FormDangNhap_Load(object sender, EventArgs e)
        {

        }
    }
}
