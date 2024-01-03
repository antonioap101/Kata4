package software.ulpgc.kata4;


import software.ulpgc.kata4.model.BMIHistogramCalculator;
import software.ulpgc.kata4.model.CsvFilePersonLoader;
import software.ulpgc.kata4.model.Person;
import software.ulpgc.kata4.view.MainFrame;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<Person> people = CsvFilePersonLoader.with("src/main/resources/bmi_dataset.csv").load();
        Map<String, Integer> histogram = new BMIHistogramCalculator(people).calculate();
        MainFrame mainFrame = new MainFrame();
        mainFrame.getHistogramDisplay().show(histogram);
        mainFrame.setVisible(true);
    }
}