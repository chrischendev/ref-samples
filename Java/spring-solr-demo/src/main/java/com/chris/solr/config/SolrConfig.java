package com.chris.solr.config;

import org.apache.solr.client.solrj.SolrClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.solr.core.SolrTemplate;

/**
 * @author chrischan
 * create on 2019/6/25 16:02
 * use for:
 */
@Configuration
public class SolrConfig {
    @Autowired
    SolrClient solrClient;

    @Bean
    public SolrTemplate solrTemplate() {
        return new SolrTemplate(solrClient);
    }
}
