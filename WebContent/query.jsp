<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>输入信息</title>
<script type="text/javascript">
	function check(){
		if(document.getElementById("form1").name.value==""){
			alert("请输入用户名！");
			document.getElementById("form1").username.focus();
			return false;
		}
		
		if(document.getElementById("form1").s_number.value==""){
			alert("请输入学号！");
			document.getElementById("form1").s_number.focus();
			return false;
		}
	}
</script>
</head>
<body>
	<form id="form1" name="form1" action="query" style="text-align:center;" method="post" onsubmit="return check();">
		<p>姓名：<input type="text" name="s_name" value=""></p>
		
		<p>性别：
		<label>
		<input type="radio" name="radiogrop1" value="男">男
		</label>
		<label>
		<input type="radio" name="radiogrop2" value="女">女
		</label>
		<label>
		<input type="radio" name="radiogrop3" value="保密">保密
		</label>
		
		</p>
		
		<p>学号：<input type="text" name="s_number" value=""></p>
		<p><input type="submit" value="提交"></p>
	</form>
</body>
</html>