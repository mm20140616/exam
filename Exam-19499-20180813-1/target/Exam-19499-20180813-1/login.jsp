<%@ page pageEncoding="utf-8" %>
<html>
<head>
    <title>登陆</title>
    <jsp:include page="common.jsp" />
    <style>
        #loginForm{
            margin-top: 30px;
        }
    </style>
</head>
<body>
    <div class="container">
        <form id="loginForm" class="form-horizontal" role="form" action="/checkLogin.do" method="post">
            <div class="form-group">
                <label class="col-xs-2 control-label">顾客ID</label>
                <div class="col-xs-4">
                    <input name="customer_id" type="text" class="form-control" placeholder="请输入顾客ID">
                </div>
                <div class="col-xs-6"></div>
            </div>
            <div class="form-group">
                <label class="col-xs-2 control-label">用户名</label>
                <div class="col-xs-4">
                    <input name="first_name" type="text" class="form-control" placeholder="请输入用户名">
                </div>
                <div class="col-xs-6"></div>
            </div>
            <div class="form-group">
                <div class="col-xs-offset-2 col-xs-10">
                    <button type="submit" class="btn btn-info">登录</button>
                </div>
            </div>
        </form>
    </div>
</body>
</html>