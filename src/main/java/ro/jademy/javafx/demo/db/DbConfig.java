package ro.jademy.javafx.demo.db;

public class DbConfig {

    protected String dbHost = "localhost";
    protected String dbPort = "3306";
    protected String dbUser = "root";
    protected String dbPass = "password";
    protected String dbName = "todo";

    //Table name
    public static final String USERS_TABLE="users";

    //Column names
    //USERS
    public static final String USERS_ID="userid";
    public static final String USERS_FIRSTNAME="firstname";
    public static final String USERS_LASTNAME="lastname";
    public static final String USERS_USERNAME="username";
    public static final String USERS_PASSWORD="password";

}
