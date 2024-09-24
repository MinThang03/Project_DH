namespace WinFormsApp2
{
    partial class FormTKDT
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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(FormTKDT));
            label2 = new Label();
            label1 = new Label();
            cboSoHDDT = new ComboBox();
            buttonThongKeTKDT = new Button();
            dgvTKDT = new DataGridView();
            ((System.ComponentModel.ISupportInitialize)dgvTKDT).BeginInit();
            SuspendLayout();
            // 
            // label2
            // 
            label2.AutoSize = true;
            label2.Location = new Point(223, 97);
            label2.Name = "label2";
            label2.Size = new Size(141, 30);
            label2.TabIndex = 25;
            label2.Text = "Số Hóa Đơn:";
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
            label1.Size = new Size(1064, 62);
            label1.TabIndex = 22;
            label1.Text = "THỐNG KÊ DOANH THU";
            label1.TextAlign = ContentAlignment.MiddleCenter;
            // 
            // cboSoHDDT
            // 
            cboSoHDDT.FormattingEnabled = true;
            cboSoHDDT.Location = new Point(399, 94);
            cboSoHDDT.Name = "cboSoHDDT";
            cboSoHDDT.Size = new Size(275, 38);
            cboSoHDDT.TabIndex = 26;
            cboSoHDDT.SelectedValueChanged += cboSoHDDT_SelectedValueChanged;
            // 
            // buttonThongKeTKDT
            // 
            buttonThongKeTKDT.BackColor = Color.Turquoise;
            buttonThongKeTKDT.ForeColor = SystemColors.ActiveCaptionText;
            buttonThongKeTKDT.Location = new Point(461, 163);
            buttonThongKeTKDT.Name = "buttonThongKeTKDT";
            buttonThongKeTKDT.Size = new Size(145, 41);
            buttonThongKeTKDT.TabIndex = 27;
            buttonThongKeTKDT.Text = "Thống Kê";
            buttonThongKeTKDT.UseVisualStyleBackColor = false;
            buttonThongKeTKDT.Click += buttonThongKeTKDT_Click;
            // 
            // dgvTKDT
            // 
            dgvTKDT.BackgroundColor = Color.FromArgb(0, 192, 192);
            dgvTKDT.ColumnHeadersHeightSizeMode = DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            dgvTKDT.Location = new Point(41, 237);
            dgvTKDT.Name = "dgvTKDT";
            dgvTKDT.RowHeadersWidth = 62;
            dgvTKDT.Size = new Size(1093, 325);
            dgvTKDT.TabIndex = 28;
            // 
            // FormTKDT
            // 
            AutoScaleDimensions = new SizeF(13F, 30F);
            AutoScaleMode = AutoScaleMode.Font;
            BackColor = Color.OldLace;
            BackgroundImage = (Image)resources.GetObject("$this.BackgroundImage");
            ClientSize = new Size(1064, 540);
            Controls.Add(dgvTKDT);
            Controls.Add(buttonThongKeTKDT);
            Controls.Add(cboSoHDDT);
            Controls.Add(label2);
            Controls.Add(label1);
            Font = new Font("Segoe UI", 11F, FontStyle.Bold, GraphicsUnit.Point, 0);
            Margin = new Padding(4);
            Name = "FormTKDT";
            Text = "FormTKDT";
            ((System.ComponentModel.ISupportInitialize)dgvTKDT).EndInit();
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private Label label2;
        private Button ThongkeTKS;
        private DataGridView dgvTKS;
        private Label label1;
        private ComboBox cboSoHDDT;
        private Button buttonThongKeTKDT;
        private DataGridView dgvTKDT;
    }
}