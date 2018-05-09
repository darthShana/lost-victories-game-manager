package com.lostVictories.gameManager.security;

import org.eclipse.jetty.util.security.Credential;
import org.mindrot.jbcrypt.BCrypt;

public class BCryptCredential extends Credential {

    private String password;

    public BCryptCredential(String password) {
        this.password = password;
    }

    @Override
    public boolean check(Object o) {
        return BCrypt.checkpw(o.toString(), password);
    }
}
