<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<script src="/js/signup.js"></script>
</head>
<body>
	<div>
		<div>
			<h3>회원가입</h3>
		</div>
		
		<div>
			<form method="post" name="signup_form">
				<div>
					<div><label>아이디:</label></div>
					<div><input type="text" name="id"><button type="button" id="check_id">중복확인</button></div>
				</div>
				
					<div><label>비밀번호:</label></div><div>
					<div><input type="text" name="password"></div>
				</div>
				
				<div>
					<div><label>성명:</label></div>
					<div><input type="text" name="name"></div>
				</div>
				
				<div>
					<div><label>전화번호:</label></div>
					<div><input type="text" name="tel"></div>
				</div>
				
				<div>
					<div><button type="button" id="signup">회원가입</button></div>
					<div><a href=".."><button type="button">취소</button></a></div>
				</div>
			</form>
		</div>
	</div>
	
</body>
</html>