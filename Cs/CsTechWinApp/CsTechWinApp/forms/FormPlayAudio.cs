using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Media;
using System.Runtime.InteropServices;

namespace CsTechWinApp.forms
{
    public partial class FormPlayAudio : Form
    {
        //加载动态链接库
        [DllImport("winmm.dll", EntryPoint = "mciSendString", CharSet = CharSet.Auto)]
        private static extern int mciSendString(
            string lpstrCommand,
            string lpstrReturnString,
            int uReturnLength,
            int hwndCallback
        );

        public FormPlayAudio()
        {
            InitializeComponent();
        }

        private void btnPlayWav_Click(object sender, EventArgs e)
        {
            string wavFilePath = "D:\\temp\\Windows Notify.wav";

            SoundPlayer player=new SoundPlayer(wavFilePath);
            player.Play();
        }

        private void btnPlayMp3_Click(object sender, EventArgs e)
        {
            string mp3FilePath = "D:\\temp\\txdx.mp3";
            mciSendString("close all", "", 0, 0);
            mciSendString("open " + mp3FilePath + " alias media", "", 0, 0);
            mciSendString("play media", "", 0, 0);
        }
    }
}
