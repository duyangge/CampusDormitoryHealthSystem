<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>寝室评分查看</title>
<script type="text/javascript">
function seacheDormitoryScore(){//查询某个寝室--按寝室号
	var dormitroyId = document.getElementById("dormitroyScoreId").value;
	window.location.href="${pageContext.request.contextPath }/dormitoryScore_selectConditionDormitoryScore?dormitoryIdScore="+dormitroyId;
}
</script>
</head>
<body>
		 <div role="tabpanel" class="tab-pane active" id="user">
              <div class="check-div form-inline">
                  <div class="col-xs-3">
                      <button class="btn btn-yellow btn-xs" data-toggle="modal" data-target="#addUserdor">登记分数 </button>
                  </div>
                  <div class="col-xs-4">
                      <input type="text" class="form-control input-sm" placeholder="输入文字搜索" id="dormitroyScoreId">
                      <button class="btn btn-white btn-xs" onclick="seacheDormitoryScore();">查 询 </button>
                  </div>
                  <div class="col-lg-3 col-lg-offset-2 col-xs-4" style=" padding-right: 40px;text-align: right;">
                      <label for="paixu">排序:&nbsp;</label>
                      <select class=" form-control">
                          <option>时间</option>
                          <option>班级</option>
                          <option>班主任</option>
                          <option>公寓</option>
                          <option>寝室号</option>
                          <option>学院</option>
                      </select>
                  </div>
              </div>
              <div class="data-div">
                  <div class="row tableHeader">
                      <div class="col-xs-2 ">
                          编码
                      </div>
                      <div class="col-xs-2">
                          寝室号
                      </div>
                      <div class="col-xs-2">
                          评分
                      </div>
                      <div class="col-xs-2">
                       日期
                      </div>
                      <div class="col-xs-2">
                          评分人员
                      </div>
                      <div class="col-xs-2">
                          操作
                      </div>
                  </div>
          <!-- 寝室评分结束 -->       
                  <div class="tablebody">
                  <c:forEach var="dorSco" items="${dorScoList}" varStatus="status"> 
                      <div class="row">
                          <div class="col-xs-2 " id="id">
                             ${dorSco.id}
                          </div>
                          <div class="col-xs-2"  id="dormitoryId"> 
                          ${dorSco.dormitoryIdScore}
                          </div>
                          <div class="col-xs-2" id="dormitoryScore">
                          ${dorSco.dormitoryScore}
                         </div>
                          <div class="col-xs-2" id="scoreDate">
                            <fmt:formatDate value="${dorSco.scoreDate}" />
                          </div>
                          <div class="col-xs-2" id="scoreUsername">
                         ${dorSco.scoreUsername}
                          </div>
                          <div class="col-xs-2">
                              <button class="btn btn-success btn-xs" data-toggle="modal" data-target="#reviseUserdor" id="updatealter" >修改</button>
                              <button class="btn btn-danger btn-xs" data-toggle="modal" data-target="#deleteUserdor" id="deletealtet">删除 </button>
                          </div>
                      </div>
                   </c:forEach>     
                  </div>
           
	<!-- 寝室评分结束 -->
              </div>
              <!--页码块-->
              <footer class="footer">
                  <ul class="pagination">
                      <li>
                          <select>
                              <option>1</option>
                              <option>2</option>
                              <option>3</option>
                              <option>4</option>
                              <option>5</option>
                              <option>6</option>
                              <option>7</option>
                              <option>8</option>
                              <option>9</option>
                              <option>10</option>
                          </select>
                          页
                      </li>
                      <li class="gray">
                          共20页
                      </li>
                      <li>
                          <i class="glyphicon glyphicon-menu-left">
                          </i>
                      </li>
                      <li>
                          <i class="glyphicon glyphicon-menu-right">
                          </i>
                      </li>
                  </ul>
              </footer>

              <!--弹出添加寝室分数窗口-->
              <div class="modal fade" id="addUserdor" role="dialog" aria-labelledby="gridSystemModalLabel">
                  <div class="modal-dialog" role="document">
                      <div class="modal-content">
                      <!--form表单  -->
                        <!--添加寝室分数窗口  -->
                        <form class="form-horizontal" action="${pageContext.request.contextPath }/dormitoryScore_addDormitoryScore">
                          <div class="modal-header">
                              <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                              <h4 class="modal-title" id="gridSystemModalLabel">登记分数</h4>
                          </div>
                          <div class="modal-body">
                              <div class="container-fluid">
                                <div class="form-group ">
                                          <label for="sName" class="col-xs-3 control-label">寝室号:</label>
                                          <div class="col-xs-8 ">
                                              <select  name="dormitoryIdScore" class=" form-control select-duiqi">
                                              		<c:forEach var="dor" items="${dorList }">
                                              			<option value="${dor.dormitoryId }">${dor.dormitoryId  }</option>
                                              		</c:forEach>
                                              </select>
                                          </div>
                                      </div>
                                      <div class="form-group">
                                          <label for="sLink" class="col-xs-3 control-label">寝室分数：</label>
                                          <div class="col-xs-8 ">
                                              <input type="text" class="form-control input-sm duiqi" id="sLink" placeholder="请输入分数" name="dormitoryScore">
                                          </div>
                                      </div>
                                      <div class="form-group">
                                          <label for="sOrd" class="col-xs-3 control-label">评分日期</label>
                                          <div class="col-xs-8">
                                              <input type="date" class="form-control input-sm duiqi" id="sOrd" placeholder="请选择日期" name="scoreDate">
                                          </div>
                                      </div>
                                      <div class="form-group">
                                          <label for="sKnot" class="col-xs-3 control-label">评分备注：</label>
                                          <div class="col-xs-8">
                                              <textarea rows="6" cols="30" class="form-control input-sm duiqi" id="sKnot" name="remarks"></textarea>
                                          </div>
                                      </div>
                                      <div class="form-group">
                                          <label for="sKnot" class="col-xs-3 control-label">评分人员</label>
                                          <div class="col-xs-8">
                                              <select class=" form-control select-duiqi" name="scoreUsername">
                                              	<c:forEach var="user" items="${allUserInfo }">
                                              		<option value="${user.name }">${user.name }</option>
                                              	</c:forEach>
                                              </select>
                                          </div>
                                      </div>
                                      <div class="form-group">
                                          <label for="situation" class="col-xs-3 control-label">状态：</label>
                                          <div class="col-xs-8">
                                              <label class="control-label" for="anniu">
                                                  <input type="radio" name="situation" id="normal">正常</label> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                              <label class="control-label" for="meun">
                                                  <input type="radio" name="situation" id="forbid"> 禁用</label>
                                          </div>
                                      </div>
                                  
                              </div>
                          </div>
                          <div class="modal-footer">
                              <button type="button" class="btn btn-xs btn-white" data-dismiss="modal">取 消</button>
                              <input type="submit" class="btn btn-xs btn-green">
                          </div>
                          </form>
                      </div>
                      <!-- /.modal-content -->
                  </div>
                  <!-- /.modal-dialog -->
              </div>
              <!-- /.modal -->
              <!--弹出修改用户窗口-->
              <div class="modal fade" id="reviseUserdor" role="dialog" aria-labelledby="gridSystemModalLabel">
                  <div class="modal-dialog" role="document">
                      <div class="modal-content">
                          <div class="modal-header">
                              <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                              <h4 class="modal-title" id="gridSystemModalLabel">修改评分</h4>
                          </div>
                          <div class="modal-body">
                              <div class="container-fluid">
                              
                 <!--修改寝室分数窗口  -->
                          <form class="form-horizontal" action="">
                                  		
                                      <div class="form-group ">
                                          <label for="sName" class="col-xs-3 control-label">寝室号:</label>
                                          <div class="col-xs-8 ">
                                              <select  name="dormitoryIdScore" class=" form-control select-duiqi">
                                              		<c:forEach var="dor" items="${dorList }">
                                              			<option value="${dor.dormitoryId }">${dor.dormitoryId  }</option>
                                              		</c:forEach>
                                              </select>
                                          </div>
                                      </div>
                                      <div class="form-group">
                                          <label for="sLink" class="col-xs-3 control-label">寝室分数：</label>
                                          <div class="col-xs-8 ">
                                              <input type="text" class="form-control input-sm duiqi" id="sLink" placeholder="请输入分数">
                                          </div>
                                      </div>
                                      <div class="form-group">
                                          <label for="sOrd" class="col-xs-3 control-label">评分日期</label>
                                          <div class="col-xs-8">
                                              <input type="date" class="form-control input-sm duiqi" id="sOrd" placeholder="请选择日期">
                                          </div>
                                      </div>
                                      <div class="form-group">
                                          <label for="sKnot" class="col-xs-3 control-label">评分备注：</label>
                                          <div class="col-xs-8">
                                              <textarea rows="6" cols="30" class="form-control input-sm duiqi" id="sKnot" name="remarks"></textarea>
                                          </div>
                                      </div>
                                      <div class="form-group">
                                          <label for="sKnot" class="col-xs-3 control-label">评分人员</label>
                                          <div class="col-xs-8">
                                              <select class=" form-control select-duiqi" name="scoreUsername">
                                              	<c:forEach var="user" items="${allUserInfo }">
                                              		<option value="${user.name }">${user.name }</option>
                                              	</c:forEach>
                                              </select>
                                          </div>
                                      </div>
                                      <div class="form-group">
                                          <label for="situation" class="col-xs-3 control-label">状态：</label>
                                          <div class="col-xs-8">
                                              <label class="control-label" for="anniu">
                                                  <input type="radio" name="situation" id="normal">正常</label> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                              <label class="control-label" for="meun">
                                                  <input type="radio" name="situation" id="forbid"> 禁用</label>
                                          </div>
                                      </div>
                                  </form>
                              </div>
                          </div>
                          <div class="modal-footer">
                              <button type="button" class="btn btn-xs btn-white" data-dismiss="modal">取 消</button>
                              <button type="button" class="btn btn-xs btn-green">保 存</button>
                          </div>
                      </div>
                      <!-- /.modal-content -->
                  </div>
                  <!-- /.modal-dialog -->
              </div>
              <!-- /.modal -->

              <!--弹出删除用户警告窗口-->
              <div class="modal fade" id="deleteUserdor" role="dialog" aria-labelledby="gridSystemModalLabel">
                  <div class="modal-dialog" role="document">
                      <div class="modal-content">
                          <div class="modal-header">
                              <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                              <h4 class="modal-title" id="gridSystemModalLabel">提示</h4>
                          </div>
                          <div class="modal-body">
                              <div class="container-fluid">
                                  确定要删除该用户？删除后不可恢复！
                              </div>
                          </div>
                          <div class="modal-footer"><!--onclick="javascript:window.location.href='${pageContext.request.contextPath }/dormitoryScore_deleteDormitoryScore?id=${dorSco.id}'"  -->
                              <button type="button" class="btn btn-xs btn-white" data-dismiss="modal">取 消</button>
                              <button type="button" class="btn  btn-xs btn-danger" onclick="javascript:window.location.href='${pageContext.request.contextPath }/dormitoryScore_deleteDormitoryScore?id=${dorSco.id}'">保 存</button>
                          </div>
                      </div>
                      <!-- /.modal-content -->
                  </div>
                  <!-- /.modal-dialog -->
              </div>
              <!-- /.modal -->
          </div>
</body>
</html>