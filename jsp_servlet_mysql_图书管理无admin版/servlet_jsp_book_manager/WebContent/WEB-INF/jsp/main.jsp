<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>main</title>
<style>
body {
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-image: url(images/main_bg.jpg);
	height: 100%;
	width: 100%;
	background-size: cover;
}

.book_img {
	width: 150px;
	height: 200px;
}

td {
	padding: 10px;
}
</style>
</head>

<body>

	<center>
		<h3>欢迎您：${sessionScope.username }</h3>
	</center>

	<h3 align="right" style="margin-right: 50px">
		<a href="index.jsp">切换用户</a>
	</h3>

	<hr>
	<table width="1235" height="211" border="1" align="center"
		cellpadding="0" cellspacing="0" bgcolor="#FDF5E6">


		<tr>
			<td width="175" align="center" bgcolor="#99FF99">封面</td>
			<td width="179" align="center" bgcolor="#99FF99">书名</td>
			<td width="200" align="center" bgcolor="#99FF99">描述</td>
			<td width="268" align="center" bgcolor="#99FF99">每日租金（元）</td>
			<td width="401" align="center" bgcolor="#99FF99">借出日期</td>
			<td width="401" align="center" bgcolor="#99FF99">操作</td>
		</tr>

		<c:forEach items="${requestScope.booklist}" var="book">
			<tr>
				<td align="center"><img class="book_img" src="${book.img_url }" /></td>
				<td align="center">${book.name }</td>
				<td>${book.info }</td>
				<td align="center">${book.price }</td>




				<td align="center">${book.borrow_date }</td>

				<c:choose>

					<c:when test="${book.borrow_date == '尚未借出' }">


						<td align="center"><input type="button" name="button"
							id="button" value="借出" onclick="borrow_book(${book.id },${page})"
							style="background: #0F6"></td>


					</c:when>


					<c:otherwise>


						<td align="center"><input type="button" name="button"
							id="button" value="归还" style="background: #F06"
							onclick="back_book(${book.id },${page})"></td>



					</c:otherwise>

				</c:choose>

			</tr>

		</c:forEach>

	</table>

	<table width="700" border="1" align="center" cellpadding="1"
		cellspacing="0">
		<tr align="center" bgcolor="#CCFFFF">
			<td><a href="listbook.do?page=1">首页</a></td>
			<!-- 显示第一页数据时，上页不可点击 -->
			<c:choose>

				<c:when test="${page ==1 }">

					<td>上页</td>
				</c:when>

				<c:otherwise>

					<td><a href="listbook.do?page=${page-1 }"> 上页</a></td>

				</c:otherwise>
			</c:choose>

			<!-- 显示最后一页数据时，下页不可点击 -->
			<c:choose>

				<c:when test="${page ==PageNum }">

					<td>下页</td>
				</c:when>

				<c:otherwise>

					<td><a href="listbook.do?page=${page+1 }"> 下页</a></td>

				</c:otherwise>
			</c:choose>

			<td><a href="listbook.do?page=${PageNum }">末页</a></td>

			<td>跳转到第 <input name="page" type="text" id="page" size="1"
				value="${page }" /> 页 <input type="button" name="turn" id="button2"
				value="确定" onclick="turn(${PageNum})" /></td>

			<td>${page }/${PageNum}页</td>
		</tr>
	</table>

	<script type="text/javascript">
		function turn(maxpage) {

			var index = document.getElementById("page").value;
		
			/* 当输入页数为0或负数时，显示第一页 */

			if (index <= 0) {

				index = 1;

			}
			/* 当输入页数大于等于最后一页时，显示最后一页 */
			
			if(index>=maxpage){
				
				
				index=maxpage;
			}

		

			window.location.href = 'listbook.do?page=' + index;

		}
		
		
		function borrow_book(id,page){
			
			alert('借出成功！');
			
			
			window.location.href = 'borrow.do?id='+id+'&page='+page;

			
		}
		
		function back_book(id,page){
			
			alert('归还成功！');
			
			
			window.location.href = 'backbookshow.do?id='+id+'&back_page='+page;

			
		}
		
		
	</script>

</body>
</html>
