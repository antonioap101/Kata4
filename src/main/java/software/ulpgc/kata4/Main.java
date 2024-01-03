package software.ulpgc;

import software.ulpgc.model.BMIHistogramCalculator;
import software.ulpgc.model.CsvFilePersonLoader;
import software.ulpgc.model.Person;
import software.ulpgc.view.MainFrame;

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