package org.example;

import java.util.HashSet;
import java.util.Set;

public class AccessControlService {
    private static AccessControlService instance;

    private final Set<String> permission = new HashSet();

    private AccessControlService() {}

    public static synchronized AccessControlService getInstance() {
        if (instance == null) {
            instance = new AccessControlService();
        }
        return instance;
    }
    public void grantAccess(String username, String documentId) {
        permission.add(username + ":" + documentId);
    }
    public boolean isAllowed(String username, String documentId) {
        return permission.contains(username + ":" + documentId);
    }
}
