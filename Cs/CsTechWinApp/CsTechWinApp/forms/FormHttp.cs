using System;
using System.Collections;
using System.Collections.Generic;
using System.IO;
using System.Net;
using System.Text;
using System.Windows.Forms;
using CsTechWinApp.models;
using Newtonsoft.Json;
using Newtonsoft.Json.Linq;

namespace CsTechWinApp.forms
{
    public partial class FormHttp : Form
    {
        public FormHttp()
        {
            InitializeComponent();
            initView();
        }

        private void initView()
        {
            //throw new NotImplementedException();
            //form
            this.StartPosition = FormStartPosition.CenterScreen;

            //listView
            listViewNews.View = View.Details;
            listViewNews.FullRowSelect = true;
            listViewNews.Columns.Add("序号", 50, HorizontalAlignment.Left);
            listViewNews.Columns.Add("标题", 250, HorizontalAlignment.Left);
            listViewNews.Columns.Add("URL", 250, HorizontalAlignment.Left);
            loadNewsData();

        }

        /**
         * 加载新闻数据
         */
        private void loadNewsData()
        {
            string newsListStr = requestNewsData();

            List<NewsItem> newsList = new List<NewsItem>();
            JArray newsArray = JArray.Parse(newsListStr);

            //构建新闻数据列表
            NewsItem newsItem = null;
            foreach (JToken newsToken in newsArray)
            {
                newsItem = new NewsItem(newsToken["title"].ToString(), newsToken["url"].ToString());
                newsList.Add(newsItem);
            }

            //把列表数据加载到控件中
            for (int i = 0; i < newsList.Count; i++)
            {
                NewsItem item = newsList[i];
                ListViewItem listViewItem = new ListViewItem();
                listViewItem.Text = Convert.ToString(i + 1);
                listViewItem.SubItems.Add(item.Title);
                listViewItem.SubItems.Add(item.Url);
                listViewNews.Items.Add(listViewItem);
            }
        }
        /**
         * 加载新闻数据
         */
        private void loadNewsData1()
        {
            string newsListStr = requestNewsData();

            JArray newsArray = JArray.Parse(newsListStr);
            /*
            foreach (JObject newsObj in newsArray)
            {
                ListViewItem item=new ListViewItem();
                item.Text = newsObj["id"].ToString();
                item.SubItems.Add(newsObj["title"].ToString());
                listViewNews.Items.Add(item);
            }
            */

            for (int i = 0; i < newsArray.Count; i++)
            {
                JToken newsObj = newsArray[i];
                ListViewItem item = new ListViewItem();
                item.Text = newsObj["id"].ToString();
                item.SubItems.Add(newsObj["title"].ToString());
                item.SubItems.Add(newsObj["url"].ToString());
                listViewNews.Items.Add(item);
            }

        }
        /**
         * 网络请求新闻数据
         */
        private string requestNewsData()
        {
            string url = "http://localhost:8031/news/search?newsType=BOLAN&page=0&pageSize=20";
            HttpWebRequest request = (HttpWebRequest)WebRequest.Create(url);
            request.Method = "GET";
            request.ContentType = "application/json;charset=UTF-8";
            request.UserAgent = null;
            request.Timeout = 100000;


            HttpWebResponse response = (HttpWebResponse)request.GetResponse();
            Stream stream = response.GetResponseStream();
            StreamReader reader = new StreamReader(stream, Encoding.UTF8);
            string result = reader.ReadToEnd();

            //MessageBox.Show(result);

            reader.Close();
            stream.Close();

            return result;
        }
    }
}
