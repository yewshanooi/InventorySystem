import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;

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
    
            if (start[0] == end[0] && start[1] == end[1] && (end[2] - start[2] < 8)) {
                DateRange(start, end);
            } else {
                // Print out invalid date or out of range (Maximum 7 days)
                System.out.println("Invalid Date");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

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

            if (data[0] == startDate[0] && data[0] == endDate[0] && data[1] == startDate[1] && data[1] == endDate[1] && data[2] > (startDate[2] - 1) && data[2] < (endDate[2] + 1)) {
                validDate.add(data[0] + "-" + data[1] + "-" + data[2] + ";" + fileDate[1] + ";" + fileDate[2]);
            }
        }
        
        // This displays the range of dates
        // System.out.println(validDate);
        br.close();
    }
}
