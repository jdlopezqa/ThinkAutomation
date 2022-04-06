package com.think.factories;

import com.think.models.ThinkActor;
import lombok.SneakyThrows;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import static io.restassured.path.json.JsonPath.from;

public class ThinkActorFactory {

    private static final String ACTORS_PATH = "json/think-actors.json";

    @SneakyThrows
    private static List<ThinkActor> getActors() {
        return Arrays.asList(from(getActorsFile()).getObject("actors", ThinkActor[].class));
    }

    @SneakyThrows
    public static ThinkActor getActorByUsername(String userName) {
        return getActors().stream()
                .filter(a -> a.getName()
                        .equals(userName))
                .findFirst()
                .orElseThrow(() ->
                        new RuntimeException(String.format("actor with name %s not found", userName)));
    }

    @SneakyThrows
    private static URL getActorsFile() {
        String path = ACTORS_PATH;
        URL filePath = ThinkActorFactory.class.getClassLoader().getResource(path);
        if (filePath == null) {
            throw new FileNotFoundException("File not found for actors: " + path);
        }
        return filePath;
    }
}
