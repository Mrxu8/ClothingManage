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
	<strong style="font-size: 14px;">选择配送商家：</strong><select>
	<option id="o" value="顺丰快递">顺丰快递</option>
	</select></div><br>
	<table id="fl" title="物流状态" style="border:1px solid black; width:100%;height:500px;margin: 0px;"
			data-options="rownumbers:true,singleSelect:true,pagination:true,url:'admin/DistributionAction!classifyDistribution.action',method:'get'">
		<thead>
			<tr>
				<th data-options="field:'userid',width:40,align:'left'">商品编号</th>
				<th data-options="field:'username',width:120,align:'left'">商品图片</th>
				<th data-options="field:'nickname',width:40,align:'left'">数量</th>
				<th data-options="field:'sex',width:40,align:'left'">价格</th>
				<th data-options="field:'age',width:60,align:'left'">付费状态</th>
				<th data-options="field:'job',width:60,align:'left'">配送方式</th>
				<th data-options="field:'image',width:60,align:'left'">配送状态</th>
				<th data-options="field:'image',width:120,align:'left'">包裹物流</th>
			</tr>
		</thead>
			<tr><th>001</th><th><img alt="" src="images/..."></th><th>3</th><th>66.6</th>
			<th>已付款</th><th>韵达快递</th><th>发货中</th><th>商家已发货</th></tr>
	</table>
<script type="text/javascript">
$(document).ready(function(){
	$("#s").click(function(){
		
	});
});
</script>
</body>
</html>