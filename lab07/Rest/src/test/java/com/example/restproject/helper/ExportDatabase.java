package com.example.restproject.helper;

import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.xml.FlatDtdDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by Konrad on 05.06.2016.
 */
public class ExportDatabase {

    public static void main(String[] args) throws Exception {
        Connection jdbcConnection = DriverManager.getConnection(
                "jdbc:hsqldb:hsql://localhost/buildingdb", "sa", "");

        IDatabaseConnection connection = new DatabaseConnection(jdbcConnection);

        FlatDtdDataSet.write(connection.createDataSet(), new FileOutputStream(
                "src/test/resources/dataSet.dtd"));

        FlatXmlDataSet.write(connection.createDataSet(), new FileOutputStream(
                "src/test/resources/fullData.xml"));

    }
}
