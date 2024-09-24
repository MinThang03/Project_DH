namespace WinFormsApp2
{
    partial class FormQLBS
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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(FormQLBS));
            buttonThoatQLBS = new Button();
            buttonLuuQLBS = new Button();
            buttonXoaQLBS = new Button();
            buttonSuaQLBS = new Button();
            buttonThemQLBS = new Button();
            txtSohd1 = new TextBox();
            txtSohd2 = new TextBox();
            txtSoluongBS = new TextBox();
            cboManvBS = new ComboBox();
            dtpNgayhd = new DateTimePicker();
            label13 = new Label();
            label12 = new Label();
            label10 = new Label();
            label11 = new Label();
            label8 = new Label();
            label9 = new Label();
            label5 = new Label();
            label6 = new Label();
            label3 = new Label();
            label7 = new Label();
            dgvQLBS = new DataGridView();
            label4 = new Label();
            label1 = new Label();
            cboMakhBS = new ComboBox();
            txtGhichuBS = new TextBox();
            cboMasachBS = new ComboBox();
            ((System.ComponentModel.ISupportInitialize)dgvQLBS).BeginInit();
            SuspendLayout();
            // 
            // buttonThoatQLBS
            // 
            buttonThoatQLBS.BackColor = Color.Turquoise;
            buttonThoatQLBS.ForeColor = SystemColors.ActiveCaptionText;
            buttonThoatQLBS.Location = new Point(1149, 541);
            buttonThoatQLBS.Name = "buttonThoatQLBS";
            buttonThoatQLBS.Size = new Size(112, 41);
            buttonThoatQLBS.TabIndex = 141;
            buttonThoatQLBS.Text = "Thoát";
            buttonThoatQLBS.UseVisualStyleBackColor = false;
            buttonThoatQLBS.Click += buttonThoatQLBS_Click;
            // 
            // buttonLuuQLBS
            // 
            buttonLuuQLBS.BackColor = Color.Turquoise;
            buttonLuuQLBS.ForeColor = SystemColors.ActiveCaptionText;
            buttonLuuQLBS.Location = new Point(999, 541);
            buttonLuuQLBS.Name = "buttonLuuQLBS";
            buttonLuuQLBS.Size = new Size(112, 41);
            buttonLuuQLBS.TabIndex = 140;
            buttonLuuQLBS.Text = "Lưu";
            buttonLuuQLBS.UseVisualStyleBackColor = false;
            buttonLuuQLBS.Click += buttonLuuQLBS_Click;
            // 
            // buttonXoaQLBS
            // 
            buttonXoaQLBS.BackColor = Color.Turquoise;
            buttonXoaQLBS.ForeColor = SystemColors.ActiveCaptionText;
            buttonXoaQLBS.Location = new Point(859, 541);
            buttonXoaQLBS.Name = "buttonXoaQLBS";
            buttonXoaQLBS.Size = new Size(112, 41);
            buttonXoaQLBS.TabIndex = 139;
            buttonXoaQLBS.Text = "Xóa";
            buttonXoaQLBS.UseVisualStyleBackColor = false;
            buttonXoaQLBS.Click += buttonXoaQLBS_Click;
            // 
            // buttonSuaQLBS
            // 
            buttonSuaQLBS.BackColor = Color.Turquoise;
            buttonSuaQLBS.ForeColor = SystemColors.ActiveCaptionText;
            buttonSuaQLBS.Location = new Point(713, 541);
            buttonSuaQLBS.Name = "buttonSuaQLBS";
            buttonSuaQLBS.Size = new Size(112, 41);
            buttonSuaQLBS.TabIndex = 138;
            buttonSuaQLBS.Text = "Sửa";
            buttonSuaQLBS.UseVisualStyleBackColor = false;
            buttonSuaQLBS.Click += buttonSuaQLBS_Click;
            // 
            // buttonThemQLBS
            // 
            buttonThemQLBS.BackColor = Color.Turquoise;
            buttonThemQLBS.ForeColor = SystemColors.ActiveCaptionText;
            buttonThemQLBS.Location = new Point(568, 541);
            buttonThemQLBS.Name = "buttonThemQLBS";
            buttonThemQLBS.Size = new Size(112, 41);
            buttonThemQLBS.TabIndex = 137;
            buttonThemQLBS.Text = "Thêm";
            buttonThemQLBS.UseVisualStyleBackColor = false;
            buttonThemQLBS.Click += buttonThemQLBS_Click;
            // 
            // txtSohd1
            // 
            txtSohd1.Location = new Point(353, 249);
            txtSohd1.Name = "txtSohd1";
            txtSohd1.Size = new Size(304, 37);
            txtSohd1.TabIndex = 136;
            txtSohd1.TextChanged += txtSohd1_TextChanged;
            // 
            // txtSohd2
            // 
            txtSohd2.Location = new Point(918, 245);
            txtSohd2.Name = "txtSohd2";
            txtSohd2.ReadOnly = true;
            txtSohd2.Size = new Size(319, 37);
            txtSohd2.TabIndex = 133;
            txtSohd2.TextChanged += txtSohd2_TextChanged;
            // 
            // txtSoluongBS
            // 
            txtSoluongBS.Location = new Point(918, 358);
            txtSoluongBS.Name = "txtSoluongBS";
            txtSoluongBS.Size = new Size(319, 37);
            txtSoluongBS.TabIndex = 131;
            // 
            // cboManvBS
            // 
            cboManvBS.FormattingEnabled = true;
            cboManvBS.Location = new Point(353, 425);
            cboManvBS.Name = "cboManvBS";
            cboManvBS.Size = new Size(304, 38);
            cboManvBS.TabIndex = 129;
            // 
            // dtpNgayhd
            // 
            dtpNgayhd.Format = DateTimePickerFormat.Short;
            dtpNgayhd.Location = new Point(353, 309);
            dtpNgayhd.Name = "dtpNgayhd";
            dtpNgayhd.Size = new Size(304, 37);
            dtpNgayhd.TabIndex = 128;
            // 
            // label13
            // 
            label13.AutoSize = true;
            label13.Font = new Font("Segoe UI", 16F, FontStyle.Bold, GraphicsUnit.Point, 0);
            label13.ForeColor = Color.Red;
            label13.Location = new Point(918, 155);
            label13.Margin = new Padding(5, 0, 5, 0);
            label13.Name = "label13";
            label13.Size = new Size(343, 45);
            label13.TabIndex = 127;
            label13.Text = "Chi Tiết Hóa Đơn Bán";
            // 
            // label12
            // 
            label12.AutoSize = true;
            label12.Font = new Font("Segoe UI", 16F, FontStyle.Bold, GraphicsUnit.Point, 0);
            label12.ForeColor = Color.Red;
            label12.Location = new Point(371, 155);
            label12.Margin = new Padding(5, 0, 5, 0);
            label12.Name = "label12";
            label12.Size = new Size(220, 45);
            label12.TabIndex = 126;
            label12.Text = "Hóa Đơn Bán";
            // 
            // label10
            // 
            label10.AutoSize = true;
            label10.Location = new Point(790, 361);
            label10.Margin = new Padding(5, 0, 5, 0);
            label10.Name = "label10";
            label10.Size = new Size(112, 30);
            label10.TabIndex = 125;
            label10.Text = "Số lượng:";
            // 
            // label11
            // 
            label11.AutoSize = true;
            label11.Location = new Point(165, 470);
            label11.Margin = new Padding(5, 0, 5, 0);
            label11.Name = "label11";
            label11.Size = new Size(0, 30);
            label11.TabIndex = 124;
            // 
            // label8
            // 
            label8.AutoSize = true;
            label8.Location = new Point(807, 304);
            label8.Margin = new Padding(5, 0, 5, 0);
            label8.Name = "label8";
            label8.Size = new Size(95, 30);
            label8.TabIndex = 123;
            label8.Text = "Mã loại:";
            // 
            // label9
            // 
            label9.AutoSize = true;
            label9.Location = new Point(178, 425);
            label9.Margin = new Padding(5, 0, 5, 0);
            label9.Name = "label9";
            label9.Size = new Size(158, 30);
            label9.TabIndex = 122;
            label9.Text = "Mã nhân viên:";
            // 
            // label5
            // 
            label5.AutoSize = true;
            label5.Location = new Point(767, 248);
            label5.Margin = new Padding(5, 0, 5, 0);
            label5.Name = "label5";
            label5.Size = new Size(135, 30);
            label5.TabIndex = 121;
            label5.Text = "Số hóa đơn:";
            // 
            // label6
            // 
            label6.AutoSize = true;
            label6.Location = new Point(159, 366);
            label6.Margin = new Padding(5, 0, 5, 0);
            label6.Name = "label6";
            label6.Size = new Size(177, 30);
            label6.TabIndex = 120;
            label6.Text = "Mã khách hàng:";
            // 
            // label3
            // 
            label3.AutoSize = true;
            label3.Location = new Point(171, 309);
            label3.Margin = new Padding(5, 0, 5, 0);
            label3.Name = "label3";
            label3.Size = new Size(165, 30);
            label3.TabIndex = 118;
            label3.Text = "Ngày hóa đơn:";
            // 
            // label7
            // 
            label7.AutoSize = true;
            label7.BackColor = Color.FromArgb(0, 192, 192);
            label7.Font = new Font("Segoe UI", 16F, FontStyle.Bold, GraphicsUnit.Point, 0);
            label7.ForeColor = Color.Red;
            label7.Location = new Point(594, 45);
            label7.Margin = new Padding(5, 0, 5, 0);
            label7.Name = "label7";
            label7.Size = new Size(330, 45);
            label7.TabIndex = 117;
            label7.Text = "QUẢN LÝ BÁN SÁCH";
            // 
            // dgvQLBS
            // 
            dgvQLBS.AutoSizeColumnsMode = DataGridViewAutoSizeColumnsMode.Fill;
            dgvQLBS.BackgroundColor = Color.FromArgb(0, 192, 192);
            dgvQLBS.ColumnHeadersHeightSizeMode = DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            dgvQLBS.Location = new Point(178, 629);
            dgvQLBS.Margin = new Padding(5, 4, 5, 4);
            dgvQLBS.Name = "dgvQLBS";
            dgvQLBS.RowHeadersWidth = 51;
            dgvQLBS.RowTemplate.Height = 29;
            dgvQLBS.Size = new Size(1141, 370);
            dgvQLBS.TabIndex = 116;
            // 
            // label4
            // 
            label4.AutoSize = true;
            label4.Location = new Point(239, 481);
            label4.Margin = new Padding(5, 0, 5, 0);
            label4.Name = "label4";
            label4.Size = new Size(97, 30);
            label4.TabIndex = 115;
            label4.Text = "Ghi chú:";
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.BackColor = Color.OldLace;
            label1.Location = new Point(201, 249);
            label1.Margin = new Padding(5, 0, 5, 0);
            label1.Name = "label1";
            label1.Size = new Size(135, 30);
            label1.TabIndex = 114;
            label1.Text = "Số hóa đơn:";
            // 
            // cboMakhBS
            // 
            cboMakhBS.FormattingEnabled = true;
            cboMakhBS.Location = new Point(353, 366);
            cboMakhBS.Name = "cboMakhBS";
            cboMakhBS.Size = new Size(304, 38);
            cboMakhBS.TabIndex = 142;
            // 
            // txtGhichuBS
            // 
            txtGhichuBS.Location = new Point(353, 481);
            txtGhichuBS.Name = "txtGhichuBS";
            txtGhichuBS.Size = new Size(304, 37);
            txtGhichuBS.TabIndex = 143;
            // 
            // cboMasachBS
            // 
            cboMasachBS.FormattingEnabled = true;
            cboMasachBS.Location = new Point(918, 301);
            cboMasachBS.Name = "cboMasachBS";
            cboMasachBS.Size = new Size(319, 38);
            cboMasachBS.TabIndex = 144;
            // 
            // FormQLBS
            // 
            AutoScaleDimensions = new SizeF(13F, 30F);
            AutoScaleMode = AutoScaleMode.Font;
            BackColor = Color.OldLace;
            BackgroundImage = (Image)resources.GetObject("$this.BackgroundImage");
            ClientSize = new Size(1580, 778);
            Controls.Add(cboMasachBS);
            Controls.Add(txtGhichuBS);
            Controls.Add(cboMakhBS);
            Controls.Add(buttonThoatQLBS);
            Controls.Add(buttonLuuQLBS);
            Controls.Add(buttonXoaQLBS);
            Controls.Add(buttonSuaQLBS);
            Controls.Add(buttonThemQLBS);
            Controls.Add(txtSohd1);
            Controls.Add(txtSohd2);
            Controls.Add(txtSoluongBS);
            Controls.Add(cboManvBS);
            Controls.Add(dtpNgayhd);
            Controls.Add(label13);
            Controls.Add(label12);
            Controls.Add(label10);
            Controls.Add(label11);
            Controls.Add(label8);
            Controls.Add(label9);
            Controls.Add(label5);
            Controls.Add(label6);
            Controls.Add(label3);
            Controls.Add(label7);
            Controls.Add(dgvQLBS);
            Controls.Add(label4);
            Controls.Add(label1);
            Font = new Font("Segoe UI", 11F, FontStyle.Bold, GraphicsUnit.Point, 0);
            Margin = new Padding(4);
            Name = "FormQLBS";
            Text = "Quản Lý Bán Sách";
            ((System.ComponentModel.ISupportInitialize)dgvQLBS).EndInit();
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private Button buttonThoatQLBS;
        private Button buttonLuuQLBS;
        private Button buttonXoaQLBS;
        private Button buttonSuaQLBS;
        private Button buttonThemQLBS;
        private TextBox txtSohd1;
        private TextBox txtSohd2;
        private TextBox txtSoluongBS;
        private ComboBox cboManvBS;
        private DateTimePicker dtpNgayhd;
        private Label label13;
        private Label label12;
        private Label label10;
        private Label label11;
        private Label label8;
        private Label label9;
        private Label label5;
        private Label label6;
        private Label label3;
        private Label label7;
        private DataGridView dgvQLBS;
        private Label label4;
        private Label label1;
        private ComboBox cboMakhBS;
        private TextBox txtGhichuBS;
        private ComboBox cboMasachBS;
    }
}