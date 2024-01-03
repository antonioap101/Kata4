package software.ulpgc.view;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private JFreeChartHistogramDisplay histogramDisplay;

    public MainFrame() throws HeadlessException {
        setTitle("Histogram");
        setSize(1000,800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(createHistogramDisplay());
    }

    private Component createHistogramDisplay() {
        histogramDisplay = new JFreeChartHistogramDisplay();
        return histogramDisplay;
    }

    public JFreeChartHistogramDisplay getHistogramDisplay() {
        return histogramDisplay;
    }
}
