package com.example.controller;

import Hashing.HashingEg;
import Service.UserService;
import model.User;

import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", urlPatterns = "/hello-servlet")
public class UserServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        doPost(request,response);




    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");


        PrintWriter printWriter = resp.getWriter();
        String page = req.getParameter("page");



        if(page.equals("old-user")){
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("Pages/login.jsp");
            requestDispatcher.forward(req, resp);
        } else if (page.equals("new-user")) {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.jsp");
            requestDispatcher.forward(req, resp);
        }


        // adding the user into database
        if(page.equals("register")){
            // user object ma set gareko variables
            User user = new User();

            user.setFullName(req.getParameter("fullname"));
            user.setUsername(req.getParameter("username"));
//            String username = req.getParameter("username");
            user.setPwd(HashingEg.hashPassword(req.getParameter("pwd")));

            new UserService().insertUser(user);


            RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.jsp");
            requestDispatcher.forward(req, resp);

        }



        // login into system
        if(page.equals("login")) {

            String username = req.getParameter("username");
            String pwd = HashingEg.hashPassword(req.getParameter("pwd"));

            User login_user = new UserService().getUser(username, pwd);

            if (login_user != null) {
                HttpSession session = req.getSession(true);
                session.setAttribute("id", login_user.getId());
                session.setAttribute("name", login_user.getFullName());

//
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("Pages/dashboard.jsp");
                requestDispatcher.forward(req, resp);

            }else {
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.jsp");
                requestDispatcher.include(req, resp);
            }

        }





//
//        if(userlist.equals("db_user")){
////            User user;
//            ArrayList list = new ArrayList();
//            list = (ArrayList) new UserService().getUserList();
//            System.out.println(list.size());
//
//        }



//
//        String link = req.getParameter("link");
//        System.out.println(link);
//
//        if(link.equals("dashboard")){
//            RequestDispatcher requestDispatcher = req.getRequestDispatcher("Pages/dashboard.jsp");
//            requestDispatcher.forward(req, resp);
//        } else if (link.equals("lists")) {
//            RequestDispatcher requestDispatcher = req.getRequestDispatcher("Pages/userlist.jsp");
//            requestDispatcher.forward(req, resp);
//        }




        if(page.equals("dashboard")){
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("Pages/dashboard.jsp");
            requestDispatcher.forward(req, resp);
        } else if (page.equals("lists")) {

            // if user list button is clicked, show the list of users
            User user = new User();
            ArrayList<User> list = (ArrayList<User>) new UserService().getUserList();

            req.setAttribute("list", list);
            req.setAttribute("user", user);



            RequestDispatcher requestDispatcher = req.getRequestDispatcher("Pages/userlist.jsp");
            requestDispatcher.forward(req, resp);
        }


        // when logging out
        if(page.equals("logout")){
            HttpSession session = req.getSession(false);
            session.invalidate();
            resp.sendRedirect("index.jsp");
        }


        // to show user details in action page
        if(page.equals("userDetails")){

            int id = Integer.parseInt(req.getParameter("id"));

            User user = new UserService().showUserRow(id);

            // jsp ma value lina ko lagi setAttribute .. obj banako pathako
            req.setAttribute("myUser", user);
            req.setAttribute("id", id);

            RequestDispatcher requestDispatcher = req.getRequestDispatcher("Pages/action.jsp");
            requestDispatcher.forward(req, resp);

        }



        //when clicking on the add New user link from the userlist page
        if(page.equals("addUser")){
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("Pages/addUser.jsp");
            requestDispatcher.forward(req, resp);
        }


        // adding new user through the add user button
        if(page.equals("register-new")){
            // user object ma set gareko variables
            User user1 = new User();

            user1.setFullName(req.getParameter("fullname"));
            user1.setUsername(req.getParameter("username"));
//            String username = req.getParameter("username");
            user1.setPwd(HashingEg.hashPassword(req.getParameter("pwd")));

            new UserService().insertUser(user1);



            // if user list button is clicked, show the list of users
            User newUser = new User();
            ArrayList<User> newUserlist = (ArrayList<User>) new UserService().getUserList();

            req.setAttribute("list", newUserlist);
            req.setAttribute("addUser", newUser);


            RequestDispatcher requestDispatcher = req.getRequestDispatcher("Pages/userlist.jsp");
            requestDispatcher.forward(req, resp);

        }






        // edit the user details when clicked on edit link from action page
        if(page.equals("editUser")){

            int id = Integer.parseInt(req.getParameter("id"));


            User user = new UserService().showUserRow(id);

            // jsp ma value lina ko lagi setAttribute .. obj banako pathako
            req.setAttribute("myUser", user);
            req.setAttribute("id", id);



            RequestDispatcher requestDispatcher = req.getRequestDispatcher("Pages/edit.jsp");
            requestDispatcher.forward(req, resp);

        }

        // when edit form is submitted
        if(page.equals("edit")){

            int id = Integer.parseInt(req.getParameter("id"));
            User user = new User();

            // model ma set garne setUserName
//            user.setId(Integer.parseInt(req.getParameter("id")));
            user.setId(id);
            user.setUsername(req.getParameter("username"));
            user.setFullName(req.getParameter("fullname"));
            user.setPwd(HashingEg.hashPassword(req.getParameter("pwd")));


            // user le j ni update garna sakxa
            try {
                new UserService().editUser(id, user);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }


            // if user list button is clicked, show the list of users
                User editUser = new User();
                ArrayList<User> newUserlist = (ArrayList<User>) new UserService().getUserList();

                req.setAttribute("list", newUserlist);



            RequestDispatcher requestDispatcher = req.getRequestDispatcher("Pages/userlist.jsp");
            requestDispatcher.forward(req, resp);



        }







        if(page.equals("deleteUser")){

            int id = Integer.parseInt(req.getParameter("id"));


            // if user list button is clicked, show the list of users
            UserService deleteUser = new UserService();
            new UserService().deleteUser(id);


            ArrayList<User> newUserlist = (ArrayList<User>) new UserService().getUserList();

            req.setAttribute("list", newUserlist);



            RequestDispatcher requestDispatcher = req.getRequestDispatcher("Pages/userlist.jsp");
            requestDispatcher.forward(req, resp);


        }





    }

    public void destroy() {
    }
}