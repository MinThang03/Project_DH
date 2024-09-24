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
    public partial class FormTKDT : Form
    {
        KetnoiCSDL kn = new KetnoiCSDL();
        public FormTKDT()
        {
            InitializeComponent();
            loadsohd();
        }
        void loadsohd()
        {
            cboSoHDDT.Items.Clear();
            foreach (DataRow dr in kn.dsQLBS().Rows)
            {
                cboSoHDDT.Items.Add(dr[0].ToString());
            }
        }
        private void cboSoHDDT_SelectedValueChanged(object sender, EventArgs e)
        {

        }

        private void buttonThongKeTKDT_Click(object sender, EventArgs e)
        {
            dgvTKDT.DataSource = kn.dsTKDT(cboSoHDDT.Text.ToUpper());
        }
    }
}
