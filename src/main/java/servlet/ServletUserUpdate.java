package servlet;

import model.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/Update")
public class ServletUserUpdate extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("UpdateServlet 2");
        System.out.println(request.getParameter("EditType"));
        if ("AddStart".equals(request.getParameter("EditType"))) {
            request.setAttribute("EditType", "AddStart");
            request.setAttribute("id", "id");
            request.setAttribute("userName", "userName");
            request.setAttribute("firstName", "firstName");
            request.setAttribute("secondName", "secondName");
            request.setAttribute("age", "age");
            request.getRequestDispatcher("WEB-INF/update.jsp").forward(request, response);

        } else if ("AddEnd".equals(request.getParameter("EditType"))) {
            new UserService().addUser( new User(
                    request.getParameter("userName"),
                    request.getParameter("firstName"),
                    request.getParameter("secondName"),
                    Byte.parseByte(request.getParameter("age"))
            ));
            request.setAttribute("lists" , new UserService().getAllUsersList());
            request.getRequestDispatcher("WEB-INF/userTable.jsp").forward(request, response);

        } else if ("UpdateStart".equals(request.getParameter("EditType"))) {
            request.setAttribute("EditType", "UpdateStart");
            request.setAttribute("id", request.getParameter("id"));
            request.setAttribute("userName", request.getParameter("userName"));
            request.setAttribute("firstName", request.getParameter("firstName"));
            request.setAttribute("secondName", request.getParameter("secondName"));
            request.setAttribute("age", request.getParameter("age"));
            request.getRequestDispatcher("WEB-INF/update.jsp").forward(request, response);

        } else if ("UpdateEnd".equals(request.getParameter("EditType"))) {
            System.out.println("UpdateEnd");
            System.out.println("ID NOW " + Long.parseLong(request.getParameter("id")));
            new UserService().updateUser( new User(
                    Long.parseLong(request.getParameter("id")),
                    request.getParameter("userName"),
                    request.getParameter("firstName"),
                    request.getParameter("secondName"),
                    Byte.parseByte(request.getParameter("age"))
            ));
            request.setAttribute("lists" , new UserService().getAllUsersList());
            request.getRequestDispatcher("WEB-INF/userTable.jsp").forward(request, response);

        } else if ("Delete".equals(request.getParameter("EditType"))) {
            new UserService().deleteUser(Long.parseLong(request.getParameter("id")));
            request.setAttribute("lists" , new UserService().getAllUsersList());
            request.getRequestDispatcher("WEB-INF/userTable.jsp").forward(request, response);
        } else {
            System.out.println("Nothing");
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("UpdateServlet");
        request.getRequestDispatcher("WEB-INF/update.jsp").forward(request, response);
    }
}