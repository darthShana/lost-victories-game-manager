package com.lostVictories.gameManager.dao;

import com.lostVictories.gameManager.model.User;
import com.lostVictories.gameManager.model.query.QRole;
import com.lostVictories.gameManager.model.query.QUser;

import java.util.UUID;

public class UserDAO {

    public User getByUsername(String username) {
        return new QUser().username.eq(username).findOne();
    }

    public User getByEmail(String email) {
        return new QUser().email.eq(email).findOne();
    }

    public void createUser(String username, String password, String firstName, String lastName, String email) {
        User user = new User(UUID.randomUUID(), username, password, firstName, lastName, email);
        user.addRole(new QRole().roleName.eq("user").findOne());
        user.save();
    }

    public User getByID(UUID id) {
        return new QUser().id.eq(id).findOne();
    }
}
