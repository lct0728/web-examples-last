
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<script src="resources/jquery-3.4.1.min.js"></script>
<script>
    $(function () {
        $("#code").blur(function () {
            //发送一个ajax请求
            // $.get("code.do",{code:$(this).val()},function (data) {
            //     $("#province").val(data.split("，")[0]);
            //     $("#city").val(data.split("，")[1]);
            // })

            $.ajax({
                type:"Get",
                url:"code.do",
                data:"code="+$(this).val(),
                success:function (data) {
                    $("#province").val(data.split("，")[0]);
                    $("#city").val(data.split("，")[1]);
                },
                statusCode:{404:function () {
                        alert("404")
                    }}
            })
        });
    })
</script>
<body>
<%--onblur="getCode(this.value)--%>
邮编<input type="text" name="code" id="code"><br>
省份<input type="text" name="province" id="province"><br>
城市<input type="text" name="city" id="city"><br>
</body>
</html>
