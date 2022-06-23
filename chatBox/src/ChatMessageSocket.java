import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatMessageSocket {
    private Socket socket;
    private JTextPane txpMessageBoard;
    private PrintWriter out;
    private BufferedReader reader;

    public ChatMessageSocket(Socket socket, JTextPane txpMessageBoard) throws IOException {
        this.socket = socket;
        this.txpMessageBoard = txpMessageBoard;

        this.out = new PrintWriter(socket.getOutputStream());
        this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        receive();
    }

    public void receive() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        String line = reader.readLine();
                        if (!line.equals("")) {
                            txpMessageBoard.setText(txpMessageBoard.getText() + "\n" + line);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.start();
    }

    public void send(String msg) {
        txpMessageBoard.setText(txpMessageBoard.getText() + "\n" + msg);
        out.println(msg);
        out.flush();
    }

    public void close() {
        try {
            reader.close();
            out.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
