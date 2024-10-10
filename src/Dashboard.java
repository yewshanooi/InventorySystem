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
    
    public static String currentDB;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        viewDatabasePanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        searchField = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        viewTable = new javax.swing.JTable();
        viewUserPopup = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        field1 = new javax.swing.JLabel();
        field2 = new javax.swing.JLabel();
        field3 = new javax.swing.JLabel();
        field4 = new javax.swing.JLabel();
        viewUserName = new javax.swing.JTextField();
        viewUserPassword = new javax.swing.JTextField();
        viewUserRole = new javax.swing.JTextField();
        modifyButton = new javax.swing.JButton();
        removeButton = new javax.swing.JButton();
        viewUserID = new javax.swing.JLabel();
        l9 = new javax.swing.JLabel();
        viewType = new javax.swing.JComboBox<>();
        dbTypeText = new javax.swing.JLabel();
        userSettings = new javax.swing.JComboBox<>();
        refreshButton = new javax.swing.JButton();
        userSettingsAccess = new javax.swing.JLabel();
        addItemPanel = new javax.swing.JPanel();
        viewUserPanel = new javax.swing.JPanel();
        addUserPanel = new javax.swing.JPanel();
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(searchField)
                        .addGap(18, 18, 18)
                        .addComponent(searchButton)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchButton))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                .addContainerGap())
        );

        viewUserPopup.setVisible(false);

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        field1.setText("User ID");

        field2.setText("Name");

        field3.setText("Password");

        field4.setText("Role");

        modifyButton.setText("Modify");
        modifyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyButtonActionPerformed(evt);
            }
        });

        removeButton.setText("Remove");
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });

        viewUserID.setText("{null}");

        javax.swing.GroupLayout viewUserPopupLayout = new javax.swing.GroupLayout(viewUserPopup);
        viewUserPopup.setLayout(viewUserPopupLayout);
        viewUserPopupLayout.setHorizontalGroup(
            viewUserPopupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewUserPopupLayout.createSequentialGroup()
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(viewUserPopupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(viewUserPopupLayout.createSequentialGroup()
                        .addGroup(viewUserPopupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(field2)
                            .addComponent(field1)
                            .addComponent(field3)
                            .addComponent(field4))
                        .addGap(18, 18, 18)
                        .addGroup(viewUserPopupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(viewUserPopupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(viewUserRole, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                .addComponent(viewUserName)
                                .addComponent(viewUserPassword))
                            .addComponent(viewUserID, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(viewUserPopupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(modifyButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(removeButton, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)))
                .addGap(18, 18, 18))
        );
        viewUserPopupLayout.setVerticalGroup(
            viewUserPopupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewUserPopupLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(viewUserPopupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(viewUserPopupLayout.createSequentialGroup()
                        .addGroup(viewUserPopupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(field1)
                            .addComponent(viewUserID))
                        .addGap(23, 23, 23)
                        .addGroup(viewUserPopupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(field2)
                            .addComponent(viewUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(viewUserPopupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(field3)
                            .addComponent(viewUserPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(viewUserPopupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(field4)
                            .addComponent(viewUserRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                        .addComponent(modifyButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(removeButton))
                    .addComponent(jSeparator1))
                .addContainerGap())
        );

        l9.setText("Database");

        viewType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<Select option>", "hospitals.txt", "ppe.txt", "suppliers.txt", "transactions.txt", "users.txt" }));
        viewType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewTypeActionPerformed(evt);
            }
        });

        dbTypeText.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        dbTypeText.setText("None");

        userSettings.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<Settings>", "Logout" }));
        userSettings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userSettingsActionPerformed(evt);
            }
        });

        refreshButton.setText("Refresh");
        refreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonActionPerformed(evt);
            }
        });

        userSettingsAccess.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        userSettingsAccess.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        userSettingsAccess.setText("{null}");
        if (Main.userType == null) {
            userSettingsAccess.setText("Developer");
            // [TODO] You have found an easter egg! Guest access is for debugging purposes only. Do not remove it or you wont be able to run Dashboard.java's main class without logging in through Main.java.
        } else if (Main.userType.equals("admin")) {
            userSettingsAccess.setText("Admin");
        } else if (Main.userType.equals("staff")) {
            userSettingsAccess.setText("Staff");
        }

        javax.swing.GroupLayout viewDatabasePanelLayout = new javax.swing.GroupLayout(viewDatabasePanel);
        viewDatabasePanel.setLayout(viewDatabasePanelLayout);
        viewDatabasePanelLayout.setHorizontalGroup(
            viewDatabasePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewDatabasePanelLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(viewDatabasePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(viewDatabasePanelLayout.createSequentialGroup()
                        .addComponent(l9)
                        .addGap(18, 18, 18)
                        .addComponent(viewType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(refreshButton)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, viewDatabasePanelLayout.createSequentialGroup()
                        .addGroup(viewDatabasePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dbTypeText, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(viewDatabasePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(viewDatabasePanelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                                .addComponent(viewUserPopup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(viewDatabasePanelLayout.createSequentialGroup()
                                .addGap(85, 85, 85)
                                .addComponent(userSettingsAccess, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(userSettings, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(31, 31, 31))))
        );
        viewDatabasePanelLayout.setVerticalGroup(
            viewDatabasePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, viewDatabasePanelLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(viewDatabasePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dbTypeText)
                    .addComponent(userSettings, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userSettingsAccess))
                .addGap(18, 18, 18)
                .addGroup(viewDatabasePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(l9)
                    .addComponent(viewType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(refreshButton))
                .addGap(18, 18, 18)
                .addGroup(viewDatabasePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(viewUserPopup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("View Database", viewDatabasePanel);

        javax.swing.GroupLayout addItemPanelLayout = new javax.swing.GroupLayout(addItemPanel);
        addItemPanel.setLayout(addItemPanelLayout);
        addItemPanelLayout.setHorizontalGroup(
            addItemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 780, Short.MAX_VALUE)
        );
        addItemPanelLayout.setVerticalGroup(
            addItemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 465, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Add Item", addItemPanel);

        javax.swing.GroupLayout viewUserPanelLayout = new javax.swing.GroupLayout(viewUserPanel);
        viewUserPanel.setLayout(viewUserPanelLayout);
        viewUserPanelLayout.setHorizontalGroup(
            viewUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 780, Short.MAX_VALUE)
        );
        viewUserPanelLayout.setVerticalGroup(
            viewUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 465, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("View User", viewUserPanel);

        l2.setText("Name");

        l3.setText("Password");

        l4.setText("Type");

        addType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<Select option>", "Admin", "Staff" }));

        addButton.setText("Submit");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout addUserPanelLayout = new javax.swing.GroupLayout(addUserPanel);
        addUserPanel.setLayout(addUserPanelLayout);
        addUserPanelLayout.setHorizontalGroup(
            addUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addUserPanelLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(addUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addUserPanelLayout.createSequentialGroup()
                        .addGroup(addUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(l3)
                            .addComponent(l4)
                            .addComponent(l2))
                        .addGap(18, 19, Short.MAX_VALUE)
                        .addGroup(addUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(addType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addName, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                            .addComponent(addPassword))
                        .addGap(516, 516, 516))
                    .addGroup(addUserPanelLayout.createSequentialGroup()
                        .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(506, 506, 506))))
        );
        addUserPanelLayout.setVerticalGroup(
            addUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addUserPanelLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(addUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(l2)
                    .addComponent(addName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(addUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(l3)
                    .addComponent(addPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(addUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(l4)
                    .addComponent(addType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addComponent(addButton)
                .addContainerGap(229, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Add User", addUserPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 780, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        if (Main.userType == null) {
        } else if (Main.userType.equals("staff")) {
            jTabbedPane1.removeTabAt(2);
            jTabbedPane1.removeTabAt(2);
        }

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

        if (userName.isEmpty() || userPassword.isEmpty() || userType.equals("<Select option>")) {
            JOptionPane.showMessageDialog(this, "Fields must not be empty", "Error", JOptionPane.ERROR_MESSAGE);
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
            
            addName.setText("");
            addPassword.setText("");
            addType.setSelectedIndex(0);
            
            JOptionPane.showMessageDialog(this, "Successfully added user " + userName, "Add User", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "An error occurred while adding a user", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } finally {
            java.util.Arrays.fill(charPass, ' ');
        }
    }//GEN-LAST:event_addButtonActionPerformed

    private void viewTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewTypeActionPerformed
        // TODO add your handling code here:
        Object db = viewType.getSelectedItem();
        FileHandler fh = new FileHandler();

        String[][] content;
        String[] header;
        
        resetViewUserPopup();

        switch (db.toString()) {
            case "hospitals.txt":
                content = fh.readFile("hospitals.txt", 3, this);
                header = new String[]{"Hospital ID", "Item ID", "Quantity"};
                viewTable.setModel(new DefaultTableModel(content, header));
                dbTypeText.setText("Hospital");
                currentDB = "hospital";
                break;
            case "ppe.txt":
                content = fh.readFile("ppe.txt", 4, this);
                header = new String[]{"Item ID", "Quantity", "Supplier ID", "Item Name"};
                viewTable.setModel(new DefaultTableModel(content, header));
                dbTypeText.setText("Item");
                currentDB = "item";
                break;
            case "suppliers.txt":
                content = fh.readFile("suppliers.txt", 3, this);
                header = new String[]{"Supplier ID", "Item ID", "Quantity"};
                viewTable.setModel(new DefaultTableModel(content, header));
                dbTypeText.setText("Supplier");
                currentDB = "supplier";
                break;
            case "transactions.txt":
                content = fh.readFile("transactions.txt", 4, this);
                header = new String[]{"Date", "Item ID", "Amount", "User ID"};
                viewTable.setModel(new DefaultTableModel(content, header));
                dbTypeText.setText("Transaction");
                currentDB = "transaction";
                break;
            case "users.txt":
                content = fh.readFile("users.txt", 4, this);
                header = new String[]{"User ID", "Name", "Password", "Role"};
                viewTable.setModel(new DefaultTableModel(content, header));
                dbTypeText.setText("User");
                currentDB = "user";
                break;
            default:
                viewTable.setModel(new DefaultTableModel());
                dbTypeText.setText("None");
                currentDB = null;
                break;
        }
    }//GEN-LAST:event_viewTypeActionPerformed

    public void resetViewUserPopup() {
        viewUserPopup.setVisible(false);
        
        viewUserID.setText("");
        viewUserName.setText("");
        viewUserPassword.setText("");
        viewUserRole.setText("");
    }

    private void viewTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewTableMouseClicked
        // TODO add your handling code here:
        if (currentDB.equals("user")) {
            int row = viewTable.getSelectedRow();
            int columnCount = viewTable.getColumnCount();

            viewUserPopup.setVisible(true);

            if (row != -1) {
                if (columnCount > 0) {
                    viewUserID.setText(getValueAt(row, 0));
                } if (columnCount > 1) {
                    viewUserName.setText(getValueAt(row, 1));
                } if (columnCount > 2) {
                    viewUserPassword.setText(getValueAt(row, 2));
                } if (columnCount > 3) {
                    viewUserRole.setText(getValueAt(row, 3));
                }
            } else {
                JOptionPane.showMessageDialog(this, "Please select a row", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_viewTableMouseClicked

    private String getValueAt(int row, int column) {
        Object value = viewTable.getModel().getValueAt(row, column);
        return value != null ? value.toString() : "";
    }
    
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

    private void userSettingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userSettingsActionPerformed
        // TODO add your handling code here:
        Object ut = userSettings.getSelectedItem();

        switch (ut.toString()) {
            case "Logout":
                Main mn = new Main();
                mn.setVisible(true);
                
                this.dispose();
                
                Main.authStatus = false;
                Main.initStatus = true;
                break;
            default:
                break;
        }
    }//GEN-LAST:event_userSettingsActionPerformed

    private void modifyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyButtonActionPerformed
        // TODO add your handling code here:
        String UID = viewUserID.getText();
        String newUsername = viewUserName.getText();
        String newPassword = viewUserPassword.getText();
        String newRole = viewUserRole.getText();

        if (newUsername.isEmpty() || newPassword.isEmpty() || newRole.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Fields must not be empty", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!newRole.equals("Admin") && !newRole.equals("Staff")) {
            JOptionPane.showMessageDialog(this, "Role must be either \"Admin\" or \"Staff\"", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        User user = new User();

        if (!newUsername.isEmpty()) {
            user.modifyUser(UID, "Username", "", newUsername);
        }
        if (!newPassword.isEmpty()) {
            user.modifyUser(UID, "Password", "", newPassword);
        }
        if (!newRole.isEmpty()) {
            user.modifyUser(UID, "Role", "", newRole);
        }

        JOptionPane.showMessageDialog(this, "Successfully modified user " + UID, "Modify", JOptionPane.INFORMATION_MESSAGE);
        
        viewTypeActionPerformed(null);
    }//GEN-LAST:event_modifyButtonActionPerformed

    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
        // TODO add your handling code here:
        int row = viewTable.getSelectedRow();

        if (row != -1) {
            String UID = viewTable.getValueAt(row, 0).toString();

            User user = new User();
            user.deleteUser(UID);

            DefaultTableModel model = (DefaultTableModel) viewTable.getModel();
            model.removeRow(row);

            resetViewUserPopup();
            
            JOptionPane.showMessageDialog(this, "Successfully removed user " + UID, "Remove", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Please select a user to remove", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_removeButtonActionPerformed

    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        // TODO add your handling code here:
        viewTypeActionPerformed(null);
    }//GEN-LAST:event_refreshButtonActionPerformed

    
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JPanel addItemPanel;
    private javax.swing.JTextField addName;
    private javax.swing.JPasswordField addPassword;
    private javax.swing.JComboBox<String> addType;
    private javax.swing.JPanel addUserPanel;
    private javax.swing.JLabel dbTypeText;
    private javax.swing.JLabel field1;
    private javax.swing.JLabel field2;
    private javax.swing.JLabel field3;
    private javax.swing.JLabel field4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel l2;
    private javax.swing.JLabel l3;
    private javax.swing.JLabel l4;
    private javax.swing.JLabel l9;
    private javax.swing.JButton modifyButton;
    private javax.swing.JButton refreshButton;
    private javax.swing.JButton removeButton;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchField;
    private javax.swing.JComboBox<String> userSettings;
    private javax.swing.JLabel userSettingsAccess;
    private javax.swing.JPanel viewDatabasePanel;
    private javax.swing.JTable viewTable;
    private javax.swing.JComboBox<String> viewType;
    private javax.swing.JLabel viewUserID;
    private javax.swing.JTextField viewUserName;
    private javax.swing.JPanel viewUserPanel;
    private javax.swing.JTextField viewUserPassword;
    private javax.swing.JPanel viewUserPopup;
    private javax.swing.JTextField viewUserRole;
    // End of variables declaration//GEN-END:variables
}
