import javax.swing.*;
import java.awt.*;

    /*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
     */


    /**
     * @author admin
     */
    public class Calculator extends javax.swing.JFrame {

        /**
         * Creates new form Calculator
         */
        public Calculator() {
            initComponents();
        }

        /**
         * This method is called from within the constructor to initialize the form.
         * WARNING: Do NOT modify this code. The content of this method is always
         * regenerated by the Form Editor.
         */
        @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">
        private void initComponents() {

            jLabel1 = new javax.swing.JLabel();
            jSeparator1 = new javax.swing.JSeparator();
            jSeparator2 = new javax.swing.JSeparator();
            jLabel2 = new javax.swing.JLabel();
            jLabel3 = new javax.swing.JLabel();
            jLabel4 = new javax.swing.JLabel();
            txtSecondNumber = new javax.swing.JTextField();
            txtResult = new javax.swing.JTextField();
            btnAdd = new javax.swing.JButton();
            btnMinus = new javax.swing.JButton();
            btnMultiply = new javax.swing.JButton();
            btnDivide = new javax.swing.JButton();
            txtFirstNumber = new javax.swing.JTextField();

            setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

            jLabel1.setText("Calculator");

            jLabel2.setText("First number");

            jLabel3.setText("Second number");

            jLabel4.setText("Result");

            btnAdd.setText("+");
            btnAdd.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnAddActionPerformed(evt);
                }
            });

            btnMinus.setText("-");
            btnMinus.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnMinusActionPerformed(evt);
                }
            });

            btnMultiply.setText("*");
            btnMultiply.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnMultiplyActionPerformed(evt);
                }
            });

            btnDivide.setText("/");
            btnDivide.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    btnDivideActionPerformed(evt);
                }
            });

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                    .addContainerGap()
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(jSeparator2)
                                                            .addGroup(layout.createSequentialGroup()
                                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                            .addComponent(jLabel3)
                                                                            .addComponent(jLabel4)
                                                                            .addComponent(jLabel2))
                                                                    .addGap(18, 18, 18)
                                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                            .addComponent(txtSecondNumber)
                                                                            .addComponent(txtResult)
                                                                            .addComponent(txtFirstNumber)))))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                    .addGap(159, 159, 159)
                                                    .addComponent(jLabel1)
                                                    .addGap(0, 0, Short.MAX_VALUE)))
                                    .addGap(26, 26, 26))
                            .addGroup(layout.createSequentialGroup()
                                    .addGap(98, 98, 98)
                                    .addComponent(btnAdd)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnMinus)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnMultiply)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(btnDivide)
                                    .addContainerGap(103, Short.MAX_VALUE))
            );
            layout.setVerticalGroup(
                    layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                    .addGap(24, 24, 24)
                                    .addComponent(jLabel1)
                                    .addGap(18, 18, 18)
                                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel2)
                                            .addComponent(txtFirstNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(txtSecondNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel3))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(txtResult, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel4))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(btnAdd)
                                            .addComponent(btnMinus)
                                            .addComponent(btnMultiply)
                                            .addComponent(btnDivide))
                                    .addGap(19, 19, 19))
            );

            pack();
        }// </editor-fold>

        private void btnDivideActionPerformed(java.awt.event.ActionEvent evt) {
            StringBuilder sb = new StringBuilder();
            String num1 = txtFirstNumber.getText();
            String num2 = txtSecondNumber.getText();
            validateNumber(num1, sb, num2);

            if (sb.length() > 0) {
                JOptionPane.showMessageDialog(this, sb.toString());
                return;
            }
            calculate(num1, num2, '/');
        }


        private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {
            StringBuilder sb = new StringBuilder();
            String num1 = txtFirstNumber.getText();
            String num2 = txtSecondNumber.getText();
            validateNumber(num1, sb, num2);

            if (sb.length() > 0) {
                JOptionPane.showMessageDialog(this, sb.toString());
                return;
            }
            calculate(num1, num2, '+');
        }


        private void btnMinusActionPerformed(java.awt.event.ActionEvent evt) {
            StringBuilder sb = new StringBuilder();
            String num1 = txtFirstNumber.getText();
            String num2 = txtSecondNumber.getText();
            validateNumber(num1, sb, num2);

            if (sb.length() > 0) {
                JOptionPane.showMessageDialog(this, sb.toString());
                return;
            }
            calculate(num1, num2, '-');
        }

        private void calculate(String num1, String num2, char otp) throws HeadlessException {
            try {
                double n1 = Double.parseDouble(num1);
                double n2 = Double.parseDouble(num2);

                switch (otp) {
                    case '+': {
                        txtResult.setText("" + (n1 + n2));
                        break;
                    }
                    case '-': {
                        txtResult.setText("" + (n1 - n2));
                        break;
                    }
                    case '*': {
                        txtResult.setText("" + (n1 * n2));
                        break;
                    }
                    case '/': {
                        txtResult.setText("" + (n1 / n2));
                        break;
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        }

        private void btnMultiplyActionPerformed(java.awt.event.ActionEvent evt) {
            StringBuilder sb = new StringBuilder();
            String num1 = txtFirstNumber.getText();
            String num2 = txtSecondNumber.getText();
            validateNumber(num1, sb, num2);

            if (sb.length() > 0) {
                JOptionPane.showMessageDialog(this, sb.toString());
                return;
            }
            calculate(num1, num2, '*');
        }


        private void validateNumber(String num1, StringBuilder sb, String num2) {
            if (num1.equals("")) {
                sb.append("Fist number is required\n");
            }
            if (num2.equals("")) {
                sb.append("Second number is required\n");
            }
        }

        /**
         * @param args the command line arguments
         */
        public static void main(String[] args) {
            /* Set the Nimbus look and feel */
            //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
            /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
             * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
             */
            try {
                for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                    if ("Nimbus".equals(info.getName())) {
                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                        break;
                    }
                }
            } catch (ClassNotFoundException ex) {
                java.util.logging.Logger.getLogger(Calculator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                java.util.logging.Logger.getLogger(Calculator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                java.util.logging.Logger.getLogger(Calculator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                java.util.logging.Logger.getLogger(Calculator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
            //</editor-fold>

            /* Create and display the form */
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new Calculator().setVisible(true);
                }
            });
        }

        // Variables declaration - do not modify
        private javax.swing.JButton btnAdd;
        private javax.swing.JButton btnDivide;
        private javax.swing.JButton btnMinus;
        private javax.swing.JButton btnMultiply;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JLabel jLabel3;
        private javax.swing.JLabel jLabel4;
        private javax.swing.JSeparator jSeparator1;
        private javax.swing.JSeparator jSeparator2;
        private javax.swing.JTextField txtFirstNumber;
        private javax.swing.JTextField txtResult;
        private javax.swing.JTextField txtSecondNumber;
        // End of variables declaration
    }
