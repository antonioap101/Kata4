package software.ulpgc.kata4;


import software.ulpgc.kata4.model.BMIHistogramCalculator;
import software.ulpgc.kata4.model.Person;
import software.ulpgc.kata4.model.SQLitePersonLoader;
import software.ulpgc.kata4.view.MainFrame;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:sqlite:src/main/resources/bmi_data.db");
        List<Person> people = SQLitePersonLoader.with(connection).load();
        Map<String, Integer> histogram = new BMIHistogramCalculator(people).calculate();
        MainFrame mainFrame = new MainFrame();
        mainFrame.getHistogramDisplay().show(histogram);
        mainFrame.setVisible(true);
    }
}