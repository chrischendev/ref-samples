using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace CsTechWinApp.forms
{
    public partial class FormImageListView : Form
    {
        public FormImageListView()
        {
            InitializeComponent();
            init();
        }

        private void init()
        {

            LoadImageList();
        }

        private void btnQuit_Click(object sender, EventArgs e)
        {
            Close();
        }

        private void LoadImageList()
        {

            //图片列表
            var path = "D:\\temp\\";
            var list = new List<string>();
            list.Add("p.png");
            list.Add("sh012.jpg");

            //显示条件
            int[] cons = {1, 0, 1, 1,1,1,1,1};

            ImageList imglist = new ImageList();
            imglist.ImageSize = new Size(48, 48);
            imglist.ColorDepth = ColorDepth.Depth32Bit;
            foreach (var fileName in list)
            {
                imglist.Images.Add(Image.FromFile(path + fileName));
                listView1.LargeImageList = imglist;
            }

            for (int i = 0; i < cons.Length; i++)
                {
                    var lvi = new ListViewItem();
                    lvi.ImageIndex = cons[i] == 1 ? 1 : 0;
                    lvi.Text = "Stu" + i;
                    lvi.ToolTipText = "Stu" + i;
                    listView1.Items.Add(lvi);
                }


        }

        private void listView1_SelectedIndexChanged(object sender, EventArgs e)
        {
            MessageBox.Show(listView1.SelectedItems[0].Text);
        }

        private void FormImageListView_Load(object sender, EventArgs e)
        {

        }
    }
}
