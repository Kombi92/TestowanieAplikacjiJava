package com.example.restproject.dbunitTest;

import com.example.restproject.domain.Owner;
import com.example.restproject.service.OwnerManager;
import com.jayway.restassured.RestAssured;
import org.dbunit.Assertion;
import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.filter.DefaultColumnFilter;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.ws.rs.core.MediaType;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;

import static com.jayway.restassured.RestAssured.delete;
import static com.jayway.restassured.RestAssured.given;

/**
 * Created by Konrad on 05.06.2016.
 */
public class DbUnitOwnerTest {

    private static IDatabaseConnection connection;
    private static IDatabaseTester databaseTester;

    private static OwnerManager om = new OwnerManager();

    @BeforeClass
    public static void setUp() throws Exception{
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;
        RestAssured.basePath = "/restproject/api";

        Connection jdbcConnection;
        jdbcConnection = DriverManager.getConnection(
                "jdbc:hsqldb:hsql://localhost/buildingdb", "sa", "");
        connection = new DatabaseConnection(jdbcConnection);

        databaseTester = new JdbcDatabaseTester(
                "org.hsqldb.jdbcDriver", "jdbc:hsqldb:hsql://localhost/buildingdb", "sa", "");
        IDataSet dataSet = new FlatXmlDataSetBuilder().build(
                new FileInputStream(new File("src/test/resources/fullData.xml")));
        databaseTester.setDataSet(dataSet);
        databaseTester.onSetup();
    }

    @Test
    public void addOwner() throws Exception{

        Owner owner = new Owner("Adrian", 2010);
        given().contentType(MediaType.APPLICATION_JSON).body(owner)
                .when().post("/owner/").then().assertThat().statusCode(201);

        IDataSet dbDataSet = connection.createDataSet();
        ITable actualTable = dbDataSet.getTable("OWNER");
        ITable filteredTable = DefaultColumnFilter.excludedColumnsTable
                (actualTable, new String[]{"ID"});

        IDataSet expectedDataSet = new FlatXmlDataSetBuilder().build(
                new File("src/test/resources/ownerData.xml"));
        ITable expectedTable = expectedDataSet.getTable("OWNER");

        Assertion.assertEquals(expectedTable, filteredTable);
    }
    @Test
    public void deleteOwner() throws Exception{

        delete("/owner/3").then().assertThat().statusCode(200);

        IDataSet dbDataSet = connection.createDataSet();
        ITable actualTable = dbDataSet.getTable("OWNER");
        ITable filteredTable = DefaultColumnFilter.excludedColumnsTable
                (actualTable, new String[]{"ID"});

        IDataSet expectedDataSet = new FlatXmlDataSetBuilder().build(
                new File("src/test/resources/ownerDeleteData.xml"));
        ITable expectedTable = expectedDataSet.getTable("OWNER");

        Assertion.assertEquals(expectedTable, filteredTable);
    }

    @AfterClass
    public static void tearDown() throws Exception{
        databaseTester.onTearDown();
    }

}
