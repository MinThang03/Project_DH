using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using static System.Windows.Forms.VisualStyles.VisualStyleElement.Header;

namespace WinFormsApp2
{
    public partial class FormCNSach : Form
    {
        KetnoiCSDL kn = new KetnoiCSDL();
        public void loadSach()
        {
            dgvCNS.DataSource = kn.dsSach();
        }
        public FormCNSach()
        {
            InitializeComponent();
            loadSach();
            LoadMaLoai();
        }
        void LoadMaLoai()
        {
            cboMaloai.Items.Clear();
            foreach (DataRow dr in kn.dsSach().Rows)
            {
                cboMaloai.Items.Add(dr[0].ToString());
            }
        }
        bool KT_rong()
        {
            if (cboMaloai.Text == "") return false;
            if (txtTensachCNS.Text == "") return false;
            if (txtTenloaiCNS.Text == "") return false;
            if (txtTacgiaCNS.Text == "") return false;
            if (txtNXBCNS.Text == "") return false;
            if (txtNamXBCNS.Text == "") return false;
            if (txtSoTrangCNS.Text == "") return false;
            if (txtGiabanCNS.Text == "") return false;
            if (txtNoidungCNS.Text == "") return false;
            if (txtSoLuongCNS.Text == "") return false;
            return true;
        }
        void resetThongtin()
        {
            cboMaloai.Text = "";
            txtTensachCNS.Text = "";
            txtTenloaiCNS.Text = "";
            txtTacgiaCNS.Text = "";
            txtNXBCNS.Text = "";
            txtNamXBCNS.Text = "";
            txtSoTrangCNS.Text = "";
            txtGiabanCNS.Text = "";
            txtNoidungCNS.Text = "";
            txtSoLuongCNS.Text = "";
            txtTensachCNS.Focus();
        }

        private void buttonSua_Click(object sender, EventArgs e)
        {
            if (txtTensachCNS.Text == "")
            {
                MessageBox.Show("Chưa nhập đủ thông tin để sửa");
                return;
            }
            if (!kn.tontaiSach(txtTensachCNS.Text.Trim()))
            {
                MessageBox.Show("Tên Sách không tồn tại!");
                return;
            }
            txtTensachCNS.Enabled = false;
            buttonThemCNS.Enabled = false;
            buttonXoaCNS.Enabled = false;
            txtTensachCNS.Focus();
        }

        private void buttonThemCNS_Click(object sender, EventArgs e)
        {
            if (!KT_rong())
            {
                MessageBox.Show("Chưa nhập đủ thông tin!", "Thông báo");
                return;
            }
            if (kn.tontaiSach(txtTensachCNS.Text.Trim()))
            {
                MessageBox.Show("Tên Sách đã tồn tại, hãy nhập tên khác!", "Thông báo");
                return;
            }
            kn.themSach(cboMaloai.Text.ToUpper(), txtTensachCNS.Text, txtTenloaiCNS.Text, txtTacgiaCNS.Text, txtNXBCNS.Text, Convert.ToInt32(txtNamXBCNS.Text), Convert.ToInt32(txtSoTrangCNS.Text), float.Parse(txtGiabanCNS.Text), txtNoidungCNS.Text, Convert.ToInt32(txtSoLuongCNS.Text));
            loadSach();
            resetThongtin();
        }

        private void cboMaloai_SelectedValueChanged(object sender, EventArgs e)
        {
            txtTenloaiCNS.Text = kn.Tenloai(cboMaloai.Text);
        }

        private void cboMaloai_Leave(object sender, EventArgs e)
        {
            txtTenloaiCNS.Text = kn.Tenloai(cboMaloai.Text);
        }

        private void buttonThoatCNS_Click(object sender, EventArgs e)
        {
            DialogResult result = MessageBox.Show("Bạn có chắc chắn muốn thoát không ?", "Thông báo", MessageBoxButtons.YesNo, MessageBoxIcon.Question);
            if (result == DialogResult.Yes)
            {
                this.Close();
            }
        }

        private void buttonXoaCNS_Click(object sender, EventArgs e)
        {
            if (!kn.tontaiSach(txtTensachCNS.Text.Trim()))
            {
                MessageBox.Show("Tên Sách không tồn tại!");
                return;
            }
            if (MessageBox.Show("Có chắc chắn xóa không?", "Thông báo", MessageBoxButtons.YesNo) == DialogResult.Yes)
            {
                kn.xoaSach(txtTensachCNS.Text.Trim());
                resetThongtin();
                loadSach();
                MessageBox.Show("Xóa thành công!");
            }
        }

        private void buttonLuuCNS_Click(object sender, EventArgs e)
        {
            if (!KT_rong())
            {
                MessageBox.Show("Chưa nhập đủ thông tin!");
                return;
            }
            kn.suaSach(cboMaloai.Text.ToUpper(), txtTensachCNS.Text, txtTenloaiCNS.Text, txtTacgiaCNS.Text, txtNXBCNS.Text, Convert.ToInt32(txtNamXBCNS.Text), Convert.ToInt32(txtSoTrangCNS.Text), float.Parse(txtGiabanCNS.Text), txtNoidungCNS.Text, Convert.ToInt32(txtSoLuongCNS.Text));
            txtTensachCNS.Enabled = true;
            buttonThemCNS.Enabled = true;
            buttonXoaCNS.Enabled = true;
            loadSach();
            MessageBox.Show("Sửa thông tin thành công!");
        }
    }
}
