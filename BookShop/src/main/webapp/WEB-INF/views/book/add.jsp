<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="../include/head.jsp"></jsp:include>
<title></title>
</head>
<body>
<div class="container">
	
	<div class="row">
		<div class="col-3"></div>
		<div class="col">
		<div><h3>도서 등록</h3></div>
		<form method="post">
			<div class="row mb-2">
				<div class="col-2"><label>도서명</label></div>
				<div class="col"><input type="text" name="title" class="form-control form-control-sm"></div>
			</div>
			
			<div class="row mb-2">
				<div class="col-2"><label>출판사</label></div>
				<div class="col"><input type="text" name="publisher" class="form-control form-control-sm"></div>
			</div>
			
			<div class="row mb-2">
				<div class="col-2"><label>가격</label></div>
				<div class="col"><input type="number" name="price" class="form-control form-control-sm"></div>
			</div>
			
			<div class="row mb-2">
				<div class="col-2"><label>출판일</label></div>
				<div class="col"><input type="date" name="pubDate" class="form-control form-control-sm"></div>
			</div>
			
			<div class="row mb-2">
				<div class="col-3"></div>
				<div class="col d-grid"><button class="btn btn-primary btn-sm">등록</button></div>
				<div class="col d-grid"><a href="list" class="btn btn-secondary btn-sm">취소</a></div>
				<div class="col-3"></div>
			</div>
		</form>
		</div>
		<div class="col-3"></div>
	</div>
</div>
</body>
</html>