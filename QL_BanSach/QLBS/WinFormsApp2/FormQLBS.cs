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
    public partial class FormQLBS : Form
    {
        KetnoiCSDL kn = new KetnoiCSDL();
        public void loadQLBS()
        {
            dgvQLBS.DataSource = kn.dsQLBS();
        }
        public FormQLBS()
        {
            InitializeComponent();
            LoadManv();
            LoadMakh();
            loadmaloai();
            loadQLBS();
        }
        void LoadManv()
        {
            cboManvBS.Items.Clear();
            foreach (DataRow dr in kn.dsNhanVien().Rows)
            {
                cboManvBS.Items.Add(dr[0].ToString());
            }
        }
        void LoadMakh()
        {
            cboMakhBS.Items.Clear();
            foreach (DataRow dr in kn.dsKhachhang().Rows)
            {
                cboMakhBS.Items.Add(dr[0].ToString());
            }
        }
        void loadmaloai()
        {
            cboMasachBS.Items.Clear();
            foreach (DataRow dr in kn.dsLoaisach().Rows)
            {
                cboMasachBS.Items.Add(dr[0].ToString());
            }
        }
        private void buttonThemQLBS_Click(object sender, EventArgs e)
        {
            kn.themHD(txtSohd1.Text.ToUpper(), DateTime.Parse(dtpNgayhd.Text), cboMakhBS.Text, cboManvBS.Text, txtGhichuBS.Text, txtSohd2.Text, cboMasachBS.Text, Convert.ToInt32(txtSoluongBS.Text));
            loadQLBS();
        }

        private void txtSohd2_TextChanged(object sender, EventArgs e)
        {

        }

        private void txtSohd1_TextChanged(object sender, EventArgs e)
        {
            txtSohd2.Text = txtSohd1.Text;
        }

        private void buttonThoatQLBS_Click(object sender, EventArgs e)
        {
            DialogResult result = MessageBox.Show("Bạn có chắc chắn muốn thoát không ?", "Thông báo", MessageBoxButtons.YesNo, MessageBoxIcon.Question);
            if (result == DialogResult.Yes)
            {
                this.Close();
            }
        }

        private void buttonSuaQLBS_Click(object sender, EventArgs e)
        {
            if (txtSohd1.Text == "")
            {
                MessageBox.Show("Chưa nhập đủ thông tin để sửa");
                return;
            }
            if (!kn.tontaihoadon(txtSohd1.Text.Trim()))
            {
                MessageBox.Show("Số phiếu không tồn tại!");
                return;
            }
            txtSohd1.Enabled = false;
            buttonThemQLBS.Enabled = false;
            buttonXoaQLBS.Enabled = false;
            txtSohd1.Focus();
        }

        private void buttonLuuQLBS_Click(object sender, EventArgs e)
        {
            if (string.IsNullOrEmpty(txtSohd1.Text) || string.IsNullOrEmpty(dtpNgayhd.Text) || string.IsNullOrEmpty(cboMakhBS.Text) ||
        string.IsNullOrEmpty(cboManvBS.Text) || string.IsNullOrEmpty(txtGhichuBS.Text) || string.IsNullOrEmpty(txtSohd2.Text) ||
        string.IsNullOrEmpty(cboMasachBS.Text) || string.IsNullOrEmpty(txtSoluongBS.Text))
            {
                MessageBox.Show("Vui lòng nhập đầy đủ thông tin!", "Thông báo");
                return;
            }

            // Thực hiện sửa thông tin trong cơ sở dữ liệu
            kn.suaQLBS(txtSohd1.Text.ToUpper(), DateTime.Parse(dtpNgayhd.Text), cboMakhBS.Text, cboManvBS.Text, txtGhichuBS.Text, txtSohd2.Text, cboMasachBS.Text, Convert.ToInt32(txtSoluongBS.Text));

            // Enable các controls và nút sau khi sửa thông tin
            txtSohd1.Enabled = true;
            buttonThemQLBS.Enabled = true;
            buttonXoaQLBS.Enabled = true;

            // Tải lại danh sách sau khi sửa thông tin
            loadQLBS();

            // Thông báo thành công
            MessageBox.Show("Sửa thông tin thành công!");
        }

        private void buttonXoaQLBS_Click(object sender, EventArgs e)
        {
            if (!kn.tontaihoadon(txtSohd1.Text.Trim()))
            {
                MessageBox.Show("Số hóa đơn không tồn tại!");
                return;
            }
            if (MessageBox.Show("Có chắc chắn xóa không?", "Thông báo", MessageBoxButtons.YesNo) == DialogResult.Yes)
            {
                kn.xoaQLBS(txtSohd1.Text.Trim());
                loadQLBS();
                MessageBox.Show("Xóa thành công!");
            }
        }
    }
}
