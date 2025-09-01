<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<div>
			<h3>도서 정보 변경</h3>
		</div>

		<div>
			<form method="post">
				<div>
					<div><label>시퀀스</label></div>
					<div><input type="number" name="code" value="${item.code}" readonly="readonly"></div>
				</div>
				
				<div>
					<div><label>도서명: </label></div>
					<div><input type="text" name="title" value="${item.title}"></div>
				</div>
				
				<div>
					<div><label>출판사: </label></div>
					<div><input type="text" name="publisher" value="${item.publisher}"></div>
				</div>
				
				<div>
					<div><label>가격 </label></div>
					<div><input type="number" name="price" value="${item.price}"></div>
				</div>
				
				<div>
					<div><label>출판일 </label></div>
					<div><input type="date" name="pubDate" value="${item.pubDate}"></div>
				</div>
				
				<div>
					<div><button>변경</button></div>
					<div><a href="../list"><button type="button">취소</button></a></div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>