<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<ul class="pagination">
	<li><a href="javascript:lcf.page.changePage(0)">首页</a></li>
	<c:if test="${p.totalPage > 1}">
		
		<c:forEach var="n" begin="${p.currentPage > 4 ? p.currentPage-2 : 1}" end="${p.currentPage < p.totalPage ? (p.totalPage - p.currentPage > 6 ? p.currentPage + 6 : p.totalPage) : p.currentPage}">
			<c:if test="${n != p.currentPage + 1}">
				<li><a href="javascript:lcf.page.changePage(${n - 1})">${n}</a></li>
			</c:if>
			<c:if test="${n == p.currentPage + 1}"><li class="active"><a href="javascript:void(0)">${n}</a></li></c:if>
		</c:forEach>
	</c:if>
	
	<li><a href="javascript:lcf.page.changePage(${p.totalPage - 1})">末页</a></li>
</ul>
<script src="${baseUrl}/js/lcf_common.js"></script>