import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.awt.Component;

public class Transfer {
    // Receiving items from supplier
    public void itemTransfer(String[][] value) {
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
    public void itemTransfer(String[][] value, String hpID, Component parent) {
        
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
                                    JOptionPane.showMessageDialog(parent, "Insufficient items\nCurrent stock on hand: "+data[1], "Error", JOptionPane.ERROR_MESSAGE);
                                    break;
                                    // [TODO] break; is broken, program still continue even after not enough of items error
                                } else if (temp < 25) {
                                    JOptionPane.showMessageDialog(parent, "Quantity of items is lower than 25", "Warning", JOptionPane.WARNING_MESSAGE);
                                    JOptionPane.showMessageDialog(parent, "Successfully send items", "Send", JOptionPane.INFORMATION_MESSAGE);
                                    itemManip(validValue, hpID);
                                } else {
                                    JOptionPane.showMessageDialog(parent, "Successfully send items", "Send", JOptionPane.INFORMATION_MESSAGE);
                                    itemManip(validValue, hpID);
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
                String spID = "";
                ArrayList<ArrayList<String>>spItems = fh.to2dArray(fileName);
                for (int i=0; i<spItems.size(); i++) {
                    if (calc[0].equals(spItems.get(i).get(1))) {
                        int item = Integer.parseInt(spItems.get(i).get(2));
                        item -= Integer.parseInt(calc[1]);
                        String newData = String.valueOf(item);
                        spItems.get(i).set(2, newData);
                        spID = spItems.get(i).get(0);
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
                fh.append("transactions.txt", (date + ";" + data[0] + ";" + "+" + calc[1] + ";" + spID + ";" + User.getUID() + ";" + time +"\n"));
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
                System.out.println(User.getUID());
                fh.append("transactions.txt", (date + ";" + data[0] + ";" + "-" + calc[1] + ";" + hpID + ";" + User.getUID() + ";" + time +"\n"));
                } else {
                    nFileData.add(n);
            }
        }
        
        String FileData = String.join("\n", nFileData);
        fh.write(file, FileData);
    }
}
