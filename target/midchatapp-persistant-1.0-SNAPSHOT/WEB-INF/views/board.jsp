<%@ page import="java.util.List" %>
<%@ page import="chatapp.model.ChatMessage" %>
<%@ page import="chatapp.model.Participant" %>
<%@ page import="java.util.Date" %>



<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Chatapp ! </title>
</head>
<body>


     <% for (ChatMessage msg: (List<ChatMessage>) request.getAttribute("list")) { %>
    <tr>
        <td>    <%= msg.getParticipant() %> </td>  
        <td> : <%= msg.getContent() %></td>
        <td> @ :  <%= ((Date) msg.getDate()).toString() %></td>
    </tr><br />
    <% } %>


    <form method="POST" action="board">
        <p>
            <label for="message">Message</label>
            <input id="message" type="text" name="message"/>
            <input type="hidden" name="action" value="addMessage"/> 
            <input type="submit" value="Post message"/>

    </form>
        </p>
</body>
</html>