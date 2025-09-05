<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="../include/head.jsp"></jsp:include>
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		

		<div class="row">
		<div class="col-3"></div>
		<div class="col">
		
		<div>
			<h3>도서 정보 변경</h3>
		</div>
			<form method="post">
				<div class="row mb-2">
					<div class="col-2"><label>도서번호</label></div>
					<div class="col"><input type="number" name="code" value="${item.code}" readonly="readonly" class="form-control form-control-sm"></div>
				</div>
				
				<div class="row mb-2">
					<div class="col-2"><label>도서명 </label></div>
					<div class="col"><input type="text" name="title" value="${item.title}" class="form-control form-control-sm"></div>
				</div>
				
				<div class="row mb-2">
					<div class="col-2"><label>출판사 </label></div>
					<div class="col"><input type="text" name="publisher" value="${item.publisher}" class="form-control form-control-sm"></div>
				</div>
				
				<div class="row mb-2">
					<div class="col-2"><label>가격 </label></div>
					<div class="col"><input type="number" name="price" value="${item.price}" class="form-control form-control-sm"></div>
				</div>
				
				<div class="row mb-2">
					<div class="col-2"><label>출판일 </label></div>
					<div class="col"><input type="date" name="pubDate" value="${item.pubDate}" class="form-control form-control-sm"></div>
				</div>
				
				<div class="row mb-2">
					<div class="col-3"></div>
					<div class="col d-grid"><button class="btn btn-primary btn-sm">변경</button></div>
					<div class="col d-grid"><a href="../list" class="btn btn-secondary btn-sm">취소</a></div>
					<div class="col-3"></div>
				</div>
			</form>
			</div>
			<div class="col-3"></div>
		</div>
	</div>
</body>
</html>