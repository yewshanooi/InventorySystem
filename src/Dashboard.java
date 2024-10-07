import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Dashboard extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public Dashboard() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        viewPanel = new javax.swing.JPanel();
        searchField = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        viewTable = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        viewUserPopup = new javax.swing.JPanel();
        field1 = new javax.swing.JLabel();
        field2 = new javax.swing.JLabel();
        field3 = new javax.swing.JLabel();
        field4 = new javax.swing.JLabel();
        value1 = new javax.swing.JTextField();
        value2 = new javax.swing.JTextField();
        value3 = new javax.swing.JTextField();
        value4 = new javax.swing.JTextField();
        modifyButton = new javax.swing.JButton();
        removeButton = new javax.swing.JButton();
        l9 = new javax.swing.JLabel();
        databaseType = new javax.swing.JComboBox<>();
        addPanel = new javax.swing.JPanel();
        l2 = new javax.swing.JLabel();
        l3 = new javax.swing.JLabel();
        l4 = new javax.swing.JLabel();
        addName = new javax.swing.JTextField();
        addPassword = new javax.swing.JPasswordField();
        addType = new javax.swing.JComboBox<>();
        addButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Dashboard");
        setLocation(new java.awt.Point(0, 0));

        searchButton.setText("Search");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        jScrollPane1.setPreferredSize(new java.awt.Dimension(450, 402));

        viewTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        viewTable.getTableHeader().setReorderingAllowed(false);
        viewTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                viewTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(viewTable);

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        field1.setText("field1");

        field2.setText("field2");

        field3.setText("field3");

        field4.setText("field4");

        modifyButton.setText("Modify");

        removeButton.setText("Remove");

        javax.swing.GroupLayout viewUserPopupLayout = new javax.swing.GroupLayout(viewUserPopup);
        viewUserPopup.setLayout(viewUserPopupLayout);
        viewUserPopupLayout.setHorizontalGroup(
            viewUserPopupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewUserPopupLayout.createSequentialGroup()
                .addGroup(viewUserPopupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(viewUserPopupLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(viewUserPopupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(field2)
                            .addComponent(field1)
                            .addComponent(field3)
                            .addComponent(field4))
                        .addGap(18, 18, 18)
                        .addGroup(viewUserPopupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(value3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                            .addComponent(value2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(value1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(value4)))
                    .addGroup(viewUserPopupLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(modifyButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(removeButton)))
                .addGap(0, 45, Short.MAX_VALUE))
        );
        viewUserPopupLayout.setVerticalGroup(
            viewUserPopupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewUserPopupLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(viewUserPopupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(field1)
                    .addComponent(value1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(viewUserPopupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(field2)
                    .addComponent(value2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(viewUserPopupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(field3)
                    .addComponent(value3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(viewUserPopupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(field4)
                    .addComponent(value4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(viewUserPopupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(modifyButton)
                    .addComponent(removeButton))
                .addContainerGap())
        );

        l9.setText("Database");

        databaseType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None", "User", "Item" }));
        databaseType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                databaseTypeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout viewPanelLayout = new javax.swing.GroupLayout(viewPanel);
        viewPanel.setLayout(viewPanelLayout);
        viewPanelLayout.setHorizontalGroup(
            viewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewPanelLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(viewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(viewPanelLayout.createSequentialGroup()
                        .addGroup(viewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(viewPanelLayout.createSequentialGroup()
                                .addComponent(l9)
                                .addGap(18, 18, 18)
                                .addComponent(databaseType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 98, Short.MAX_VALUE))
                            .addComponent(searchField))
                        .addGap(18, 18, 18)
                        .addComponent(searchButton)))
                .addGap(40, 40, 40)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(viewUserPopup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        viewPanelLayout.setVerticalGroup(
            viewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, viewPanelLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(viewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(l9)
                    .addComponent(databaseType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(viewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(viewUserPopup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1)
                    .addGroup(viewPanelLayout.createSequentialGroup()
                        .addGroup(viewPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(53, 53, 53))
        );

        jTabbedPane1.addTab("View Database", viewPanel);

        l2.setText("Name");

        l3.setText("Password");

        l4.setText("Type");

        addType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None", "Staff", "Admin" }));

        addButton.setText("Submit");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout addPanelLayout = new javax.swing.GroupLayout(addPanel);
        addPanel.setLayout(addPanelLayout);
        addPanelLayout.setHorizontalGroup(
            addPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addPanelLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(addPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(addPanelLayout.createSequentialGroup()
                        .addGroup(addPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(l3)
                            .addComponent(l4)
                            .addComponent(l2))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(addPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addName, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 445, Short.MAX_VALUE))
        );
        addPanelLayout.setVerticalGroup(
            addPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addPanelLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(addPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(l2)
                    .addComponent(addName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(addPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(l3)
                    .addComponent(addPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(addPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(l4)
                    .addComponent(addType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addComponent(addButton)
                .addContainerGap(129, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Add User", addPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 698, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        // TODO add your handling code here:
        String userName = addName.getText();
        char[] charPass = addPassword.getPassword();
            String userPassword = new String(charPass);
        Object objType = addType.getSelectedItem();
            String userType = objType.toString();

        if (userName.isEmpty() || userPassword.isEmpty() || userType.equals("None")) {
            JOptionPane.showMessageDialog(this, "Fields are still empty", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Pattern pattern = Pattern.compile("\\s");
        Matcher matcher = pattern.matcher(userPassword);
        if (matcher.find()) {
            JOptionPane.showMessageDialog(this, "Password contain whitespace", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            User user = new User();
            user.createUser(userName, userPassword, userType);
            JOptionPane.showMessageDialog(this, "Successfully added user " + userName, "Add User", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "An error occurred while adding a user", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } finally {
            java.util.Arrays.fill(charPass, ' ');
        }
    }//GEN-LAST:event_addButtonActionPerformed

    private void databaseTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_databaseTypeActionPerformed
        // TODO add your handling code here:
        Object db = databaseType.getSelectedItem();
        FileHandler fh = new FileHandler();

        if (db.toString().equals("None")) {
            viewTable.setModel(new DefaultTableModel());
        } else if (db.toString().equals("User")) {
            String[][] content = fh.readFile("users.txt", 4, this);
            String[] header = {"User ID", "Name", "Password", "Role"};

            viewTable.setModel(new DefaultTableModel(content, header));
        } else if (db.toString().equals("Item")) {
            String[][] content = fh.readFile("ppe.txt", 3, this);
            String[] header = {"Item ID", "Quantity", "Supplier ID"};

            viewTable.setModel(new DefaultTableModel(content, header));
        }
    }//GEN-LAST:event_databaseTypeActionPerformed

    private void viewTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewTableMouseClicked
        // TODO add your handling code here:
//        int row = viewTable.getSelectedRow();
//
//        if (row != -1) {
//            String click1 = viewTable.getModel().getValueAt(row, 0).toString();
//            value1.setText(click1);
//            String click2 = viewTable.getModel().getValueAt(row, 1).toString();
//            value2.setText(click2);
//            String click3 = viewTable.getModel().getValueAt(row, 2).toString();
//            value3.setText(click3);
//            String click4 = viewTable.getModel().getValueAt(row, 3).toString();
//            value4.setText(click4);
//        } else {
//            JOptionPane.showMessageDialog(this, "Please select a row.");
//        }
    }//GEN-LAST:event_viewTableMouseClicked

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        // TODO add your handling code here:
        String query = searchField.getText().trim();
        
        if (query.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a query", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        ArrayList<String[]> fetch = new ArrayList<>();
        FileHandler fh = new FileHandler();
        
        try {
            ArrayList<ArrayList<String>> data = fh.to2dArray("users.txt");

            for (ArrayList<String> userData : data) {
                if (!userData.isEmpty() && userData.get(0).equalsIgnoreCase(query)) { // Ignore lower/upper case differences
                    fetch.add(new String[]{userData.get(0), userData.get(1), userData.get(2), userData.get(3)});
                    break; // Avoid adding the same row if there are multiple matching values
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "An error occurred while reading the file", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String[][] results = new String[fetch.size()][];
        for (int i = 0; i < fetch.size(); i++) {
            results[i] = fetch.get(i);
        }

        String[] header = {"User ID", "Name", "Password", "Role"};

        if (fetch.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No results found for:\n\n" + query, "Search", JOptionPane.INFORMATION_MESSAGE);
        } else {
            viewTable.setModel(new DefaultTableModel(results, header));
        }
    }//GEN-LAST:event_searchButtonActionPerformed

            
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Dashboard().setVisible(true);
//            }
//        });
//    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JTextField addName;
    private javax.swing.JPanel addPanel;
    private javax.swing.JPasswordField addPassword;
    private javax.swing.JComboBox<String> addType;
    private javax.swing.JComboBox<String> databaseType;
    private javax.swing.JLabel field1;
    private javax.swing.JLabel field2;
    private javax.swing.JLabel field3;
    private javax.swing.JLabel field4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel l2;
    private javax.swing.JLabel l3;
    private javax.swing.JLabel l4;
    private javax.swing.JLabel l9;
    private javax.swing.JButton modifyButton;
    private javax.swing.JButton removeButton;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchField;
    private javax.swing.JTextField value1;
    private javax.swing.JTextField value2;
    private javax.swing.JTextField value3;
    private javax.swing.JTextField value4;
    private javax.swing.JPanel viewPanel;
    private javax.swing.JTable viewTable;
    private javax.swing.JPanel viewUserPopup;
    // End of variables declaration//GEN-END:variables
}
