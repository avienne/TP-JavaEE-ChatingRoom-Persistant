<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Chatapp ! </title>
</head>
<body>
    <form method="POST" action="join">
        <p>
            <label for="name">Name</label>
            <input id="name" type="text" name="name"/>
            <input type="hidden" name="action" value="add"/>
            <label for="E-mail">E-mail</label>
            <input id="email" type="text" name="email"/>
            <input type="submit" value="add Participant"/>
        </p>
    </form>
</body>
</html>