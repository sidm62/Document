package org.example;


import java.time.LocalDate;
 interface DocumentInter {

    String getId();


     LocalDate getDate();


     String getContent(User user) throws AccessDeniedException;

}
