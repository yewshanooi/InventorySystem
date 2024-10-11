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

    public String[][] searchByID(String tableName, String query) {
        ArrayList<String[]> fetch = new ArrayList<>();
        FileHandler fh = new FileHandler();

        try {
            ArrayList<ArrayList<String>> fileData = fh.to2dArray(tableName);

            for (ArrayList<String> data : fileData) {
                if (!data.isEmpty() && data.get(0).equalsIgnoreCase(query)) {
                    fetch.add(data.toArray(new String[0]));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        String[][] dataInArray = new String[fetch.size()][];
        fetch.toArray(dataInArray);

        return dataInArray;
    }

    public String[][] SortBy(String file, boolean asc) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(file));
        FileHandler fh = new FileHandler();
        ArrayList<ArrayList<String>> fileCont = fh.to2dArray(file);;
        
        boolean swapped;
        for (int i=0; i<fileCont.size(); i++) {
            ArrayList<String> temp;
            int value1,value2;
            swapped = false;
            if (asc) {
                for (int j=0; j<fileCont.size()-i-1; j++) {
                    if (Integer.parseInt(fileCont.get(j).get(1)) > Integer.parseInt(fileCont.get(j+1).get(1))) {
                        temp = fileCont.get(j);
                        fileCont.set(j, fileCont.get(j+1));
                        fileCont.set(j+1, temp);
                        swapped = true;
                    }
                }
            } else {
                for (int j=0; j<fileCont.size()-i-1; j++) {
                    if (Integer.parseInt(fileCont.get(j).get(1)) < Integer.parseInt(fileCont.get(j+1).get(1))) {
                        temp = fileCont.get(j);
                        fileCont.set(j, fileCont.get(j+1));
                        fileCont.set(j+1, temp);
                        swapped = true;
                    }
                }

            }
            
            if (swapped == false)
            break;
        }

        // Convert Array List to String List
        int wad = fileCont.size();
        int daw = fileCont.get(0).size();
        String[][] sortedList = new String[wad][daw];
        for(int i=0;i<fileCont.size();i++){
            for(int j=0;j<fileCont.get(i).size();j++){
                sortedList[i][j]=fileCont.get(i).get(j);
            }
        }

        // For testing output
        // for (String[] n : sortedList) {
        //     System.out.println(n[0]+" "+n[1]+" "+n[2]+" "+n[3]+" ");
        // }

        br.close();
        return sortedList;
    }
}
