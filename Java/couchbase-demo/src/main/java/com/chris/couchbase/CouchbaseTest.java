package com.chris.couchbase;


import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.CouchbaseCluster;
import com.couchbase.client.java.document.JsonDocument;
import com.couchbase.client.java.document.json.JsonObject;

import java.io.IOException;

/**
 * create by: Chris Chan
 * create on: 2019/6/16 22:25
 * use for:
 */
public class CouchbaseTest {
    public static void main(String[] args) throws IOException {
        test2();
    }

    private static void test2() {
        Cluster cluster = CouchbaseCluster.create("192.168.0.114");
        Bucket bucket = cluster.openBucket("bucket01");
        bucket.insert(JsonDocument.create("user", JsonObject.create().put("name", "chris").put("age", 40)));
/*
        // Create a JSON Document
        JsonObject arthur = JsonObject.create()
                .put("name", "Arthur")
                .put("email", "kingarthur@couchbase.com")
                .put("interests", JsonArray.from("Holy Grail", "African Swallows"));

        // Store the Document
        bucket.upsert(JsonDocument.create("u:king_arthur", arthur));

        // Load the Document and print it
        // Prints Content and Metadata of the stored Document
        System.out.println(bucket.get("u:king_arthur"));

        // Create a N1QL Primary Index (but ignore if it exists)
        bucket.bucketManager().createN1qlPrimaryIndex(true, false);

        // Perform a N1QL Query
        N1qlQueryResult result = bucket.query(
                N1qlQuery.parameterized("SELECT name FROM default WHERE $1 IN interests",
                        JsonArray.from("African Swallows"))
        );

        // Print each found Row
        for (N1qlQueryRow row : result) {
            // Prints {"name":"Arthur"}
            System.out.println(row);
        }
*/
        // Just close a single bucket
        bucket.close();

        // Disconnect and close all buckets
        cluster.disconnect();
    }
//
//    private static void test1() throws IOException {
//        // (Subset) of nodes in the cluster to establish a connection
//        List<URI> hosts = Arrays.asList(URI.create("http://192.168.0.114:8091/"));
//        // Name of the Bucket to connect to
//        String bucket = "bucket01";
//        // Password of the bucket (empty) string if none
//        String password = "dev19810221";
//        // Connect to the Cluster
//        CouchbaseClient client = new CouchbaseClient(hosts, bucket, password);
//
//        /*
//         * Store a Document
//         * 1.client.set("hardy-couchbase-001","Hello Couchbasesss111111!")
//         * 2.Retreive the Document and print it: client.get("hardy-couchbase-001")
//         */
//        client.set("hardy-couchbase-001","Hello hardy-couchbase-001");
//        client.set("order_assign-001","Hello order_assign-001");
//        client.set("order_assign-002","Hello order_assign-002");
//
//        System.out.println(client.get("hardy-couchbase-001") +" : "+client.get("order_assign-001"));
//
//        client.delete("hardy-couchbase-001");
//
//        // Shutting down properly
//        client.shutdown();
//    }
}
