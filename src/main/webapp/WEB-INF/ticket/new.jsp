<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:import url="main.jsp"></c:import>
<form:form action="newticket" method="post" modelAttribute="ticket">
<c:import url="form.jsp"></c:import>

</form:form>

