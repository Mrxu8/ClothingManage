<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>CheckBox Selection on DataGrid - jQuery EasyUI Demo</title>
	<link rel="stylesheet" type="text/css" href="themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="themes/icon.css">
	<link rel="stylesheet" type="text/css" href="css/demo.css">
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
</head>
<body>
	
	
	<div style="margin:5px 0;"></div>
		<div id="tb" style="padding:2px 5px;">
			Date From: <input class="easyui-datebox" style="width:110px">
			To: <input class="easyui-datebox" style="width:110px">
			Language: 
			<select class="easyui-combobox" panelHeight="auto" style="width:100px">
				<option value="java">Java</option>
				<option value="c">C</option>
				<option value="basic">Basic</option>
				<option value="perl">Perl</option>
				<option value="python">Python</option>
			</select>
			<a href="#" class="easyui-linkbutton" iconCls="icon-search">Search</a>
		</div>
		<table id="dg" class="easyui-datagrid"  style="width:100%;height:400px"
				data-options="rownumbers:true,singleSelect:true,url:'datagrid_data1.json',method:'get'">			
			<thead>
				<tr>
					<th data-options="field:'ck',checkbox:true"></th>
					<th data-options="field:'itemid',width:80">Item ID</th>
					<th data-options="field:'productid',width:150">商品</th>
				
					<th data-options="field:'unitcost',width:120,align:'right'">评论人</th>
					<th data-options="field:'unitcost',width:220,align:'right'">评论时间</th>
					<th data-options="field:'attr1',width:220">评论内容</th>
					
				</tr>
			</thead>
		</table>
		<div style="margin:10px 0;">
			<span>Selection Mode: </span>
			<select onchange="$('#dg').datagrid({singleSelect:(this.value==0)})">
				<option value="0">Single Row</option>
				<option value="1">Multiple Rows</option>
			</select><br/>
			SelectOnCheck: <input type="checkbox" checked onchange="$('#dg').datagrid({selectOnCheck:$(this).is(':checked')})"><br/>
			CheckOnSelect: <input type="checkbox" checked onchange="$('#dg').datagrid({checkOnSelect:$(this).is(':checked')})">
		</div>
	

</body>
</html>