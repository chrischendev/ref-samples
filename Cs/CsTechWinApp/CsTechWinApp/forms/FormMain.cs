using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using CsTechWinApp.forms;

namespace CsTechWinApp
{
    public partial class FormMain : Form
    {
        public FormMain()
        {
            InitializeComponent();
        }

        private void btnImageListView_Click(object sender, EventArgs e)
        {
            new FormImageListView().ShowDialog();
        }

        private void btnQuit_Click(object sender, EventArgs e)
        {
            Environment.Exit(0);
        }

        private void btnCheckBox_Click(object sender, EventArgs e)
        {
            new FormLittleControls().ShowDialog();
        }

        private void FormMain_Load(object sender, EventArgs e)
        {

        }

        private void btnHttpRequest_Click(object sender, EventArgs e)
        {
            new FormHttp().ShowDialog();
        }

        private void btnPlayAudio_Click(object sender, EventArgs e)
        {
            new FormPlayAudio().ShowDialog();
        }

        private void btnPlayVideo_Click(object sender, EventArgs e)
        {
            new FormPlayVideo().ShowDialog();
        }

        private void btnChat_Click(object sender, EventArgs e)
        {
            new FormWebsocket().ShowDialog();
        }

        private void btnDraw_Click(object sender, EventArgs e)
        {
            new FormDraw().ShowDialog();
        }

        private void btnLocalDB_Click(object sender, EventArgs e)
        {
            new FormLocalDB().ShowDialog();
        }

        private void btnMySql_Click(object sender, EventArgs e)
        {
            new FormMySql().ShowDialog();
        }

        private void btnExcel_Click(object sender, EventArgs e)
        {
            new FormExcel().ShowDialog();
        }
    }
}
