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
    public partial class FormTKS : Form
    {
        KetnoiCSDL kn = new KetnoiCSDL();
        public FormTKS()
        {
            InitializeComponent();
            LoadMaLoai();
        }
        void LoadMaLoai()
        {
            cboMaloaiTKS.Items.Clear();
            foreach (DataRow dr in kn.dsSach().Rows)
            {
                cboMaloaiTKS.Items.Add(dr[0].ToString());
            }
        }
        private void cboMaloaiTKS_SelectedValueChanged(object sender, EventArgs e)
        {
            txtTenLoaiTKS.Text = kn.Tenloai(cboMaloaiTKS.Text);
        }

        private void txtTenLoaiTKS_Leave(object sender, EventArgs e)
        {
            txtTenLoaiTKS.Text = kn.Tenloai(cboMaloaiTKS.Text);
        }

        private void ThongkeTKS_Click(object sender, EventArgs e)
        {
            dgvTKS.DataSource = kn.dsTKS(cboMaloaiTKS.Text.ToUpper());
        }

        private void txtTenLoaiTKS_TextChanged(object sender, EventArgs e)
        {

        }
    }
}
