<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>物流分类查看</title>
	<link rel="stylesheet" type="text/css" href="themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="themes/icon.css">
	<link rel="stylesheet" type="text/css" href="css/demo.css">
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
</head>
<body style="margin: 5px; padding: 0px;">
	<div align="center" style="margin-top: 8px;">
	<strong style="font-size: 14px;">选择配送商家：</strong>
	<select id="select">
	<option id="d1" value="1" selected="selected">顺丰快递</option>
	<option id="d2" value="2">中通快递</option>
	<option id="d3" value="3">韵达快递</option>
	<option id="d4" value="4">圆通快递</option>
	<option id="d5" value="5">申通快递</option>
	<option id="d6" value="6">EMS</option>
	</select></div><br>
	<iframe id="data" style="width: 100%; height: 500px;"></iframe>

<script type="text/javascript">
		$(document).ready(function(){
			var options=$("#select option:selected");//获取选中的项
			var ss=options.val();//拿到选中项的值
			$("#data").attr("src","classifyData.jsp?distribution="+ss);
		});
</script>
</body>
</html>