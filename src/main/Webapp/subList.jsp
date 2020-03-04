
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<table>
    <tr>
        <th>编号</th>
        <th>书名</th>
        <th>作者</th>
        <th>价格</th>
    </tr>
    <c:forEach items="${list}" var="b">
        <tr>
            <th>${b.bookno}</th>
            <th>${b.name}</th>
            <th>${b.title}</th>
            <th>${b.price}</th>
        </tr>
    </c:forEach>
</table>