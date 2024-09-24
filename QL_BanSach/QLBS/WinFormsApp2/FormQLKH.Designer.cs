namespace WinFormsApp2
{
    partial class FormQLKH
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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(FormQLKH));
            buttonThoatKH = new Button();
            buttonLuuKH = new Button();
            buttonXoaKH = new Button();
            buttonSuaKH = new Button();
            txtDienthoaiKH = new TextBox();
            txtDiachiKH = new TextBox();
            txtTenKH = new TextBox();
            txtMaKH = new TextBox();
            label7 = new Label();
            label6 = new Label();
            label5 = new Label();
            label3 = new Label();
            label2 = new Label();
            label1 = new Label();
            dgvKH = new DataGridView();
            buttonThemKH = new Button();
            ((System.ComponentModel.ISupportInitialize)dgvKH).BeginInit();
            SuspendLayout();
            // 
            // buttonThoatKH
            // 
            buttonThoatKH.BackColor = Color.Turquoise;
            buttonThoatKH.ForeColor = SystemColors.ActiveCaptionText;
            buttonThoatKH.Location = new Point(1114, 341);
            buttonThoatKH.Name = "buttonThoatKH";
            buttonThoatKH.Size = new Size(112, 41);
            buttonThoatKH.TabIndex = 39;
            buttonThoatKH.Text = "Thoát";
            buttonThoatKH.UseVisualStyleBackColor = false;
            buttonThoatKH.Click += buttonThoatKH_Click;
            // 
            // buttonLuuKH
            // 
            buttonLuuKH.BackColor = Color.Turquoise;
            buttonLuuKH.ForeColor = SystemColors.ActiveCaptionText;
            buttonLuuKH.Location = new Point(964, 341);
            buttonLuuKH.Name = "buttonLuuKH";
            buttonLuuKH.Size = new Size(112, 41);
            buttonLuuKH.TabIndex = 38;
            buttonLuuKH.Text = "Lưu";
            buttonLuuKH.UseVisualStyleBackColor = false;
            buttonLuuKH.Click += buttonLuuKH_Click;
            // 
            // buttonXoaKH
            // 
            buttonXoaKH.BackColor = Color.Turquoise;
            buttonXoaKH.ForeColor = SystemColors.ActiveCaptionText;
            buttonXoaKH.Location = new Point(824, 341);
            buttonXoaKH.Name = "buttonXoaKH";
            buttonXoaKH.Size = new Size(112, 41);
            buttonXoaKH.TabIndex = 37;
            buttonXoaKH.Text = "Xóa";
            buttonXoaKH.UseVisualStyleBackColor = false;
            buttonXoaKH.Click += buttonXoaKH_Click;
            // 
            // buttonSuaKH
            // 
            buttonSuaKH.BackColor = Color.Turquoise;
            buttonSuaKH.ForeColor = SystemColors.ActiveCaptionText;
            buttonSuaKH.Location = new Point(678, 341);
            buttonSuaKH.Name = "buttonSuaKH";
            buttonSuaKH.Size = new Size(112, 41);
            buttonSuaKH.TabIndex = 36;
            buttonSuaKH.Text = "Sửa";
            buttonSuaKH.UseVisualStyleBackColor = false;
            buttonSuaKH.Click += buttonSuaKH_Click;
            // 
            // txtDienthoaiKH
            // 
            txtDienthoaiKH.Location = new Point(918, 243);
            txtDienthoaiKH.Name = "txtDienthoaiKH";
            txtDienthoaiKH.Size = new Size(297, 39);
            txtDienthoaiKH.TabIndex = 31;
            // 
            // txtDiachiKH
            // 
            txtDiachiKH.Location = new Point(918, 181);
            txtDiachiKH.Name = "txtDiachiKH";
            txtDiachiKH.Size = new Size(297, 39);
            txtDiachiKH.TabIndex = 30;
            // 
            // txtTenKH
            // 
            txtTenKH.Location = new Point(348, 240);
            txtTenKH.Name = "txtTenKH";
            txtTenKH.Size = new Size(297, 39);
            txtTenKH.TabIndex = 29;
            // 
            // txtMaKH
            // 
            txtMaKH.Location = new Point(348, 178);
            txtMaKH.Name = "txtMaKH";
            txtMaKH.Size = new Size(297, 39);
            txtMaKH.TabIndex = 28;
            // 
            // label7
            // 
            label7.AutoSize = true;
            label7.Location = new Point(749, 243);
            label7.Name = "label7";
            label7.Size = new Size(139, 32);
            label7.TabIndex = 27;
            label7.Text = "Điện thoại:";
            // 
            // label6
            // 
            label6.AutoSize = true;
            label6.Location = new Point(789, 181);
            label6.Name = "label6";
            label6.Size = new Size(99, 32);
            label6.TabIndex = 26;
            label6.Text = "Địa chỉ:";
            // 
            // label5
            // 
            label5.AutoSize = true;
            label5.Location = new Point(769, 181);
            label5.Name = "label5";
            label5.Size = new Size(0, 32);
            label5.TabIndex = 25;
            // 
            // label3
            // 
            label3.AutoSize = true;
            label3.Location = new Point(101, 243);
            label3.Name = "label3";
            label3.Size = new Size(198, 32);
            label3.TabIndex = 23;
            label3.Text = "Tên khách hàng:";
            // 
            // label2
            // 
            label2.AutoSize = true;
            label2.Location = new Point(105, 181);
            label2.Name = "label2";
            label2.Size = new Size(194, 32);
            label2.TabIndex = 22;
            label2.Text = "Mã khách hàng:";
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.Font = new Font("Segoe UI", 16F, FontStyle.Bold, GraphicsUnit.Point, 0);
            label1.ForeColor = SystemColors.MenuHighlight;
            label1.Location = new Point(533, 86);
            label1.Name = "label1";
            label1.Size = new Size(428, 45);
            label1.TabIndex = 21;
            label1.Text = "DANH MỤC KHÁCH HÀNG";
            // 
            // dgvKH
            // 
            dgvKH.AutoSizeColumnsMode = DataGridViewAutoSizeColumnsMode.Fill;
            dgvKH.BackgroundColor = Color.FromArgb(0, 192, 192);
            dgvKH.ColumnHeadersHeightSizeMode = DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            dgvKH.Location = new Point(110, 412);
            dgvKH.Name = "dgvKH";
            dgvKH.RowHeadersWidth = 62;
            dgvKH.Size = new Size(1116, 208);
            dgvKH.TabIndex = 40;
            dgvKH.CellClick += dgvKH_CellClick;
            // 
            // buttonThemKH
            // 
            buttonThemKH.BackColor = Color.Turquoise;
            buttonThemKH.ForeColor = SystemColors.ActiveCaptionText;
            buttonThemKH.Location = new Point(533, 341);
            buttonThemKH.Name = "buttonThemKH";
            buttonThemKH.Size = new Size(112, 41);
            buttonThemKH.TabIndex = 41;
            buttonThemKH.Text = "Thêm";
            buttonThemKH.UseVisualStyleBackColor = false;
            buttonThemKH.Click += buttonThemKH_Click;
            // 
            // FormQLKH
            // 
            AutoScaleDimensions = new SizeF(14F, 32F);
            AutoScaleMode = AutoScaleMode.Font;
            BackColor = Color.OldLace;
            BackgroundImage = (Image)resources.GetObject("$this.BackgroundImage");
            ClientSize = new Size(1327, 576);
            Controls.Add(buttonThemKH);
            Controls.Add(dgvKH);
            Controls.Add(buttonThoatKH);
            Controls.Add(buttonLuuKH);
            Controls.Add(buttonXoaKH);
            Controls.Add(buttonSuaKH);
            Controls.Add(txtDienthoaiKH);
            Controls.Add(txtDiachiKH);
            Controls.Add(txtTenKH);
            Controls.Add(txtMaKH);
            Controls.Add(label7);
            Controls.Add(label6);
            Controls.Add(label5);
            Controls.Add(label3);
            Controls.Add(label2);
            Controls.Add(label1);
            Font = new Font("Segoe UI", 12F, FontStyle.Bold, GraphicsUnit.Point, 0);
            Margin = new Padding(4);
            Name = "FormQLKH";
            Text = "Quản Lý Khách Hàng";
            ((System.ComponentModel.ISupportInitialize)dgvKH).EndInit();
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private Button buttonThoatKH;
        private Button buttonLuuKH;
        private Button buttonXoaKH;
        private Button buttonSuaKH;
        private TextBox txtDienthoaiKH;
        private TextBox txtDiachiKH;
        private TextBox txtTenKH;
        private TextBox txtMaKH;
        private Label label7;
        private Label label6;
        private Label label5;
        private Label label3;
        private Label label2;
        private Label label1;
        private DataGridView dgvKH;
        private Button buttonThemKH;
    }
}