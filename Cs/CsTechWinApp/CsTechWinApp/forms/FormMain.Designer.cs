namespace CsTechWinApp
{
    partial class FormMain
    {
        /// <summary>
        /// 必需的设计器变量。
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// 清理所有正在使用的资源。
        /// </summary>
        /// <param name="disposing">如果应释放托管资源，为 true；否则为 false。</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows 窗体设计器生成的代码

        /// <summary>
        /// 设计器支持所需的方法 - 不要修改
        /// 使用代码编辑器修改此方法的内容。
        /// </summary>
        private void InitializeComponent()
        {
            this.btnImageListView = new System.Windows.Forms.Button();
            this.btnQuit = new System.Windows.Forms.Button();
            this.btnCheckBox = new System.Windows.Forms.Button();
            this.btnHttpRequest = new System.Windows.Forms.Button();
            this.btnPlayAudio = new System.Windows.Forms.Button();
            this.btnPlayVideo = new System.Windows.Forms.Button();
            this.btnChat = new System.Windows.Forms.Button();
            this.btnDraw = new System.Windows.Forms.Button();
            this.btnLocalDB = new System.Windows.Forms.Button();
            this.btnMySql = new System.Windows.Forms.Button();
            this.btnExcel = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // btnImageListView
            // 
            this.btnImageListView.Location = new System.Drawing.Point(13, 13);
            this.btnImageListView.Name = "btnImageListView";
            this.btnImageListView.Size = new System.Drawing.Size(88, 23);
            this.btnImageListView.TabIndex = 0;
            this.btnImageListView.Text = "图片列表视图";
            this.btnImageListView.UseVisualStyleBackColor = true;
            this.btnImageListView.Click += new System.EventHandler(this.btnImageListView_Click);
            // 
            // btnQuit
            // 
            this.btnQuit.Location = new System.Drawing.Point(297, 227);
            this.btnQuit.Name = "btnQuit";
            this.btnQuit.Size = new System.Drawing.Size(75, 23);
            this.btnQuit.TabIndex = 1;
            this.btnQuit.Text = "退出";
            this.btnQuit.UseVisualStyleBackColor = true;
            this.btnQuit.Click += new System.EventHandler(this.btnQuit_Click);
            // 
            // btnCheckBox
            // 
            this.btnCheckBox.Location = new System.Drawing.Point(12, 42);
            this.btnCheckBox.Name = "btnCheckBox";
            this.btnCheckBox.Size = new System.Drawing.Size(88, 23);
            this.btnCheckBox.TabIndex = 2;
            this.btnCheckBox.Text = "常用小控件";
            this.btnCheckBox.UseVisualStyleBackColor = true;
            this.btnCheckBox.Click += new System.EventHandler(this.btnCheckBox_Click);
            // 
            // btnHttpRequest
            // 
            this.btnHttpRequest.Location = new System.Drawing.Point(13, 72);
            this.btnHttpRequest.Name = "btnHttpRequest";
            this.btnHttpRequest.Size = new System.Drawing.Size(87, 23);
            this.btnHttpRequest.TabIndex = 3;
            this.btnHttpRequest.Text = "HTTP请求";
            this.btnHttpRequest.UseVisualStyleBackColor = true;
            this.btnHttpRequest.Click += new System.EventHandler(this.btnHttpRequest_Click);
            // 
            // btnPlayAudio
            // 
            this.btnPlayAudio.Location = new System.Drawing.Point(13, 102);
            this.btnPlayAudio.Name = "btnPlayAudio";
            this.btnPlayAudio.Size = new System.Drawing.Size(87, 23);
            this.btnPlayAudio.TabIndex = 4;
            this.btnPlayAudio.Text = "播放音频";
            this.btnPlayAudio.UseVisualStyleBackColor = true;
            this.btnPlayAudio.Click += new System.EventHandler(this.btnPlayAudio_Click);
            // 
            // btnPlayVideo
            // 
            this.btnPlayVideo.Location = new System.Drawing.Point(13, 132);
            this.btnPlayVideo.Name = "btnPlayVideo";
            this.btnPlayVideo.Size = new System.Drawing.Size(87, 23);
            this.btnPlayVideo.TabIndex = 5;
            this.btnPlayVideo.Text = "播放视频";
            this.btnPlayVideo.UseVisualStyleBackColor = true;
            this.btnPlayVideo.Click += new System.EventHandler(this.btnPlayVideo_Click);
            // 
            // btnChat
            // 
            this.btnChat.Location = new System.Drawing.Point(13, 162);
            this.btnChat.Name = "btnChat";
            this.btnChat.Size = new System.Drawing.Size(87, 23);
            this.btnChat.TabIndex = 6;
            this.btnChat.Text = "Webcosket";
            this.btnChat.UseVisualStyleBackColor = true;
            this.btnChat.Click += new System.EventHandler(this.btnChat_Click);
            // 
            // btnDraw
            // 
            this.btnDraw.Location = new System.Drawing.Point(13, 192);
            this.btnDraw.Name = "btnDraw";
            this.btnDraw.Size = new System.Drawing.Size(87, 23);
            this.btnDraw.TabIndex = 7;
            this.btnDraw.Text = "画图";
            this.btnDraw.UseVisualStyleBackColor = true;
            this.btnDraw.Click += new System.EventHandler(this.btnDraw_Click);
            // 
            // btnLocalDB
            // 
            this.btnLocalDB.Location = new System.Drawing.Point(148, 13);
            this.btnLocalDB.Name = "btnLocalDB";
            this.btnLocalDB.Size = new System.Drawing.Size(87, 23);
            this.btnLocalDB.TabIndex = 8;
            this.btnLocalDB.Text = "本地数据库";
            this.btnLocalDB.UseVisualStyleBackColor = true;
            this.btnLocalDB.Click += new System.EventHandler(this.btnLocalDB_Click);
            // 
            // btnMySql
            // 
            this.btnMySql.Location = new System.Drawing.Point(148, 42);
            this.btnMySql.Name = "btnMySql";
            this.btnMySql.Size = new System.Drawing.Size(87, 23);
            this.btnMySql.TabIndex = 9;
            this.btnMySql.Text = "MySql数据库";
            this.btnMySql.UseVisualStyleBackColor = true;
            this.btnMySql.Click += new System.EventHandler(this.btnMySql_Click);
            // 
            // btnExcel
            // 
            this.btnExcel.Location = new System.Drawing.Point(148, 72);
            this.btnExcel.Name = "btnExcel";
            this.btnExcel.Size = new System.Drawing.Size(87, 23);
            this.btnExcel.TabIndex = 10;
            this.btnExcel.Text = "Excel表格";
            this.btnExcel.UseVisualStyleBackColor = true;
            this.btnExcel.Click += new System.EventHandler(this.btnExcel_Click);
            // 
            // FormMain
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(384, 262);
            this.Controls.Add(this.btnExcel);
            this.Controls.Add(this.btnMySql);
            this.Controls.Add(this.btnLocalDB);
            this.Controls.Add(this.btnDraw);
            this.Controls.Add(this.btnChat);
            this.Controls.Add(this.btnPlayVideo);
            this.Controls.Add(this.btnPlayAudio);
            this.Controls.Add(this.btnHttpRequest);
            this.Controls.Add(this.btnCheckBox);
            this.Controls.Add(this.btnQuit);
            this.Controls.Add(this.btnImageListView);
            this.Name = "FormMain";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "C#技术学习集锦";
            this.Load += new System.EventHandler(this.FormMain_Load);
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.Button btnImageListView;
        private System.Windows.Forms.Button btnQuit;
        private System.Windows.Forms.Button btnCheckBox;
        private System.Windows.Forms.Button btnHttpRequest;
        private System.Windows.Forms.Button btnPlayAudio;
        private System.Windows.Forms.Button btnPlayVideo;
        private System.Windows.Forms.Button btnChat;
        private System.Windows.Forms.Button btnDraw;
        private System.Windows.Forms.Button btnLocalDB;
        private System.Windows.Forms.Button btnMySql;
        private System.Windows.Forms.Button btnExcel;
    }
}

