import java.time.LocalDate;
import java.util.ArrayList;

public class test {

    public static void main(String[] args) {
        int HeadCover=40,FaceShield=0,Mask=50,Glove=0,Gown=0,ShoeCover=0;
        String[][] value = {{"HC;",Integer.toString(HeadCover)},{"FS;",Integer.toString(FaceShield)},{"MS;",Integer.toString(Mask)},{"GL;",Integer.toString(Glove)},{"GW;",Integer.toString(Gown)},{"SC;",Integer.toString(ShoeCover)}};

        for (int i=0;i<value.length;i++) {
            try {
                if(Integer.valueOf(value[i][1]) != 0) {
                    String validValue = value[i][0] + value[i][1];
                    itemManip(validValue, true);
                } else if (Integer.valueOf(value[i][1]) <= 0) {
                     // [TODO] Add pop up message "Item quantity cannot be below 0"
                     // [TODO] Design of the input data must all have set value of 0 and is already
                     //        linked to the specific id value
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void itemManip(String value, boolean receive) throws Exception {
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
                    // [TODO] incoming transactions
                    System.out.println(calc[0] + calc[1]);
                    ArrayList<ArrayList<String>>temp2 = fh.to2dArray("suppliers.txt");
                    System.out.println(temp2);
                    for (int i=0; i<temp2.size(); i++) {
                        
                    }
                } else {
                    temp -= Integer.parseInt(data[1]);
                    operation = "-";
                    // [TODO] outgoing transactions
                    if (temp < 25) {
                        // [TODO] Prompt user that item is in low quantity
                    } else if (temp < 1) {
                        // [TODO] Prompt user insufficient item
                    } else {
                        continue;
                    }
                }
                nFileData.add(data[0] + ";" + Integer.toString(temp) + ";" + data[2] + ";" + data[3]);
                fh.append("transactions.txt", (date + ";" + data[0] + ";" + operation + calc[1] + ";" + user.getUID() + "\n"));
            } else {
                nFileData.add(n);
            }
        }
        
        String FileData = String.join("\n", nFileData);
        fh.write(file, FileData);
    }
}
