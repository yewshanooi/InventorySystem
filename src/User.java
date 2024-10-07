import java.util.ArrayList;

public class User {
    private String Username;
    private String UID;
    
    public String getUID() {
        return UID;
    }

    public void setUID(String uID) {
        UID = uID;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public void createUser(String username, String password, String role) {
        try {
            FileHandler fh = new FileHandler();

            String file = "users.txt";
            String filler = "0";
            int maxDigit = 2;
            int newID = 1;

            ArrayList<ArrayList<String>> fileCont = fh.to2dArray(file);

            for (int i = 0; i < fileCont.size(); i++) {
                if (Integer.parseInt(fileCont.get(i).get(0).substring(3, fileCont.get(i).get(0).length())) == newID) {
                    newID++;
                }
            }

            String UID = ("STF" + filler.repeat(maxDigit - Integer.toString(newID).length()) + Integer.toString(newID));
            String userInfo = "\n"+UID+";"+username+";"+password+";"+role;

            fh.append(file, userInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}