using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CsTechWinApp.models
{
    class NewsItem
    {
        private string title;
        private string url;

        public NewsItem()
        {
        }

        public NewsItem(string title, string url)
        {
            this.title = title;
            this.url = url;
        }

        public string Title
        {
            get => title;
            set => title = value;
        }

        public string Url
        {
            get => url;
            set => url = value;
        }
    }
}
