import java.time.LocalDate;
import java.util.ArrayList;

public class Transfer {
    public void filterInvalid(String[][] value, boolean receive) {
        for (int i=0;i<value.length;i++) {
            try {
                if(Integer.valueOf(value[i][1]) != 0) {
                    String validValue = value[i][0] + value[i][1];
                    itemManip(validValue, receive);
                } // Add pop up message if value[i][0] < 0
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void itemManip(String value, boolean receive) throws Exception {
        String file = "ppe.txt";
        LocalDate date = LocalDate.now();
        FileHandler fh = new FileHandler();
        User user = new User();

        ArrayList<String> fileCont = new ArrayList<String>(fh.toArray(file));
        
        // Actual calculation
        String[] calc = value.split(";");
        ArrayList<String> nFileData = new ArrayList<String>();
        int temp = Integer.parseInt(calc[1]);
        
        for (String n : fileCont) {
            String[] data = n.split(";");
            String operation = "";
            if (calc[0].equals(data[0])) {
                if (receive) {
                    temp += Integer.parseInt(data[1]);
                    operation = "+";
                } else {
                    temp -= Integer.parseInt(data[1]);
                    operation = "-";
                }
                nFileData.add(data[0] + ";" + Integer.toString(temp) + ";" + data[2]);
                fh.append("transactions.txt", (date + ";" + data[0] + ";" + operation + calc[1] + ";" + user.getUID() + "\n"));
            } else {
                nFileData.add(n);
            }
        }
        
        String FileData = String.join("\n", nFileData);
        fh.write(file, FileData);
    }
}