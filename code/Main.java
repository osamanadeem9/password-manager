package sample;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.util.Optional;
import java.util.Scanner;

public class Main extends Application {
    Stage stage;

    Scene loginScene;
    Text logLabel0, logLabel1, logLabel2;
    TextField logTextField1; PasswordField logTextField2;
    Button loginB1, loginB2;

    Scene forgetScene;
    Text forgetLabel0, forgetLabel1, forgetLabel2, forgetLabel3;
    TextField forgetTextField1; PasswordField forgetTextField2, forgetTextField3;
    Button forgetB1;
    String newname="nust", newpass="1234";

    Scene genScene1, genScene2, genScene3;
    Button genB0, genB1, genB2, genB3, genB4;
    Button genB5;
    Button genB6, genB7, genB8, genB9;
    Text genLabel0,genLabel1, genLabel2;
    Text genLabel3;
    Text genLabel4;
    TextField genTextField;
    RadioButton r1, r2, r3, r4, r5;
    ToggleGroup radioGroup;
    Strings passwordDisplayed;

    Scene enScene1;
    Text enLabel1;
    TextField enTextField;
    Button enB1, enB2;
    Text enLabel2;
    Cipher caesar;

    Scene deScene1;
    Text deLabel1;
    TextField deTextField;
    Button deB1, deB2;
    Text deLabel2;

    Scene saveScene1;
    Text saveLabel1;
    TableView table;
    Button saveB1, saveB2;


    private Button returnbutton1, returnbutton2, returnbutton3, returnbutton4;


    @Override
    public void start(Stage primaryStage) {


        stage = primaryStage;
        stage.setTitle("KeyCode Manager");

        returnbutton1 = new Button("Return to Main");
        returnbutton2 = new Button("Return to Main");
        returnbutton3 = new Button("Return to Main");
        returnbutton4 = new Button("Return to Main");
        returnbutton1.setOnAction(event -> stage.setScene(genScene1));
        returnbutton2.setOnAction(event -> stage.setScene(genScene1));
        returnbutton3.setOnAction(event -> stage.setScene(genScene1));

        GridPane layout1 = new GridPane();
        layout1.setHgap(10); layout1.setVgap(10);


        logLabel0 = new Text("Login Information");
        logLabel0.setFont(new Font(15));
        logLabel1 = new Text("Username: ");
        logTextField1 = new TextField();
        logTextField1.setMaxWidth(90);
        logLabel2 = new Text("Password: ");
        logTextField2 = new PasswordField();
        logTextField2.setMaxWidth(90);

        loginB1 = new Button("Login");
        loginB2 = new Button("Change Password");


        layout1.add(logLabel0, 4,1);
        layout1.add(logLabel1, 2, 4);
        layout1.add(logTextField1, 4,4);
        layout1.add(logLabel2,2,6);
        layout1.add(logTextField2, 4,6);

        layout1.add(loginB1, 4,10);
        layout1.add(loginB2,5,10);


        loginB1.setOnAction(event -> {
            if (!logTextField1.getText().isEmpty() || !logTextField2.getText().isEmpty()) {
                if (logTextField1.getText().equals(newname) && logTextField2.getText().equals(newpass)) {
                    stage.setScene(genScene1);
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Wrong Username or Password");
                    alert.showAndWait();
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setContentText("Username or Password Missing");
                alert.showAndWait();
            }
        });
        loginB2.setOnAction(event -> stage.setScene(forgetScene));

        loginScene = new Scene(layout1, 350, 240);

        GridPane layout2 = new GridPane();
        layout2.setVgap(10); layout2.setHgap(10);
        forgetLabel0 = new Text("Change Password");
        forgetLabel0.setFont(new Font(15));
        forgetLabel1 = new Text("Username: ");
        forgetTextField1 = new TextField();
        forgetTextField1.setMaxWidth(90);
        forgetLabel2 = new Text("Old Password");
        forgetTextField2 =new PasswordField();
        forgetTextField2.setMaxWidth(90);
        forgetLabel3 = new Text("New Password: ");
        forgetTextField3 = new PasswordField();
        forgetTextField3.setMaxWidth(90);


        forgetB1 = new Button("Change Password");
        layout2.add(forgetLabel0, 4,1);
        layout2.add(forgetLabel1, 2, 4);
        layout2.add(forgetTextField1, 4,4);
        layout2.add(forgetLabel2,2,5);
        layout2.add(forgetTextField2, 4,5);
        layout2.add(forgetLabel3, 2, 6);
        layout2.add(forgetTextField3, 4,6);

        layout2.add(forgetB1, 4,10);


        forgetB1.setOnAction(event -> {
            if (!forgetTextField1.getText().isEmpty() && !forgetTextField2.getText().isEmpty()) {
                if (forgetTextField2.getText().equals(newpass)) {
                    newname = forgetTextField1.getText();
                    newpass = forgetTextField3.getText();
                    stage.setScene(loginScene);
                } else {

                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Wrong old password");
                    alert.showAndWait();
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Fields Missing");
                alert.showAndWait();
            }
        });
        forgetScene = new Scene(layout2, 350, 240);

        Pane layout3 = new Pane();
        genLabel0 = new Text("KeyCode Manager");
        genLabel0.setFont(Font.font(30));
        genLabel0.setLayoutX(10); genLabel0.setLayoutY(50);
        genB1 = new Button("Generate Password");
        genB1.setLayoutX(200);
        genB1.setLayoutY(150);
        genB2 = new Button("Encrypt Password");
        genB2.setLayoutX(200);
        genB2.setLayoutY(200);
        genB3 = new Button("Decrypt Password");
        genB3.setLayoutX(200);
        genB3.setLayoutY(250);
        genB4 = new Button("View Saved Passwords");
        genB4.setLayoutX(200);
        genB4.setLayoutY(300);
        genB0 = new Button("Log Out");
        genB0.setLayoutX(200); genB0.setLayoutY(350);

        genB0.setOnAction(event -> stage.setScene(loginScene));
        genB1.setOnAction(event -> stage.setScene(genScene2));
        layout3.getChildren().addAll(genLabel0,genB1, genB2, genB3, genB4, genB0);
        //layout1.setAlignment(Pos.CENTER);

        genScene1 = new Scene(layout3, 500, 500);

        VBox layout4 = new VBox(30);
        genLabel1 = new Text("Enter the password length to generate");
        genB5 = new Button("Next");

        genTextField = new TextField();
        genTextField.setMaxWidth(50);

        layout4.getChildren().addAll(genLabel1, genTextField, genB5);
        genB5.setOnAction(event -> {
            Scanner sc = new Scanner(genTextField.getText());
            boolean valid = sc.hasNextInt();
            if (valid == true){
                stage.setScene(genScene3);
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Invalid value entered");
                alert.showAndWait();
            }

        });
        layout4.setAlignment(Pos.CENTER);

        genScene2 = new Scene(layout4, 500, 500);

        GridPane layout5 = new GridPane();
        layout5.setHgap(10); layout5.setVgap(10);

        genLabel2 = new Text("Select the type of password to generate");
        genLabel2.setFont(Font.font(17));
        genLabel3 = new Text();
        genLabel3.setFont(Font.font(20));
        genLabel3.setWrappingWidth(200);
        genLabel4 = new Text();
        genLabel4.setFont(new Font(15));
        genLabel4.setWrappingWidth(200);
        genB6 = new Button("Generate Password");
        genB7 = new Button("Copy Password");
        genB7.setVisible(false);
        genB8 = new Button("Save Password");
        genB8.setVisible(false);
        genB9= new Button("Back");
        radioGroup = new ToggleGroup();

        r1 = new RadioButton("Numeric Password");
        r1.setToggleGroup(radioGroup);

        r2 = new RadioButton("Alpha Password");
        r2.setToggleGroup(radioGroup);
        r3 = new RadioButton("Alphanumeric Password");
        r3.setToggleGroup(radioGroup);
        r4 = new RadioButton("Alphanumeric Password with special characters");
        r4.setToggleGroup(radioGroup);

        passwordDisplayed = new Strings();


        radioGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue) {
                if (radioGroup.getSelectedToggle() != null) {

                    if ((radioGroup.getSelectedToggle()) == r1) {
                        passwordDisplayed.setMaxlength(Integer.parseInt(genTextField.getText()));
                        passwordDisplayed.setCharlist("123456789");

                    } else if ((radioGroup.getSelectedToggle()) == r2) {
                        passwordDisplayed.setMaxlength(Integer.parseInt(genTextField.getText()));
                        passwordDisplayed.setCharlist("abcdefghijklmnopqrstuvwxyz");

                    } else if ((radioGroup.getSelectedToggle()) == r3) {
                        passwordDisplayed.setMaxlength(Integer.parseInt(genTextField.getText()));
                        passwordDisplayed.setCharlist("abcdefghijklmnopqrstuvwxyz123456789");

                    } else if ((radioGroup.getSelectedToggle()) == r4) {
                        passwordDisplayed.setMaxlength(Integer.parseInt(genTextField.getText()));
                        passwordDisplayed.setCharlist("abcdefghijklmnopqrstuvwxyz123456789.@&.@&.@&.@&");

                    }
                }
            }
        });
        genB6.setOnAction(event -> {
            int seconds = 31557600;
            String strength;
            int passlength = Integer.parseInt(genTextField.getText());
            double time1=0, time2=0;
            double password=0;
            double combinations=0;
            genLabel3.setText(passwordDisplayed.generateRandomString());
            genB7.setVisible(true);
            genB8.setVisible(true);
            TimeEstimator t = new TimeEstimator();
            if (radioGroup.getSelectedToggle()==r1){
                combinations = t.estimator_numeric(genLabel3.getText(), Integer.parseInt(genTextField.getText()));

                time1 = combinations / 2500 / seconds;
                time2 = combinations / 4500 / seconds;

            }
            if (radioGroup.getSelectedToggle()==r2){
                combinations = t.estimator_alpha(genLabel3.getText(), Integer.parseInt(genTextField.getText()));
                time1 = combinations / 2500 / seconds;
                time2 = combinations / 4500 / seconds;


            }
            if (radioGroup.getSelectedToggle()==r3){
                combinations = t.estimator_alphaNumeric(genLabel3.getText(), Integer.parseInt(genTextField.getText()));
                time1 = combinations/2500/seconds;
                time2 = combinations/4500/seconds;


            }
            if (radioGroup.getSelectedToggle()==r4){
                combinations = t.estimator_alphaNumericAndSpecial(genLabel3.getText(), Integer.parseInt(genTextField.getText()));
                time1 = combinations/2500/seconds;
                time2 = combinations/4500/seconds;

            }
            if (time1>100){
                genLabel4.setText(String.format("This password will take infinite time to crack on an average computer"));
            }else {
                genLabel4.setText(String.format("This password will take atmost %.4f - %.4f years to crack on an average computer", time2, time1));
            }
        });

        genB7.setOnAction(event -> {
            String password = genLabel3.getText();

            Toolkit toolkit = Toolkit.getDefaultToolkit();
            Clipboard clipboard = toolkit.getSystemClipboard();
            StringSelection passCopy = new StringSelection(password);
            clipboard.setContents(passCopy, null);
        });
        genB8.setOnAction(event -> {
            TextInputDialog dialog = new TextInputDialog();
            dialog.setTitle("Notes");
            dialog.setHeaderText("Enter a name for your password for identification later");
            dialog.setContentText("Enter name: ");

            Optional<String> res = dialog.showAndWait();
            if (res.isPresent()) {
                SavedPassword pass = new SavedPassword(res.get(), genLabel3.getText());
                table.getItems().add(pass);
            }


        });
        genB9.setOnAction(event -> stage.setScene(genScene2));
        layout5.add(genLabel2, 1, 2);
        layout5.add(genLabel4, 1,3);

        layout5.add(r1, 3, 10);
        layout5.add(r2, 3, 13);
        layout5.add(r3, 3, 16);
        layout5.add(r4, 3, 19);
        layout5.add(genB6, 1, 23);
        layout5.add(genLabel3, 3, 25);
        layout5.add(genB7,  5, 25);
        layout5.add(genB8, 3, 27);
        layout5.add(genB9, 1,30);
        layout5.add(returnbutton1, 7, 30);
        genScene3 = new Scene(layout5, 900, 600);



            genB2.setOnAction(event -> stage.setScene(enScene1));
            VBox layout6 = new VBox(30);
            enLabel1 = new Text("Enter the password you want to encrypt");
            enTextField = new TextField();
            enLabel2 = new Text();
            enB1 = new Button("Encrypt");
            enB2= new Button("Save Password");
            enB2.setVisible(false);

            enTextField.setMaxWidth(200);

            enB1.setOnAction(event -> {
                caesar = new Cipher();
                String encrypted = caesar.encrypt(enTextField.getText().toCharArray(), 20);
                enLabel2.setText(encrypted);
                returnbutton2.setVisible(true);
                enLabel2.setFont(Font.font(20));
                enB2.setVisible(true);
            });

            enB2.setOnAction(event -> {
                TextInputDialog dialog = new TextInputDialog();
                dialog.setTitle("Notes");
                dialog.setHeaderText("Enter a name for your password for identification later");
                dialog.setContentText("Enter name: ");

                Optional<String>res = dialog.showAndWait();
                if (res.isPresent()){
                    SavedPassword pass = new SavedPassword(res.get(), enLabel2.getText());
                    table.getItems().add(pass);
                }


            });
            layout6.getChildren().addAll(enLabel1, enTextField, enB1, enLabel2, enB2,returnbutton2);
            layout6.setAlignment(Pos.CENTER);
            enScene1 = new Scene(layout6, 500, 500);


            genB3.setOnAction(event -> stage.setScene(deScene1));
            deLabel1 = new Text("Enter the password you want to decrypt");
            deB1 = new Button("Decrypt");
            deB2 = new Button("Save Password");
            deB2.setVisible(false);
            deTextField = new TextField();
            deTextField.setMaxWidth(200);
            deLabel2 = new Text();
            deLabel2.setFont(Font.font(20));


            VBox deLayout1 = new VBox(30);
            deLayout1.getChildren().addAll(deLabel1, deTextField, deB1, deLabel2, deB2, returnbutton3);
            deLayout1.setAlignment(Pos.CENTER);

            deB1.setOnAction(event -> {
                caesar = new Cipher();
                String decrypted = caesar.decrypt(deTextField.getText().toCharArray(), 20);
                deLabel2.setText(decrypted);
                deLabel2.setFont(Font.font(20));
                deB2.setVisible(true);

            });
            deB2.setOnAction(event -> {
                TextInputDialog dialog = new TextInputDialog();
                dialog.setTitle("Notes");
                dialog.setHeaderText("Enter a name for your password for identification later");
                dialog.setContentText("Enter name: ");

                Optional<String>res = dialog.showAndWait();
                if (res.isPresent()){
                    SavedPassword pass = new SavedPassword(res.get(), deLabel2.getText());
                    table.getItems().add(pass);
                }

            });


            deScene1 = new Scene(deLayout1, 500, 500);


            genB4.setOnAction(event -> stage.setScene(saveScene1));

            Pane layout7 = new Pane();

            saveLabel1 = new Text("Saved Passwords");
            saveLabel1.setFont(new Font(20));
            saveLabel1.setLayoutX(10); saveLabel1.setLayoutY(20);
            saveB1 = new Button("Copy");
            saveB1.setVisible(false);
            saveB1.setLayoutX(430); saveB1.setLayoutY(90);
            saveB2 = new Button ("Delete");
            saveB2.setLayoutX(430); saveB2.setLayoutY(120);
            saveB2.setVisible(false);
            table = new TableView();
            table.setLayoutX(60); table.setLayoutY(60);
            table.setMaxHeight(350);
            TableColumn names = new TableColumn("Name");
            names.setCellValueFactory(new PropertyValueFactory<>("name"));
            names.setMinWidth(150);
            TableColumn pass = new TableColumn("Password");
            pass.setCellValueFactory(new PropertyValueFactory<>("password"));
            pass.setMinWidth(200);
            table.getColumns().addAll(names,pass);

            table.getSelectionModel().clearSelection();
            table.setOnMouseClicked(event -> {
                String selectedPassword = null;
                if (event.getClickCount()>1){
                    if(table.getSelectionModel().getSelectedItem()!=null){
                        SavedPassword passed = (SavedPassword) table.getSelectionModel().getSelectedItem();
                        selectedPassword=passed.getPassword();
                        saveB1.setVisible(true);
                        saveB2.setVisible(true);
                    }
                    String finalSelectedPassword = selectedPassword;
                    saveB1.setOnAction(event1 -> {
                        Toolkit toolkit = Toolkit.getDefaultToolkit();
                        Clipboard clipboard = toolkit.getSystemClipboard();
                        String pa= finalSelectedPassword;
                        StringSelection passCopy = new StringSelection(pa);
                        clipboard.setContents(passCopy, null);
                    });
                    saveB2.setOnAction(event1 -> {
                        SavedPassword passed = (SavedPassword)table.getSelectionModel().getSelectedItem();
                        table.getItems().remove(passed);

                    });

                }
            });

            returnbutton4.setLayoutX(390); returnbutton4.setLayoutY(470);
            returnbutton4.setOnAction(event -> stage.setScene(genScene1));
            layout7.getChildren().addAll(saveLabel1,table,saveB1, saveB2,returnbutton4);
            saveScene1 = new Scene(layout7,500,500);

            stage.setScene(loginScene);
            stage.show();
        }



        public static void main (String[]args){

            launch(args);
        }
    }
