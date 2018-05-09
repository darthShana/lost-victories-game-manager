package com.lostVictories.gameManager.service;


import com.lostVictories.gameManager.dao.UserDAO;
import com.lostVictories.gameManager.model.User;
import com.lostVictories.gameManager.security.BCryptCredential;
import org.eclipse.jetty.security.AbstractLoginService;

import javax.inject.Inject;
import java.util.stream.Collectors;

public class GameLoginService extends AbstractLoginService {

    @Inject
    UserDAO userDAO;

    @Override
    protected String[] loadRoleInfo(UserPrincipal userPrincipal) {
        return userDAO.getByUsername(userPrincipal.getName()).getRoles().stream()
                .map(r->r.getRoleName())
                .collect(Collectors.toSet()).toArray(new String[]{});
    }

    @Override
    protected UserPrincipal loadUserInfo(String s) {
        System.out.println("requesting user info for:"+s);
        User byUsername = userDAO.getByUsername(s);
        System.out.println("found:"+byUsername.getEmail());
        return new UserPrincipal(byUsername.getUsername(), new BCryptCredential(byUsername.getPassword()));
    }
}
