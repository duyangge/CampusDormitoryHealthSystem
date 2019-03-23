<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改密码</title>
</head>
<body>
  <div role="tabpanel" class="tab-pane" id="chan">
          <div class="check-div">
                                                      原始密码为admin
         </div>
       <div style="padding: 50px 0;margin-top: 50px;background-color: #fff; text-align: right;width: 420px;margin: 50px auto;">
  <!--form表单  -->
           <form class="form-horizontal" action="${pageContext.request.contextPath }/user_modifyPassWord">
               <div class="form-group">
                   <label for="sKnot" class="col-xs-4 control-label">原密码：</label>
                   <div class="col-xs-5">
                       <input type="password" name= "password" class="form-control input-sm duiqi" id="sKnot" placeholder="请输入原密码" style="margin-top: 7px;">
                   </div>
               </div>
               <div class="form-group">
                   <label for="sKnot" class="col-xs-4 control-label">新密码：</label>
                   <div class="col-xs-5">
                       <input type="password" name="newPass" class="form-control input-sm duiqi" id="sKnot" placeholder="请输入新密码" style="margin-top: 7px;">
                   </div>
               </div>
               <div class="form-group">
                   <label for="sKnot" class="col-xs-4 control-label">重复密码：</label>
                   <div class="col-xs-5">
                       <input type="password" name="newPassAg" class="form-control input-sm duiqi" id="sKnot" placeholder="请再次输入密码" style="margin-top: 7px;">
                   </div>
               </div>
               <div class="form-group text-right">
                   <div class="col-xs-offset-4 col-xs-5" style="margin-left: 169px;">
                       <button type="reset" class="btn btn-xs btn-white">取 消</button>
                       <button type="submit" class="btn btn-xs btn-green">保存</button>
                   </div>
               </div>
           </form>
       </div>
    </div>
</body>
</html>