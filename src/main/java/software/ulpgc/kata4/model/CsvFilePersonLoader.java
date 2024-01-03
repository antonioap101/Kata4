package software.ulpgc.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.util.Collections.emptyList;

public class CsvFilePersonLoader implements PersonLoader{
    private final File file;

    private CsvFilePersonLoader(File file) {
        this.file = file;
    }

    public static PersonLoader with(String file){return new CsvFilePersonLoader(new File(file));}


    @Override
    public List<Person> load() {
        try {
            return load(new BufferedReader(new FileReader(file)));
        } catch (FileNotFoundException e) {
            return emptyList();
        }
    }

    private List<Person> load(BufferedReader bufferedReader) {
        return bufferedReader.lines()
                .skip(1)
                .map(this::toPerson)
                .collect(Collectors.toList());
    }

    private Person toPerson(String s) {
        return toPerson(s.split(","));
    }

    private Person toPerson(String[] split) {
        return new Person(split[0],
                parseDouble(split[1]),
                parseInt(split[2]),
                parseDouble(split[3])
        );
    }
}
