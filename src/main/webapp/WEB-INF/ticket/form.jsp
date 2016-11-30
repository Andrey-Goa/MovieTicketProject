<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>



<table>

 <tr>
        <td>Фильм:</td>

 <td><form:select path="movieTicket.movieId">
         <form:option value="" label=""/>
         <c:forEach items="${movies}" var="mov">
            <form:option label="${mov.movieTitle}" value="${mov.movieId}"/>
     </c:forEach>  </form:select> </td>
     <td> <form:errors path="movieTicket.movieId" cssClass="error" /></td>

</tr>
    <tr>
        <td>ФИО</td>
        <td><form:input path="name" /></td>
        <td><form:errors path="name" cssClass="error" /></td>
    </tr>
    <tr>
        <td>Телефон:</td>
        <td><form:input path="tel" /></td>
        <td><form:errors path="tel" cssClass="error" /></td>
    </tr>
    <tr>
        <td>Зал:</td>
        <td><form:input path="hall" /></td>
        <td><form:errors path="hall" cssClass="error" /></td>
    </tr>
    <tr>
        <td>Ряд:</td>
        <td><form:input path="row" /></td>
        <td><form:errors path="row" cssClass="error" /></td>
    </tr>
    <tr>
        <td>Место:</td>
        <td><form:input path="space" /></td>
        <td><form:errors path="space" cssClass="error" /></td>
    </tr>
    <tr>
        <td>Статус:</td>
        <td><form:radiobutton path="status"  value="1"  checked="checked"/> Бронирование
            <form:radiobutton path="status" value="2" /> Продажа
    </tr>
</table>

    <input type="submit" value="OK" class="btn btn-primary" />

    <form action="/" method="GET">
        <input type="button" class="btn btn-success " value="Отмена" > </form>


