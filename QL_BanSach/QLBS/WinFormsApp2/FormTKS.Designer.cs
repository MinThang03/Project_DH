namespace WinFormsApp2
{
    partial class FormTKS
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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(FormTKS));
            ThongkeTKS = new Button();
            dgvTKS = new DataGridView();
            label1 = new Label();
            label2 = new Label();
            cboMaloaiTKS = new ComboBox();
            label3 = new Label();
            txtTenLoaiTKS = new TextBox();
            ((System.ComponentModel.ISupportInitialize)dgvTKS).BeginInit();
            SuspendLayout();
            // 
            // ThongkeTKS
            // 
            ThongkeTKS.BackColor = Color.FromArgb(0, 192, 192);
            ThongkeTKS.Location = new Point(560, 255);
            ThongkeTKS.Margin = new Padding(6, 7, 6, 7);
            ThongkeTKS.Name = "ThongkeTKS";
            ThongkeTKS.Size = new Size(162, 53);
            ThongkeTKS.TabIndex = 17;
            ThongkeTKS.Text = "Thống kê";
            ThongkeTKS.UseVisualStyleBackColor = false;
            ThongkeTKS.Click += ThongkeTKS_Click;
            // 
            // dgvTKS
            // 
            dgvTKS.AutoSizeColumnsMode = DataGridViewAutoSizeColumnsMode.Fill;
            dgvTKS.BackgroundColor = Color.FromArgb(0, 192, 192);
            dgvTKS.ColumnHeadersHeightSizeMode = DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            dgvTKS.GridColor = Color.FromArgb(0, 192, 192);
            dgvTKS.Location = new Point(65, 322);
            dgvTKS.Margin = new Padding(6, 7, 6, 7);
            dgvTKS.Name = "dgvTKS";
            dgvTKS.RowHeadersWidth = 62;
            dgvTKS.Size = new Size(1181, 346);
            dgvTKS.TabIndex = 15;
            // 
            // label1
            // 
            label1.BackColor = Color.OldLace;
            label1.BorderStyle = BorderStyle.FixedSingle;
            label1.Dock = DockStyle.Top;
            label1.Font = new Font("Segoe UI", 16F, FontStyle.Bold, GraphicsUnit.Point, 0);
            label1.ForeColor = SystemColors.Highlight;
            label1.Location = new Point(0, 0);
            label1.Margin = new Padding(6, 0, 6, 0);
            label1.Name = "label1";
            label1.Size = new Size(1356, 62);
            label1.TabIndex = 13;
            label1.Text = "THỐNG KÊ SÁCH";
            label1.TextAlign = ContentAlignment.MiddleCenter;
            // 
            // label2
            // 
            label2.AutoSize = true;
            label2.Location = new Point(354, 100);
            label2.Name = "label2";
            label2.Size = new Size(100, 30);
            label2.TabIndex = 18;
            label2.Text = "Mã Loại:";
            // 
            // cboMaloaiTKS
            // 
            cboMaloaiTKS.FormattingEnabled = true;
            cboMaloaiTKS.Location = new Point(504, 97);
            cboMaloaiTKS.Name = "cboMaloaiTKS";
            cboMaloaiTKS.Size = new Size(256, 38);
            cboMaloaiTKS.TabIndex = 19;
            cboMaloaiTKS.SelectedValueChanged += cboMaloaiTKS_SelectedValueChanged;
            // 
            // label3
            // 
            label3.AutoSize = true;
            label3.Location = new Point(354, 172);
            label3.Name = "label3";
            label3.Size = new Size(103, 30);
            label3.TabIndex = 20;
            label3.Text = "Tên Loại:";
            // 
            // txtTenLoaiTKS
            // 
            txtTenLoaiTKS.Location = new Point(504, 169);
            txtTenLoaiTKS.Name = "txtTenLoaiTKS";
            txtTenLoaiTKS.Size = new Size(256, 37);
            txtTenLoaiTKS.TabIndex = 21;
            txtTenLoaiTKS.TextChanged += txtTenLoaiTKS_TextChanged;
            txtTenLoaiTKS.Leave += txtTenLoaiTKS_Leave;
            // 
            // FormTKS
            // 
            AutoScaleDimensions = new SizeF(13F, 30F);
            AutoScaleMode = AutoScaleMode.Font;
            BackColor = Color.OldLace;
            BackgroundImage = (Image)resources.GetObject("$this.BackgroundImage");
            ClientSize = new Size(1356, 589);
            Controls.Add(txtTenLoaiTKS);
            Controls.Add(label3);
            Controls.Add(cboMaloaiTKS);
            Controls.Add(label2);
            Controls.Add(ThongkeTKS);
            Controls.Add(dgvTKS);
            Controls.Add(label1);
            Font = new Font("Segoe UI", 11F, FontStyle.Bold, GraphicsUnit.Point, 0);
            Margin = new Padding(4);
            Name = "FormTKS";
            Text = "FormTKS";
            ((System.ComponentModel.ISupportInitialize)dgvTKS).EndInit();
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private Button ThongkeTKS;
        private DataGridView dgvTKS;
        private Label label1;
        private Label label2;
        private ComboBox cboMaloaiTKS;
        private Label label3;
        private TextBox txtTenLoaiTKS;
    }
}