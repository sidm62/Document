package org.example;

import java.time.LocalDate;

public class DocumentProxy implements DocumentInter {

    private Document document;

    public DocumentProxy(Document document) {
        this.document = document;
    }

    @Override
    public String getId() {
        return document.getId();
    }

    @Override
    public LocalDate getCreationDate() {
        return document.getCreationDate();
    }

    @Override
    public String getContent(User user)  throws AccessDeniedEception {
        AccessControlService acs = AccessControlService.getInstance();

        if (acs.isAllowed(getId(), user.getUsername())) {
            return document.getContent(user);
        } else {
            System.out.println(
                    "Access Denied: User '" + user.getUsername() + "' does not have permission to view document '" + getId() + "'."
            );
            return null;
        }
    }
}
