package com.chris.hadoop.hbase;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.*;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.log4j.BasicConfigurator;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by Chris Chen
 * 2018/12/13
 * Explain:
 */

public class HBaseTest {
    private static String HBASE_URL = "10.100.81.174:60000";
    public static Configuration conf;
    public static Admin admin;
    public static Connection connection;

    static {
        System.setProperty("hadoop.home.dir", "D:\\softs\\hadoop-2.8.5");//HADOOP_HOME
        BasicConfigurator.configure();//自动快速地使用缺省Log4j环境

        conf = HBaseConfiguration.create();
        conf.set("hbase.zookeeper.property.clientPort", "2181");
        conf.set("hbase.zookeeper.quorum", "10.100.81.177,10.100.81.178,10.100.81.179");
        conf.set("hbase.master", HBASE_URL);

        try {
            connection = ConnectionFactory.createConnection(conf);
            admin = connection.getAdmin();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        String tableName = "chris_test_1";
        createTable(tableName, "name", "address", "contact");
        deleteTable(tableName);
        listTables();
        insertRow(tableName, "rowKey1", "name", "userName", "kaly chen");
        getData(tableName, "rowKey1", "name", "userName");
        //scanData(tableName, "rowKey", "rowKey1");
    }

    //扫描批量数据
    private static void scanData(String tableName, String startRowKey, String stopRowKey) throws IOException {
        Table table = connection.getTable(TableName.valueOf(tableName));
        Scan scan = new Scan();
        //scan.setStartRow(Bytes.toBytes(startRowKey));
        //scan.setStopRow(Bytes.toBytes(stopRowKey));
        ResultScanner resultScanner = table.getScanner(scan);
        for (Result result : resultScanner) {
            showResult(result);
        }
        table.close();
        close();
    }

    //获取数据
    private static void getData(String tableName, String rowKey, String columnFamily, String column) throws IOException {
        Table table = connection.getTable(TableName.valueOf(tableName));
        Get get = new Get(Bytes.toBytes(rowKey));
        Result result = table.get(get);
        showResult(result);
        table.close();
        close();
    }

    //查看数据
    private static void showResult(Result result) {
        Cell[] rawCells = result.rawCells();
        for (Cell cell : rawCells) {
            System.out.println("RowKey: " + new String(CellUtil.cloneRow(cell)));
            System.out.println("Time: " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(cell.getTimestamp()));
            System.out.println("ColumnFamily: " + new String(CellUtil.cloneFamily(cell)));
            System.out.println("Column: " + new String(CellUtil.cloneQualifier(cell)));
            System.out.println("Value: " + new String(CellUtil.cloneValue(cell)));
        }
    }

    //插入行
    private static void insertRow(String tableName, String rowKey, String columnFamily, String column, String value) throws IOException {
        Table table = connection.getTable(TableName.valueOf(tableName));
        Put put = new Put(Bytes.toBytes(rowKey));
        put.addColumn(Bytes.toBytes(columnFamily), Bytes.toBytes(column), Bytes.toBytes(value));
        table.put(put);
    }

    //查看所有表
    private static void listTables() throws IOException {
        List<TableDescriptor> tableDescriptors = admin.listTableDescriptors();
        tableDescriptors.stream().forEach(tab -> System.out.println(tab.getTableName().getNameAsString()));
    }

    //删除表
    private static void deleteTable(String tableName) throws IOException {
        TableName tbName = TableName.valueOf(tableName);
        //if (admin.tableExists(tbName)) {//todo 这句总有问题
        admin.disableTable(tbName);
        admin.deleteTable(tbName);
        //}
        close();
    }

    //创建表
    private static void createTable(String tableName, String... columnFamilies) throws IOException {
        TableName tableName1 = TableName.valueOf(tableName);

        //此处有异常
//        if (admin.tableExists(tableName1)) {
//            System.out.println("数据表已经存在");
//            close();
//            return;
//        }

        HTableDescriptor hTableDescriptor = new HTableDescriptor(tableName1);
        for (String columnFamily : columnFamilies) {
            HColumnDescriptor hColumnDescriptor = new HColumnDescriptor(columnFamily);
            hTableDescriptor.addFamily(hColumnDescriptor);
        }
        admin.createTable(hTableDescriptor);
        close();
    }

    //关闭连接
    private static void close() {
        try {
            admin.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
