
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<script src="resources/jquery-3.4.1.min.js"></script>
<script>
    $(function () {
        $("#bookno").blur(function () {
            $.get("booktwo.do",{bookno: $(this).val()},function (data) {
                if(data.bookno){
                    $("#span_bookno").html("查到");
                    $("#name").val(data.name);
                    $("#title").val(data.title);
                    $("#price").val(data.price);
                    $("#number").val(data.number)
                }else{
                    $("#span_bookno").html("查不到");
                    $("#name").val("");
                    $("#title").val("");
                    $("#price").val("");
                    $("#number").val("")
                }
            },"json")
        });

        $(".pageButton").click(function () {
            $("#data").load("bookpage.do",{pageNo:$(this).attr("pagevalue")})
        })
    })
</script>
<body>
bookno<input type="text" name="bookno" id="bookno"><span id="span_bookno"></span><br>
name<input type="text" name="name" id="name" readonly><br>
title<input type="text" name="title" id="title" readonly><br>
price<input type="text" name="price" id="price" readonly><br>
number<input type="text" name="number" id="number" readonly><br>
<br>
<input type="button" value="第一页" pagevalue="1" class="pageButton">
<input type="button" value="第二页" pagevalue="2" class="pageButton">
<input type="button" value="第三页" pagevalue="3" class="pageButton">
<div id="data" style="width:500px;height: 300px;background-color: #eeeeff"></div>
</body>
</html>
