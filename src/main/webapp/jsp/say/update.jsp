<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <%@include file="/jsp/common/js.jsp" %>
</head>
<body>
<div class="container">
    <h1>我的说说</h1>

    <div style="width: 50%">
        <form method="post" action="${pageContext.request.contextPath}/say/update">
            <div class="form-group" style="display: none">
                <label for="userid">用户ID</label>
                <input name="userid" id="userid" type="text" class="form-control" placeholder="">
            </div>
            <div class="form-group">
                <input name="say" id="say" type="text" class="form-control" placeholder="">
            </div>
            <button type="submit" class="btn btn-default">保存</button>
            <button type="reset" class="btn btn-default">重置</button>
        </form>
    </div>
</div>
</body>
</html>
