
import javax.swing.JOptionPane;


/**
 *
 * @author Ooi
 */
public class Main extends javax.swing.JFrame {

    /**
     * Creates new form Init
     */
    public Main() {
        initComponents();
    }
    
    public static boolean initStatus = false;

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
        jLabel2 = new javax.swing.JLabel();
        initialiseButton = new javax.swing.JButton();
        getStartedButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Inventory System");
        setLocation(new java.awt.Point(0, 0));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Welcome to Inventory System!");

        jLabel2.setText("Note: Please initialise the required files before getting started");

        initialiseButton.setText("Initialise files");
        initialiseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                initialiseButtonActionPerformed(evt);
            }
        });

        getStartedButton.setText("Get started");
        getStartedButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getStartedButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(initialiseButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(getStartedButton))
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(initialiseButton)
                    .addComponent(getStartedButton))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void initialiseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_initialiseButtonActionPerformed
        // TODO add your handling code here:
        
        if (!initStatus) {
            FileHandler fh = new FileHandler();
            Transfer transfer = new Transfer();
            Sort dateSort = new Sort();
            User user = new User();

            // Create file & initialise preset data
            String[] file = {"ppe.txt","hospitals.txt","suppliers.txt","transactions.txt","users.txt"};
            fh.createFile(file);

            // Initialise item amount
            String[] sp_item = {"SP1;HC;1000","SP1;FS;500","SP2;MS;10000","SP2;GL;10000","SP3;GW;100","SP3;SC;1000"};
            fh.initialize("suppliers.txt", sp_item);

            // String[] empty_item = {"HC;0;SP1","FS;0;SP1","MS;0;SP2","GL;0;SP2","GW;0;SP3","SC;0;SP3"};
            String[] fill_item = {"HC;100;SP1","FS;100;SP1","MS;100;SP2","GL;100;SP2","GW;100;SP3","SC;100;SP3"};
            String[] users = {"STF01;David;man123;Manager","STF02;Joe;staff123;Staff"};
            fh.initialize("ppe.txt", fill_item);
            fh.initialize("users.txt", users);

            // Receive Item
            int HeadCover=0,FaceShield=50,Mask=50,Glove=0,Gown=0,ShoeCover=0;
            String[][] itemUpdate = {{"HC;",Integer.toString(HeadCover)},{"FS;",Integer.toString(FaceShield)},{"MS;",Integer.toString(Mask)},{"GL;",Integer.toString(Glove)},{"GW;",Integer.toString(Gown)},{"SC;",Integer.toString(ShoeCover)}};
            transfer.filterInvalid(itemUpdate, true); // True to receive, false to send out

            // Filter date
            dateSort.validRange("2024-10-3", "2024-10-10");

            user.createUser("Karlson", "123", "Manager");


            // Delete file
            // fh.deleteFile(file);


            JOptionPane.showMessageDialog(this, "Successfully created ppe.txt, hospitals.txt, suppliers.txt, transactions.txt, and users.txt", "Initialise", JOptionPane.INFORMATION_MESSAGE);
            initStatus = true;
        } else {
            JOptionPane.showMessageDialog(this, "You have already initialised the files", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_initialiseButtonActionPerformed

    private void getStartedButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getStartedButtonActionPerformed
        // TODO add your handling code here:
        if (!initStatus) {
            JOptionPane.showMessageDialog(this, "You have not initialise the files", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            Login lg = new Login();
            lg.setVisible(true);

            this.dispose();
        }
    }//GEN-LAST:event_getStartedButtonActionPerformed
    
    
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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton getStartedButton;
    private javax.swing.JButton initialiseButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
