package org.example;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        AccessControlService acs = AccessControlService.getInstance();

        User A = new User("A");
        User B = new User("B");

        library.addUnprotected("DOC-001","Public Announcement: Yes");
        library.addProtected("DOC-002","Public Announcement: No");

        acs.grantAccess("A","DOC-002");
        System.out.println("Unprotected Document Access");
        DocumentInter doc1 = library.getDocument("DOC-001");
        System.out.println("Document ID:" + doc1.getId());
        System.out.println("Creation Date" + doc1.getCreationDate());
        try {
            System.out.println("A views DOC-001"+ doc1.getContent(A));

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        System.out.println("Access Protected Document");
        DocumentInter doc2 = library.getDocument("DOC-002");
        System.out.println("Document ID: " + doc2.getId());
        System.out.println("Creation Date: " + doc2.getCreationDate());
        try {
            System.out.println("B views DOC-002"+ doc2.getContent(B));

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

}