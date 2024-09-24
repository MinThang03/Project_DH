namespace WinFormsApp2
{
    partial class FormCNLoaiSach
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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(FormCNLoaiSach));
            txtNXB = new Label();
            txtMaLoaiLS = new TextBox();
            label2 = new Label();
            label1 = new Label();
            txtTenLoaiLS = new TextBox();
            buttonThoatCNLS = new Button();
            buttonLuuCNLS = new Button();
            buttonXoaCNLS = new Button();
            buttonSuaCNLS = new Button();
            buttonThemCNLS = new Button();
            dgvCNLS = new DataGridView();
            ((System.ComponentModel.ISupportInitialize)dgvCNLS).BeginInit();
            SuspendLayout();
            // 
            // txtNXB
            // 
            txtNXB.AutoSize = true;
            txtNXB.Location = new Point(539, 145);
            txtNXB.Margin = new Padding(4, 0, 4, 0);
            txtNXB.Name = "txtNXB";
            txtNXB.Size = new Size(103, 30);
            txtNXB.TabIndex = 51;
            txtNXB.Text = "Tên Loại:";
            // 
            // txtMaLoaiLS
            // 
            txtMaLoaiLS.Location = new Point(183, 142);
            txtMaLoaiLS.Margin = new Padding(4);
            txtMaLoaiLS.Name = "txtMaLoaiLS";
            txtMaLoaiLS.Size = new Size(261, 37);
            txtMaLoaiLS.TabIndex = 50;
            // 
            // label2
            // 
            label2.AutoSize = true;
            label2.Location = new Point(60, 145);
            label2.Margin = new Padding(4, 0, 4, 0);
            label2.Name = "label2";
            label2.Size = new Size(100, 30);
            label2.TabIndex = 49;
            label2.Text = "Mã Loại:";
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.Font = new Font("Segoe UI", 16F, FontStyle.Bold, GraphicsUnit.Point, 0);
            label1.ForeColor = SystemColors.MenuHighlight;
            label1.Location = new Point(391, 52);
            label1.Margin = new Padding(4, 0, 4, 0);
            label1.Name = "label1";
            label1.Size = new Size(360, 45);
            label1.TabIndex = 48;
            label1.Text = "CẬP NHẬT LOẠI SÁCH";
            // 
            // txtTenLoaiLS
            // 
            txtTenLoaiLS.Location = new Point(670, 142);
            txtTenLoaiLS.Margin = new Padding(4);
            txtTenLoaiLS.Name = "txtTenLoaiLS";
            txtTenLoaiLS.Size = new Size(261, 37);
            txtTenLoaiLS.TabIndex = 52;
            // 
            // buttonThoatCNLS
            // 
            buttonThoatCNLS.BackColor = Color.Turquoise;
            buttonThoatCNLS.ForeColor = SystemColors.ActiveCaptionText;
            buttonThoatCNLS.Location = new Point(785, 213);
            buttonThoatCNLS.Name = "buttonThoatCNLS";
            buttonThoatCNLS.Size = new Size(112, 41);
            buttonThoatCNLS.TabIndex = 57;
            buttonThoatCNLS.Text = "Thoát";
            buttonThoatCNLS.UseVisualStyleBackColor = false;
            buttonThoatCNLS.Click += buttonThoatCNLS_Click;
            // 
            // buttonLuuCNLS
            // 
            buttonLuuCNLS.BackColor = Color.Turquoise;
            buttonLuuCNLS.ForeColor = SystemColors.ActiveCaptionText;
            buttonLuuCNLS.Location = new Point(635, 213);
            buttonLuuCNLS.Name = "buttonLuuCNLS";
            buttonLuuCNLS.Size = new Size(112, 41);
            buttonLuuCNLS.TabIndex = 56;
            buttonLuuCNLS.Text = "Lưu";
            buttonLuuCNLS.UseVisualStyleBackColor = false;
            buttonLuuCNLS.Click += buttonLuuCNLS_Click;
            // 
            // buttonXoaCNLS
            // 
            buttonXoaCNLS.BackColor = Color.Turquoise;
            buttonXoaCNLS.ForeColor = SystemColors.ActiveCaptionText;
            buttonXoaCNLS.Location = new Point(495, 213);
            buttonXoaCNLS.Name = "buttonXoaCNLS";
            buttonXoaCNLS.Size = new Size(112, 41);
            buttonXoaCNLS.TabIndex = 55;
            buttonXoaCNLS.Text = "Xóa";
            buttonXoaCNLS.UseVisualStyleBackColor = false;
            buttonXoaCNLS.Click += buttonXoaCNLS_Click;
            // 
            // buttonSuaCNLS
            // 
            buttonSuaCNLS.BackColor = Color.Turquoise;
            buttonSuaCNLS.ForeColor = SystemColors.ActiveCaptionText;
            buttonSuaCNLS.Location = new Point(349, 213);
            buttonSuaCNLS.Name = "buttonSuaCNLS";
            buttonSuaCNLS.Size = new Size(112, 41);
            buttonSuaCNLS.TabIndex = 54;
            buttonSuaCNLS.Text = "Sửa";
            buttonSuaCNLS.UseVisualStyleBackColor = false;
            buttonSuaCNLS.Click += buttonSuaCNLS_Click;
            // 
            // buttonThemCNLS
            // 
            buttonThemCNLS.BackColor = Color.Turquoise;
            buttonThemCNLS.ForeColor = SystemColors.ActiveCaptionText;
            buttonThemCNLS.Location = new Point(204, 213);
            buttonThemCNLS.Name = "buttonThemCNLS";
            buttonThemCNLS.Size = new Size(112, 41);
            buttonThemCNLS.TabIndex = 53;
            buttonThemCNLS.Text = "Thêm";
            buttonThemCNLS.UseVisualStyleBackColor = false;
            buttonThemCNLS.Click += buttonThemCNLS_Click;
            // 
            // dgvCNLS
            // 
            dgvCNLS.AutoSizeColumnsMode = DataGridViewAutoSizeColumnsMode.Fill;
            dgvCNLS.BackgroundColor = Color.FromArgb(0, 192, 192);
            dgvCNLS.ColumnHeadersHeightSizeMode = DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            dgvCNLS.Location = new Point(260, 286);
            dgvCNLS.Name = "dgvCNLS";
            dgvCNLS.RowHeadersWidth = 62;
            dgvCNLS.Size = new Size(566, 241);
            dgvCNLS.TabIndex = 58;
            // 
            // FormCNLoaiSach
            // 
            AutoScaleDimensions = new SizeF(13F, 30F);
            AutoScaleMode = AutoScaleMode.Font;
            BackColor = Color.OldLace;
            BackgroundImage = (Image)resources.GetObject("$this.BackgroundImage");
            ClientSize = new Size(997, 546);
            Controls.Add(dgvCNLS);
            Controls.Add(buttonThoatCNLS);
            Controls.Add(buttonLuuCNLS);
            Controls.Add(buttonXoaCNLS);
            Controls.Add(buttonSuaCNLS);
            Controls.Add(buttonThemCNLS);
            Controls.Add(txtTenLoaiLS);
            Controls.Add(txtNXB);
            Controls.Add(txtMaLoaiLS);
            Controls.Add(label2);
            Controls.Add(label1);
            Font = new Font("Segoe UI", 11F, FontStyle.Bold, GraphicsUnit.Point, 0);
            Margin = new Padding(4);
            Name = "FormCNLoaiSach";
            Text = "Cập Nhật Loại Sách";
            ((System.ComponentModel.ISupportInitialize)dgvCNLS).EndInit();
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private Label txtNXB;
        private TextBox txtMaLoaiLS;
        private Label label2;
        private Label label1;
        private TextBox txtTenLoaiLS;
        private Button buttonThoatCNLS;
        private Button buttonLuuCNLS;
        private Button buttonXoaCNLS;
        private Button buttonSuaCNLS;
        private Button buttonThemCNLS;
        private DataGridView dgvCNLS;
    }
}