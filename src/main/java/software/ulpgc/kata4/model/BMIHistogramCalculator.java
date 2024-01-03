package software.ulpgc.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BMIHistogramCalculator implements HistogramCalculator{
    private static final int BIN_SIZE = 5;
    private final List<Person> people;

    public BMIHistogramCalculator(List<Person> people) {
        this.people = people;
    }

    @Override
    public Map<String, Integer> calculate() {
        HashMap<String, Integer> result = new HashMap<>();
        for(Person p: people){
            String key = toBin(p.bmi());
            result.put(key, result.getOrDefault(key,0)+1);
        }
        return result;
    }

    private String toBin(double bmi) {
        return low(bmi) + "-" + high(bmi);
    }

    private int high(double bmi) {
        return low(bmi) + BIN_SIZE;
    }

    private int low(double bmi) {
        return (int) (bmi/BIN_SIZE)*BIN_SIZE;
    }
}
