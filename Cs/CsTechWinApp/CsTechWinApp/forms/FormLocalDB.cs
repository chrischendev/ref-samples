using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Data.OleDb;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using CsTechWinApp.models;

namespace CsTechWinApp.forms
{
    public partial class FormLocalDB : Form
    {
        private OleDbConnection oleDbConnection;
        private OleDbCommand oleDbCommand;

        public FormLocalDB()
        {
            InitializeComponent();
        }

        private void btnConnectDB_Click(object sender, EventArgs e)
        {
            //connectMDB("D:\\temp\\mdb\\school.mdb","student");
            connectACCDB("D:\\temp\\mdb\\school.accdb", "student");
        }

        /**
         * 连接MDB
         */
        private void connectMDB(string sourceFile, string tableName)
        {
            String connectionString = "Provider=Microsoft.Jet.OLEDB.4.0;Data Source=" + sourceFile + ";";//sourceFile 为需要操作的mdb数据的路径
            OleDbConnection conn = new OleDbConnection(connectionString);//连接mdb数据库
            conn.Open();
            OleDbCommand cmd = conn.CreateCommand();//获取OleDbCommand 
            string sql = "select * from " + tableName;//sql语句，其中TableName为操作的mdb中的一张表格的名称
            cmd.CommandText = sql;
            OleDbDataReader dataReader = cmd.ExecuteReader();//执行sql语句
            DataTable table = new DataTable();
            table.Load(dataReader);//OleDbDataReader 转为DataTable
            string data = "";
            data = table.Rows[0]["name"].ToString();//获取表格中第i行的“name字段”所对应单元格的数据

            MessageBox.Show(data);

            this.oleDbConnection = conn;
            this.oleDbCommand = cmd;
            //conn.Close();//暂时不关闭

        }
        /**
         * 连接ACCDB Provider不相同
         */
        private void connectACCDB(string sourceFile, string tableName)
        {
            String connectionString = "Provider=Microsoft.ACE.OLEDB.12.0;;Data Source=" + sourceFile + ";";//sourceFile 为需要操作的mdb数据的路径
            OleDbConnection conn = new OleDbConnection(connectionString);//连接mdb数据库
            conn.Open();
            OleDbCommand cmd = conn.CreateCommand();//获取OleDbCommand 
                                                    //            string sql = "select * from " + tableName;//sql语句，其中TableName为操作的mdb中的一张表格的名称
                                                    //            cmd.CommandText = sql;
                                                    //            OleDbDataReader dataReader = cmd.ExecuteReader();//执行sql语句
                                                    //            DataTable table = new DataTable();
                                                    //            table.Load(dataReader);//OleDbDataReader 转为DataTable
                                                    //            string data = "";
                                                    //            data = table.Rows[0]["name"].ToString();//获取表格中第i行的“name字段”所对应单元格的数据
                                                    //            MessageBox.Show(data);
            this.oleDbConnection = conn;
            this.oleDbCommand = cmd;
            //conn.Close();

        }

        private void btnQuery_Click(object sender, EventArgs e)
        {
            string tableName = "student";
            query(tableName);

        }

        /**
         * 查询数据
         */
        private void query(string tableName)
        {
            string sql = "select * from " + tableName;
            this.oleDbCommand.CommandText = sql;
            OleDbDataReader dataReader = this.oleDbCommand.ExecuteReader();
            DataTable table = new DataTable();
            table.Load(dataReader);
            string name = "";
            foreach (DataRow tableRow in table.Rows)
            {
                name = tableRow["name"].ToString();
                textBox1.Text += name + "\r\n";
            }
        }

        private void btnAddData_Click(object sender, EventArgs e)
        {
            string tableName = "student";
            Student student = new Student(tbName.Text, Convert.ToInt32(tbAge.Text), tbAddress.Text, tbInfo.Text);
            add(tableName, student);

            textBox1.Text = "";
            query(tableName);
        }

        private void add(string tableName, Student student)
        {
            //age是整数，两边不加引号
            string sql = "insert into " + tableName + "(name,age,address,info) values('" + student.Name + "'," + student.Age + ",'" + student.Address + "','" + student.Info + "')";
            this.oleDbCommand.CommandText = sql;
            this.oleDbCommand.ExecuteNonQuery();
        }

        private void btnCloseConnection_Click(object sender, EventArgs e)
        {
            this.oleDbConnection.Close();
            MessageBox.Show("与Microsoft Access的数据库已经断开");
        }
    }
}
