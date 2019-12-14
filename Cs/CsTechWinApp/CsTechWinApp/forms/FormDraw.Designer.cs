namespace CsTechWinApp.forms
{
    partial class FormDraw
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
            this.menuStripDraw = new System.Windows.Forms.MenuStrip();
            this.文件ToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.新建ToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.打开ToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.toolStripMenuItem1 = new System.Windows.Forms.ToolStripSeparator();
            this.保存ToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.另存为ToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.toolStripMenuItem2 = new System.Windows.Forms.ToolStripSeparator();
            this.mnuDrawQuit = new System.Windows.Forms.ToolStripMenuItem();
            this.编辑ToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.撤销ToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.重做ToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.剪切ToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.复制ToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.toolStripMenuItem3 = new System.Windows.Forms.ToolStripSeparator();
            this.粘贴ToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.视图ToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.首选项ToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.帮助ToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.关于ToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.pictureBoxCanvas = new System.Windows.Forms.PictureBox();
            this.画图ToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.画点ToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.画直线ToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.mnuDrawRect = new System.Windows.Forms.ToolStripMenuItem();
            this.mnuDrawEllipse = new System.Windows.Forms.ToolStripMenuItem();
            this.画椭圆ToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.画图片ToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.toolStripMenuItem4 = new System.Windows.Forms.ToolStripSeparator();
            this.手画ToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.menuStripDraw.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBoxCanvas)).BeginInit();
            this.SuspendLayout();
            // 
            // menuStripDraw
            // 
            this.menuStripDraw.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.文件ToolStripMenuItem,
            this.编辑ToolStripMenuItem,
            this.画图ToolStripMenuItem,
            this.视图ToolStripMenuItem,
            this.帮助ToolStripMenuItem});
            this.menuStripDraw.Location = new System.Drawing.Point(0, 0);
            this.menuStripDraw.Name = "menuStripDraw";
            this.menuStripDraw.Size = new System.Drawing.Size(800, 25);
            this.menuStripDraw.TabIndex = 0;
            this.menuStripDraw.Text = "画图菜单";
            // 
            // 文件ToolStripMenuItem
            // 
            this.文件ToolStripMenuItem.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.新建ToolStripMenuItem,
            this.打开ToolStripMenuItem,
            this.toolStripMenuItem1,
            this.保存ToolStripMenuItem,
            this.另存为ToolStripMenuItem,
            this.toolStripMenuItem2,
            this.mnuDrawQuit});
            this.文件ToolStripMenuItem.Name = "文件ToolStripMenuItem";
            this.文件ToolStripMenuItem.Size = new System.Drawing.Size(44, 21);
            this.文件ToolStripMenuItem.Text = "文件";
            // 
            // 新建ToolStripMenuItem
            // 
            this.新建ToolStripMenuItem.Name = "新建ToolStripMenuItem";
            this.新建ToolStripMenuItem.Size = new System.Drawing.Size(180, 22);
            this.新建ToolStripMenuItem.Text = "新建";
            // 
            // 打开ToolStripMenuItem
            // 
            this.打开ToolStripMenuItem.Name = "打开ToolStripMenuItem";
            this.打开ToolStripMenuItem.Size = new System.Drawing.Size(180, 22);
            this.打开ToolStripMenuItem.Text = "打开";
            // 
            // toolStripMenuItem1
            // 
            this.toolStripMenuItem1.Name = "toolStripMenuItem1";
            this.toolStripMenuItem1.Size = new System.Drawing.Size(177, 6);
            // 
            // 保存ToolStripMenuItem
            // 
            this.保存ToolStripMenuItem.Name = "保存ToolStripMenuItem";
            this.保存ToolStripMenuItem.Size = new System.Drawing.Size(180, 22);
            this.保存ToolStripMenuItem.Text = "保存";
            // 
            // 另存为ToolStripMenuItem
            // 
            this.另存为ToolStripMenuItem.Name = "另存为ToolStripMenuItem";
            this.另存为ToolStripMenuItem.Size = new System.Drawing.Size(180, 22);
            this.另存为ToolStripMenuItem.Text = "另存为";
            // 
            // toolStripMenuItem2
            // 
            this.toolStripMenuItem2.Name = "toolStripMenuItem2";
            this.toolStripMenuItem2.Size = new System.Drawing.Size(177, 6);
            // 
            // mnuDrawQuit
            // 
            this.mnuDrawQuit.Name = "mnuDrawQuit";
            this.mnuDrawQuit.Size = new System.Drawing.Size(180, 22);
            this.mnuDrawQuit.Text = "退出";
            this.mnuDrawQuit.Click += new System.EventHandler(this.mnuDrawQuit_Click);
            // 
            // 编辑ToolStripMenuItem
            // 
            this.编辑ToolStripMenuItem.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.撤销ToolStripMenuItem,
            this.重做ToolStripMenuItem,
            this.toolStripMenuItem3,
            this.剪切ToolStripMenuItem,
            this.复制ToolStripMenuItem,
            this.粘贴ToolStripMenuItem});
            this.编辑ToolStripMenuItem.Name = "编辑ToolStripMenuItem";
            this.编辑ToolStripMenuItem.Size = new System.Drawing.Size(44, 21);
            this.编辑ToolStripMenuItem.Text = "编辑";
            // 
            // 撤销ToolStripMenuItem
            // 
            this.撤销ToolStripMenuItem.Name = "撤销ToolStripMenuItem";
            this.撤销ToolStripMenuItem.Size = new System.Drawing.Size(180, 22);
            this.撤销ToolStripMenuItem.Text = "撤销";
            // 
            // 重做ToolStripMenuItem
            // 
            this.重做ToolStripMenuItem.Name = "重做ToolStripMenuItem";
            this.重做ToolStripMenuItem.Size = new System.Drawing.Size(180, 22);
            this.重做ToolStripMenuItem.Text = "重做";
            // 
            // 剪切ToolStripMenuItem
            // 
            this.剪切ToolStripMenuItem.Name = "剪切ToolStripMenuItem";
            this.剪切ToolStripMenuItem.Size = new System.Drawing.Size(180, 22);
            this.剪切ToolStripMenuItem.Text = "剪切";
            // 
            // 复制ToolStripMenuItem
            // 
            this.复制ToolStripMenuItem.Name = "复制ToolStripMenuItem";
            this.复制ToolStripMenuItem.Size = new System.Drawing.Size(180, 22);
            this.复制ToolStripMenuItem.Text = "复制";
            // 
            // toolStripMenuItem3
            // 
            this.toolStripMenuItem3.Name = "toolStripMenuItem3";
            this.toolStripMenuItem3.Size = new System.Drawing.Size(177, 6);
            // 
            // 粘贴ToolStripMenuItem
            // 
            this.粘贴ToolStripMenuItem.Name = "粘贴ToolStripMenuItem";
            this.粘贴ToolStripMenuItem.Size = new System.Drawing.Size(180, 22);
            this.粘贴ToolStripMenuItem.Text = "粘贴";
            // 
            // 视图ToolStripMenuItem
            // 
            this.视图ToolStripMenuItem.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.首选项ToolStripMenuItem});
            this.视图ToolStripMenuItem.Name = "视图ToolStripMenuItem";
            this.视图ToolStripMenuItem.Size = new System.Drawing.Size(44, 21);
            this.视图ToolStripMenuItem.Text = "查看";
            // 
            // 首选项ToolStripMenuItem
            // 
            this.首选项ToolStripMenuItem.Name = "首选项ToolStripMenuItem";
            this.首选项ToolStripMenuItem.Size = new System.Drawing.Size(180, 22);
            this.首选项ToolStripMenuItem.Text = "首选项";
            // 
            // 帮助ToolStripMenuItem
            // 
            this.帮助ToolStripMenuItem.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.关于ToolStripMenuItem});
            this.帮助ToolStripMenuItem.Name = "帮助ToolStripMenuItem";
            this.帮助ToolStripMenuItem.Size = new System.Drawing.Size(44, 21);
            this.帮助ToolStripMenuItem.Text = "帮助";
            // 
            // 关于ToolStripMenuItem
            // 
            this.关于ToolStripMenuItem.Name = "关于ToolStripMenuItem";
            this.关于ToolStripMenuItem.Size = new System.Drawing.Size(180, 22);
            this.关于ToolStripMenuItem.Text = "关于";
            // 
            // pictureBoxCanvas
            // 
            this.pictureBoxCanvas.Location = new System.Drawing.Point(0, 28);
            this.pictureBoxCanvas.Name = "pictureBoxCanvas";
            this.pictureBoxCanvas.Size = new System.Drawing.Size(800, 422);
            this.pictureBoxCanvas.TabIndex = 1;
            this.pictureBoxCanvas.TabStop = false;
            // 
            // 画图ToolStripMenuItem
            // 
            this.画图ToolStripMenuItem.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.画点ToolStripMenuItem,
            this.画直线ToolStripMenuItem,
            this.mnuDrawRect,
            this.mnuDrawEllipse,
            this.画椭圆ToolStripMenuItem,
            this.画图片ToolStripMenuItem,
            this.toolStripMenuItem4,
            this.手画ToolStripMenuItem});
            this.画图ToolStripMenuItem.Name = "画图ToolStripMenuItem";
            this.画图ToolStripMenuItem.Size = new System.Drawing.Size(44, 21);
            this.画图ToolStripMenuItem.Text = "画图";
            // 
            // 画点ToolStripMenuItem
            // 
            this.画点ToolStripMenuItem.Name = "画点ToolStripMenuItem";
            this.画点ToolStripMenuItem.Size = new System.Drawing.Size(180, 22);
            this.画点ToolStripMenuItem.Text = "画点";
            // 
            // 画直线ToolStripMenuItem
            // 
            this.画直线ToolStripMenuItem.Name = "画直线ToolStripMenuItem";
            this.画直线ToolStripMenuItem.Size = new System.Drawing.Size(180, 22);
            this.画直线ToolStripMenuItem.Text = "画直线";
            // 
            // mnuDrawRect
            // 
            this.mnuDrawRect.Name = "mnuDrawRect";
            this.mnuDrawRect.Size = new System.Drawing.Size(180, 22);
            this.mnuDrawRect.Text = "画矩形";
            this.mnuDrawRect.Click += new System.EventHandler(this.mnuDrawRect_Click);
            // 
            // mnuDrawEllipse
            // 
            this.mnuDrawEllipse.Name = "mnuDrawEllipse";
            this.mnuDrawEllipse.Size = new System.Drawing.Size(180, 22);
            this.mnuDrawEllipse.Text = "画圆";
            this.mnuDrawEllipse.Click += new System.EventHandler(this.mnuDrawEllipse_Click);
            // 
            // 画椭圆ToolStripMenuItem
            // 
            this.画椭圆ToolStripMenuItem.Name = "画椭圆ToolStripMenuItem";
            this.画椭圆ToolStripMenuItem.Size = new System.Drawing.Size(180, 22);
            this.画椭圆ToolStripMenuItem.Text = "画椭圆";
            // 
            // 画图片ToolStripMenuItem
            // 
            this.画图片ToolStripMenuItem.Name = "画图片ToolStripMenuItem";
            this.画图片ToolStripMenuItem.Size = new System.Drawing.Size(180, 22);
            this.画图片ToolStripMenuItem.Text = "画图片";
            // 
            // toolStripMenuItem4
            // 
            this.toolStripMenuItem4.Name = "toolStripMenuItem4";
            this.toolStripMenuItem4.Size = new System.Drawing.Size(177, 6);
            // 
            // 手画ToolStripMenuItem
            // 
            this.手画ToolStripMenuItem.Name = "手画ToolStripMenuItem";
            this.手画ToolStripMenuItem.Size = new System.Drawing.Size(180, 22);
            this.手画ToolStripMenuItem.Text = "手画";
            // 
            // FormDraw
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(this.pictureBoxCanvas);
            this.Controls.Add(this.menuStripDraw);
            this.MainMenuStrip = this.menuStripDraw;
            this.Name = "FormDraw";
            this.Text = "画图";
            this.menuStripDraw.ResumeLayout(false);
            this.menuStripDraw.PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBoxCanvas)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.MenuStrip menuStripDraw;
        private System.Windows.Forms.ToolStripMenuItem 文件ToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem 新建ToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem 打开ToolStripMenuItem;
        private System.Windows.Forms.ToolStripSeparator toolStripMenuItem1;
        private System.Windows.Forms.ToolStripMenuItem 保存ToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem 另存为ToolStripMenuItem;
        private System.Windows.Forms.ToolStripSeparator toolStripMenuItem2;
        private System.Windows.Forms.ToolStripMenuItem mnuDrawQuit;
        private System.Windows.Forms.ToolStripMenuItem 编辑ToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem 撤销ToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem 重做ToolStripMenuItem;
        private System.Windows.Forms.ToolStripSeparator toolStripMenuItem3;
        private System.Windows.Forms.ToolStripMenuItem 剪切ToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem 复制ToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem 粘贴ToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem 视图ToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem 首选项ToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem 帮助ToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem 关于ToolStripMenuItem;
        private System.Windows.Forms.PictureBox pictureBoxCanvas;
        private System.Windows.Forms.ToolStripMenuItem 画图ToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem 画点ToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem 画直线ToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem mnuDrawRect;
        private System.Windows.Forms.ToolStripMenuItem mnuDrawEllipse;
        private System.Windows.Forms.ToolStripMenuItem 画椭圆ToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem 画图片ToolStripMenuItem;
        private System.Windows.Forms.ToolStripSeparator toolStripMenuItem4;
        private System.Windows.Forms.ToolStripMenuItem 手画ToolStripMenuItem;
    }
}