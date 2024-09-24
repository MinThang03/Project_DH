namespace WinFormsApp2
{
    partial class FormDangNhap
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
            label1 = new Label();
            label2 = new Label();
            label3 = new Label();
            txtTenDN = new TextBox();
            txtMK = new TextBox();
            buttonThoat = new Button();
            buttonDN = new Button();
            SuspendLayout();
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.Location = new Point(262, 127);
            label1.Margin = new Padding(4, 0, 4, 0);
            label1.Name = "label1";
            label1.Size = new Size(0, 32);
            label1.TabIndex = 0;
            // 
            // label2
            // 
            label2.AutoSize = true;
            label2.Location = new Point(112, 59);
            label2.Name = "label2";
            label2.Size = new Size(190, 32);
            label2.TabIndex = 1;
            label2.Text = "Tên đăng nhập:";
            // 
            // label3
            // 
            label3.AutoSize = true;
            label3.Location = new Point(174, 116);
            label3.Name = "label3";
            label3.Size = new Size(128, 32);
            label3.TabIndex = 2;
            label3.Text = "Mật khẩu:";
            // 
            // txtTenDN
            // 
            txtTenDN.Location = new Point(331, 56);
            txtTenDN.Name = "txtTenDN";
            txtTenDN.Size = new Size(315, 39);
            txtTenDN.TabIndex = 3;
            // 
            // txtMK
            // 
            txtMK.Location = new Point(331, 113);
            txtMK.Name = "txtMK";
            txtMK.PasswordChar = '*';
            txtMK.Size = new Size(315, 39);
            txtMK.TabIndex = 4;
            // 
            // buttonThoat
            // 
            buttonThoat.BackColor = Color.FromArgb(0, 192, 192);
            buttonThoat.Location = new Point(471, 184);
            buttonThoat.Name = "buttonThoat";
            buttonThoat.Size = new Size(153, 42);
            buttonThoat.TabIndex = 6;
            buttonThoat.Text = "Thoát";
            buttonThoat.UseVisualStyleBackColor = false;
            buttonThoat.Click += buttonThoat_Click;
            // 
            // buttonDN
            // 
            buttonDN.BackColor = Color.FromArgb(0, 192, 192);
            buttonDN.Location = new Point(208, 184);
            buttonDN.Name = "buttonDN";
            buttonDN.Size = new Size(168, 42);
            buttonDN.TabIndex = 7;
            buttonDN.Text = "Đăng nhập";
            buttonDN.UseVisualStyleBackColor = false;
            buttonDN.Click += buttonDN_Click;
            // 
            // FormDangNhap
            // 
            AutoScaleDimensions = new SizeF(14F, 32F);
            AutoScaleMode = AutoScaleMode.Font;
            BackColor = Color.Khaki;
            ClientSize = new Size(842, 287);
            Controls.Add(buttonDN);
            Controls.Add(buttonThoat);
            Controls.Add(txtMK);
            Controls.Add(txtTenDN);
            Controls.Add(label3);
            Controls.Add(label2);
            Controls.Add(label1);
            Font = new Font("Segoe UI", 12F, FontStyle.Bold, GraphicsUnit.Point, 0);
            Margin = new Padding(4);
            Name = "FormDangNhap";
            Text = "Đăng nhập hệ thống";
            Load += FormDangNhap_Load;
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private Label label1;
        private Label label2;
        private Label label3;
        private TextBox txtTenDN;
        private TextBox txtMK;
        private Button buttonThoat;
        private Button buttonDN;
    }
}