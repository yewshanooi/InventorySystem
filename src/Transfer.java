import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.awt.Component;

public class Transfer {
    // Receiving items from supplier
    public void filterInvalid(String[][] value) {
        for (int i=0;i<value.length;i++) {
            try {
                if(Integer.valueOf(value[i][1]) != 0) {
                    String validValue = value[i][0] + value[i][1];
                    itemManip(validValue);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    
    // Sending items to hospital
    public void filterInvalid(String[][] value, String uid, Component parent) {
        for (int i=0;i<value.length;i++) {
            try {
                if(Integer.valueOf(value[i][1]) != 0) {
                    String file = "ppe.txt";
                    FileHandler fh = new FileHandler();
                    String validValue = value[i][0] + value[i][1];

                    String[] calc = validValue.split(";");
                    int temp = Integer.parseInt(calc[1]);
                    ArrayList<String> fileCont = new ArrayList<String>(fh.toArray(file));

                    for (String n : fileCont) {

                        String[] data = n.split(";");
                            if (calc[0].equals(data[0])) {
                                temp = Integer.parseInt(data[1]) - temp;
                                if (temp < 1) {
                                    JOptionPane.showMessageDialog(parent, "Insufficient items", "Error", JOptionPane.ERROR_MESSAGE);
                                    break;
                                } else if (temp < 25) {
                                    JOptionPane.showMessageDialog(parent, "Quantity of items is lower than 25", "Warning", JOptionPane.WARNING_MESSAGE);
                                    itemManip(validValue, uid);
                                } else {
                                    itemManip(validValue, uid);
                                }
                            }
                        }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // This is for receiving item from supplier
    public void itemManip(String value) throws Exception {
        String file = "ppe.txt";
        FileHandler fh = new FileHandler();
        User user = new User();

        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        String formattedDate = myDateObj.format(myFormatObj);
        String[] sep = formattedDate.split(" ");
        String date = sep[0];
        String time = sep[1];

        ArrayList<String> fileCont = new ArrayList<String>(fh.toArray(file));
        
        // Actual calculation
        String[] calc = value.split(";");
        ArrayList<String> nFileData = new ArrayList<String>();
        int temp = Integer.parseInt(calc[1]);
        
        for (String n : fileCont) {
            String[] data = n.split(";");
            if (calc[0].equals(data[0])) {
                temp += Integer.parseInt(data[1]);

                String fileName ="suppliers.txt";
                ArrayList<ArrayList<String>>spItems = fh.to2dArray(fileName);
                for (int i=0; i<spItems.size(); i++) {
                    if (calc[0].equals(spItems.get(i).get(1))) {
                        int item = Integer.parseInt(spItems.get(i).get(2));
                        item -= Integer.parseInt(calc[1]);
                        String newData = String.valueOf(item);
                        spItems.get(i).set(2, newData);
                    }
                }

                String[] update = new String[spItems.size()];
                ArrayList<String> alToList = new ArrayList<>();
                for (int i=0;i<spItems.size();i++) {
                    String[] dataJoin = new String[spItems.get(i).size()];
                    dataJoin = spItems.get(i).toArray(dataJoin);
                    String spItemsString = String.join(";", dataJoin);
                    alToList.add(spItemsString);
                }

                update = alToList.toArray(update);

                fh.initialize(fileName, update);

                nFileData.add(data[0] + ";" + Integer.toString(temp) + ";" + data[2] + ";" + data[3]);
                fh.append("transactions.txt", (date + ";" + data[0] + ";" + "+" + calc[1] + ";" + user.getUID() + ";" + time +"\n"));
            } else {
                nFileData.add(n);
            }
        }
        
        String FileData = String.join("\n", nFileData);
        fh.write(file, FileData);
    }

    // This is for sending out items to hospital
    public void itemManip(String value, String hpID) throws Exception {
        String file = "ppe.txt";
        FileHandler fh = new FileHandler();
        User user = new User();

        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        String formattedDate = myDateObj.format(myFormatObj);
        String[] sep = formattedDate.split(" ");
        String date = sep[0];
        String time = sep[1];

        ArrayList<String> fileCont = new ArrayList<String>(fh.toArray(file));
        
        // Actual calculation
        String[] calc = value.split(";");
        ArrayList<String> nFileData = new ArrayList<String>();
        int temp = Integer.parseInt(calc[1]);
        
        for (String n : fileCont) {
            String[] data = n.split(";");
            if (calc[0].equals(data[0])) {
                temp = Integer.parseInt(data[1]) - temp;
                String fileName ="hospitals.txt";
                ArrayList<ArrayList<String>>spItems = fh.to2dArray(fileName);
                
                for (int i=0; i<spItems.size(); i++) {
                    if (hpID.equals(spItems.get(i).get(0)) && calc[0].equals(spItems.get(i).get(1))) {
                        int item = Integer.parseInt(spItems.get(i).get(2));
                        item += Integer.parseInt(calc[1]);
                        String newData = String.valueOf(item);
                        spItems.get(i).set(2, newData);
                    }
                }

                String[] update = new String[spItems.size()];
                ArrayList<String> alToList = new ArrayList<>();
                for (int i=0;i<spItems.size();i++) {
                    String[] dataJoin = new String[spItems.get(i).size()];
                    dataJoin = spItems.get(i).toArray(dataJoin);
                    String spItemsString = String.join(";", dataJoin);
                    alToList.add(spItemsString);
                }

                update = alToList.toArray(update);

                fh.initialize(fileName, update);

                nFileData.add(data[0] + ";" + Integer.toString(temp) + ";" + data[2] + ";" + data[3]);
                fh.append("transactions.txt", (date + ";" + data[0] + ";" + "-" + calc[1] + ";" + hpID + ";" + user.getUID() + ";" + time +"\n"));
                } else {
                    nFileData.add(n);
            }
        }
        
        String FileData = String.join("\n", nFileData);
        fh.write(file, FileData);
    }
}
