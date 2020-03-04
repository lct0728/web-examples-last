
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<script>
    var xhr=null;
    //邮编失去焦点的事件处理
    function getCode(val) {
        //1.创建xhr对象
        xhr=new XMLHttpRequest();
        //2.打开连接
        xhr.open("get","/code.do?code="+val,true)
        //3.设置回调
        xhr.onreadystatechange=callback;
        //4.发送请求
        xhr.send(null);
    }
    function callback() {
        //打印状态
        if(xhr.readyState==4){
            if(xhr.status==200){
                // alert("服务端已经处理完毕，获得的结果如下");
                // alert(xhr.responseText);
               var c=xhr.responseText.split("，");
               document.getElementById("province").value=c[0];
                document.getElementById("city").value=c[1];
            }
            else {
                alert("请求出错,错误码"+xhr.status);
            }
        }
        // alert(xhr.readyState)
    }
</script>
<body>
                                    <%--onblur="getCode(this.value)--%>
邮编<input type="text" name="code" id="code" onkeyup="getCode(this.value)"><br>
省份<input type="text" name="province" id="province"><br>
城市<input type="text" name="city" id="city"><br>
</body>
</html>
