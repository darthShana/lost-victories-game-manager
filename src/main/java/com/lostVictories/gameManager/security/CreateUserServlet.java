package com.lostVictories.gameManager.security;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lostVictories.gameManager.dao.UserDAO;
import com.lostVictories.gameManager.model.User;
import com.lostVictories.gameManager.model.query.QUser;
import io.ebean.Ebean;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.mindrot.jbcrypt.BCrypt;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;


public class CreateUserServlet extends DefaultServlet {

    @Inject
    UserDAO userDAO;
    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String data;
        StringBuilder builder = new StringBuilder();
        BufferedReader reader = request.getReader();
        String line;
        while ((line = reader.readLine()) != null) {
            builder.append(line);
        }
        data = builder.toString();
        JsonNode jsonNode = objectMapper.readTree(data);

        if(userDAO.getByUsername(jsonNode.get("username").asText())!=null || userDAO.getByEmail(jsonNode.get("email").asText())!=null){
            response.sendError(400, "invalid request");
            return;
        }
        userDAO.createUser(
                jsonNode.get("username").asText(),
                BCrypt.hashpw(jsonNode.get("password").asText(), BCrypt.gensalt()),
                jsonNode.get("firstName").asText(),
                jsonNode.get("lastName").asText(),
                jsonNode.get("email").asText());
    }



}
