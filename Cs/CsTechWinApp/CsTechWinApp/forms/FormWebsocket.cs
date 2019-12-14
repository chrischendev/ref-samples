using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Runtime.Remoting.Channels;
using System.Text;
using System.Threading;
using System.Threading.Tasks;
using System.Windows.Forms;
using WebSocketSharp;

namespace CsTechWinApp.forms
{
    public partial class FormWebsocket : Form
    {
        private WebSocket webSocketClient;
        private SynchronizationContext mainthreadContext;
        public FormWebsocket()
        {
            InitializeComponent();
            mainthreadContext = SynchronizationContext.Current;//记录主线程的上下文
            initView();
        }

        private void initView()
        {
            this.StartPosition = FormStartPosition.CenterScreen;
            //填写默认用户名和ws服务地址
            tbUsername.Text="chris";
            tbWsUrl.Text = "ws://localhost:8765/chat";


        }

        /**
         * 连接WS服务
         */
        public void connectToWsServer()
        {
            //创建Websocket客户端
            string username = tbUsername.Text;
            WebSocket ws = new WebSocket(tbWsUrl.Text+"/"+username);
            //收到消息 通过主线程的上下文将数据传递给主线程
            ws.OnMessage += (sender, response) => mainthreadContext.Post(new SendOrPostCallback(ShowOnMessageInfo), response.Data);
            //连接错误
            ws.OnError += (sender, e) => mainthreadContext.Post(new SendOrPostCallback(ShowOnErrorInfo), e.Message);
            //退出
            ws.OnClose += (sender, result) => mainthreadContext.Post(new SendOrPostCallback(ShowOnCloseInfo), result.Reason);
            //连接成功
            ws.OnOpen += (sender, info) => mainthreadContext.Post(new SendOrPostCallback(ShowOnOpenInfo), username);

            ws.Connect();

            this.webSocketClient = ws;
        }

        /**
         * 连接
         */
        private void btnConnect_Click(object sender, EventArgs e)
        {
            //创建线程
            Thread thread = new Thread(new ThreadStart(connectToWsServer));
            thread.Start();
        }

        /**
         * 发送消息
         */
        private void btnSend_Click(object sender, EventArgs e)
        {
            this.webSocketClient.Send(tbChatCentent.Text);
        }

        /**
         * 主线程修改UI
         */
        public void ShowOnOpenInfo(object username)
        {
            tbChatDetails.Text += username + " 连接成功\r\n\r\n";
        }
        public void ShowOnCloseInfo(object reason)
        {
            tbChatDetails.Text += "你 已经退出 原因: "+reason+"\r\n\r\n";
        }
        public void ShowOnErrorInfo(object errorMessage)
        {
            tbChatDetails.Text += "连接出现错误 "+ errorMessage + "\r\n\r\n";
        }
        public void ShowOnMessageInfo(object message)
        {
            tbChatDetails.Text += message + " \r\n\r\n";
        }
    }
}
