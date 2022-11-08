package com.think.factories.indicators;

import com.github.javafaker.Faker;
import com.think.factories.events.EventsFactory;
import com.think.models.indicators.variables.Variable;
import com.think.utils.GetDate;
import lombok.SneakyThrows;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import static io.restassured.path.json.JsonPath.from;

public class VariablesFactory {

    private static final String VARIABLES_PATH = "json/variables.json";

    public static Variable getVariableByKey(String key) {
        String random = Faker.instance().random().nextInt(100, 9999).toString();
        Variable variable = getVariableWithKey(key);
        variable.setName(variable.getName().concat(" ").concat(random));
        variable.setInitialDate(GetDate.oneYearAgo());
        return variable;
    }

    @SneakyThrows
    private static Variable getVariableWithKey(String key) {
        return getEvents().stream()
                .filter(a -> a.getKey()
                        .equals(key))
                .findFirst()
                .orElseThrow(() ->
                        new RuntimeException(String.format("Variable with key %s not found", key)));
    }

    @SneakyThrows
    private static List<Variable> getEvents() {
        return Arrays.asList(from(getVariablesFile()).getObject("variables", Variable[].class));
    }

    @SneakyThrows
    private static URL getVariablesFile() {
        String path = VARIABLES_PATH;
        URL filePath = EventsFactory.class.getClassLoader().getResource(path);
        if (filePath == null) {
            throw new FileNotFoundException("File not found for variables: " + path);
        }
        return filePath;
    }
}
