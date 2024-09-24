namespace WinFormsApp2
{
    partial class FormQLNV
    {
        /// <summary>
        ///  Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        ///  Clean up any resources being used.
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
        ///  Required method for Designer support - do not modify
        ///  the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(FormQLNV));
            label1 = new Label();
            label2 = new Label();
            label3 = new Label();
            label4 = new Label();
            label5 = new Label();
            label6 = new Label();
            label7 = new Label();
            txtMaNV = new TextBox();
            txtTenNV = new TextBox();
            txtDiachi = new TextBox();
            txtDienthoai = new TextBox();
            dtpNgaysinh = new DateTimePicker();
            rdoNam = new RadioButton();
            rdoNu = new RadioButton();
            buttonThem = new Button();
            buttonSua = new Button();
            buttonXoa = new Button();
            buttonLuu = new Button();
            dgv = new DataGridView();
            buttonThoat = new Button();
            ((System.ComponentModel.ISupportInitialize)dgv).BeginInit();
            SuspendLayout();
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.Font = new Font("Segoe UI", 16F, FontStyle.Bold, GraphicsUnit.Point, 0);
            label1.ForeColor = SystemColors.MenuHighlight;
            label1.Location = new Point(603, 56);
            label1.Name = "label1";
            label1.Size = new Size(389, 45);
            label1.TabIndex = 0;
            label1.Text = "DANH MỤC NHÂN VIÊN";
            label1.Click += label1_Click;
            // 
            // label2
            // 
            label2.AutoSize = true;
            label2.Location = new Point(175, 151);
            label2.Name = "label2";
            label2.Size = new Size(176, 32);
            label2.TabIndex = 1;
            label2.Text = "Mã nhân viên:";
            // 
            // label3
            // 
            label3.AutoSize = true;
            label3.Location = new Point(171, 213);
            label3.Name = "label3";
            label3.Size = new Size(180, 32);
            label3.TabIndex = 2;
            label3.Text = "Tên nhân viên:";
            // 
            // label4
            // 
            label4.AutoSize = true;
            label4.Location = new Point(216, 272);
            label4.Name = "label4";
            label4.Size = new Size(135, 32);
            label4.TabIndex = 3;
            label4.Text = "Ngày sinh:";
            // 
            // label5
            // 
            label5.AutoSize = true;
            label5.Location = new Point(839, 151);
            label5.Name = "label5";
            label5.Size = new Size(119, 32);
            label5.TabIndex = 4;
            label5.Text = "Giới tính:";
            // 
            // label6
            // 
            label6.AutoSize = true;
            label6.Location = new Point(859, 213);
            label6.Name = "label6";
            label6.Size = new Size(99, 32);
            label6.TabIndex = 5;
            label6.Text = "Địa chỉ:";
            // 
            // label7
            // 
            label7.AutoSize = true;
            label7.Location = new Point(819, 272);
            label7.Name = "label7";
            label7.Size = new Size(139, 32);
            label7.TabIndex = 6;
            label7.Text = "Điện thoại:";
            // 
            // txtMaNV
            // 
            txtMaNV.Location = new Point(381, 148);
            txtMaNV.Name = "txtMaNV";
            txtMaNV.Size = new Size(297, 39);
            txtMaNV.TabIndex = 7;
            // 
            // txtTenNV
            // 
            txtTenNV.Location = new Point(381, 213);
            txtTenNV.Name = "txtTenNV";
            txtTenNV.Size = new Size(297, 39);
            txtTenNV.TabIndex = 8;
            // 
            // txtDiachi
            // 
            txtDiachi.Location = new Point(999, 213);
            txtDiachi.Name = "txtDiachi";
            txtDiachi.Size = new Size(297, 39);
            txtDiachi.TabIndex = 9;
            // 
            // txtDienthoai
            // 
            txtDienthoai.Location = new Point(999, 269);
            txtDienthoai.Name = "txtDienthoai";
            txtDienthoai.Size = new Size(297, 39);
            txtDienthoai.TabIndex = 10;
            // 
            // dtpNgaysinh
            // 
            dtpNgaysinh.Format = DateTimePickerFormat.Short;
            dtpNgaysinh.Location = new Point(381, 272);
            dtpNgaysinh.Name = "dtpNgaysinh";
            dtpNgaysinh.Size = new Size(301, 39);
            dtpNgaysinh.TabIndex = 11;
            // 
            // rdoNam
            // 
            rdoNam.AutoSize = true;
            rdoNam.Location = new Point(999, 151);
            rdoNam.Name = "rdoNam";
            rdoNam.Size = new Size(93, 36);
            rdoNam.TabIndex = 12;
            rdoNam.TabStop = true;
            rdoNam.Text = "Nam";
            rdoNam.UseVisualStyleBackColor = true;
            // 
            // rdoNu
            // 
            rdoNu.AutoSize = true;
            rdoNu.Location = new Point(1133, 151);
            rdoNu.Name = "rdoNu";
            rdoNu.Size = new Size(74, 36);
            rdoNu.TabIndex = 13;
            rdoNu.TabStop = true;
            rdoNu.Text = "Nữ";
            rdoNu.UseVisualStyleBackColor = true;
            // 
            // buttonThem
            // 
            buttonThem.BackColor = Color.Turquoise;
            buttonThem.ForeColor = SystemColors.ActiveCaptionText;
            buttonThem.Location = new Point(603, 357);
            buttonThem.Name = "buttonThem";
            buttonThem.Size = new Size(112, 41);
            buttonThem.TabIndex = 14;
            buttonThem.Text = "Thêm";
            buttonThem.UseVisualStyleBackColor = false;
            buttonThem.Click += buttonThem_Click;
            // 
            // buttonSua
            // 
            buttonSua.BackColor = Color.Turquoise;
            buttonSua.ForeColor = SystemColors.ActiveCaptionText;
            buttonSua.Location = new Point(748, 357);
            buttonSua.Name = "buttonSua";
            buttonSua.Size = new Size(112, 41);
            buttonSua.TabIndex = 15;
            buttonSua.Text = "Sửa";
            buttonSua.UseVisualStyleBackColor = false;
            buttonSua.Click += buttonSua_Click;
            // 
            // buttonXoa
            // 
            buttonXoa.BackColor = Color.Turquoise;
            buttonXoa.ForeColor = SystemColors.ActiveCaptionText;
            buttonXoa.Location = new Point(894, 357);
            buttonXoa.Name = "buttonXoa";
            buttonXoa.Size = new Size(112, 41);
            buttonXoa.TabIndex = 16;
            buttonXoa.Text = "Xóa";
            buttonXoa.UseVisualStyleBackColor = false;
            buttonXoa.Click += buttonXoa_Click;
            // 
            // buttonLuu
            // 
            buttonLuu.BackColor = Color.Turquoise;
            buttonLuu.ForeColor = SystemColors.ActiveCaptionText;
            buttonLuu.Location = new Point(1034, 357);
            buttonLuu.Name = "buttonLuu";
            buttonLuu.Size = new Size(112, 41);
            buttonLuu.TabIndex = 17;
            buttonLuu.Text = "Lưu";
            buttonLuu.UseVisualStyleBackColor = false;
            buttonLuu.Click += buttonLuu_Click;
            // 
            // dgv
            // 
            dgv.AutoSizeColumnsMode = DataGridViewAutoSizeColumnsMode.Fill;
            dgv.BackgroundColor = Color.FromArgb(0, 192, 192);
            dgv.ColumnHeadersHeightSizeMode = DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            dgv.Location = new Point(106, 422);
            dgv.Name = "dgv";
            dgv.RowHeadersWidth = 62;
            dgv.Size = new Size(1315, 241);
            dgv.TabIndex = 19;
            dgv.CellClick += dgv_CellClick;
            dgv.CellContentClick += dgv_CellContentClick;
            // 
            // buttonThoat
            // 
            buttonThoat.BackColor = Color.Turquoise;
            buttonThoat.ForeColor = SystemColors.ActiveCaptionText;
            buttonThoat.Location = new Point(1184, 357);
            buttonThoat.Name = "buttonThoat";
            buttonThoat.Size = new Size(112, 41);
            buttonThoat.TabIndex = 20;
            buttonThoat.Text = "Thoát";
            buttonThoat.UseVisualStyleBackColor = false;
            buttonThoat.Click += buttonThoat_Click;
            // 
            // FormQLNV
            // 
            AutoScaleDimensions = new SizeF(14F, 32F);
            AutoScaleMode = AutoScaleMode.Font;
            BackColor = Color.OldLace;
            BackgroundImage = (Image)resources.GetObject("$this.BackgroundImage");
            ClientSize = new Size(1536, 576);
            Controls.Add(buttonThoat);
            Controls.Add(dgv);
            Controls.Add(buttonLuu);
            Controls.Add(buttonXoa);
            Controls.Add(buttonSua);
            Controls.Add(buttonThem);
            Controls.Add(rdoNu);
            Controls.Add(rdoNam);
            Controls.Add(dtpNgaysinh);
            Controls.Add(txtDienthoai);
            Controls.Add(txtDiachi);
            Controls.Add(txtTenNV);
            Controls.Add(txtMaNV);
            Controls.Add(label7);
            Controls.Add(label6);
            Controls.Add(label5);
            Controls.Add(label4);
            Controls.Add(label3);
            Controls.Add(label2);
            Controls.Add(label1);
            Font = new Font("Segoe UI", 12F, FontStyle.Bold, GraphicsUnit.Point, 0);
            Margin = new Padding(4);
            Name = "FormQLNV";
            Text = "Quản Lý Nhân Viên";
            Load += Form1_Load;
            ((System.ComponentModel.ISupportInitialize)dgv).EndInit();
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private Label label1;
        private Label label2;
        private Label label3;
        private Label label4;
        private Label label5;
        private Label label6;
        private Label label7;
        private TextBox txtMaNV;
        private TextBox txtTenNV;
        private TextBox txtDiachi;
        private TextBox txtDienthoai;
        private DateTimePicker dtpNgaysinh;
        private RadioButton rdoNam;
        private RadioButton rdoNu;
        private Button buttonThem;
        private Button buttonSua;
        private Button buttonXoa;
        private Button buttonLuu;
        private DataGridView dgv;
        private Button buttonThoat;
    }
}
