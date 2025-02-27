import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ooi
 */
public class Main extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Main() {
        initComponents();
    }
    
    public static boolean authStatus = false;
    public static String userType;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        loginUsername = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        loginButton = new javax.swing.JButton();
        loginPassword = new javax.swing.JPasswordField();
        initButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setLocation(new java.awt.Point(0, 0));

        jLabel1.setText("User ID");

        jLabel2.setText("Password");

        loginButton.setText("Login");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        initButton.setText("Initialisation");
        initButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                initButtonActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Welcome to Inventory System");

        jLabel4.setText("Management, made easy.");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(loginUsername)
                                    .addComponent(loginPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(loginButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(initButton)))))
                .addContainerGap(56, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(119, 119, 119))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addGap(66, 66, 66)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(loginUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(loginPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loginButton)
                    .addComponent(initButton))
                .addContainerGap(72, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        // TODO add your handling code here:
        boolean isEmpty = false;

        String[] files = {"ppe.txt","hospitals.txt","suppliers.txt","users.txt"};

        try {
            for (String n : files) {
                BufferedReader bw = new BufferedReader(new FileReader(n));
                if (bw.readLine() == null) {
                    isEmpty = true;
                    break;
                }
                bw.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (isEmpty) {
            JOptionPane.showMessageDialog(this, "Files are currently empty. Please initialise first before logging in!", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            String id = loginUsername.getText();
            char[] passwordChar = loginPassword.getPassword(); // The .getText() method for password is deprecated as it returns value in String which is not secure
                String password = new String(passwordChar); // Convert passwordChar (char) to password (String)

            try {
                String file = "users.txt";
                BufferedReader br = new BufferedReader(new FileReader(file));

                String line;

                while ((line = br.readLine()) != null) {
                    String[] part = line.split(";");

                    String getID = part[0];
                    String getName = part[1];
                    String getPassword = part[2];
                    String getType = part[3];
    
                    if (id.equals(getID) && password.equals(getPassword)) {
                        User.setUID(getID);
                        User.setUsername(getName);
                        authStatus = true;

                        if (getType.equals("Admin")) {
                            userType = "admin";
                        } else if (getType.equals("Staff")) {
                            userType = "staff";
                        }

                        JOptionPane.showMessageDialog(this, "Welcome, " + getName + "!\n" + "You are logged in as " + userType, "Login", JOptionPane.INFORMATION_MESSAGE);

                        Dashboard db = new Dashboard();
                        db.setVisible(true);

                        this.dispose();
                        break;
                    }
                }

                if (!authStatus) {
                    loginUsername.setText("");
                    loginPassword.setText("");
                    JOptionPane.showMessageDialog(this, "Your ID or password is incorrect. Please try again", "Error", JOptionPane.ERROR_MESSAGE);
                }

                br.close();
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "An error occurred while reading the file", "Error", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            } finally {
                java.util.Arrays.fill(passwordChar, ' '); // Clear the passwordChar from memory for security purpose
            }
        }
    }//GEN-LAST:event_loginButtonActionPerformed

    private void initButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_initButtonActionPerformed
        // TODO add your handling code here:
        FileHandler fh = new FileHandler();
        
        String[] options = {"Yes", "No"};
        int choice = JOptionPane.showOptionDialog(this, "Do you want to set the item values as 100?", "Initialise", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        int choice2 = JOptionPane.showOptionDialog(this, "Do you want to reset Hospital, Supplier and User data?", "Initialise", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

        String[] users = {"STF01;Karlson;pw123#;Admin","STF02;Shan;pw456#;Staff","STF03;John Doe;pw789$;Staff","STF04;Jane Doe;pw012$;Admin"};
        String[] sp_item = {"SP1;HC;1000","SP1;FS;500","SP2;MS;10000","SP2;GL;10000","SP3;GW;100","SP3;SC;1000"};
        String[] hp_item = {"HP1;HC;100","HP1;FS;100","HP1;MS;100","HP1;GL;100","HP1;GW;100","HP1;SC;100","HP2;HC;100","HP2;FS;100","HP2;MS;100","HP2;GL;100","HP2;GW;100","HP2;SC;100","HP3;HC;100","HP3;FS;100","HP3;MS;100","HP3;GL;100","HP3;GW;100","HP3;SC;100"};
        String[] transactions = {};
        
        if (choice == 0) {
            String[] item = {"HC;100;SP1;Head Cover","FS;100;SP1;Face Shield","MS;100;SP2;Mask","GL;100;SP2;Glove","GW;100;SP3;Gown","SC;100;SP3;Shoe Cover"};
            fh.initialize("ppe.txt", item);
        } else if (choice == 1) {
            String[] item = {"HC;0;SP1;Head Cover","FS;0;SP1;Face Shield","MS;0;SP2;Mask","GL;0;SP2;Glove","GW;0;SP3;Gown","SC;0;SP3;Shoe Cover"};
            fh.initialize("ppe.txt", item);
        }
        
        if (choice2 == 0) {
            fh.initialize("users.txt", users);
            fh.initialize("suppliers.txt", sp_item);
            fh.initialize("hospitals.txt", hp_item);
            fh.initialize("transactions.txt", transactions);
        }
    }//GEN-LAST:event_initButtonActionPerformed


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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
        
        FileHandler fh = new FileHandler();
        // User user = new User();
        
        // Create empty files
        String[] file = {"ppe.txt","hospitals.txt","suppliers.txt","transactions.txt","users.txt"};

        fh.createFile(file);

        // Filter date
        // dateSort.validRange("3-10-2024", "10-10-2024");

        // Delete file
        // fh.deleteFile(file);
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton initButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton loginButton;
    private javax.swing.JPasswordField loginPassword;
    private javax.swing.JTextField loginUsername;
    // End of variables declaration//GEN-END:variables
}
