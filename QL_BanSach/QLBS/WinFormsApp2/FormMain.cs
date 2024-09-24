//using QuanLyNhapSach;
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
    public partial class FormMain : Form
    {
        public string laytenDN;
        public FormMain()
        {
            InitializeComponent();
        }

        private void menuMain_ItemClicked(object sender, ToolStripItemClickedEventArgs e)
        {

        }


        private void quảnLýNhânViênToolStripMenuItem_Click(object sender, EventArgs e)
        {
            bool kt = false;
            foreach (Form f in this.MdiChildren)
            {
                if (f.Name.Equals("FormQLNV"))
                {
                    f.Activate();
                    kt = true;
                    break;
                }
            }
            if (!kt)
            {
                FormQLNV QLNV = new FormQLNV();
                QLNV.MdiParent = this;
                QLNV.Show();
            }
        }

        private void FormMain_FormClosed(object sender, FormClosedEventArgs e)
        {
            Application.Exit();
        }

        private void labelTenDN_Click(object sender, EventArgs e)
        {

        }

        private void quảnLýSáchToolStripMenuItem_Click(object sender, EventArgs e)
        {
            bool kt = false;
            foreach (Form f in this.MdiChildren)
            {
                if (f.Name.Equals("FormQLNS"))
                {
                    f.Activate();
                    kt = true;
                    break;
                }
            }
            if (!kt)
            {
                FormQLNS QLNS = new FormQLNS();
                QLNS.MdiParent = this;
                QLNS.Show();
            }
        }

        private void quảnLýKháchHàngToolStripMenuItem_Click(object sender, EventArgs e)
        {
            bool kt = false;
            foreach (Form f in this.MdiChildren)
            {
                if (f.Name.Equals("FormQLKH"))
                {
                    f.Activate();
                    kt = true;
                    break;
                }
            }
            if (!kt)
            {
                FormQLKH QLKH = new FormQLKH();
                QLKH.MdiParent = this;
                QLKH.Show();
            }
        }

        private void cToolStripMenuItem_Click(object sender, EventArgs e)
        {
            bool kt = false;
            foreach (Form f in this.MdiChildren)
            {
                if (f.Name.Equals("FormCNLoaiSach"))
                {
                    f.Activate();
                    kt = true;
                    break;
                }
            }
            if (!kt)
            {
                FormCNLoaiSach CNLoaiSach = new FormCNLoaiSach();
                CNLoaiSach.MdiParent = this;
                CNLoaiSach.Show();
            }
        }

        private void cậpNhậtSáchToolStripMenuItem_Click(object sender, EventArgs e)
        {
            bool kt = false;
            foreach (Form f in this.MdiChildren)
            {
                if (f.Name.Equals("FormCNSach"))
                {
                    f.Activate();
                    kt = true;
                    break;
                }
            }
            if (!kt)
            {
                FormCNSach CNSach = new FormCNSach();
                CNSach.MdiParent = this;
                CNSach.Show();
            }
        }

        private void thanhToánToolStripMenuItem_Click(object sender, EventArgs e)
        {
            bool kt = false;
            foreach (Form f in this.MdiChildren)
            {
                if (f.Name.Equals("FormQLBS"))
                {
                    f.Activate();
                    kt = true;
                    break;
                }
            }
            if (!kt)
            {
                FormQLBS QLBS = new FormQLBS();
                QLBS.MdiParent = this;
                QLBS.Show();
            }
        }

        private void thoátToolStripMenuItem_Click(object sender, EventArgs e)
        {
            DialogResult result = MessageBox.Show("Bạn có chắc chắn muốn thoát không ?", "Thông báo", MessageBoxButtons.YesNo, MessageBoxIcon.Question);
            if (result == DialogResult.Yes)
            {
                this.Close();
            }
        }

        private void thốngKêĐầuSáchToolStripMenuItem_Click(object sender, EventArgs e)
        {
            bool kt = false;
            foreach (Form f in this.MdiChildren)
            {
                if (f.Name.Equals("FormTKS"))
                {
                    f.Activate();
                    kt = true;
                    break;
                }
            }
            if (!kt)
            {
                FormTKS TKS = new FormTKS();
                TKS.MdiParent = this;
                TKS.Show();
            }
        }

        private void thốngKêDoanhThuToolStripMenuItem_Click(object sender, EventArgs e)
        {
            bool kt = false;
            foreach (Form f in this.MdiChildren)
            {
                if (f.Name.Equals("FormTKDT"))
                {
                    f.Activate();
                    kt = true;
                    break;
                }
            }
            if (!kt)
            {
                FormTKDT TKDT = new FormTKDT();
                TKDT.MdiParent = this;
                TKDT.Show();
            }
        }
    }
}
