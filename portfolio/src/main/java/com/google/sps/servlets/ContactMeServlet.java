package com.google.sps.servlets;

import com.google.api.gax.rpc.DataLossException;
import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.FullEntity;
import com.google.cloud.datastore.KeyFactory;
import java.io.IOException;
import java.util.Date;
import java.util.Calendar;
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
    Date date = new Date();
    Calendar cal = Calendar.getInstance();
    cal.setTime(date);
    String userDate = String.valueOf(cal.get(Calendar.MONTH)) + '\\' + String.valueOf(cal.get(Calendar.DAY_OF_MONTH)) + "\\" + String.valueOf(cal.get(Calendar.YEAR));

    //create Instance
    Datastore datastore = DatastoreOptions.getDefaultInstance().getService();

    KeyFactory keyFactory = datastore.newKeyFactory().setKind("Contact");
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
