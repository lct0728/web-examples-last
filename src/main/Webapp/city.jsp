
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<script src="resources/jquery-3.4.1.min.js"></script>
<script>
    $(function () {


        //省改变
        $("#province").change(function () {
            $("#city").empty();
            $.getJSON("city.do",{pid:$(this).val()},function (data) {
                $.each(data,function (i,d) {
                    $("#city").append($("<option>").val(d.id).html(d.name))
                })
                $("#city").change();
            })
        })

        //市改变
        $("#city").change(function () {
            $("#area").empty();
            $.getJSON("city.do",{pid:$(this).val()},function (data) {
                $.each(data,function (i,d) {
                    $("#area").append($("<option>").val(d.id).html(d.name))
                })
            })
        })

        //加载省份
        $.getJSON("city.do",{pid:"0001"},function (data) {
            $.each(data,function (i,d) {
                $("#province").append($("<option>").val(d.id).html(d.name))
            })
            $("#province").change();
        })

    })
</script>
<body>

<select id="province" style="width: 100px"></select>省
<select id="city" style="width: 100px"></select>市
<select id="area" style="width: 100px"></select>
</body>
</html>
