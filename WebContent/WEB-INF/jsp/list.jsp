<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>序列码列表</title>
</head>
<body class="hold-transition skin-blue sidebar-mini">
	<div>
		<form action="${baseUrl}/code?type=3" method="post" onsubmit="return toVaild()">
			<table class="table">
				<thead>
					<tr>
					    <td><a href="${baseUrl}/code?type=1">生成新序列码</a></td>
						<td><input type="radio" name="isuse" value="0">未使用&nbsp;&nbsp;</td>
						<td><input type="radio" name="isuse" value="1">已使用&nbsp;&nbsp;</td>
						<td><input type="submit" class="bg-blue btn" value="搜索" /></td>
						
					</tr>
					<tr>
						<th>序列码</th>
						<th>创建时间</th>
						<th>设备号</th>
						<th>绑定时间</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${p.results}" var="b" varStatus="status">
						<tr>
							<td>${b.code}</td>
							<td>${b.creat_time}</td>
							<td>${b.device}</td>
							<td>${b.bind_time}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</form>
	</div>
	<%@include file="/WEB-INF/common/pager4js.jsp"%>
	<div style="display: none;">
		<form id="frmChangePage" action="${baseUrl}/code?type=3" method="post">
			<input id="hdnCurrentPage" type="hidden" name="currentPage" value="${p.currentPage}" /> 
			<input id="hdnPageSize" type="hidden" name="total" value="${p.totalRecords}" /> 
			<input id="isuse" type="hidden" name="isuse" value="${isuse}" /> 
		</form>
	</div>
</body>
</html>
<script src="${baseUrl}/js/jQuery-2.1.4.min.js"></script>
<script type="text/javascript">
$(function() {
$("input[name='isuse'][value=${isuse}]").attr("checked",true); 
});
</script>
<style type="text/css">
.pagination {
  display: inline-block;
  padding-left: 0;
  margin: 20px 0;
  border-radius: 4px;
}
.pagination > li {
  display: inline;
}
.pagination > li > a,
.pagination > li > span {
  position: relative;
  float: left;
  padding: 6px 12px;
  margin-left: -1px;
  line-height: 1.42857143;
  color: #337ab7;
  text-decoration: none;
  background-color: #fff;
  border: 1px solid #ddd;
}
.pagination > li:first-child > a,
.pagination > li:first-child > span {
  margin-left: 0;
  border-top-left-radius: 4px;
  border-bottom-left-radius: 4px;
}
.pagination > li:last-child > a,
.pagination > li:last-child > span {
  border-top-right-radius: 4px;
  border-bottom-right-radius: 4px;
}
.pagination > li > a:hover,
.pagination > li > span:hover,
.pagination > li > a:focus,
.pagination > li > span:focus {
  z-index: 3;
  color: #23527c;
  background-color: #eee;
  border-color: #ddd;
}
.pagination > .active > a,
.pagination > .active > span,
.pagination > .active > a:hover,
.pagination > .active > span:hover,
.pagination > .active > a:focus,
.pagination > .active > span:focus {
  z-index: 2;
  color: #fff;
  cursor: default;
  background-color: #337ab7;
  border-color: #337ab7;
}
.pagination > .disabled > span,
.pagination > .disabled > span:hover,
.pagination > .disabled > span:focus,
.pagination > .disabled > a,
.pagination > .disabled > a:hover,
.pagination > .disabled > a:focus {
  color: #777;
  cursor: not-allowed;
  background-color: #fff;
  border-color: #ddd;
}
.pagination-lg > li > a,
.pagination-lg > li > span {
  padding: 10px 16px;
  font-size: 18px;
  line-height: 1.3333333;
}
.pagination-lg > li:first-child > a,
.pagination-lg > li:first-child > span {
  border-top-left-radius: 6px;
  border-bottom-left-radius: 6px;
}
.pagination-lg > li:last-child > a,
.pagination-lg > li:last-child > span {
  border-top-right-radius: 6px;
  border-bottom-right-radius: 6px;
}
.pagination-sm > li > a,
.pagination-sm > li > span {
  padding: 5px 10px;
  font-size: 12px;
  line-height: 1.5;
}
.pagination-sm > li:first-child > a,
.pagination-sm > li:first-child > span {
  border-top-left-radius: 3px;
  border-bottom-left-radius: 3px;
}
.pagination-sm > li:last-child > a,
.pagination-sm > li:last-child > span {
  border-top-right-radius: 3px;
  border-bottom-right-radius: 3px;
}
.table > thead > tr > th,
.table > tbody > tr > th,
.table > tfoot > tr > th,
.table > thead > tr > td,
.table > tbody > tr > td,
.table > tfoot > tr > td {
  border-top: 3px solid #f4f4f4;
}
.table > thead > tr > th {
  border-bottom: 3px solid #f4f4f4;
}
.table tr td .progress {
  margin-top: 5px;
}
.table-bordered {
  border: 3px solid #f4f4f4;
}
.table-bordered > thead > tr > th,
.table-bordered > tbody > tr > th,
.table-bordered > tfoot > tr > th,
.table-bordered > thead > tr > td,
.table-bordered > tbody > tr > td,
.table-bordered > tfoot > tr > td {
  border: 1px solid #f4f4f4;
}
.table-bordered > thead > tr > th,
.table-bordered > thead > tr > td {
  border-bottom-width: 2px;
}
.table.no-border,
.table.no-border td,
.table.no-border th {
  border: 0;
}
/* .text-center in tables */
table.text-center,
table.text-center td,
table.text-center th {
  text-align: center;
}
.table.align th {
  text-align: left;
}
.table.align td {
  text-align: right;
}
.bg-blue {
  color: #fff !important;
  background-color: #0073b7 !important;
}
.btn {
  display: inline-block;
  padding: 6px 12px;
  margin-bottom: 0;
  font-size: 14px;
  font-weight: normal;
  line-height: 1.42857143;
  text-align: center;
  white-space: nowrap;
  vertical-align: middle;
  -ms-touch-action: manipulation;
      touch-action: manipulation;
  cursor: pointer;
  -webkit-user-select: none;
     -moz-user-select: none;
      -ms-user-select: none;
          user-select: none;
  background-image: none;
  border: 1px solid transparent;
  border-radius: 4px;
}
.btn:focus,
.btn:active:focus,
.btn.active:focus,
.btn.focus,
.btn:active.focus,
.btn.active.focus {
  outline: thin dotted;
  outline: 5px auto -webkit-focus-ring-color;
  outline-offset: -2px;
}
.btn:hover,
.btn:focus,
.btn.focus {
  color: #333;
  text-decoration: none;
}
.btn:active,
.btn.active {
  background-image: none;
  outline: 0;
  -webkit-box-shadow: inset 0 3px 5px rgba(0, 0, 0, .125);
          box-shadow: inset 0 3px 5px rgba(0, 0, 0, .125);
}
</style>