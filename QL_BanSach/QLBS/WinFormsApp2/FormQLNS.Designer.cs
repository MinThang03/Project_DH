namespace WinFormsApp2
{
    partial class FormQLNS
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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(FormQLNS));
            label10 = new Label();
            label11 = new Label();
            label8 = new Label();
            label9 = new Label();
            label5 = new Label();
            label6 = new Label();
            label2 = new Label();
            label3 = new Label();
            label7 = new Label();
            dgvQLNS = new DataGridView();
            label4 = new Label();
            label1 = new Label();
            label12 = new Label();
            label13 = new Label();
            dtpNgay = new DateTimePicker();
            cboManvNS = new ComboBox();
            cboMaloaiNS = new ComboBox();
            txtGhichuNS = new TextBox();
            txtGiamuaNS = new TextBox();
            txtSoluongNS = new TextBox();
            txtSophieu2 = new TextBox();
            txtTenNCC = new TextBox();
            txtSophieu1 = new TextBox();
            buttonThoatQLNS = new Button();
            buttonLuuQLNS = new Button();
            buttonXoaQLNS = new Button();
            buttonSuaQLNS = new Button();
            buttonThemQLNS = new Button();
            ((System.ComponentModel.ISupportInitialize)dgvQLNS).BeginInit();
            SuspendLayout();
            // 
            // label10
            // 
            label10.AutoSize = true;
            label10.Location = new Point(704, 462);
            label10.Margin = new Padding(5, 0, 5, 0);
            label10.Name = "label10";
            label10.Size = new Size(97, 30);
            label10.TabIndex = 93;
            label10.Text = "Ghi chú:";
            label10.Click += label10_Click;
            // 
            // label11
            // 
            label11.AutoSize = true;
            label11.Location = new Point(72, 472);
            label11.Margin = new Padding(5, 0, 5, 0);
            label11.Name = "label11";
            label11.Size = new Size(0, 30);
            label11.TabIndex = 92;
            // 
            // label8
            // 
            label8.AutoSize = true;
            label8.Location = new Point(697, 405);
            label8.Margin = new Padding(5, 0, 5, 0);
            label8.Name = "label8";
            label8.Size = new Size(104, 30);
            label8.TabIndex = 89;
            label8.Text = "Giá mua:";
            // 
            // label9
            // 
            label9.AutoSize = true;
            label9.Location = new Point(85, 427);
            label9.Margin = new Padding(5, 0, 5, 0);
            label9.Name = "label9";
            label9.Size = new Size(158, 30);
            label9.TabIndex = 88;
            label9.Text = "Mã nhân viên:";
            // 
            // label5
            // 
            label5.AutoSize = true;
            label5.Location = new Point(690, 349);
            label5.Margin = new Padding(5, 0, 5, 0);
            label5.Name = "label5";
            label5.Size = new Size(112, 30);
            label5.TabIndex = 85;
            label5.Text = "Số lượng:";
            // 
            // label6
            // 
            label6.AutoSize = true;
            label6.Location = new Point(44, 368);
            label6.Margin = new Padding(5, 0, 5, 0);
            label6.Name = "label6";
            label6.Size = new Size(199, 30);
            label6.TabIndex = 84;
            label6.Text = "Tên nhà cung cấp:";
            // 
            // label2
            // 
            label2.AutoSize = true;
            label2.Location = new Point(704, 290);
            label2.Margin = new Padding(5, 0, 5, 0);
            label2.Name = "label2";
            label2.Size = new Size(95, 30);
            label2.TabIndex = 81;
            label2.Text = "Mã loại:";
            // 
            // label3
            // 
            label3.AutoSize = true;
            label3.Location = new Point(169, 309);
            label3.Margin = new Padding(5, 0, 5, 0);
            label3.Name = "label3";
            label3.Size = new Size(74, 30);
            label3.TabIndex = 80;
            label3.Text = "Ngày:";
            // 
            // label7
            // 
            label7.AutoSize = true;
            label7.BackColor = Color.FromArgb(0, 192, 192);
            label7.Font = new Font("Segoe UI", 16F, FontStyle.Bold, GraphicsUnit.Point, 0);
            label7.ForeColor = Color.Red;
            label7.Location = new Point(501, 47);
            label7.Margin = new Padding(5, 0, 5, 0);
            label7.Name = "label7";
            label7.Size = new Size(354, 45);
            label7.TabIndex = 74;
            label7.Text = "QUẢN LÝ NHẬP SÁCH";
            label7.Click += label7_Click;
            // 
            // dgvQLNS
            // 
            dgvQLNS.AutoSizeColumnsMode = DataGridViewAutoSizeColumnsMode.Fill;
            dgvQLNS.BackgroundColor = Color.FromArgb(0, 192, 192);
            dgvQLNS.ColumnHeadersHeightSizeMode = DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            dgvQLNS.Location = new Point(85, 631);
            dgvQLNS.Margin = new Padding(5, 4, 5, 4);
            dgvQLNS.Name = "dgvQLNS";
            dgvQLNS.RowHeadersWidth = 51;
            dgvQLNS.RowTemplate.Height = 29;
            dgvQLNS.Size = new Size(1141, 370);
            dgvQLNS.TabIndex = 73;
            // 
            // label4
            // 
            label4.AutoSize = true;
            label4.Location = new Point(697, 226);
            label4.Margin = new Padding(5, 0, 5, 0);
            label4.Name = "label4";
            label4.Size = new Size(108, 30);
            label4.TabIndex = 71;
            label4.Text = "Số phiếu:";
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.BackColor = Color.OldLace;
            label1.Location = new Point(135, 251);
            label1.Margin = new Padding(5, 0, 5, 0);
            label1.Name = "label1";
            label1.Size = new Size(108, 30);
            label1.TabIndex = 70;
            label1.Text = "Số phiếu:";
            // 
            // label12
            // 
            label12.AutoSize = true;
            label12.Font = new Font("Segoe UI", 16F, FontStyle.Bold, GraphicsUnit.Point, 0);
            label12.ForeColor = Color.Red;
            label12.Location = new Point(276, 145);
            label12.Margin = new Padding(5, 0, 5, 0);
            label12.Name = "label12";
            label12.Size = new Size(258, 45);
            label12.TabIndex = 97;
            label12.Text = "Phiếu Mua Sách";
            // 
            // label13
            // 
            label13.AutoSize = true;
            label13.Font = new Font("Segoe UI", 16F, FontStyle.Bold, GraphicsUnit.Point, 0);
            label13.ForeColor = Color.Red;
            label13.Location = new Point(842, 145);
            label13.Margin = new Padding(5, 0, 5, 0);
            label13.Name = "label13";
            label13.Size = new Size(303, 45);
            label13.TabIndex = 98;
            label13.Text = "Chi Tiết Phiếu Mua";
            // 
            // dtpNgay
            // 
            dtpNgay.Format = DateTimePickerFormat.Short;
            dtpNgay.Location = new Point(260, 304);
            dtpNgay.Name = "dtpNgay";
            dtpNgay.Size = new Size(304, 37);
            dtpNgay.TabIndex = 100;
            // 
            // cboManvNS
            // 
            cboManvNS.FormattingEnabled = true;
            cboManvNS.Location = new Point(260, 427);
            cboManvNS.Name = "cboManvNS";
            cboManvNS.Size = new Size(304, 38);
            cboManvNS.TabIndex = 101;
            cboManvNS.SelectedValueChanged += cboManvNS_SelectedValueChanged;
            // 
            // cboMaloaiNS
            // 
            cboMaloaiNS.FormattingEnabled = true;
            cboMaloaiNS.Location = new Point(841, 287);
            cboMaloaiNS.Name = "cboMaloaiNS";
            cboMaloaiNS.Size = new Size(319, 38);
            cboMaloaiNS.TabIndex = 102;
            // 
            // txtGhichuNS
            // 
            txtGhichuNS.Location = new Point(841, 459);
            txtGhichuNS.Name = "txtGhichuNS";
            txtGhichuNS.Size = new Size(319, 37);
            txtGhichuNS.TabIndex = 103;
            // 
            // txtGiamuaNS
            // 
            txtGiamuaNS.Location = new Point(841, 405);
            txtGiamuaNS.Name = "txtGiamuaNS";
            txtGiamuaNS.Size = new Size(319, 37);
            txtGiamuaNS.TabIndex = 104;
            // 
            // txtSoluongNS
            // 
            txtSoluongNS.Location = new Point(841, 346);
            txtSoluongNS.Name = "txtSoluongNS";
            txtSoluongNS.Size = new Size(319, 37);
            txtSoluongNS.TabIndex = 105;
            // 
            // txtSophieu2
            // 
            txtSophieu2.Location = new Point(841, 226);
            txtSophieu2.Name = "txtSophieu2";
            txtSophieu2.ReadOnly = true;
            txtSophieu2.Size = new Size(319, 37);
            txtSophieu2.TabIndex = 106;
            // 
            // txtTenNCC
            // 
            txtTenNCC.Location = new Point(260, 368);
            txtTenNCC.Name = "txtTenNCC";
            txtTenNCC.Size = new Size(304, 37);
            txtTenNCC.TabIndex = 107;
            // 
            // txtSophieu1
            // 
            txtSophieu1.Location = new Point(260, 248);
            txtSophieu1.Name = "txtSophieu1";
            txtSophieu1.Size = new Size(304, 37);
            txtSophieu1.TabIndex = 108;
            txtSophieu1.TextChanged += txtSophieu1_TextChanged;
            // 
            // buttonThoatQLNS
            // 
            buttonThoatQLNS.BackColor = Color.Turquoise;
            buttonThoatQLNS.ForeColor = SystemColors.ActiveCaptionText;
            buttonThoatQLNS.Location = new Point(1056, 543);
            buttonThoatQLNS.Name = "buttonThoatQLNS";
            buttonThoatQLNS.Size = new Size(112, 41);
            buttonThoatQLNS.TabIndex = 113;
            buttonThoatQLNS.Text = "Thoát";
            buttonThoatQLNS.UseVisualStyleBackColor = false;
            buttonThoatQLNS.Click += buttonThoatQLNS_Click;
            // 
            // buttonLuuQLNS
            // 
            buttonLuuQLNS.BackColor = Color.Turquoise;
            buttonLuuQLNS.ForeColor = SystemColors.ActiveCaptionText;
            buttonLuuQLNS.Location = new Point(906, 543);
            buttonLuuQLNS.Name = "buttonLuuQLNS";
            buttonLuuQLNS.Size = new Size(112, 41);
            buttonLuuQLNS.TabIndex = 112;
            buttonLuuQLNS.Text = "Lưu";
            buttonLuuQLNS.UseVisualStyleBackColor = false;
            buttonLuuQLNS.Click += buttonLuuQLNS_Click;
            // 
            // buttonXoaQLNS
            // 
            buttonXoaQLNS.BackColor = Color.Turquoise;
            buttonXoaQLNS.ForeColor = SystemColors.ActiveCaptionText;
            buttonXoaQLNS.Location = new Point(766, 543);
            buttonXoaQLNS.Name = "buttonXoaQLNS";
            buttonXoaQLNS.Size = new Size(112, 41);
            buttonXoaQLNS.TabIndex = 111;
            buttonXoaQLNS.Text = "Xóa";
            buttonXoaQLNS.UseVisualStyleBackColor = false;
            buttonXoaQLNS.Click += buttonXoaQLNS_Click;
            // 
            // buttonSuaQLNS
            // 
            buttonSuaQLNS.BackColor = Color.Turquoise;
            buttonSuaQLNS.ForeColor = SystemColors.ActiveCaptionText;
            buttonSuaQLNS.Location = new Point(620, 543);
            buttonSuaQLNS.Name = "buttonSuaQLNS";
            buttonSuaQLNS.Size = new Size(112, 41);
            buttonSuaQLNS.TabIndex = 110;
            buttonSuaQLNS.Text = "Sửa";
            buttonSuaQLNS.UseVisualStyleBackColor = false;
            buttonSuaQLNS.Click += buttonSuaQLNS_Click;
            // 
            // buttonThemQLNS
            // 
            buttonThemQLNS.BackColor = Color.Turquoise;
            buttonThemQLNS.ForeColor = SystemColors.ActiveCaptionText;
            buttonThemQLNS.Location = new Point(475, 543);
            buttonThemQLNS.Name = "buttonThemQLNS";
            buttonThemQLNS.Size = new Size(112, 41);
            buttonThemQLNS.TabIndex = 109;
            buttonThemQLNS.Text = "Thêm";
            buttonThemQLNS.UseVisualStyleBackColor = false;
            buttonThemQLNS.Click += buttonThemQLNS_Click;
            // 
            // FormQLNS
            // 
            AutoScaleDimensions = new SizeF(13F, 30F);
            AutoScaleMode = AutoScaleMode.Font;
            BackColor = Color.OldLace;
            BackgroundImage = (Image)resources.GetObject("$this.BackgroundImage");
            ClientSize = new Size(1301, 957);
            Controls.Add(buttonThoatQLNS);
            Controls.Add(buttonLuuQLNS);
            Controls.Add(buttonXoaQLNS);
            Controls.Add(buttonSuaQLNS);
            Controls.Add(buttonThemQLNS);
            Controls.Add(txtSophieu1);
            Controls.Add(txtTenNCC);
            Controls.Add(txtSophieu2);
            Controls.Add(txtSoluongNS);
            Controls.Add(txtGiamuaNS);
            Controls.Add(txtGhichuNS);
            Controls.Add(cboMaloaiNS);
            Controls.Add(cboManvNS);
            Controls.Add(dtpNgay);
            Controls.Add(label13);
            Controls.Add(label12);
            Controls.Add(label10);
            Controls.Add(label11);
            Controls.Add(label8);
            Controls.Add(label9);
            Controls.Add(label5);
            Controls.Add(label6);
            Controls.Add(label2);
            Controls.Add(label3);
            Controls.Add(label7);
            Controls.Add(dgvQLNS);
            Controls.Add(label4);
            Controls.Add(label1);
            Font = new Font("Segoe UI", 11F, FontStyle.Bold, GraphicsUnit.Point, 0);
            Margin = new Padding(4);
            Name = "FormQLNS";
            Text = "Quản Lý Nhập Sách";
            ((System.ComponentModel.ISupportInitialize)dgvQLNS).EndInit();
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private ComboBox cboMaloai;
        private TextBox txtSoLuongCNS;
        private Label label10;
        private Label label11;
        private TextBox txtNoidungCNS;
        private TextBox txtTacgiaCNS;
        private Label label8;
        private Label label9;
        private TextBox txtGiabanCNS;
        private TextBox txtTenloaiCNS;
        private Label label5;
        private Label label6;
        private TextBox txtSoTrangCNS;
        private TextBox txtTensachCNS;
        private Label label2;
        private Label label3;
        private Button buttonXoaCNS;
        private Button buttonSuaCNS;
        private Button buttonThemCNS;
        private Label label7;
        private DataGridView dgvQLNS;
        private Label label4;
        private Label label1;
        private Label label12;
        private Label label13;
        private DateTimePicker dtpNgay;
        private ComboBox cboManvNS;
        private ComboBox cboMaloaiNS;
        private TextBox txtGhichuNS;
        private TextBox txtGiamuaNS;
        private TextBox txtSoluongNS;
        private TextBox txtSophieu2;
        private TextBox txtTenNCC;
        private TextBox txtSophieu1;
        private Button buttonThoatQLNS;
        private Button buttonLuuQLNS;
        private Button buttonXoaQLNS;
        private Button buttonSuaQLNS;
        private Button buttonThemQLNS;
    }
}