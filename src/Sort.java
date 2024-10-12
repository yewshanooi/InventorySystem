import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Sort {
    // Call this method to use this class
    public String[][] dateRange(String s, String e) throws Exception {
        ArrayList<ArrayList<String>> validDates = new ArrayList<>();

        String[] startString = s.split("-");
        String[] endString = e.split("-");
        int[] start = new int[3];
        int[] end = new int[3];

        for (int i = 0; i < 3; i++) {
            start[i] = Integer.parseInt(startString[i]);
            end[i] = Integer.parseInt(endString[i]);
        }
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate startDate = LocalDate.of(start[2], start[1], start[0]);  
        LocalDate endDate = LocalDate.of(end[2], end[1], end[0]);  
        long numOfDaysBetween = ChronoUnit.DAYS.between(startDate, endDate);  
        
        // iterate through the dates between start and end dates  
        for (int i = 0; i < numOfDaysBetween+1; i++) {  
            String file = "transactions.txt";
            LocalDate betweenDate = startDate.plusDays(i);
            FileHandler fh = new FileHandler();

            ArrayList<ArrayList<String>> fileCont = fh.to2dArray(file);
            for (ArrayList<String> date : fileCont) {
                if (betweenDate.format(formatter).equals(date.get(0))) {
                    validDates.add(date);
                }
            }
        }

        String[][] validDatesString = new String[validDates.size()][validDates.get(0).size()];
    
        for(int i=0;i<validDates.size();i++){
            for(int j=0;j<validDates.get(i).size();j++){
                validDatesString[i][j]=validDates.get(i).get(j);
            }
        }

        return validDatesString;
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
            int index1 = fileCont.size();
            int index2 = fileCont.get(0).size();
            String[][] sortedList = new String[index1][index2];
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
