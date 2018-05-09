package com.lostVictories.gameManager.security;

import org.eclipse.jetty.servlet.DefaultServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends DefaultServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.getWriter().append("<html><form method='POST' action='/j_security_check'>"
                + "<input type='text' name='j_username'/>"
                + "<input type='password' name='j_password'/>"
                + "<input type='submit' value='Login'/></form></html>");
    }

}
