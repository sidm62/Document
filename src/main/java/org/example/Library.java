package org.example;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Library {

    private final Map<String, DocumentInter> documents = new HashMap<>();

    public void addUnprotected(String id, String content) {
        Document doc = new Document(id, LocalDate.now(), content);
        documents.put(id, doc);
    }
    public void addProtected(String id, String content) {
        Document realdoc = new Document(id, LocalDate.now(), content);
        DocumentProxy proxy = new DocumentProxy(realdoc);
        documents.put(id, proxy);
    }
    public DocumentInter getDocument(String id) {
        return documents.get(id);
    }
}
