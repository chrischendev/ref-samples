using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Drawing.Drawing2D;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace CsTechWinApp.forms
{
    public partial class FormDraw : Form
    {
        private Graphics cg;
        public FormDraw()
        {
            InitializeComponent();
            initView();
        }

        private void initView()
        {
            cg = pictureBoxCanvas.CreateGraphics();
            cg.SmoothingMode = SmoothingMode.AntiAlias;
        }

        private void mnuDrawRect_Click(object sender, EventArgs e)
        {
            Pen pen = new Pen(Color.Red, 3.5f);
            //.DrawArc(pen, 100, 100, 200, 2100, 0, 30);
            cg.DrawRectangle(pen, 100, 100, 200, 120);
        }

        private void mnuDrawQuit_Click(object sender, EventArgs e)
        {
            Close();
        }

        private void mnuDrawEllipse_Click(object sender, EventArgs e)
        {
            Pen pen = new Pen(Color.Blue, 3f);
            cg.DrawEllipse(pen, 200, 200, 120, 120);
        }
    }
}
