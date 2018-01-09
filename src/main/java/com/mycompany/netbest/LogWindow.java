
package com.mycompany.netbest;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import static sun.security.jgss.GSSUtil.login;

public class LogWindow extends javax.swing.JFrame {
String login;
    class DB{
    Connection conn;
    boolean zalogowany;
    PreparedStatement stmt = null;
    ResultSet rs;
    
    
    public DB(){
            
}
    
public String hashPassword(String password) throws NoSuchAlgorithmException{
        MessageDigest md = MessageDigest.getInstance("SHA");
        md.update(password.getBytes());
        byte[] b = md.digest();
        StringBuffer sb = new StringBuffer();
        for(byte b1 : b){
            sb.append(Integer.toHexString(b1 & 0xff).toString());
        }
        return sb.toString();
    }
    
    
    public void click() throws NoSuchAlgorithmException{

login = loginText.getText();
String pass = passText.getText();
if (login.equals("")||pass.equals("")){
    error.setVisible(true);
}
else {        
        try {
           
            loginUser(login, pass);
            // TODO add your handling code here:
        } catch (SQLException ex) {
            Logger.getLogger(LogWindow.class.getName()).log(Level.SEVERE, null, ex);
        }}
    }
   public void loginUser(String name, String pass) throws SQLException, NoSuchAlgorithmException {
   
   
   try {
      conn = DriverManager.getConnection("jdbc:mysql://sql2.freesqldatabase.com/sql2212964", "sql2212964", "tV5!yB5!");
      stmt = conn.prepareStatement("SELECT COUNT(login) FROM Users WHERE login = ? and password = ?");
      stmt.setString(1, name);
      stmt.setString(2, hashPassword(pass));
      stmt.executeQuery(); 
      
      rs = stmt.executeQuery( ); 
      while(rs.next()){  
          zalogowany = rs.getString(1).equals("1");
   
      }
   }
   finally {
      try {
         if (stmt != null) { stmt.close(); }
      }
      catch (SQLException e) {
         
      }
      try {
         if (conn != null) { conn.close(); }
      }
      catch (SQLException e) {
       
      }
   }
    }
    }
   
 
    public LogWindow() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        errorLog = new javax.swing.JDialog();
        jPanel2 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        NetBest = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        loginText = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        zalogujSieButton = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        error = new javax.swing.JLabel();
        passText = new javax.swing.JPasswordField();

        errorLog.setLocationByPlatform(true);
        errorLog.setMinimumSize(new java.awt.Dimension(200, 100));
        errorLog.setResizable(false);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(207, 6, 46));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("Próba logowania nie powiodła się!");
        jLabel23.setToolTipText("");
        jLabel23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel23MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel23MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel23)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout errorLogLayout = new javax.swing.GroupLayout(errorLog.getContentPane());
        errorLog.getContentPane().setLayout(errorLogLayout);
        errorLogLayout.setHorizontalGroup(
            errorLogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        errorLogLayout.setVerticalGroup(
            errorLogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(207, 6, 46));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("Próba logowania nie powiodła się!");
        jLabel24.setToolTipText("");
        jLabel24.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel24MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel24MouseExited(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("NetBest");
        setMaximumSize(new java.awt.Dimension(300, 375));
        setMinimumSize(new java.awt.Dimension(300, 375));
        setPreferredSize(new java.awt.Dimension(300, 375));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(300, 500));
        jPanel1.setMinimumSize(new java.awt.Dimension(300, 500));

        NetBest.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        NetBest.setForeground(new java.awt.Color(207, 6, 46));
        NetBest.setText("NetBest");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(216, 45, 2));
        jLabel3.setText("Login:");

        loginText.setText("DR");
        loginText.setBorder(null);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(216, 45, 2));
        jLabel4.setText("Hasło:");

        zalogujSieButton.setBackground(new java.awt.Color(255, 255, 255));
        zalogujSieButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        zalogujSieButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                zalogujSieButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                zalogujSieButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                zalogujSieButtonMouseExited(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(207, 6, 46));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("Zaloguj się");
        jLabel22.setToolTipText("");
        jLabel22.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel22MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel22MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel22MouseExited(evt);
            }
        });

        javax.swing.GroupLayout zalogujSieButtonLayout = new javax.swing.GroupLayout(zalogujSieButton);
        zalogujSieButton.setLayout(zalogujSieButtonLayout);
        zalogujSieButtonLayout.setHorizontalGroup(
            zalogujSieButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(zalogujSieButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        zalogujSieButtonLayout.setVerticalGroup(
            zalogujSieButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, zalogujSieButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel22)
                .addContainerGap())
        );

        error.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        error.setForeground(new java.awt.Color(207, 6, 46));
        error.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        error.setText("Próba logowania nie powiodła się!");
        error.setToolTipText("");
        error.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                errorMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                errorMouseExited(evt);
            }
        });

        passText.setText("joanna");
        passText.setBorder(null);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(error, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator3)
                    .addComponent(zalogujSieButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1)
                    .addComponent(loginText)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(NetBest, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(passText)
                    .addComponent(jSeparator2)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(75, 75, 75))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(NetBest)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(loginText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(zalogujSieButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(error)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void zalogujSieButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_zalogujSieButtonMouseEntered
zalogujSieButton.setBackground(Color.getHSBColor(0, 0, (float) 0.97));
        // TODO add your handling code here:
    }//GEN-LAST:event_zalogujSieButtonMouseEntered

    private void zalogujSieButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_zalogujSieButtonMouseExited
zalogujSieButton.setBackground(Color.getHSBColor(0, 0, (float) 1));
        // TODO add your handling code here:
    }//GEN-LAST:event_zalogujSieButtonMouseExited

    private void jLabel22MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseEntered
zalogujSieButton.setBackground(Color.getHSBColor(0, 0, (float) 0.97));
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel22MouseEntered

    private void jLabel22MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseExited
zalogujSieButton.setBackground(Color.getHSBColor(0, 0, (float) 1));
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel22MouseExited

    private void zalogujSieButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_zalogujSieButtonMouseClicked
DB db = new DB();
        try {
            MainWindow zmiana;
    zmiana = new MainWindow();
    zmiana.db = db;
    db.click();
   if(db.zalogowany==true){
    zmiana.setVisible(true);
    this.setVisible(false);}
    else{
        error.setVisible(true);
    }
            // TODO add your handling code here:
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(LogWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_zalogujSieButtonMouseClicked

    private void jLabel23MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel23MouseExited

    private void jLabel23MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel23MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel23MouseEntered

    private void jLabel24MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel24MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel24MouseEntered

    private void jLabel24MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel24MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel24MouseExited

    private void errorMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_errorMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_errorMouseEntered

    private void errorMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_errorMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_errorMouseExited

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
error.setVisible(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    private void jLabel22MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel22MouseClicked
DB db = new DB();
        try {
    MainWindow zmiana;
    zmiana = new MainWindow();
    zmiana.db = db;
    
    db.click();
    if(db.zalogowany==true){
    zmiana.setVisible(true);
    this.setVisible(false);}
    else{
        error.setVisible(true);
    }
            // TODO add your handling code here:
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(LogWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabel22MouseClicked

    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(LogWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LogWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LogWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LogWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LogWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel NetBest;
    private javax.swing.JLabel error;
    private javax.swing.JDialog errorLog;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextField loginText;
    private javax.swing.JPasswordField passText;
    private javax.swing.JPanel zalogujSieButton;
    // End of variables declaration//GEN-END:variables
}
