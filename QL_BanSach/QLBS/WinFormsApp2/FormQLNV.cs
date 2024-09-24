namespace WinFormsApp2
{
    public partial class FormQLNV : Form
    {
        KetnoiCSDL kn = new KetnoiCSDL();
        public void loadNV()
        {
            dgv.DataSource = kn.dsNhanVien();
        }
        public FormQLNV()
        {
            InitializeComponent();
            loadNV();
        }
        bool KT_rong()
        {
            if (txtMaNV.Text == "") return false;
            if (txtTenNV.Text == "") return false;
            if (txtDiachi.Text == "") return false;
            if (txtDienthoai.Text == "") return false;
            return true;
        }
        void resetThongtin()
        {
            txtMaNV.Text = "";
            txtTenNV.Text = "";
            dtpNgaysinh.Text = "";
            rdoNam.Checked = true;
            txtDiachi.Text = "";
            txtDienthoai.Text = "";
            txtMaNV.Focus();
        }
        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }

        private void dgv_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {

        }

        private void buttonLuu_Click(object sender, EventArgs e)
        {
            if (!KT_rong())
            {
                MessageBox.Show("Chưa nhập đủ thông tin!");
                return;
            }
            string gt;
            if (rdoNam.Checked) gt = "Nam";
            else gt = "Nữ";
            kn.suaNhanVien(txtMaNV.Text.Trim(), txtTenNV.Text, DateTime.Parse(dtpNgaysinh.Text), gt, txtDiachi.Text, txtDienthoai.Text);
            txtMaNV.Enabled = true;
            buttonThem.Enabled = true;
            buttonXoa.Enabled = true;
            loadNV();
            MessageBox.Show("Sửa thông tin thành công!");
        }

        private void buttonThoat_Click(object sender, EventArgs e)
        {
            DialogResult result = MessageBox.Show("Bạn có chắc chắn muốn thoát không ?", "Thông báo", MessageBoxButtons.YesNo, MessageBoxIcon.Question);
            if (result == DialogResult.Yes)
            {
                this.Close();
            }
        }

        private void buttonThem_Click(object sender, EventArgs e)
        {
            if (!KT_rong())
            {
                MessageBox.Show("Chưa nhập đủ thông tin!", "Thông báo");
                return;
            }
            if (kn.tontaiNhanVien(txtMaNV.Text.Trim()))
            {
                MessageBox.Show("Mã nhân viên đã tồn tại, hãy nhập mã khác!", "Thông báo");
                return;
            }
            string gt;
            if (rdoNam.Checked) gt = "Nam";
            else gt = "Nữ";
            kn.themNhanVien(txtMaNV.Text.ToUpper(), txtTenNV.Text, DateTime.Parse(dtpNgaysinh.Text), gt, txtDiachi.Text, txtDienthoai.Text);
            loadNV();
            resetThongtin();
        }

        private void buttonSua_Click(object sender, EventArgs e)
        {
            if (txtMaNV.Text == "")
            {
                MessageBox.Show("Chưa nhập đủ thông tin để sửa");
                return;
            }
            if (!kn.tontaiNhanVien(txtMaNV.Text.Trim()))
            {
                MessageBox.Show("Mã nhân viên không tồn tại!");
                return;
            }
            txtMaNV.Enabled = false;
            buttonThem.Enabled = false;
            buttonXoa.Enabled = false;
            txtMaNV.Focus();
        }

        private void buttonXoa_Click(object sender, EventArgs e)
        {
            if (!kn.tontaiNhanVien(txtMaNV.Text.Trim()))
            {
                MessageBox.Show("Mã nhân viên không tồn tại!");
                return;
            }
            if (MessageBox.Show("Có chắc chắn xóa không?", "Thông báo", MessageBoxButtons.YesNo) == DialogResult.Yes)
            {
                kn.xoaNhanVien(txtMaNV.Text.Trim());
                resetThongtin();
                loadNV();
                MessageBox.Show("Xóa thành công!");
            }
        }

        private void dgv_CellClick(object sender, DataGridViewCellEventArgs e)
        {
            int i = e.RowIndex;
            if (i < 0)  
            { 
                return; 
            }
            DataGridViewRow row = new DataGridViewRow();
            row = dgv.Rows[i];
            txtMaNV.Text = row.Cells[0].Value.ToString();
            txtTenNV.Text = row.Cells[1].Value.ToString();
            if (DateTime.TryParse(row.Cells[2].Value.ToString(), out DateTime ngaySinh))
            {
                dtpNgaysinh.Value = ngaySinh;
            }
            string gt = row.Cells[3].Value.ToString();
            if (gt == "Nam") rdoNam.Checked = true; 
            else rdoNu.Checked = true;
            txtDiachi.Text = row.Cells[4].Value.ToString();
            txtDienthoai.Text = row.Cells[5].Value.ToString();
        }
    }
}
