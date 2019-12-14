using System;
using System.Collections.Generic;
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
using System.Windows.Navigation;
using System.Windows.Shapes;
using CsTechWptApp.windows;

namespace CsTechWptApp
{
    /// <summary>
    /// MainWindow.xaml 的交互逻辑
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
        }

        private void BtnImageList_OnClick(object sender, RoutedEventArgs e)
        {
//            new WinImageListView().Show();
            new WinImageListView().ShowDialog();
        }

        private void BtnListView_OnClick(object sender, RoutedEventArgs e)
        {
            new WinListView().ShowDialog();
        }
    }
}
