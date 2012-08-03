package org.wsdemo.servlets;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.websocket.MessageInbound;
import org.apache.catalina.websocket.WebSocketServlet;

@WebServlet("/ecm") 
public class WSEcho extends WebSocketServlet {

	private static final long serialVersionUID = 1L;

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected MessageInbound createWebSocketInbound(String subProtocol,
            HttpServletRequest request) {
        return new WSEchoInbound();
    }

    private static final class WSEchoInbound extends MessageInbound {

        public WSEchoInbound() {
            super();
        }

        @Override
        protected void onBinaryMessage(ByteBuffer message) throws IOException {
            getWsOutbound().writeBinaryMessage(message);
        }

        @Override
        protected void onTextMessage(CharBuffer message) throws IOException {
        	System.out.println("onTextMessage start");
            getWsOutbound().writeTextMessage(message);
        }
        
        @Override
        protected void onClose(int status) {
        	System.out.println("onClose() " + status);
        	super.onClose(status);
        }

    }
}
