package com.think.factories.events;

import com.github.javafaker.Faker;
import com.think.models.events.Event;

import lombok.SneakyThrows;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import static io.restassured.path.json.JsonPath.from;

public class EventsFactory {

    private static final String EVENTS_PATH = "json/events.json";

    public static Event getEventByType(String type) {
        String random = Faker.instance().random().nextInt(100, 999).toString();
        Event event = getEventWithType(type);
        event.setSubject(event.getSubject() + random);
        event.setDescription(event.getDescription() + random);
        return event;
    }

    @SneakyThrows
    private static Event getEventWithType(String type) {
        return getEvents().stream()
                .filter(a -> a.getType()
                        .equals(type))
                .findFirst()
                .orElseThrow(() ->
                        new RuntimeException(String.format("Events with type %s not found", type)));
    }

    @SneakyThrows
    private static List<Event> getEvents() {
        return Arrays.asList(from(getEventsFile()).getObject("events", Event[].class));
    }

    @SneakyThrows
    private static URL getEventsFile() {
        String path = EVENTS_PATH;
        URL filePath = EventsFactory.class.getClassLoader().getResource(path);
        if (filePath == null) {
            throw new FileNotFoundException("File not found for events: " + path);
        }
        return filePath;
    }
}
