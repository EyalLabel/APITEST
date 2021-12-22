package SQL;

import java.sql.SQLException;

public class DataBaseManager {
    //connection
    public static final String URL = "jdbc:mysql://localhost:3306?createDatabaseIfNotExist=FALSE";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "2^VxV%^w^7ccJG64qcQ";
    //create and drop DB
    private static final String CREATE_DB = "CREATE SCHEMA if not exists memoSystem ";
    private static final String DROP_DB = "DROP memoSystem";
    //create and drop tables
    private static final String CREATE_TABLE = "CREATE TABLE if not exists `memoSystem`.`memos`(`id` INT NOT NULL AUTO_INCREMENT,`description` VARCHAR(250) NOT NULL,`important` BOOL NOT NULL,`shown` BOOLEAN NOT NULL,`memoDate` DATETIME NOT NULL,PRIMARY KEY(`id`))";
    private static final String DROP_TABLE = "DROP `memoSystem`.`memos`";

    public static void createDataBase() {
        try {
            DButils.runQuery(CREATE_DB);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void createTables() {
        try {
            DButils.runQuery(CREATE_TABLE);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void dropTables() {
        try {
            DButils.runQuery(DROP_TABLE);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void dropDataBase() {
        try {
            DButils.runQuery(DROP_DB);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}

