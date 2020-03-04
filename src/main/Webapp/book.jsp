
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<script src="resources/jquery-3.4.1.min.js"></script>
<script>
    $(function () {
        $("#bookno").blur(function () {
            $.get("book.do",{bookno:$(this).val()},function (data) {
                $("#span_bookno").html(data.fontcolor("red"))
            })
        })
    })
</script>
<body>
bookno<input type="text" name="bookno" id="bookno"><span name="span_bookno" id="span_bookno"></span>
</body>
</html>
