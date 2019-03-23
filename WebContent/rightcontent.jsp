<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
      <div id="rightContent">
           <a class="toggle-btn" id="nimei">
               <i class="glyphicon glyphicon-align-justify"></i>
           </a>
           <!-- Tab panes -->
           <div class="tab-content">
               <!-- 统计均分模块 -->
		       <jsp:include page="ScoreManager.jsp"></jsp:include>
          
	           <!--寝室评分管理模块-->
	           <jsp:include page="dorManager.jsp"></jsp:include>
         
               <!-- 修改密码模块 -->
        	   <jsp:include page="updatePassword.jsp"></jsp:include>
        </div>
     </div>
</body>
</html>