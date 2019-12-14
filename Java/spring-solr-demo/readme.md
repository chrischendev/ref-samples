方案1，使用solrClient，配置要到core部分，或者在solrTemplate中写到core这一节，实体类用@Field注解字段
方案2，使用SpringData，配置无需core部分，实体类用@SolrDocument(collection = "chris_core")注解，知名core，@Indexed(name = "id")注解字段，@Id注解主键