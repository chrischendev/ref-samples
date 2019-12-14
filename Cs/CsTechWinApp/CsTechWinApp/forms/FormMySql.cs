using MySql.Data.MySqlClient;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Runtime.Remoting.Metadata.W3cXsd2001;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using CsTechWinApp.models;

namespace CsTechWinApp.forms
{
    public partial class FormMySql : Form
    {
        private MySqlConnection mySqlConnection;

        public FormMySql()
        {
            InitializeComponent();
            initView();
        }

        private void initView()
        {
            //throw new NotImplementedException();
        }

        private void btnConnect_Click(object sender, EventArgs e)
        {
            String connetStr = "server=47.97.183.139;port=3306;user=chris;password=Gk!123456; database=db_chris_proctice;charset=utf8;SslMode=none";
            MySqlConnection conn = new MySqlConnection(connetStr);
            conn.Open();
            mySqlConnection = conn;
            MessageBox.Show("mysql数据库连接成功");
        }

        private void btnQuery_Click(object sender, EventArgs e)
        {
            textBox1.Text = "";

            string sql = "select * from tb_user limit 0,10";
            MySqlCommand cmd = new MySqlCommand(sql, this.mySqlConnection);
            MySqlDataReader reader = cmd.ExecuteReader();
            DataTable table = new DataTable();
            table.Load(reader);

            foreach (DataRow tableRow in table.Rows)
            {
                string name = tableRow["name"].ToString();
                textBox1.Text += name + "\r\n";
            }
            Console.WriteLine("数据查询成功");
        }

        private void btnCloseConnection_Click(object sender, EventArgs e)
        {
            this.mySqlConnection.Close();
        }

        private void btnAdd_Click(object sender, EventArgs e)
        {
            string tableName = "tb_user";
            UserModel userModel = new UserModel(tbName.Text, Convert.ToInt32(tbAge.Text), tbAddress.Text);
            add(tableName, userModel);
        }

        /**
         * 添加user数据 带事务处理
         */
        private void add(string tableName, UserModel userModel)
        {
            //开启事务 必须保证先开启连接
            MySqlTransaction mySqlTransaction = this.mySqlConnection.BeginTransaction();
            try
            {
                string sql = "insert into " + tableName + "(name,age,address) values (@name,@age,@addr)";
                MySqlCommand mySqlCommand = new MySqlCommand(sql, this.mySqlConnection);
                mySqlCommand.Parameters.AddWithValue("name", userModel.Name);
                mySqlCommand.Parameters.AddWithValue("age", userModel.Age);
                mySqlCommand.Parameters.AddWithValue("addr", userModel.Address);
                mySqlCommand.ExecuteNonQuery();
                //事务提交
                mySqlTransaction.Commit();

                MessageBox.Show("数据添加成功");
            }
            catch (Exception e)
            {
                Console.WriteLine(e);
                //throw;
                //事务回滚
                mySqlTransaction.Rollback();
            }
            
            btnQuery_Click(this, null);
        }

        /**
         * 添加user数据 有参数处理机制 不带事务
         */
        private void add1(string tableName, UserModel userModel)
        {
            string sql = "insert into " + tableName + "(name,age,address) values (@name,@age,@addr)";

            MySqlCommand mySqlCommand = new MySqlCommand(sql, this.mySqlConnection);

            mySqlCommand.Parameters.AddWithValue("name", userModel.Name);
            mySqlCommand.Parameters.AddWithValue("age", userModel.Age);
            mySqlCommand.Parameters.AddWithValue("addr", userModel.Address);

            mySqlCommand.ExecuteNonQuery();

            MessageBox.Show("数据添加成功");

            //更新查询显示
            btnQuery_Click(this, null);
        }
        /**
         * 添加user数据 土办法
         */
        private void add2(string tableName, UserModel userModel)
        {
            string sql = "insert into " + tableName + "(name,age,address) values('" + userModel.Name + "'," +
                         userModel.Age + ",'" + userModel.Address + "')";
            MySqlCommand mySqlCommand = new MySqlCommand(sql, this.mySqlConnection);
            mySqlCommand.ExecuteNonQuery();
            MessageBox.Show("数据添加成功");

            btnQuery_Click(this, null);
        }
    }
}
