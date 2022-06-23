import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class ClientHandler implements Runnable {
    public static ArrayList<ClientHandler> clientHandlers = new ArrayList<>();
    private JTextPane txpMessageBoard;
    private Socket socket;
    private PrintWriter out;
    private BufferedReader reader;
    private String userName;


    public ClientHandler(JTextPane txpMessageBoard, Socket socket) throws IOException {
        this.txpMessageBoard = txpMessageBoard;
        this.socket = socket;

        this.out = new PrintWriter(socket.getOutputStream());
        this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.userName = reader.readLine();
        txpMessageBoard.setText(txpMessageBoard.getText() + "\n" + userName + " has joined the chat");
        send(userName + " has joined the chat");
        clientHandlers.add(this);
    }


    public BufferedReader getReader() {
        return reader;
    }

    @Override
    public void run() {
        while (socket.isConnected()) {
            try {
                String line = reader.readLine();
                if (line != null || !line.equals("")) {
                    txpMessageBoard.setText(txpMessageBoard.getText() + "\n" + line);
                    send(line);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static ArrayList<ClientHandler> getClientHandlers() {
        return clientHandlers;
    }

    public PrintWriter getOut() {
        return out;
    }

    public void send(String msg) {
        for (ClientHandler clientHandler : clientHandlers) {
            if (!clientHandler.userName.equals(userName)) {
                clientHandler.out.println(msg);
                clientHandler.out.flush();
            }
        }
    }
    //or (ClientHandler clientHandler : clientHandlers) {
    //            try {
    //                // You don't want to broadcast the message to the user who sent it.
    //                if (!clientHandler.clientUsername.equals(clientUsername)) {
    //                    clientHandler.bufferedWriter.write(messageToSend);
    //                    clientHandler.bufferedWriter.newLine();
    //                    clientHandler.bufferedWriter.flush();
    //                }

    private void removeClientHandler(){
        clientHandlers.remove(this);
        txpMessageBoard.setText(txpMessageBoard.getText() + "\n" + userName + " has left the chat");
    }

    public void close() {
        removeClientHandler();
        try {
            reader.close();
            out.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
