<%@ page isELIgnored="false" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html>
<body>
          <form action="http://localhost:8080/GameDoanSo/game" method="post">
            <div class="form-group">
              <label>Ten Nguoi Choi</label>
              <input type="text" class="form-control" name="name">
            </div>
            <div class="form-group">
              <label>   Cau Tra Loi</label>
              <input type="number" class="form-control" name="answer">
            </div>
            <button type="submit" class="btn btn-primary">Tra Loi</button>
          </form>
          <h2> ${ suggest }</h2>
          <tbody>
            <c:forEach items="${players}" var="item">
                <tr>
                    <td>${item.getPlayerName()}</td>
                    <td>${item.getPoint()}</td>

                </tr>
            </c:forEach>
          </tbody>
</body>
</html>
