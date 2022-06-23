//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager.LookAndFeelInfo;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client extends JFrame {
    private ChatMessageSocket messageSocket;

    private JButton btnListen;
    private JButton btnSend;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JScrollPane jScrollPane1;
    private JSeparator jSeparator1;
    private JTextPane txbMessageBorad;
    private JTextField txtMessage;
    private JTextField txtPort;
    private JTextField txtServerHost;

    public Client() {
        this.initComponents();
        this.setLocationRelativeTo((Component)null);
    }

    private void initComponents() {
        this.jLabel1 = new JLabel();
        this.jSeparator1 = new JSeparator();
        this.txtPort = new JTextField();
        this.jLabel2 = new JLabel();
        this.btnListen = new JButton();
        this.jScrollPane1 = new JScrollPane();
        this.txbMessageBorad = new JTextPane();
        this.jLabel3 = new JLabel();
        this.btnSend = new JButton();
        this.txtMessage = new JTextField();
        this.jLabel4 = new JLabel();
        this.txtServerHost = new JTextField();
        this.setDefaultCloseOperation(3);
        this.jLabel1.setFont(new Font("Segoe UI", 1, 18));
        this.jLabel1.setText("Chat Client");
        this.txtPort.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Client.this.txtPortActionPerformed(evt);
            }
        });
        this.jLabel2.setText("Port");
        this.btnListen.setText("Listen");
        this.btnListen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Client.this.btnListenActionPerformed(evt);
            }
        });
        this.jScrollPane1.setViewportView(this.txbMessageBorad);
        this.jLabel3.setText("Message");
        this.btnSend.setText("Send");
        this.btnSend.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Client.this.btnSendActionPerformed(evt);
            }
        });
        this.jLabel4.setText("Server Host");
        GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.jSeparator1).addGroup(layout.createSequentialGroup().addGap(10, 10, 10).addGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.jLabel4).addGap(18, 18, 18).addComponent(this.txtServerHost, -2, 160, -2).addPreferredGap(ComponentPlacement.RELATED, -1, 32767).addComponent(this.jLabel2).addPreferredGap(ComponentPlacement.UNRELATED).addComponent(this.txtPort, -2, 45, -2).addGap(18, 18, 18).addComponent(this.btnListen)).addComponent(this.jScrollPane1).addGroup(layout.createSequentialGroup().addComponent(this.jLabel3).addGap(18, 18, 18).addComponent(this.txtMessage, -2, 185, -2).addPreferredGap(ComponentPlacement.RELATED, 140, 32767).addComponent(this.btnSend))))).addContainerGap()).addGroup(Alignment.TRAILING, layout.createSequentialGroup().addContainerGap(-1, 32767).addComponent(this.jLabel1).addGap(197, 197, 197)));
        layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel1).addGap(18, 18, 18).addComponent(this.jSeparator1, -2, 5, -2).addPreferredGap(ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(this.jLabel4).addComponent(this.txtServerHost, -2, -1, -2)).addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(this.txtPort, -2, -1, -2).addComponent(this.jLabel2).addComponent(this.btnListen))).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.jScrollPane1, -2, 202, -2).addGap(18, 18, 18).addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(this.jLabel3).addComponent(this.btnSend).addComponent(this.txtMessage, -2, -1, -2)).addContainerGap(-1, 32767)));
        this.pack();
    }

    private void txtPortActionPerformed(ActionEvent evt) {
    }

    private void btnListenActionPerformed(ActionEvent evt) {
        try {
            Socket socket = new Socket(txtServerHost.getText(), Integer.parseInt(txtPort.getText()));
            txbMessageBorad.setText(txbMessageBorad.getText() + "\n Connected");
            messageSocket = new ChatMessageSocket(socket, txbMessageBorad);

        }catch (Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage());
            e.printStackTrace();
        }
    }

    private void btnSendActionPerformed(ActionEvent evt) {
        if (txtMessage.getText().equals("")){
            return;
        }
        messageSocket.send("Client: " + txtMessage.getText());
        txtMessage.setText("");
    }

    public static void main(String[] args) {
        try {
            LookAndFeelInfo[] var1 = UIManager.getInstalledLookAndFeels();
            int var2 = var1.length;

            for(int var3 = 0; var3 < var2; ++var3) {
                LookAndFeelInfo info = var1[var3];
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException var5) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, (String)null, var5);
        } catch (InstantiationException var6) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, (String)null, var6);
        } catch (IllegalAccessException var7) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, (String)null, var7);
        } catch (UnsupportedLookAndFeelException var8) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, (String)null, var8);
        }

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                (new Client()).setVisible(true);
            }
        });
    }
}

