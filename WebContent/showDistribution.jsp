<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>查看物流状态</title>
	<link rel="stylesheet" type="text/css" href="themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="themes/icon.css">
	<link rel="stylesheet" type="text/css" href="css/demo.css">
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="js/datagrid-detailview.js"></script>
</head>
<body style="margin: 5px; padding: 0px;">
	<table id="dg" style="width:100%;height:530px" title="订单-商品物流信息"
		data-options="pagination:true,singleSelect:true,rownumbers:true,fitColumns:true,
		url:'admin/DistributionAction!listDistributionByPage.action?count=10',method:'get'">
		<thead>
			<tr>
				<th id="order_id" field="order_id" align="center" width="40">订单编号</th>
				<th field="user_id" align="center" width="40">购买用户</th>
				<th field="payment" align="left" width="40">付款金额</th>
				<th field="status" align="center" width="40">付款状态</th>
				<th field="payment_type" align="center" width="40">付款方式</th>
				<th field="note" width="80" align="left">用户备注</th>
			</tr>
		</thead>
	</table>

<script type="text/javascript">
$('#dg').datagrid({
	view: detailview,
	detailFormatter:function(index,row){
		return '<div style="padding:2px"><table class="ddv"></table></div>';
	},
	onExpandRow: function(index,row){
		var ddv = $(this).datagrid('getRowDetail',index).find('table.ddv');
		ddv.datagrid({
			url:'admin/DistributionAction!distributionByOrder.action?orderid='+(index+1)+'&itemid='+row.itemid,
			fitColumns:true,
			singleSelect:true,
			rownumbers:true,
			loadMsg:'',
			height:'auto',
			columns:[[
				{field:'goods_id',title:'商品编号',width:40},
				{field:'goods_name',title:'商品名称',width:40},
				{field:'picture',title:'商品图片',width:50},
				{field:'price',title:'商品价格',width:40},
				{field:'count',title:'购买数量',width:40},
				{field:'total',title:'合计',width:40},
				{field:'distribution',title:'配送物流',width:40},
				{field:'distributions',title:'物流信息',width:60}
			]],
			onResize:function(){
				$('#dg').datagrid('fixDetailRowHeight',index);
			},
			onLoadSuccess:function(){
				setTimeout(function(){
					$('#dg').datagrid('fixDetailRowHeight',index);
				},0);
			}
		});
		$('#dg').datagrid('fixDetailRowHeight',index);
	}
});
</script>
</body>
</html>