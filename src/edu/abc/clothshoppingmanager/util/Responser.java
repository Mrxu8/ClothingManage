package edu.abc.clothshoppingmanager.util;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Responser {//这是定义一个response来将弄好的JSON数据发送到页面,因为复用单写一个类来调用

	public static void responseToJson(HttpServletResponse response,HttpServletRequest request,String jsonText) throws Exception {
		response.setContentType("text/json;charset=utf-8");
		PrintWriter out=response.getWriter();
		out.write(jsonText);
		out.flush();
		out.close();
	}
}