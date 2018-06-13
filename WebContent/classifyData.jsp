<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="themes/icon.css">
	<link rel="stylesheet" type="text/css" href="css/demo.css">
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
</head>
<body style="margin: 0px; padding: 0px;">
<table id="ta" class="easyui-datagrid" title="商品-按商家物流查看" style="width:100%;height:500px"
		data-options="singleSelect:true,fitColumns:true,
		method:'get'" url="admin/DistributionAction!classifyDistribution.action?distribution=${param.distribution}">
	<thead>
		<tr>
			<th data-options="field:'order_id',width:80,align:'left'">订单编号</th>
			<th data-options="field:'goods_id',width:80,align:'left'">商品编号</th>
			<th data-options="field:'goods_name',width:100,align:'left'">商品名称</th>
			<th data-options="field:'picture',width:120,align:'center'">商品图片</th>
			<th data-options="field:'price',width:80,align:'center'">商品价格</th>
			<th data-options="field:'count',width:80,align:'left'">购买数量</th>
			<th data-options="field:'total',width:80,align:'left'">合计</th>
			<th data-options="field:'distribution',width:80,align:'left'">配送物流</th>
			<th data-options="field:'distributions',width:120,align:'left'">物流信息</th>
		</tr>
	</thead>
</table>
</body>
</html>