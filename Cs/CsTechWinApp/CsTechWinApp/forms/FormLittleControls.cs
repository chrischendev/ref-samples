using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace CsTechWinApp.forms
{
    public partial class FormLittleControls : Form
    {
        public FormLittleControls()
        {
            InitializeComponent();
            initView();

        }

        /**
         * 初始化控件
         */
        private void initView()
        {
            //throw new NotImplementedException();

            //组合框
            comboBox1.DropDownStyle = ComboBoxStyle.DropDownList;
            comboBox1.Items.Add("天龙八部");
            comboBox1.Items.Add("神雕侠侣");
            comboBox1.Items.Add("醉梦狂风");
            comboBox1.SelectedIndex = 0;

            //绑定上下文菜单
            lblContextMenu.ContextMenuStrip = contextMenuStrip1;

            //图片框加载图片
            //pictureBox1.SizeMode = PictureBoxSizeMode.StretchImage;//自适应
            //pictureBox1.LoadAsync("D:\\temp\\sh_02.jpg");

            pictureBox1.BackgroundImageLayout = ImageLayout.Stretch;//背景自适应
            pictureBox1.BackgroundImage=Image.FromFile("D:\\temp\\sh_02.jpg");

        }

        private void btnShowCheckBox_Click(object sender, EventArgs e)
        {
            List<string> cityList = new List<string>();
            foreach (Control control in groupBox1.Controls)
            {
                if (control is CheckBox)
                {
                    CheckBox checkBox = (CheckBox)control;
                    if (checkBox.Checked)
                    {
                        cityList.Add(checkBox.Text);
                    }
                }

            }
            //拼接集合字符串
            string cities = string.Join(",", cityList.ToArray());
            MessageBox.Show(cities);
        }

        private void checkBox1_CheckedChanged(object sender, EventArgs e)
        {
            MessageBox.Show(checkBox1.Text);
        }

        private void btnShowRadioButton_Click(object sender, EventArgs e)
        {
            if (radioButton1.Checked)
            {
                MessageBox.Show(radioButton1.Text);
            }
            else if (radioButton2.Checked)
            {
                MessageBox.Show(radioButton2.Text);
            }
            else if (radioButton3.Checked)
            {
                MessageBox.Show(radioButton3.Text);
            }


        }

        private void radioButton1_CheckedChanged(object sender, EventArgs e)
        {
            lblRadioButton.Text = radioButton1.Text;
        }

        private void radioButton2_CheckedChanged(object sender, EventArgs e)
        {
            lblRadioButton.Text = radioButton2.Text;
        }

        private void radioButton3_CheckedChanged(object sender, EventArgs e)
        {
            lblRadioButton.Text = radioButton3.Text;
        }

        private void btnAddItem_Click(object sender, EventArgs e)
        {
            comboBox1.Items.Add("如来神掌");
        }

        private void btnShowSelected_Click(object sender, EventArgs e)
        {
            string comboBox1Text = comboBox1.Text;
            MessageBox.Show(comboBox1.Items.IndexOf(comboBox1Text)+" : "+comboBox1Text);
        }

        private void mnStart_Click(object sender, EventArgs e)
        {
            MessageBox.Show("开始喽");
        }

        private void mnEnd_Click(object sender, EventArgs e)
        {
            MessageBox.Show("结束了");
        }

        private void btnProgressStart_Click(object sender, EventArgs e)
        {
            for (int i = 0; i <= 100; i++)
            {
                //必须加这一句，否则标签不显示数字
                Application.DoEvents();
                //progressBar1.Value = progressBar1.Step;
                progressBar1.Value = i;
                lblProgressValue.Text = Convert.ToString(progressBar1.Value);
                Thread.Sleep(100);
            }
        }
    }
}
