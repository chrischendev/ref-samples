package com.chris.solr.utils;

import com.chris.solr.model.Person;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.apache.solr.common.SolrInputField;

import java.io.IOException;
import java.util.List;

/**
 * @author chrischan
 * create on 2019/6/25 9:57
 * use for:
 */
public class SolrUtils {
    private static final String SOLR_URL = "http://10.16.17.143:8983/solr/chris_core";

    /**
     * 创建客户端
     *
     * @return
     */
    public static HttpSolrClient getHttpSolrClient() {
        HttpSolrClient client = new HttpSolrClient.Builder(SOLR_URL)
                .withConnectionTimeout(1000 * 10)
                .withSocketTimeout(1000 * 60)
                .build();
        return client;
    }

    /**
     * 添加对象
     *
     * @param object
     * @param <T>
     * @throws IOException
     * @throws SolrServerException
     */
    public static <T> void add(T object) throws IOException, SolrServerException {
        HttpSolrClient httpSolrClient = getHttpSolrClient();
        httpSolrClient.addBean(object);
        httpSolrClient.commit();
        httpSolrClient.close();
    }

    /**
     * 添加集合
     *
     * @param objectList
     * @param <T>
     * @throws IOException
     * @throws SolrServerException
     */
    public static <T> void addList(List<T> objectList) throws IOException, SolrServerException {
        HttpSolrClient httpSolrClient = getHttpSolrClient();
        httpSolrClient.addBeans(objectList);
        httpSolrClient.commit();
        httpSolrClient.close();
    }


    /**
     * 添加文档
     *
     * @throws IOException
     * @throws SolrServerException
     */
    public static void addDoc() throws IOException, SolrServerException {
        SolrInputDocument document = new SolrInputDocument();
        document.addField("id", 5);
        SolrInputField nameField = new SolrInputField("name");
        nameField.setValue("sunfeifei1");
        document.addField("name", nameField);
        document.addField("description", "mylove");

        HttpSolrClient httpSolrClient = getHttpSolrClient();
        httpSolrClient.add(document);
        httpSolrClient.commit();
        httpSolrClient.close();
    }

    /**
     * 删除索引
     *
     * @param id
     * @throws IOException
     * @throws SolrServerException
     */
    public static void deleteDocumentById(String id) throws IOException, SolrServerException {
        HttpSolrClient httpSolrClient = getHttpSolrClient();
        httpSolrClient.deleteById(id);
        httpSolrClient.commit();
        httpSolrClient.close();
    }

    /**
     * 删除所有 一个core
     *
     * @throws IOException
     * @throws SolrServerException
     */
    public static void deleteAll() throws IOException, SolrServerException {
        HttpSolrClient httpSolrClient = getHttpSolrClient();
        httpSolrClient.deleteByQuery("*:*");
        httpSolrClient.commit();
        httpSolrClient.close();
    }

    /**
     * 查询
     *
     * @return
     */
    public static void query() throws IOException, SolrServerException {
        HttpSolrClient httpSolrClient = getHttpSolrClient();

        SolrQuery solrQuery = new SolrQuery();

        //查询参数q
        solrQuery.set("q", "*:*");
        //默认搜索域 df
        solrQuery.set("df", "name");
        //分页
        solrQuery.setStart(0);
        solrQuery.setRows(10);
        //设置高亮
        solrQuery.setHighlight(true);
        solrQuery.setMoreLikeThisFields("name");
        solrQuery.setHighlightSimplePre("<span class='keyword'>");
        solrQuery.setHighlightSimplePost("</span>");

        QueryResponse response = httpSolrClient.query(solrQuery);

        SolrDocumentList documentList = response.getResults();
        for (SolrDocument solrDocument : documentList) {
            System.out.println(solrDocument.get("id"));
            System.out.println(solrDocument.get("name"));
            System.out.println(solrDocument.get("description"));
        }

        List<Person> personList = response.getBeans(Person.class);
        System.out.println(personList.get(0).getName()[0]);

    }
}
