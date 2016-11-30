<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: andrey-goa
  Date: 29.11.16
  Time: 1:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:import url="main.jsp"></c:import>
<form:form action="/ticket/edit/${ticket.id}" method="post" modelAttribute="ticket" >
    <c:import url="form.jsp"></c:import>

</form:form>
