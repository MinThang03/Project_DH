namespace WinFormsApp2
{
    partial class FormCNSach
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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(FormCNSach));
            label7 = new Label();
            dgvCNS = new DataGridView();
            txtNamXBCNS = new TextBox();
            label4 = new Label();
            label1 = new Label();
            buttonThoatCNS = new Button();
            buttonLuuCNS = new Button();
            buttonXoaCNS = new Button();
            buttonSuaCNS = new Button();
            buttonThemCNS = new Button();
            txtSoTrangCNS = new TextBox();
            txtTensachCNS = new TextBox();
            label2 = new Label();
            label3 = new Label();
            txtGiabanCNS = new TextBox();
            label5 = new Label();
            label6 = new Label();
            txtNoidungCNS = new TextBox();
            txtTacgiaCNS = new TextBox();
            label8 = new Label();
            label9 = new Label();
            txtSoLuongCNS = new TextBox();
            txtNXBCNS = new TextBox();
            label10 = new Label();
            label11 = new Label();
            cboMaloai = new ComboBox();
            txtTenloaiCNS = new TextBox();
            ((System.ComponentModel.ISupportInitialize)dgvCNS).BeginInit();
            SuspendLayout();
            // 
            // label7
            // 
            label7.AutoSize = true;
            label7.Font = new Font("Segoe UI", 16F, FontStyle.Bold, GraphicsUnit.Point, 0);
            label7.ForeColor = SystemColors.MenuHighlight;
            label7.Location = new Point(565, 56);
            label7.Margin = new Padding(5, 0, 5, 0);
            label7.Name = "label7";
            label7.Size = new Size(279, 45);
            label7.TabIndex = 44;
            label7.Text = "CẬP NHẬT SÁCH";
            // 
            // dgvCNS
            // 
            dgvCNS.AutoSizeColumnsMode = DataGridViewAutoSizeColumnsMode.Fill;
            dgvCNS.BackgroundColor = Color.FromArgb(0, 192, 192);
            dgvCNS.ColumnHeadersHeightSizeMode = DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            dgvCNS.Location = new Point(159, 561);
            dgvCNS.Margin = new Padding(5, 4, 5, 4);
            dgvCNS.Name = "dgvCNS";
            dgvCNS.RowHeadersWidth = 51;
            dgvCNS.RowTemplate.Height = 29;
            dgvCNS.Size = new Size(1328, 370);
            dgvCNS.TabIndex = 43;
            // 
            // txtNamXBCNS
            // 
            txtNamXBCNS.Location = new Point(916, 156);
            txtNamXBCNS.Margin = new Padding(5, 4, 5, 4);
            txtNamXBCNS.Name = "txtNamXBCNS";
            txtNamXBCNS.Size = new Size(318, 37);
            txtNamXBCNS.TabIndex = 39;
            // 
            // label4
            // 
            label4.AutoSize = true;
            label4.Location = new Point(714, 156);
            label4.Margin = new Padding(5, 0, 5, 0);
            label4.Name = "label4";
            label4.Size = new Size(165, 30);
            label4.TabIndex = 36;
            label4.Text = "Năm xuất bản:";
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.Location = new Point(209, 159);
            label1.Margin = new Padding(5, 0, 5, 0);
            label1.Name = "label1";
            label1.Size = new Size(95, 30);
            label1.TabIndex = 33;
            label1.Text = "Mã loại:";
            // 
            // buttonThoatCNS
            // 
            buttonThoatCNS.BackColor = Color.Turquoise;
            buttonThoatCNS.ForeColor = SystemColors.ActiveCaptionText;
            buttonThoatCNS.Location = new Point(1107, 483);
            buttonThoatCNS.Name = "buttonThoatCNS";
            buttonThoatCNS.Size = new Size(112, 41);
            buttonThoatCNS.TabIndex = 52;
            buttonThoatCNS.Text = "Thoát";
            buttonThoatCNS.UseVisualStyleBackColor = false;
            buttonThoatCNS.Click += buttonThoatCNS_Click;
            // 
            // buttonLuuCNS
            // 
            buttonLuuCNS.BackColor = Color.Turquoise;
            buttonLuuCNS.ForeColor = SystemColors.ActiveCaptionText;
            buttonLuuCNS.Location = new Point(957, 483);
            buttonLuuCNS.Name = "buttonLuuCNS";
            buttonLuuCNS.Size = new Size(112, 41);
            buttonLuuCNS.TabIndex = 51;
            buttonLuuCNS.Text = "Lưu";
            buttonLuuCNS.UseVisualStyleBackColor = false;
            buttonLuuCNS.Click += buttonLuuCNS_Click;
            // 
            // buttonXoaCNS
            // 
            buttonXoaCNS.BackColor = Color.Turquoise;
            buttonXoaCNS.ForeColor = SystemColors.ActiveCaptionText;
            buttonXoaCNS.Location = new Point(817, 483);
            buttonXoaCNS.Name = "buttonXoaCNS";
            buttonXoaCNS.Size = new Size(112, 41);
            buttonXoaCNS.TabIndex = 50;
            buttonXoaCNS.Text = "Xóa";
            buttonXoaCNS.UseVisualStyleBackColor = false;
            buttonXoaCNS.Click += buttonXoaCNS_Click;
            // 
            // buttonSuaCNS
            // 
            buttonSuaCNS.BackColor = Color.Turquoise;
            buttonSuaCNS.ForeColor = SystemColors.ActiveCaptionText;
            buttonSuaCNS.Location = new Point(671, 483);
            buttonSuaCNS.Name = "buttonSuaCNS";
            buttonSuaCNS.Size = new Size(112, 41);
            buttonSuaCNS.TabIndex = 49;
            buttonSuaCNS.Text = "Sửa";
            buttonSuaCNS.UseVisualStyleBackColor = false;
            buttonSuaCNS.Click += buttonSua_Click;
            // 
            // buttonThemCNS
            // 
            buttonThemCNS.BackColor = Color.Turquoise;
            buttonThemCNS.ForeColor = SystemColors.ActiveCaptionText;
            buttonThemCNS.Location = new Point(526, 483);
            buttonThemCNS.Name = "buttonThemCNS";
            buttonThemCNS.Size = new Size(112, 41);
            buttonThemCNS.TabIndex = 48;
            buttonThemCNS.Text = "Thêm";
            buttonThemCNS.UseVisualStyleBackColor = false;
            buttonThemCNS.Click += buttonThemCNS_Click;
            // 
            // txtSoTrangCNS
            // 
            txtSoTrangCNS.Location = new Point(916, 217);
            txtSoTrangCNS.Margin = new Padding(5, 4, 5, 4);
            txtSoTrangCNS.Name = "txtSoTrangCNS";
            txtSoTrangCNS.Size = new Size(318, 37);
            txtSoTrangCNS.TabIndex = 56;
            // 
            // txtTensachCNS
            // 
            txtTensachCNS.Location = new Point(334, 217);
            txtTensachCNS.Margin = new Padding(5, 4, 5, 4);
            txtTensachCNS.Name = "txtTensachCNS";
            txtTensachCNS.Size = new Size(301, 37);
            txtTensachCNS.TabIndex = 55;
            // 
            // label2
            // 
            label2.AutoSize = true;
            label2.Location = new Point(772, 220);
            label2.Margin = new Padding(5, 0, 5, 0);
            label2.Name = "label2";
            label2.Size = new Size(107, 30);
            label2.TabIndex = 54;
            label2.Text = "Số trang:";
            // 
            // label3
            // 
            label3.AutoSize = true;
            label3.Location = new Point(197, 217);
            label3.Margin = new Padding(5, 0, 5, 0);
            label3.Name = "label3";
            label3.Size = new Size(107, 30);
            label3.TabIndex = 53;
            label3.Text = "Tên sách:";
            // 
            // txtGiabanCNS
            // 
            txtGiabanCNS.Location = new Point(916, 276);
            txtGiabanCNS.Margin = new Padding(5, 4, 5, 4);
            txtGiabanCNS.Name = "txtGiabanCNS";
            txtGiabanCNS.Size = new Size(318, 37);
            txtGiabanCNS.TabIndex = 60;
            // 
            // label5
            // 
            label5.AutoSize = true;
            label5.Location = new Point(781, 279);
            label5.Margin = new Padding(5, 0, 5, 0);
            label5.Name = "label5";
            label5.Size = new Size(98, 30);
            label5.TabIndex = 58;
            label5.Text = "Giá bán:";
            // 
            // label6
            // 
            label6.AutoSize = true;
            label6.Location = new Point(206, 279);
            label6.Margin = new Padding(5, 0, 5, 0);
            label6.Name = "label6";
            label6.Size = new Size(98, 30);
            label6.TabIndex = 57;
            label6.Text = "Tên loại:";
            // 
            // txtNoidungCNS
            // 
            txtNoidungCNS.Location = new Point(916, 335);
            txtNoidungCNS.Margin = new Padding(5, 4, 5, 4);
            txtNoidungCNS.Name = "txtNoidungCNS";
            txtNoidungCNS.Size = new Size(318, 37);
            txtNoidungCNS.TabIndex = 64;
            // 
            // txtTacgiaCNS
            // 
            txtTacgiaCNS.Location = new Point(334, 335);
            txtTacgiaCNS.Margin = new Padding(5, 4, 5, 4);
            txtTacgiaCNS.Name = "txtTacgiaCNS";
            txtTacgiaCNS.Size = new Size(301, 37);
            txtTacgiaCNS.TabIndex = 63;
            // 
            // label8
            // 
            label8.AutoSize = true;
            label8.Location = new Point(764, 335);
            label8.Margin = new Padding(5, 0, 5, 0);
            label8.Name = "label8";
            label8.Size = new Size(115, 30);
            label8.TabIndex = 62;
            label8.Text = "Nội dung:";
            // 
            // label9
            // 
            label9.AutoSize = true;
            label9.Location = new Point(213, 335);
            label9.Margin = new Padding(5, 0, 5, 0);
            label9.Name = "label9";
            label9.Size = new Size(91, 30);
            label9.TabIndex = 61;
            label9.Text = "Tác giả:";
            // 
            // txtSoLuongCNS
            // 
            txtSoLuongCNS.Location = new Point(916, 389);
            txtSoLuongCNS.Margin = new Padding(5, 4, 5, 4);
            txtSoLuongCNS.Name = "txtSoLuongCNS";
            txtSoLuongCNS.Size = new Size(318, 37);
            txtSoLuongCNS.TabIndex = 68;
            // 
            // txtNXBCNS
            // 
            txtNXBCNS.Location = new Point(334, 389);
            txtNXBCNS.Margin = new Padding(5, 4, 5, 4);
            txtNXBCNS.Name = "txtNXBCNS";
            txtNXBCNS.Size = new Size(301, 37);
            txtNXBCNS.TabIndex = 67;
            // 
            // label10
            // 
            label10.AutoSize = true;
            label10.Location = new Point(767, 392);
            label10.Margin = new Padding(5, 0, 5, 0);
            label10.Name = "label10";
            label10.Size = new Size(112, 30);
            label10.TabIndex = 66;
            label10.Text = "Số lượng:";
            // 
            // label11
            // 
            label11.AutoSize = true;
            label11.Location = new Point(146, 392);
            label11.Margin = new Padding(5, 0, 5, 0);
            label11.Name = "label11";
            label11.Size = new Size(158, 30);
            label11.TabIndex = 65;
            label11.Text = "Nhà xuất bản:";
            // 
            // cboMaloai
            // 
            cboMaloai.FormattingEnabled = true;
            cboMaloai.Location = new Point(334, 159);
            cboMaloai.Name = "cboMaloai";
            cboMaloai.Size = new Size(301, 38);
            cboMaloai.TabIndex = 69;
            cboMaloai.SelectedValueChanged += cboMaloai_SelectedValueChanged;
            cboMaloai.Leave += cboMaloai_Leave;
            // 
            // txtTenloaiCNS
            // 
            txtTenloaiCNS.Location = new Point(334, 276);
            txtTenloaiCNS.Margin = new Padding(5, 4, 5, 4);
            txtTenloaiCNS.Name = "txtTenloaiCNS";
            txtTenloaiCNS.ReadOnly = true;
            txtTenloaiCNS.Size = new Size(301, 37);
            txtTenloaiCNS.TabIndex = 59;
            // 
            // FormCNSach
            // 
            AutoScaleDimensions = new SizeF(13F, 30F);
            AutoScaleMode = AutoScaleMode.Font;
            BackColor = Color.OldLace;
            BackgroundImage = (Image)resources.GetObject("$this.BackgroundImage");
            ClientSize = new Size(1599, 732);
            Controls.Add(cboMaloai);
            Controls.Add(txtSoLuongCNS);
            Controls.Add(txtNXBCNS);
            Controls.Add(label10);
            Controls.Add(label11);
            Controls.Add(txtNoidungCNS);
            Controls.Add(txtTacgiaCNS);
            Controls.Add(label8);
            Controls.Add(label9);
            Controls.Add(txtGiabanCNS);
            Controls.Add(txtTenloaiCNS);
            Controls.Add(label5);
            Controls.Add(label6);
            Controls.Add(txtSoTrangCNS);
            Controls.Add(txtTensachCNS);
            Controls.Add(label2);
            Controls.Add(label3);
            Controls.Add(buttonThoatCNS);
            Controls.Add(buttonLuuCNS);
            Controls.Add(buttonXoaCNS);
            Controls.Add(buttonSuaCNS);
            Controls.Add(buttonThemCNS);
            Controls.Add(label7);
            Controls.Add(dgvCNS);
            Controls.Add(txtNamXBCNS);
            Controls.Add(label4);
            Controls.Add(label1);
            Font = new Font("Segoe UI", 11F, FontStyle.Bold, GraphicsUnit.Point, 0);
            Margin = new Padding(4);
            Name = "FormCNSach";
            Text = "Cập Nhật Sách";
            ((System.ComponentModel.ISupportInitialize)dgvCNS).EndInit();
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private TextBox txtGhichu;
        private DateTimePicker dtpNgayHD;
        private Label label7;
        private DataGridView dgvCNS;
        private TextBox txtNamXBCNS;
        private TextBox txtMaNV2;
        private Label label4;
        private Label label1;
        private Button buttonThoatCNS;
        private Button buttonLuuCNS;
        private Button buttonXoaCNS;
        private Button buttonSuaCNS;
        private Button buttonThemCNS;
        private TextBox txtSoTrangCNS;
        private TextBox txtTensachCNS;
        private Label label2;
        private Label label3;
        private TextBox txtGiabanCNS;
        private Label label5;
        private Label label6;
        private TextBox txtNoidungCNS;
        private TextBox txtTacgiaCNS;
        private Label label8;
        private Label label9;
        private TextBox txtSoLuongCNS;
        private TextBox txtNXBCNS;
        private Label label10;
        private Label label11;
        private ComboBox cboMaloai;
        private TextBox txtTenloaiCNS;
    }
}