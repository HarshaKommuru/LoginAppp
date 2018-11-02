

<%@page import="com.caps.model.beans.Students"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Display</title>
</head>
<body>
<h1>Your Details are:</h1>
 <jsp:useBean id="stud" class="com.caps.model.beans.Students" scope="request"/>

Id:${stud.userid}
First name:${stud.firstname}
Last name:${stud.lastname}
Password:${stud.password}
Gender:${stud.gender}
Type:${stud.type}

</body>
</html>