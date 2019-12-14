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
    /// WinListView.xaml 的交互逻辑
    /// </summary>
    public partial class WinListView : Window
    {
        public WinListView()
        {
            InitializeComponent();
            init();
        }
        private void init()
        {
            ObservableCollection<PersonalInfo> personalInfoList = new ObservableCollection<PersonalInfo>();
            personalInfoList.Add(new PersonalInfo("李白", 10, "134124", "libai@hotmail.com"));
            personalInfoList.Add(new PersonalInfo("杜甫", 2, "242354", "dufu@hotmail.com"));
            personalInfoList.Add(new PersonalInfo("苏轼", 4, "345356", "sushi@hotmail.com"));
            personalInfoList.Add(new PersonalInfo("李清照", 3, "453546", "liqingzhao@hotmail.com"));

            listView.ItemsSource = personalInfoList;

        }
    }

}
