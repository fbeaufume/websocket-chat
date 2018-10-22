package com.adeliosys.chat;

import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * WebSocket endpoint for the chat messages.
 */
@ServerEndpoint(value = "/endpoint/{room}")
public class ChatWithRoomEndpoint {

	@OnOpen
	public void onOpen(@PathParam("room") String room, Session session) {
		session.getUserProperties().put("room", room);
	}

	@OnMessage
	public void onMessage(@PathParam("room") String room, String message, Session session) throws Exception {
		message = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + " " + message;

		for (Session s : session.getOpenSessions()) {
			if (s.isOpen() && room.equals(s.getUserProperties().get("room"))) {
				s.getAsyncRemote().sendText(message);
			}
		}
	}
}
