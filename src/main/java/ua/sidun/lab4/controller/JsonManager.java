package ua.sidun.lab4.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import ua.sidun.lab4.model.University;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Запис університету у формат JSON, збереження у файл, зчитування з файлу та відновлення об'єкта з
 * тексту JSON.
 */
public class JsonManager {

    private final ObjectMapper mapper =
            new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);

    public String toJson(University university) throws IOException {
        return mapper.writeValueAsString(university);
    }

    public University fromJson(String json) throws IOException {
        return mapper.readValue(json, University.class);
    }

    public void writeToFile(University university, Path file) throws IOException {
        Files.writeString(file, toJson(university), StandardCharsets.UTF_8);
    }

    public University readFromFile(Path file) throws IOException {
        return fromJson(Files.readString(file, StandardCharsets.UTF_8));
    }
}
