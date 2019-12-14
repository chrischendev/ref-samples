namespace CsTechWinApp.forms
{
    partial class FormLocalDB
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
            this.btnConnectDB = new System.Windows.Forms.Button();
            this.btnQuery = new System.Windows.Forms.Button();
            this.btnAddData = new System.Windows.Forms.Button();
            this.textBox1 = new System.Windows.Forms.TextBox();
            this.groupBox1 = new System.Windows.Forms.GroupBox();
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.label4 = new System.Windows.Forms.Label();
            this.tbName = new System.Windows.Forms.TextBox();
            this.tbAge = new System.Windows.Forms.TextBox();
            this.tbAddress = new System.Windows.Forms.TextBox();
            this.tbInfo = new System.Windows.Forms.TextBox();
            this.btnCloseConnection = new System.Windows.Forms.Button();
            this.groupBox1.SuspendLayout();
            this.SuspendLayout();
            // 
            // btnConnectDB
            // 
            this.btnConnectDB.Location = new System.Drawing.Point(670, 167);
            this.btnConnectDB.Name = "btnConnectDB";
            this.btnConnectDB.Size = new System.Drawing.Size(118, 23);
            this.btnConnectDB.TabIndex = 0;
            this.btnConnectDB.Text = "连接Access数据库";
            this.btnConnectDB.UseVisualStyleBackColor = true;
            this.btnConnectDB.Click += new System.EventHandler(this.btnConnectDB_Click);
            // 
            // btnQuery
            // 
            this.btnQuery.Location = new System.Drawing.Point(670, 235);
            this.btnQuery.Name = "btnQuery";
            this.btnQuery.Size = new System.Drawing.Size(118, 23);
            this.btnQuery.TabIndex = 1;
            this.btnQuery.Text = "查询";
            this.btnQuery.UseVisualStyleBackColor = true;
            this.btnQuery.Click += new System.EventHandler(this.btnQuery_Click);
            // 
            // btnAddData
            // 
            this.btnAddData.Location = new System.Drawing.Point(670, 415);
            this.btnAddData.Name = "btnAddData";
            this.btnAddData.Size = new System.Drawing.Size(118, 23);
            this.btnAddData.TabIndex = 2;
            this.btnAddData.Text = "添加数据";
            this.btnAddData.UseVisualStyleBackColor = true;
            this.btnAddData.Click += new System.EventHandler(this.btnAddData_Click);
            // 
            // textBox1
            // 
            this.textBox1.Location = new System.Drawing.Point(12, 12);
            this.textBox1.Multiline = true;
            this.textBox1.Name = "textBox1";
            this.textBox1.Size = new System.Drawing.Size(327, 247);
            this.textBox1.TabIndex = 3;
            // 
            // groupBox1
            // 
            this.groupBox1.Controls.Add(this.tbInfo);
            this.groupBox1.Controls.Add(this.tbAddress);
            this.groupBox1.Controls.Add(this.tbAge);
            this.groupBox1.Controls.Add(this.tbName);
            this.groupBox1.Controls.Add(this.label4);
            this.groupBox1.Controls.Add(this.label3);
            this.groupBox1.Controls.Add(this.label2);
            this.groupBox1.Controls.Add(this.label1);
            this.groupBox1.Location = new System.Drawing.Point(12, 265);
            this.groupBox1.Name = "groupBox1";
            this.groupBox1.Size = new System.Drawing.Size(327, 173);
            this.groupBox1.TabIndex = 4;
            this.groupBox1.TabStop = false;
            this.groupBox1.Text = "添加数据";
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(7, 25);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(29, 12);
            this.label1.TabIndex = 0;
            this.label1.Text = "姓名";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(7, 66);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(29, 12);
            this.label2.TabIndex = 1;
            this.label2.Text = "年龄";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(7, 107);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(29, 12);
            this.label3.TabIndex = 2;
            this.label3.Text = "地址";
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(7, 148);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(29, 12);
            this.label4.TabIndex = 3;
            this.label4.Text = "信息";
            // 
            // tbName
            // 
            this.tbName.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.tbName.Location = new System.Drawing.Point(57, 21);
            this.tbName.Name = "tbName";
            this.tbName.Size = new System.Drawing.Size(248, 21);
            this.tbName.TabIndex = 4;
            // 
            // tbAge
            // 
            this.tbAge.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.tbAge.Location = new System.Drawing.Point(57, 62);
            this.tbAge.Name = "tbAge";
            this.tbAge.Size = new System.Drawing.Size(100, 21);
            this.tbAge.TabIndex = 5;
            // 
            // tbAddress
            // 
            this.tbAddress.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.tbAddress.Location = new System.Drawing.Point(57, 103);
            this.tbAddress.Name = "tbAddress";
            this.tbAddress.Size = new System.Drawing.Size(248, 21);
            this.tbAddress.TabIndex = 6;
            // 
            // tbInfo
            // 
            this.tbInfo.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.tbInfo.Location = new System.Drawing.Point(57, 144);
            this.tbInfo.Name = "tbInfo";
            this.tbInfo.Size = new System.Drawing.Size(248, 21);
            this.tbInfo.TabIndex = 7;
            // 
            // btnCloseConnection
            // 
            this.btnCloseConnection.Location = new System.Drawing.Point(670, 201);
            this.btnCloseConnection.Name = "btnCloseConnection";
            this.btnCloseConnection.Size = new System.Drawing.Size(118, 23);
            this.btnCloseConnection.TabIndex = 5;
            this.btnCloseConnection.Text = "断开数据库连接";
            this.btnCloseConnection.UseVisualStyleBackColor = true;
            this.btnCloseConnection.Click += new System.EventHandler(this.btnCloseConnection_Click);
            // 
            // FormLocalDB
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(this.btnCloseConnection);
            this.Controls.Add(this.groupBox1);
            this.Controls.Add(this.textBox1);
            this.Controls.Add(this.btnAddData);
            this.Controls.Add(this.btnQuery);
            this.Controls.Add(this.btnConnectDB);
            this.Name = "FormLocalDB";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "本地数据库";
            this.groupBox1.ResumeLayout(false);
            this.groupBox1.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Button btnConnectDB;
        private System.Windows.Forms.Button btnQuery;
        private System.Windows.Forms.Button btnAddData;
        private System.Windows.Forms.TextBox textBox1;
        private System.Windows.Forms.GroupBox groupBox1;
        private System.Windows.Forms.TextBox tbInfo;
        private System.Windows.Forms.TextBox tbAddress;
        private System.Windows.Forms.TextBox tbAge;
        private System.Windows.Forms.TextBox tbName;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Button btnCloseConnection;
    }
}