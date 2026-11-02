package org.example;

import java.time.LocalDate;

public class Document implements DocumentInter {
    private final String id;
    private final LocalDate date;
    private final String content;

    public Document(String id, LocalDate date, String content) {
        this.id = id;
        this.date = date;
        this.content = content;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public LocalDate getDate() {
        return date;
    }

    @Override
    public String getContent(User user) {
        return content;
    }

}
