using CsTechWptApp.model;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Shapes;

namespace CsTechWptApp.windows
{
    /// <summary>
    /// WinImageListView.xaml 的交互逻辑
    /// </summary>
    public partial class WinImageListView : Window
    {
        ObservableCollection<LVData> LVDatas = new ObservableCollection<LVData>();
        public WinImageListView()
        {
            InitializeComponent();
            init();
        }

        private void init()
        {
            BindFileManager();
            LVDatas.Add(new LVData { Name = "诗涵", Pic = "D:\\sh012.jpg" });
            LVDatas.Add(new LVData { Name = "不知", Pic = "D:\\p.png" });

        }


        public void BindFileManager()
        {
            lstFileManager.ItemsSource = LVDatas;
        }
    }
}
