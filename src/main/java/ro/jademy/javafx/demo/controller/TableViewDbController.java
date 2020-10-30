package ro.jademy.javafx.demo.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import ro.jademy.javafx.demo.db.DbConfig;
import ro.jademy.javafx.demo.db.DbHandler;
import ro.jademy.javafx.demo.model.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TableViewDbController {

    private ObservableList<User> userObservableList = FXCollections.observableArrayList();

    @FXML
    private TableView<User> userTableView;
    @FXML
    private TableColumn<User, String> colFirstName;
    @FXML
    private TableColumn<User, String> colLastName;
    @FXML
    private TableColumn<User, String> colUserName;
    @FXML
    private TableColumn<User, String> colPassword;



    @FXML
    void initialize() {

        colFirstName.setCellValueFactory(features -> features.getValue().firstNameColumn);
        colLastName.setCellValueFactory(features -> features.getValue().lastNameColumn);
        colUserName.setCellValueFactory(features -> features.getValue().userNameColumn);
        colPassword.setCellValueFactory(features -> features.getValue().passwordColumn);

        DbHandler dbHandler = new DbHandler();
        try {
            dbHandler.getDbConnection();
            buildData();
        } catch (SQLException | ClassNotFoundException ce) {
        }
    }

    public void buildData() {

        DbHandler dbHandler = new DbHandler();
        String query = "SELECT * FROM " + DbConfig.USERS_TABLE;

        try {
            PreparedStatement prepStatement = dbHandler.getDbConnection().prepareStatement(query);
            ResultSet rs = prepStatement.executeQuery();

            while (rs.next()) {
                User user = new User();
                user.firstNameColumn.set(rs.getString("firstname"));
                user.lastNameColumn.set(rs.getString("lastname"));
                user.userNameColumn.set(rs.getString("username"));
                user.passwordColumn.set(rs.getString("password"));

                userObservableList.add(user);
            }
            userTableView.setItems(userObservableList);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error on Building Data");
        }
    }

 }
