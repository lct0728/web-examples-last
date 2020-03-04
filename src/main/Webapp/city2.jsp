
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<script src="resources/jquery-3.4.1.min.js"></script>
<script>
    $(function () {
        //使用load完成三级联动,此时应返回html片段     "pid=0001"
        $("#province").change(function () {
            $("#city").load("city2.do",{pid:$(this).val()},function () {
                $("#city").change()
            })
        });

        $("#city").change(function () {
            $("#area").load("city2.do",{pid:$(this).val()})
        });

        $("#province").load("city2.do",{pid:"0001"},function () {
            $("#province").change()
        });
    })
</script>
<body>

<select id="province" style="width: 100px"></select>省
<select id="city" style="width: 100px"></select>市
<select id="area" style="width: 100px"></select>
</body>
</html>
