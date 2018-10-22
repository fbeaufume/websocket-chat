# WebSocket Chat Sample

This is a very basic WebSocket chat application based on Java EE 7.

Build with `mvn package`.

Deploy to your compliant application server (tested with WildFly 10.1.0 and 14.0.1)
by simply copying the war file.

Then open `http://localhost:8080/websocket-chat/`.

Does not work as-is with Tomcat 8.5.34 or 9.0.12 due to the Session.getOpenSessions() bug,
see https://stackoverflow.com/questions/47612057/tomcats-interpretation-of-javax-websocket-sessiongetopensessions
