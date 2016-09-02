<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% String path = request.getContextPath(); String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>部门列表</title>
<link rel="stylesheet" type="text/css" href="<%=path %>/css/style.css">
<script type="text/javascript">
	function addDept(){
		alert('添加部门');
	}
</script>
</head>
<body>
	<!-- 页面头部 -->
	<jsp:include page="header.jsp"></jsp:include>
	<!-- 页面内容 -->
	<form action="" method="post" id="form1" onsubmit="delByBatch()">
		<table border="0" width="950" height="350" bgcolor="#ffffff"
			align="center">
			<tr>
				<td align="center" valign="top">
					<table width="90%" border="0" cellpadding="5" cellspacing="1"
						bgcolor="#CCCCCC">
						<tr>
							<th width="17%" bgcolor="#FFCC00">批量删除</th>
							<th width="17%" bgcolor="#FFCC00">部门编号</th>
							<th width="17%" bgcolor="#FFCC00">部门名称</th>
							<th width="21%" bgcolor="#FFCC00">部门地址</th>
							<%--
							if(session.getAttribute("sname")!=null && 
							      session.getAttribute("slevel").toString().equals("1")){
							--%>
							<c:if test="${sessionScope.slevel == 1 }">
								<th width="17%" bgcolor="#FFCC00">操作</th>
							</c:if>
							<%-- } --%>
						</tr>

						<!-- 循环输出部门记录 -->
						<%--     
						//DepartmentsDao dao = DepartmentsFactory.getInstance();
					    //List<DepartmentsBean> allData = dao.queryAllData(); 
					    List<DepartmentsBean> allData =(List<DepartmentsBean>) request.getAttribute("Data"); 
						Iterator<DepartmentsBean> it = allData.iterator();
						while (it.hasNext()) {
						DepartmentsBean bean = it.next();
						--%>
						<c:forEach items="${requestScope.depts }" var="oneRow" varStatus="vs">
							<tr>
								<td bgcolor="#FFFFFF"><input type="checkbox" name="delList"
									id="" value="${oneRow.deptId }"></td>
								<td bgcolor="#FFFFFF">${oneRow.deptId }</td>
								<td bgcolor="#FFFFFF">
									<%--=bean.getDepartment_name() --%> ${oneRow.deptName }
								</td>
								<td bgcolor="#FFFFFF">
									<%--=bean.getLocation_name() --%> ${oneRow.locName }
								</td>
								<%--
							if(session.getAttribute("sname")!=null && 
							      session.getAttribute("slevel").toString().equals("1")){
								
							--%>
								<%-- <c:if test="${sessionScope.slevel == 1 }">--%>
									<td bgcolor="#FFFFFF"><a
										href="javascript:upd(${oneRow.deptId })">修改</a> <a
										href="javascript:del(${oneRow.deptId })">删除</a>
								    </td>
								<%-- </c:if>--%>
								<%-- } --%>
							</tr>
						</c:forEach>
						<%-- } --%>
						<!-- 循环输出部门记录结束 -->
						<tr align="center">
							<td colspan="5"><a href="QueryDeptOnPageServlet?pagenum=1">首页</a>
								<a
								href="QueryDeptOnPageServlet?pagenum=${requestScope.nowPage-1 }">上一页</a>
								<span font-color="red">当前页${nowPage }</span> <a
								href="QueryDeptOnPageServlet?pagenum=${requestScope.nowPage+1 }">下一页</a>
								<a
								href="QueryDeptOnPageServlet?pagenum=${requestScope.pageCount }">尾页</a>
								<a href="">跳转到</a>：<input type="text" size="6" id="pnum" name="">
							</td>

						</tr>
						<tr align="center">
							<td colspan="5"><c:forEach begin="1"
									end="${requestScope.pageCount }" var="page">
									<a href="QueryDeptOnPageServlet?pagenum=${page }">${page }</a>
								</c:forEach></td>
						</tr>
						<tr align="center">
							<td colspan="5"><c:forEach begin="1" end="5" var="pg">
									<c:if test="${pg<=requestScope.pageCount }">
										<a href="QueryDeptOnPageServlet?pagenum=${pg }">${pg }</a>&nbsp;&nbsp;
									</c:if>
								</c:forEach> <c:if test="${requestScope.pageCount>5 }">
                                   ...&nbsp;&nbsp;
                                    <a
										href="QueryDeptOnPageServlet?pagenum=${pageCount }">${requestScope.pageCount }</a>
								</c:if></td>
						</tr>
					</table> <%-- 
					if(session.getAttribute("sname")!=null && 
						session.getAttribute("slevel").toString().equals("1")){
					--%> 
					<%-- <c:if test="${sessionScope.slevel == 1 }">--%>
						<p>
							<a href="javascript:addDept()">增加新部门</a> 
							
							<input type="submit" value="删除选中部门">
						</p>
					<%-- </c:if> --%>
					<%-- } --%>
				</td>
			</tr>
		</table>
	</form>
	<!-- 页面底部 -->
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>