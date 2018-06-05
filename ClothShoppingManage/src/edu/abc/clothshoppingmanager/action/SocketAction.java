package edu.abc.clothshoppingmanager.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/websocket")
public class SocketAction {
	
	public static Map<String, Session> sessionMap=new HashMap<String, Session>();
	
	public void onMessage(String message,Session session) throws IOException, InterruptedException {
		System.out.println("接收到的消息"+message);
		session.getBasicRemote().sendText("");
	}
}
