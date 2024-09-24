namespace WinFormsApp2
{
    partial class FormMain
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(FormMain));
            menuMain = new MenuStrip();
            quảnLýChungToolStripMenuItem = new ToolStripMenuItem();
            quảnLýNhânViênToolStripMenuItem = new ToolStripMenuItem();
            quảnLýKháchHàngToolStripMenuItem = new ToolStripMenuItem();
            cToolStripMenuItem = new ToolStripMenuItem();
            cậpNhậtSáchToolStripMenuItem = new ToolStripMenuItem();
            quảnLýSáchToolStripMenuItem = new ToolStripMenuItem();
            thanhToánToolStripMenuItem = new ToolStripMenuItem();
            thốngKêBáoCáoToolStripMenuItem = new ToolStripMenuItem();
            thốngKêĐầuSáchToolStripMenuItem = new ToolStripMenuItem();
            thốngKêDoanhThuToolStripMenuItem = new ToolStripMenuItem();
            thoátToolStripMenuItem = new ToolStripMenuItem();
            labelTenDN = new Label();
            menuMain.SuspendLayout();
            SuspendLayout();
            // 
            // menuMain
            // 
            menuMain.Font = new Font("Segoe UI", 10F, FontStyle.Bold, GraphicsUnit.Point, 0);
            menuMain.ImageScalingSize = new Size(24, 24);
            menuMain.Items.AddRange(new ToolStripItem[] { quảnLýChungToolStripMenuItem, quảnLýSáchToolStripMenuItem, thanhToánToolStripMenuItem, thốngKêBáoCáoToolStripMenuItem, thoátToolStripMenuItem });
            menuMain.Location = new Point(0, 0);
            menuMain.Name = "menuMain";
            menuMain.Padding = new Padding(7, 3, 0, 3);
            menuMain.Size = new Size(1138, 38);
            menuMain.TabIndex = 0;
            menuMain.Text = "Chương Trình Quản Lý Bán Sách";
            menuMain.ItemClicked += menuMain_ItemClicked;
            // 
            // quảnLýChungToolStripMenuItem
            // 
            quảnLýChungToolStripMenuItem.DropDownItems.AddRange(new ToolStripItem[] { quảnLýNhânViênToolStripMenuItem, quảnLýKháchHàngToolStripMenuItem, cToolStripMenuItem, cậpNhậtSáchToolStripMenuItem });
            quảnLýChungToolStripMenuItem.Name = "quảnLýChungToolStripMenuItem";
            quảnLýChungToolStripMenuItem.Size = new Size(165, 32);
            quảnLýChungToolStripMenuItem.Text = "Quản lý chung";
            // 
            // quảnLýNhânViênToolStripMenuItem
            // 
            quảnLýNhânViênToolStripMenuItem.Name = "quảnLýNhânViênToolStripMenuItem";
            quảnLýNhânViênToolStripMenuItem.Size = new Size(302, 36);
            quảnLýNhânViênToolStripMenuItem.Text = "Quản lý nhân viên";
            quảnLýNhânViênToolStripMenuItem.Click += quảnLýNhânViênToolStripMenuItem_Click;
            // 
            // quảnLýKháchHàngToolStripMenuItem
            // 
            quảnLýKháchHàngToolStripMenuItem.Name = "quảnLýKháchHàngToolStripMenuItem";
            quảnLýKháchHàngToolStripMenuItem.Size = new Size(302, 36);
            quảnLýKháchHàngToolStripMenuItem.Text = "Quản lý khách hàng";
            quảnLýKháchHàngToolStripMenuItem.Click += quảnLýKháchHàngToolStripMenuItem_Click;
            // 
            // cToolStripMenuItem
            // 
            cToolStripMenuItem.Name = "cToolStripMenuItem";
            cToolStripMenuItem.Size = new Size(302, 36);
            cToolStripMenuItem.Text = "Cập nhật loại sách";
            cToolStripMenuItem.Click += cToolStripMenuItem_Click;
            // 
            // cậpNhậtSáchToolStripMenuItem
            // 
            cậpNhậtSáchToolStripMenuItem.Name = "cậpNhậtSáchToolStripMenuItem";
            cậpNhậtSáchToolStripMenuItem.Size = new Size(302, 36);
            cậpNhậtSáchToolStripMenuItem.Text = "Cập nhật sách";
            cậpNhậtSáchToolStripMenuItem.Click += cậpNhậtSáchToolStripMenuItem_Click;
            // 
            // quảnLýSáchToolStripMenuItem
            // 
            quảnLýSáchToolStripMenuItem.Name = "quảnLýSáchToolStripMenuItem";
            quảnLýSáchToolStripMenuItem.Size = new Size(202, 32);
            quảnLýSáchToolStripMenuItem.Text = "Quản lý nhập sách";
            quảnLýSáchToolStripMenuItem.Click += quảnLýSáchToolStripMenuItem_Click;
            // 
            // thanhToánToolStripMenuItem
            // 
            thanhToánToolStripMenuItem.Name = "thanhToánToolStripMenuItem";
            thanhToánToolStripMenuItem.Size = new Size(190, 32);
            thanhToánToolStripMenuItem.Text = "Quản lý bán sách";
            thanhToánToolStripMenuItem.Click += thanhToánToolStripMenuItem_Click;
            // 
            // thốngKêBáoCáoToolStripMenuItem
            // 
            thốngKêBáoCáoToolStripMenuItem.DropDownItems.AddRange(new ToolStripItem[] { thốngKêĐầuSáchToolStripMenuItem, thốngKêDoanhThuToolStripMenuItem });
            thốngKêBáoCáoToolStripMenuItem.Name = "thốngKêBáoCáoToolStripMenuItem";
            thốngKêBáoCáoToolStripMenuItem.Size = new Size(196, 32);
            thốngKêBáoCáoToolStripMenuItem.Text = "Thống kê báo cáo";
            // 
            // thốngKêĐầuSáchToolStripMenuItem
            // 
            thốngKêĐầuSáchToolStripMenuItem.Name = "thốngKêĐầuSáchToolStripMenuItem";
            thốngKêĐầuSáchToolStripMenuItem.Size = new Size(305, 36);
            thốngKêĐầuSáchToolStripMenuItem.Text = "Thống kê sách";
            thốngKêĐầuSáchToolStripMenuItem.Click += thốngKêĐầuSáchToolStripMenuItem_Click;
            // 
            // thốngKêDoanhThuToolStripMenuItem
            // 
            thốngKêDoanhThuToolStripMenuItem.Name = "thốngKêDoanhThuToolStripMenuItem";
            thốngKêDoanhThuToolStripMenuItem.Size = new Size(305, 36);
            thốngKêDoanhThuToolStripMenuItem.Text = "Thống kê doanh thu";
            thốngKêDoanhThuToolStripMenuItem.Click += thốngKêDoanhThuToolStripMenuItem_Click;
            // 
            // thoátToolStripMenuItem
            // 
            thoátToolStripMenuItem.Name = "thoátToolStripMenuItem";
            thoátToolStripMenuItem.Size = new Size(83, 32);
            thoátToolStripMenuItem.Text = "Thoát";
            thoátToolStripMenuItem.Click += thoátToolStripMenuItem_Click;
            // 
            // labelTenDN
            // 
            labelTenDN.AutoSize = true;
            labelTenDN.BackColor = SystemColors.ButtonHighlight;
            labelTenDN.ForeColor = Color.Blue;
            labelTenDN.Location = new Point(910, 5);
            labelTenDN.Name = "labelTenDN";
            labelTenDN.Size = new Size(76, 30);
            labelTenDN.TabIndex = 4;
            labelTenDN.Text = "label1";
            labelTenDN.Click += labelTenDN_Click;
            // 
            // FormMain
            // 
            AutoScaleDimensions = new SizeF(13F, 30F);
            AutoScaleMode = AutoScaleMode.Font;
            BackgroundImage = (Image)resources.GetObject("$this.BackgroundImage");
            BackgroundImageLayout = ImageLayout.Stretch;
            ClientSize = new Size(1138, 540);
            Controls.Add(labelTenDN);
            Controls.Add(menuMain);
            DoubleBuffered = true;
            Font = new Font("Segoe UI", 11F, FontStyle.Bold, GraphicsUnit.Point, 0);
            Icon = (Icon)resources.GetObject("$this.Icon");
            IsMdiContainer = true;
            MainMenuStrip = menuMain;
            Margin = new Padding(4);
            Name = "FormMain";
            Text = "Chương Trình Quản Lý Bán Sách";
            WindowState = FormWindowState.Maximized;
            FormClosed += FormMain_FormClosed;
            menuMain.ResumeLayout(false);
            menuMain.PerformLayout();
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private MenuStrip menuMain;
        private ToolStripMenuItem quảnLýChungToolStripMenuItem;
        private ToolStripMenuItem quảnLýNhânViênToolStripMenuItem;
        private ToolStripMenuItem quảnLýKháchHàngToolStripMenuItem;
        private ToolStripMenuItem quảnLýSáchToolStripMenuItem;
        private ToolStripMenuItem thanhToánToolStripMenuItem;
        private ToolStripMenuItem thốngKêBáoCáoToolStripMenuItem;
        private ToolStripMenuItem thốngKêĐầuSáchToolStripMenuItem;
        private ToolStripMenuItem thốngKêDoanhThuToolStripMenuItem;
        private ToolStripMenuItem thoátToolStripMenuItem;
        public Label labelTenDN;
        private ToolStripMenuItem cToolStripMenuItem;
        private ToolStripMenuItem cậpNhậtSáchToolStripMenuItem;
    }
}