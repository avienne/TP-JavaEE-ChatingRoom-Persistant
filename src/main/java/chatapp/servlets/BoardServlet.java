package chatapp.servlets;

import chatapp.model.Participant;
import chatapp.model.ChatMessage;
import chatapp.components.ChatBoard;
import chatapp.components.StatusBroadcaster;


import javax.inject.Inject;
import javax.ejb.EJB; 

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.annotation.Resource;

import java.io.IOException;


import java.util.Date;


@WebServlet(urlPatterns = "/board")
public class BoardServlet extends HttpServlet {

   @Inject 
   Participant participant;

   @EJB
   ChatBoard chatBoard;

   @EJB
   StatusBroadcaster participantStatusBroadcaster;


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("list", chatBoard.getMessages());
        request.getServletContext().getRequestDispatcher("/WEB-INF/views/board.jsp").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String content = request.getParameter("message");
        
        if(content != null && ! content.contains("/status")){
            ChatMessage message = new ChatMessage(participant.getName(),new Date(),content);
            chatBoard.addMessage(message);
        }else if (content.contains("/status")){
           String s = this.participantStatusBroadcaster.postUpdate(participant.getName(), content.substring(8));
           ChatMessage message = new ChatMessage(participant.getName(),new Date(),s);
           chatBoard.addMessage(message);

        }
        response.sendRedirect("board");
    }
}
