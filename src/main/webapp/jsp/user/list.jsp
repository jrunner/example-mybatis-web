<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Bootstrap Table</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/js/bootstrap-table-master/docs/docs.css"/>
    <%@include file="/jsp/common/js.jsp" %>
</head>
<body>
<a class="sr-only" href="#content">Skip to main content</a>
<header class="navbar navbar-inverse navbar-fixed-top bs-docs-nav">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="${pageContext.request.contextPath}/index.jsp">首页</a>
        </div>
        <nav class="collapse navbar-collapse bs-navbar-collapse" role="navigation">
            <ul class="nav navbar-nav">
                <li class="active">
                    <a href="${pageContext.request.contextPath}/jsp/say/list.jsp">我的说说</a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/jsp/user/list.jsp">用户列表</a>
                </li>
            </ul>
        </nav>
    </div>
</header>
<div class="bs-header" id="content">
    <div class="container">
        <h1>艾客</h1>
        <p>我的地盘我做主~</p>
    </div>
</div>
<div class="container">
    <div class="row">
        <div class="col-md-3">
            <div class="bs-sidebar" role="complementary">
                <ul class="nav bs-sidenav">
                    <li><a href="#basic-table">Basic Table</a></li>
                </ul>
            </div>
        </div>
        <div class="col-md-9" role="main">
            <div>
                <div class="page-header">
                    <button type="button" class="btn btn-primary" onclick="toUpdate()">创建用户</button>
                </div>
                <div class="bs-example" id="divTable">
                    <table class="table"></table>
                </div>
            </div>

            <hr>
            <a href="http://git.oschina.net/jrunner" target="_blank">More examples use</a>
        </div>
    </div>
</div>

<a href="http://git.oschina.net/jrunner" class="fork_me"></a>

<footer class="bs-footer" role="contentinfo">
    <div class="container">
        <p>Copyright © 2012-2014, Bootstrap Table is licensed under the The MIT License. Coded by yangpengfei. </p>
        <ul class="footer-links">
            <li>Currently: v1.0.1</li>
            <li class="muted">·</li>
            <li><a href="http://github.com/jrunner">My repos</a></li>
            <li class="muted">·</li>
            <li><a href="http://git.oschina.net/jrunner">Github (@jrunner)</a></li>
            <li class="muted">·</li>
            <li><a href="mailto:jrunner@126.com">Email</a></li>
        </ul>
    </div>
</footer>
</body>
</html>

<script>
    $(document).ready(function() {
        var url = "${pageContext.request.contextPath}/user/query";
        $.ajax({type: "POST",url: url, cache: false, data: {}, dataType: 'json',success: JCollBack });
    })

    function JCollBack(s){
        if(s.success == false){
            alert('操作失败!'+ s.result);
            return;
        }

        if(s.flag == 'del'){
            window.location.reload();
            return;
        }
        var data = s.result;
        var table = '<table id="table" class="table" cellpadding="2" cellspacing="2" data-height="246">';
        table += '<tr>';
        table += '<th  width="100">编号</th>';
        table += '<th  width="100">名称</th>';
        table += '<th  width="300">密码</th>';
        table += '<th  width="300">生日</th>';
        table += '<th  width="300">创建时间</th>';
        table += '<th  width="300">操作</th>';
        table += '</tr>';
        for(var i=0; i<data.length; i++){
            table += '<tr>';
            table += '<td>'+data[i].id+'</td>';
            table += '<td>'+data[i].name+'</td>';
            table += '<td>'+data[i].password+'</td>';
            table += '<td>'+data[i].birthday+'</td>';
            table += '<td>'+data[i].createTime+'</td>';
            table += '<td><a href="{0}">{1}</a></td>'.replace("{0}",'javascript:del('+data[i].id+')').replace("{1}","删除");
            table += '</tr>';
        }
        table += '</table>';
        $('#divTable').html(table)
    }

    function del(id){
        var url = "${pageContext.request.contextPath}/user/del";
        $.ajax({type: "POST",url: url, cache: false, data: {id:id}, dataType: 'json',success: JCollBack });
    }

    function toUpdate(){
        var url = "${pageContext.request.contextPath}/jsp/user/update.jsp";
        window.location = url;
    }

</script>
