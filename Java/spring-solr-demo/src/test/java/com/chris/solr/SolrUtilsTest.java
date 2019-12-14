package com.chris.solr;

import com.chris.solr.model.Person;
import com.chris.solr.utils.SolrUtils;
import org.apache.solr.client.solrj.SolrServerException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author chrischan
 * create on 2019/6/25 10:04
 * use for:
 */
public class SolrUtilsTest {
    public static void main(String[] args) throws IOException, SolrServerException {
        testDel();
    }

    private static void testAddObjectList() throws IOException, SolrServerException {
        List<Person> personList = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            personList.add(new Person(String.valueOf(101 + i), "姓名" + i, "描述"));
        }
        SolrUtils.addList(personList);
    }

    private static void testAddObject() throws IOException, SolrServerException {
        Person person = new Person(String.valueOf(101), "yaoshihan", "mylove");
        SolrUtils.add(person);
    }

    private static void testDel() throws IOException, SolrServerException {
        SolrUtils.deleteDocumentById("2");
        SolrUtils.deleteAll();
    }

    private static void testQuery() throws IOException, SolrServerException {
        SolrUtils.query();
    }

    private static void testAddDoc() throws IOException, SolrServerException {
        SolrUtils.addDoc();
    }
}
