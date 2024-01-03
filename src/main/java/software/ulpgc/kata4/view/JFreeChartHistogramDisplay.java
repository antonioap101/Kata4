package software.ulpgc.view;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.Map;

public class JFreeChartHistogramDisplay extends JPanel implements HistogramDisplay {

    public JFreeChartHistogramDisplay() {
        setLayout(new BorderLayout());
    }

    @Override
    public void show(Map<String, Integer> histogram) {
        add(new ChartPanel(barChart(histogram)));
    }

    private JFreeChart barChart(Map<String, Integer> histogram) {
        return ChartFactory.createBarChart(
                "BMI Histogram",
                "BMI-Range",
                "count",
                datasetWith(histogram),
                PlotOrientation.VERTICAL,
                true,
                false,
                false
        );
    }

    private CategoryDataset datasetWith(Map<String, Integer> histogram) {
        DefaultCategoryDataset categoryDataset = new DefaultCategoryDataset();
        for (String range: histogram.keySet().stream().sorted().toList()){
            categoryDataset.addValue(histogram.get(range), "BMI", range);
        }
        return categoryDataset;
    }
}
