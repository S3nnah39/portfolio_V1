package com.google.sps.servlets;

import com.google.api.gax.rpc.DataLossException;
import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.FullEntity;
import com.google.cloud.datastore.KeyFactory;
import java.io.IOException;
import java.util.Date;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** Servlet responsible for creating new tasks. */
@WebServlet("/contactMe")
public class ContactMeServlet extends HttpServlet {

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
    
    //Get data from contact me form
    String userName = request.getParameter("FLname");
    String userEmail = request.getParameter("emailInfo");
    String userSMS = request.getParameter("message");
    String userDate = String.valueOf(new Date().getMonth()) + '\\' + String.valueOf(new Date().getDay()) + "\\" + String.valueOf(new Date().getYear());

    //create Instance
    Datastore datastore = DatastoreOptions.getDefaultInstance().getService();

    KeyFactory keyFactory = datastore.newKeyFactory().setKind("contact");
    FullEntity taskEntity =
        Entity.newBuilder(keyFactory.newKey())
            .set("name", userName)
            .set("email", userEmail) 
            .set("timestamp", userDate)
            .set("message", userSMS)
            .build();

    datastore.put(taskEntity);

    // Return to the index page
    response.sendRedirect("/index.html");
  }
}
