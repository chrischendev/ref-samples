namespace CsTechWinApp.forms
{
    partial class FormHttp
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
            this.listViewNews = new System.Windows.Forms.ListView();
            this.SuspendLayout();
            // 
            // listViewNews
            // 
            this.listViewNews.FullRowSelect = true;
            this.listViewNews.Location = new System.Drawing.Point(13, 13);
            this.listViewNews.Name = "listViewNews";
            this.listViewNews.Size = new System.Drawing.Size(775, 425);
            this.listViewNews.TabIndex = 0;
            this.listViewNews.UseCompatibleStateImageBehavior = false;
            // 
            // FormHttp
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(this.listViewNews);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedSingle;
            this.Name = "FormHttp";
            this.Text = "Http接口调用";
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.ListView listViewNews;
    }
}