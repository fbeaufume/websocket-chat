package com.adeliosys.chat;

import javax.websocket.OnMessage;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * WebSocket endpoint for the chat messages.
 */
@ServerEndpoint(value = "/endpoint")
public class ChatEndpoint {

	@OnMessage
	public void onMessage(String message, Session session) throws Exception {
		message = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + " " + message;

		for (Session s : session.getOpenSessions()) {
			if (s.isOpen()) {
				s.getAsyncRemote().sendText(message);
			}
		}
	}
}
