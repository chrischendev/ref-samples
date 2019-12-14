namespace CsTechWinApp.forms
{
    partial class FormWebsocket
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
            this.btnConnect = new System.Windows.Forms.Button();
            this.tbChatCentent = new System.Windows.Forms.TextBox();
            this.btnSend = new System.Windows.Forms.Button();
            this.tbWsUrl = new System.Windows.Forms.TextBox();
            this.tbChatDetails = new System.Windows.Forms.TextBox();
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.tbUsername = new System.Windows.Forms.TextBox();
            this.SuspendLayout();
            // 
            // btnConnect
            // 
            this.btnConnect.Location = new System.Drawing.Point(614, 12);
            this.btnConnect.Name = "btnConnect";
            this.btnConnect.Size = new System.Drawing.Size(75, 23);
            this.btnConnect.TabIndex = 0;
            this.btnConnect.Text = "连接";
            this.btnConnect.UseVisualStyleBackColor = true;
            this.btnConnect.Click += new System.EventHandler(this.btnConnect_Click);
            // 
            // tbChatCentent
            // 
            this.tbChatCentent.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.tbChatCentent.Location = new System.Drawing.Point(12, 395);
            this.tbChatCentent.Multiline = true;
            this.tbChatCentent.Name = "tbChatCentent";
            this.tbChatCentent.Size = new System.Drawing.Size(596, 76);
            this.tbChatCentent.TabIndex = 1;
            // 
            // btnSend
            // 
            this.btnSend.Location = new System.Drawing.Point(614, 395);
            this.btnSend.Name = "btnSend";
            this.btnSend.Size = new System.Drawing.Size(75, 76);
            this.btnSend.TabIndex = 3;
            this.btnSend.Text = "发送";
            this.btnSend.UseVisualStyleBackColor = true;
            this.btnSend.Click += new System.EventHandler(this.btnSend_Click);
            // 
            // tbWsUrl
            // 
            this.tbWsUrl.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.tbWsUrl.Location = new System.Drawing.Point(132, 13);
            this.tbWsUrl.Name = "tbWsUrl";
            this.tbWsUrl.Size = new System.Drawing.Size(320, 21);
            this.tbWsUrl.TabIndex = 4;
            // 
            // tbChatDetails
            // 
            this.tbChatDetails.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.tbChatDetails.Location = new System.Drawing.Point(13, 41);
            this.tbChatDetails.Multiline = true;
            this.tbChatDetails.Name = "tbChatDetails";
            this.tbChatDetails.ReadOnly = true;
            this.tbChatDetails.Size = new System.Drawing.Size(676, 348);
            this.tbChatDetails.TabIndex = 5;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(13, 17);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(113, 12);
            this.label1.TabIndex = 6;
            this.label1.Text = "WebSocket服务地址:";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(459, 17);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(41, 12);
            this.label2.TabIndex = 7;
            this.label2.Text = "用户名";
            // 
            // tbUsername
            // 
            this.tbUsername.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.tbUsername.Location = new System.Drawing.Point(507, 13);
            this.tbUsername.Name = "tbUsername";
            this.tbUsername.Size = new System.Drawing.Size(100, 21);
            this.tbUsername.TabIndex = 8;
            // 
            // FormWebsocket
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(701, 483);
            this.Controls.Add(this.tbUsername);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.tbChatDetails);
            this.Controls.Add(this.tbWsUrl);
            this.Controls.Add(this.btnSend);
            this.Controls.Add(this.tbChatCentent);
            this.Controls.Add(this.btnConnect);
            this.Name = "FormWebsocket";
            this.Text = "聊天";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Button btnConnect;
        private System.Windows.Forms.TextBox tbChatCentent;
        private System.Windows.Forms.Button btnSend;
        private System.Windows.Forms.TextBox tbWsUrl;
        private System.Windows.Forms.TextBox tbChatDetails;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.TextBox tbUsername;
    }
}