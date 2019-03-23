<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>左侧菜单栏</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="description" content="左右结构项目，属于大人员的社交工具">
        <meta name="keywords" content="左右结构项目 社交 占座 ">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
        <meta name="format-detection" content="telephone=no">
        <title>萍乡学院宿舍卫生测评系统后台</title>
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="css/common.css" />
        <link rel="stylesheet" type="text/css" href="css/slide.css" />
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
        <link rel="stylesheet" type="text/css" href="css/flat-ui.min.css" />
        <link rel="stylesheet" type="text/css" href="css/jquery.nouislider.css">
</head>
<body>
   	<!-- 左侧菜单栏目块 -->
            <div class="leftMeun" id="leftMeun">
                <div id="logoDiv">
                    <p id="logoP"><img id="logo"  src="images/logo.png"><span>后台系统管理</span></p>
                </div>
                <div id="personInfor">
                    <p id="userName">${userInfo.name }管理员，你好</p>
                    <p><span>Tel:${userInfo.telphone}</span><b/> More Templates <a href="http://www.pxc.jx.cn/" target="_blank" title="萍乡学院">萍乡学院</a> - Collect from <a href="http://www.pxc.jx.cn/" title="萍乡学院" target="_blank">萍乡学院</a></p>
                    <p>
                        <a href="${pageContext.request.contextPath }/user_loginOut">退出登录</a>
                    </p>
                </div><!--#user  -->
                <div class="meun-title" style="margin-left:10px;">账号管理</div>
                 <div class="meun-item meun-item-active"  href="#user " aria-controls="user" role="tab" data-toggle="tab"><img src="images/icon_user_grey.png">	
                	评分管理
                </div>
                <div class="meun-item" href="#char" aria-controls="char" role="tab" data-toggle="tab"><img src="images/icon_chara_grey.png">统计均分</div>
               <!--  <div class="meun-item" href="#char" aria-controls="char" role="tab" data-toggle="tab"><img src="images/icon_chara_grey.png">权限管理</div> -->
                <div class="meun-item" href="#chan" aria-controls="chan" role="tab" data-toggle="tab"><img src="images/icon_change_grey.png">修改密码</div>
		   </div>
</body>
</html>