package chatapp.servlets;

import chatapp.model.Participant;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/join")
public class JoinServlet extends HttpServlet {

    @Inject
    Participant participant;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getServletContext().getRequestDispatcher("/WEB-INF/views/join.jsp").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null) {
            if ("add".equals(action)) {
                addParticipant(request);
            } 
        }
        response.sendRedirect("board");

    }

    private void addParticipant(HttpServletRequest request){
        this.participant.setName(request.getParameter("name"));
        this.participant.setEmail(request.getParameter("email"));
    }
}
