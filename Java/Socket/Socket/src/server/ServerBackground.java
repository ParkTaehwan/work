package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
 
public class ServerBackground {
 
    private ServerSocket serverSocket;
    private Socket socket;
    private ServerGui gui;
    private String msg;
 
    /** 세번째. 사용자들의 정보를 저장하는 맵입니다. */
    private Map<String, DataOutputStream> clientsMap = new HashMap<String, DataOutputStream>();
 
    public final void setGui(ServerGui gui) {
        this.gui = gui;
    }
 
    public void setting() throws IOException {
            Collections.synchronizedMap(clientsMap); // 네트워크 교통정리!
            serverSocket = new ServerSocket(7777);//7777을 서버 포트로 사용하겠다!
            while (true) {
                /* 첫번째. 서버가 할일 분담. 계속 접속받는것. */
                System.out.println("서버 대기중...");
                socket = serverSocket.accept(); // 먼저 서버가 할일은 계속 반복해서 사용자를 받는다.
                System.out.println(socket.getInetAddress() + "에서 접속했습니다.");
                // 여기서 새로운 사용자 쓰레드 클래스 생성해서 소켓정보를 넣어줌
                Receiver receiver = new Receiver(socket);
                receiver.start();
            }
    }
 
    public static void main(String[] args) throws IOException {
        ServerBackground serverBackground = new ServerBackground();
        serverBackground.setting();
    }
 
    // 맵의내용(클라이언트) 저장과 삭제
    public void addClient(String nick, DataOutputStream out) throws IOException {
        sendMessage(nick + "님이 접속하셨습니다.\n");
        clientsMap.put(nick, out);
    }
 
    public void removeClient(String nick) {
        sendMessage(nick + "님이 나가셨습니다.\n");
        clientsMap.remove(nick);
    }
 
    // 메시지 내용 전파
    public void sendMessage(String msg) {
        Iterator<String> it = clientsMap.keySet().iterator();
        String key = "";
        while (it.hasNext()) {
            key = it.next();
            try {
                clientsMap.get(key).writeUTF(msg);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
 
    // -----------------------------------------------------------------------------
    class Receiver extends Thread {
        private DataInputStream in;
        private DataOutputStream out;
        private String nick;
 
        /*두번째. 리시버가 한일은 자기 혼자서 네트워크 처리 계속..듣기.. 처리해주는 것. */
        public Receiver(Socket socket) throws IOException {
            out = new DataOutputStream(socket.getOutputStream());
            in = new DataInputStream(socket.getInputStream());
            nick = in.readUTF();
            addClient(nick, out);
        }
 
        public void run() {
            try {// 계속 듣기만!!
                while (in != null) {
                    msg = in.readUTF();
                    sendMessage(msg);
                    gui.appendMsg(msg);
                }
            } catch (IOException e) {
                // 사용접속종료시 여기서 에러 발생-->접속 종료한것. 여기서 리무브 클라이언트 처리
                removeClient(nick);
            }
        }
    }
}