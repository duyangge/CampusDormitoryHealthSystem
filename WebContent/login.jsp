<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>校园宿舍卫生管理系统</title>
<meta name="keywords" content="寝室卫生测评后台管理系统后台登录">
<meta name="description" content="寝室卫生测评后台管理系统登录">
<meta name="viewport" content="width=device-width">
<link href="css/base.css" rel="stylesheet" type="text/css">
<link href="css/login.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="login">
<form action="${pageContext.request.contextPath }/user_login" method="post" id="form">
	<div class="logo"><font style="color:white;font-size:40px;font-weight:bold;font-family:Hiragino Sans GB ;">校园宿舍卫生管理系统</font></div>
    <div class="login_form">
    	 <font style="color:red;font-size:15px;">${loginInfo }</font>
    	<div class="user">
        	<input class="text_value"  name="name" type="text" id="username">
            <input class="text_value"  name="password" type="password" id="password">
        </div>
        <button class="button" id="submit" type="submit">登录</button>
    </div>
    
    <div id="tip"></div>
    <div class="foot">
    Copyright © 2011-2018  All Rights Reserved. More Templates <a href="http://www.pxxy.jx.cn/" target="_blank" title="萍乡学院">萍乡学院</a> - Collect from <a href="http://www.pxxy.jx.cn/" target="_blank" title="萍乡学院">萍乡学院</a> </a>
    </div>
    </form>
</div>
</body>
</html>
