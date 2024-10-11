import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Sort {
    // Call this method to use this class
    public void validRange(String startDate, String endDate) {
        try {
            String[] startString = startDate.split("-");
            String[] endString = endDate.split("-");
            int[] start = new int[3];
            int[] end = new int[3];
    
            for (int i = 0; i < 3; i++) {
                start[i] = Integer.parseInt(startString[i]);
                end[i] = Integer.parseInt(endString[i]);
            }
    
            if (start[2] == end[2] && start[1] == end[1] && (end[0] - start[0] < 8)) {
                DateRange(start, end);
            } else {
                // Print out invalid date or out of range (Maximum 7 days)
                System.out.println("Invalid Date");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Dont call this
    public void DateRange(int[] startDate, int[] endDate) throws Exception {
        String file = "transactions.txt";
        BufferedReader br = new BufferedReader(new FileReader(file));
        FileHandler fh = new FileHandler();

        ArrayList<String> fileCont = new ArrayList<String>();
        fileCont = fh.toArray(file);
        String[] fileDate = new String[1];
        ArrayList<String> validDate = new ArrayList<>();
        
        for (int i = 0; i < fileCont.size(); i++) {
            fileDate = fileCont.get(i).split(";");
            String[] dateString = fileDate[0].split("-");
            int[] data = new int[3];
            for (int d = 0; d < 3; d++) {
                data[d] = Integer.parseInt(dateString[d]);
            }

            if (data[2] == startDate[2] && data[2] == endDate[2] && data[1] == startDate[1] && data[1] == endDate[1] && data[0] > (startDate[0] - 1) && data[0] < (endDate[0] + 1)) {
                validDate.add(data[0] + "-" + data[1] + "-" + data[2] + ";" + fileDate[1] + ";" + fileDate[2] + ";" + fileDate[3] + ";" + fileDate[4]);
            }
        }
        
        // This displays the range of dates
        // System.out.println(validDate);
        br.close();
    }

    private void searchID(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchUserButtonActionPerformed
        // TODO add your handling code here:
        // String query = searchUserField.getText().trim();

        // if (query.isEmpty()) {
        //     JOptionPane.showMessageDialog(this, "Please enter a query", "Error", JOptionPane.ERROR_MESSAGE);
        //     return;
        // }

        ArrayList<String[]> fetch = new ArrayList<>();
        FileHandler fh = new FileHandler();

        try {
            ArrayList<ArrayList<String>> fileData = fh.to2dArray(Dashboard.currentDB + ".txt");

            for (ArrayList<String> data : fileData) {
                if (!data.isEmpty() && data.get(0).equalsIgnoreCase(query)) { // Ignore lower/upper case differences
                    fetch.add(new String[]{data.get(0), data.get(1), data.get(2), data.get(3)});
                    break; // Avoid adding the same row if there are multiple matching values
                }
            }
        } catch (Exception e) {
            // JOptionPane.showMessageDialog(this, "An error occurred while reading the file", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String[][] results = new String[fetch.size()][];
        for (int i = 0; i < fetch.size(); i++) {
            results[i] = fetch.get(i);
        }

        if(Dashboard.currentDB.equals("item")) {
            String[] header = {"Item ID", "Quantity", "Supplier ID", "Item Name"};
        } else {
            String[] header = {"User ID", "Name", "Password", "Role"};
        }

        if (fetch.isEmpty()) {
            // JOptionPane.showMessageDialog(this, "No results found for:\n\n" + query, "Search", JOptionPane.INFORMATION_MESSAGE);
            // searchUserField.setText("");
        } else {
            // viewUserTable.setModel(new DefaultTableModel(results, header));
        }
    }//GEN-LAST:event_searchUserButtonActionPerformed

    
}
