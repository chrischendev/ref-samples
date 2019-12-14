using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CsTechWinApp.models
{
    class NewsItemDetails
    {
        private int id;
        private String code;
        private String title;
        private String url;
        private String type;
        private String imageMain;
        private String imageUrls;
        private String author;
        private String source;
        private String description;
        private String tags;
        private String publishTimeStr;
        private String publishTime;

        public NewsItemDetails()
        {
        }

        public NewsItemDetails(int id, string code, string title, string url, string type, string imageMain, string imageUrls, string author, string source, string description, string tags, string publishTimeStr, string publishTime)
        {
            this.id = id;
            this.code = code;
            this.title = title;
            this.url = url;
            this.type = type;
            this.imageMain = imageMain;
            this.imageUrls = imageUrls;
            this.author = author;
            this.source = source;
            this.description = description;
            this.tags = tags;
            this.publishTimeStr = publishTimeStr;
            this.publishTime = publishTime;
        }

        public int Id
        {
            get => id;
            set => id = value;
        }

        public string Code
        {
            get => code;
            set => code = value;
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

        public string Type
        {
            get => type;
            set => type = value;
        }

        public string ImageMain
        {
            get => imageMain;
            set => imageMain = value;
        }

        public string ImageUrls
        {
            get => imageUrls;
            set => imageUrls = value;
        }

        public string Author
        {
            get => author;
            set => author = value;
        }

        public string Source
        {
            get => source;
            set => source = value;
        }

        public string Description
        {
            get => description;
            set => description = value;
        }

        public string Tags
        {
            get => tags;
            set => tags = value;
        }

        public string PublishTimeStr
        {
            get => publishTimeStr;
            set => publishTimeStr = value;
        }

        public string PublishTime
        {
            get => publishTime;
            set => publishTime = value;
        }
    }
}
