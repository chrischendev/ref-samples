# -*- coding: utf-8 -*-
# scrapy crawl toutiao -o toutiao_scrapy_list.csv
from scrapy.linkextractors import LinkExtractor
from scrapy.spiders import CrawlSpider, Rule

# 遇上了反爬虫问题
class ToutiaoSpider(CrawlSpider):
    name = 'toutiao'
    allowed_domains = ['www.toutiao.com']
    start_urls = ['http://www.toutiao.com/']

    rules = (
        Rule(LinkExtractor(allow=r'http://www.toutiao.com/*'), callback='parse_item', follow=True),
    )

    def parse_item(self, response):
        item = {}

        title=response.xpath('/html/body/div/div[2]/div[2]/div[2]/ul/li/div/div/div/div[1]/a/text()').extract_first()
        #item['domain_id'] = response.xpath('//input[@id="sid"]/@value').get()
        #item['name'] = response.xpath('//div[@id="name"]').get()
        #item['description'] = response.xpath('//div[@id="description"]').get()

        if title!=None:
            item['title'] = title
            print(str(item))
            return item
