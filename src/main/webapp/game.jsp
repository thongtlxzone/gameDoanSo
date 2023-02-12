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
            <button type="submit" name = "delete-btn" class="btn btn-primary">Xoa Du Lieu</button>

          </form>

          <h2> ${ suggest }</h2>

          <b>Top 5 nguoi choi:</b>
            <tbody>
                <c:forEach items="${players}" var="item">
                    <ul>
                        <li>Ten Nguoi Choi: ${ item.getPlayerName() }</li>
                        <li>So lan thu: ${ item.getPoint() }</li>
                    </ul>
                </c:forEach>
          </tbody>
</body>
</html>
