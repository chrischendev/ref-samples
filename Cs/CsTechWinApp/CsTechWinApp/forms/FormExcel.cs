using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using Microsoft.Office.Interop.Excel;
using Application = Microsoft.Office.Interop.Excel.Application;

namespace CsTechWinApp.forms
{
    public partial class FormExcel : Form
    {
        private Application xlsApp;
        private Workbook workbook;

        public FormExcel()
        {
            InitializeComponent();
            initView();

        }

        private void initView()
        {
            xlsApp = new Application();
        }

        private void btnQuit_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void btnImport_Click(object sender, EventArgs e)
        {
            Workbooks workbooks = xlsApp.Workbooks;
            workbook = workbooks.Open("D:\\temp\\user.xls");//索引从1开始
            Worksheet sheet = workbook.Worksheets.Item[1];
            textBox1.Text += sheet.Name + "\r\n";
            textBox1.Text += sheet.Range["A1"].Value2 + "\r\n";

            Range rows = sheet.Rows;
            textBox1.Text += "一共 " + rows.Count + "行\r\n";

            Range cells = sheet.Cells;
            textBox1.Text += "一共 " + cells.Count + "个单元格\r\n";

            //读取任意一个单元格
            string val=((Range)sheet.Cells[1,1]).Text.ToString();
            textBox1.Text += val + "\r\n";

            for (int i = 0; i < 3; i++)
            {
                string val1 = ((Range)sheet.Cells[2, i+1]).Text.ToString();
                textBox1.Text += val1 + "\r\n";
            }




        }

        private void btnExport_Click(object sender, EventArgs e)
        {

        }

        private void btnUpdate_Click(object sender, EventArgs e)
        {
            Workbooks workbooks = xlsApp.Workbooks;
            workbook = workbooks.Open("D:\\temp\\user.xls");//索引从1开始
            Worksheet sheet = workbook.Worksheets.Item[1];
       
            //修改一个单元格
            sheet.Cells[2, 1]="Will Chan";
            
            //保存
            workbook.Save();

        }
    }
}
