<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <%@include file="/jsp/common/js.jsp" %>
</head>
<body>
<div class="container">
    <h1>用户注册</h1>

    <div style="width: 50%">
        <form method="post" action="${pageContext.request.contextPath}/user/update">
            <div class="form-group">
                <label for="name">用户</label>
                <input name="name" id="name" type="text" class="form-control" placeholder="">
            </div>
            <div class="form-group">
                <label for="password">密码</label>
                <input name="password" id="password" type="password" class="form-control" placeholder="">
            </div>
            <div class="form-group">
                <label for="birthday">出生年月</label>
                <input name="birthday" id="birthday" type="text" class="form-control" placeholder="yyyy-MM-dd">
            </div>
            <div class="form-group">
                <label for="pic">头像</label>
                <input type="file" name="pic" id="pic">

                <p class="help-block">请选择一个头像</p>
            </div>
            <div class="checkbox">
                <label>
                    <input name="sex" id="sex" type="radio" checked> 男 <input name="sex" id="sex" type="radio"> 女
                </label>
            </div>
            <button type="submit" class="btn btn-default">保存</button>
            <button type="reset" class="btn btn-default">重置</button>
        </form>
    </div>
</div>
</body>
</html>
