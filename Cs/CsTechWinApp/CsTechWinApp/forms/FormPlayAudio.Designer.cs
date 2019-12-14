namespace CsTechWinApp.forms
{
    partial class FormPlayAudio
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
            this.btnPlayWav = new System.Windows.Forms.Button();
            this.btnPlayMp3 = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // btnPlayWav
            // 
            this.btnPlayWav.Location = new System.Drawing.Point(23, 13);
            this.btnPlayWav.Name = "btnPlayWav";
            this.btnPlayWav.Size = new System.Drawing.Size(94, 23);
            this.btnPlayWav.TabIndex = 0;
            this.btnPlayWav.Text = "播放wav文件";
            this.btnPlayWav.UseVisualStyleBackColor = true;
            this.btnPlayWav.Click += new System.EventHandler(this.btnPlayWav_Click);
            // 
            // btnPlayMp3
            // 
            this.btnPlayMp3.Location = new System.Drawing.Point(23, 43);
            this.btnPlayMp3.Name = "btnPlayMp3";
            this.btnPlayMp3.Size = new System.Drawing.Size(94, 23);
            this.btnPlayMp3.TabIndex = 1;
            this.btnPlayMp3.Text = "播放mp3";
            this.btnPlayMp3.UseVisualStyleBackColor = true;
            this.btnPlayMp3.Click += new System.EventHandler(this.btnPlayMp3_Click);
            // 
            // FormPlayAudio
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(519, 283);
            this.Controls.Add(this.btnPlayMp3);
            this.Controls.Add(this.btnPlayWav);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedSingle;
            this.MaximizeBox = false;
            this.MinimizeBox = false;
            this.Name = "FormPlayAudio";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "播放音频";
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.Button btnPlayWav;
        private System.Windows.Forms.Button btnPlayMp3;
    }
}