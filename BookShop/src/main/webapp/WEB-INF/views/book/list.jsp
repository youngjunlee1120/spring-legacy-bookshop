<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<div>
		<div>${member.name}</div>
		<div><h3>도서 목록</h3></div>
		
		<div>
			<table border="1">
				<thead>
					<tr>
						<th>시퀀스</th>
						<th>도서명</th>
						<th>출판사</th>
						<th>가격</th>
						<th>출판일</th>
						<th>관리</th>
					</tr>
				</thead>
				
				<tbody>
					<c:if test="${list.size() < 1} }">
					<tr>
						<td colspan="6">검색된 도서가 없습니다.</td>
					</tr>
					</c:if>
					
					<c:forEach var="item" items="${list}">
					<tr>
						<td>${item.code}</td>
						<td>${item.title}</td>
						<td>${item.publisher}</td>
						<td>${item.price}</td>
						<td>${item.pubDate}</td>
						<td><a href="update/${item.code}">변경</a> <a href="delete/${item.code}">삭제</a></td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		
		<div>
			<div><a href="add">등록</a></div>
			<div><a href="..">이전</a></div>
		</div>
	</div>
</body>
</html>