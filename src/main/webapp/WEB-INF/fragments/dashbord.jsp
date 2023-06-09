<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="false"%>
<!DOCTYPE html>
<html>

<%-- head  --%>
<jsp:include page="/WEB-INF/fragments/head.jsp" />

<body class="hold-transition sidebar-mini">

	<div class="wrapper">
		<jsp:include page="/WEB-INF/fragments/menu.jsp" />


		<!-- Control Sidebar -->
		<jsp:include page="/WEB-INF/fragments/asidebar.jsp" />

		<%-- ./wrapper div  --%>
		<jsp:include page="/WEB-INF/fragments/addition.jsp" />
</body>
</html>