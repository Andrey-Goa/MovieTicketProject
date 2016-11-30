<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<c:import url="main.jsp"></c:import>
<form action="/newticket">
    <button class="btn btn-success nav-tabs left" type="submit"> Добавить билет </button>
</form>

<form action="/updateticket" method="GET">
    <button class="btn btn-success nav-tabs right" data-toggle="modal"> Обновить </button>
</form>
<br>
<div class="margtable">
<table class="table table-bordered table-hover">
  <thead class="thead-inverse">
    <tr>
      <th>Билет</th>
      <th>Изменить</th>
      <th>Удалить</th>

    </tr>
  </thead>
 <tbody>
 <c:forEach items="${tickets}" var="tics">

     <td><h4><c:out value="Билет № ${tics.id}"></c:out></h4></td>
      <form action="/ticket/edit/${tics.id}" method="GET">
           <td><button class="btn btn-success nav-tabs" data-toggle="modal">Изменить</button></td>
           </form>

     <form action="/ticket/del/${tics.id}" method="POST">
           <td><button class="btn btn-danger" onclick="return confirmDelete();">Удалить</button></td>
           </form>
     </tr>
     </c:forEach>


 </tbody>
    </table>
</div>
    <script>
        function confirmDelete() {
                if (confirm("Вы уверены?")) {
                    return true;
                } else {
                    return false;
                }

}

</script>
