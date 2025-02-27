import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;

public class User {
    private static String Username;
    private static String UID;

    public static String getUsername() {
        return Username;
    }

    public static void setUsername(String Username) {
        User.Username = Username;
    }

    public static String getUID() {
        return UID;
    }

    public static void setUID(String UID) {
        User.UID = UID;
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

            String UID = "STF" + filler.repeat(maxDigit - Integer.toString(newID).length()) + newID;
            String userInfo = UID + ";" + username + ";" + password + ";" + role;

            if (fileCont.isEmpty()) {
                fh.append(file, userInfo);
            } else {
                fh.append(file, "\n" + userInfo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(String UID) {
        try {
            String file = "users.txt";

            FileHandler fh = new FileHandler();
            ArrayList<ArrayList<String>> fileCont = fh.to2dArray(file);

            int userCheck=0;
            // To check if user is in database, if true then update data
            for (int i=0;i<fileCont.size();i++) {
                if (UID.equals(fileCont.get(i).get(0))) {
                    fileCont.remove(i);
                } else {
                    userCheck++;
                }
            }

            String[] newUser = new String[fileCont.size()];
            ArrayList<String> alToList = new ArrayList<>();
            for (int i=0;i<fileCont.size();i++) {
                String[] dataJoin = new String[fileCont.get(i).size()];
                dataJoin = fileCont.get(i).toArray(dataJoin);
                String temp = String.join(";", dataJoin);
                alToList.add(temp);
            }

            newUser = alToList.toArray(newUser);
            fh.initialize("users.txt", newUser);

            if (UID.equals(User.getUID())) {

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void modifyUser(String UID, String dataType, String oldData, String newData) {
        try {
            String file = "users.txt";
            
            FileHandler fh = new FileHandler();
            BufferedReader br = new BufferedReader(new FileReader(file));
            ArrayList<ArrayList<String>> fileCont = fh.to2dArray(file);
            
            int index = 0;
            
            if (dataType.equals("Username")) {
                index=1;
            } else if (dataType.equals("Password"))  {
                index=2;
            } else if (dataType.equals("Role")) {
                index=3;
            }

            // To check if user is in database, if true then update data
            int userCheck = 0;
            
            for (int i=0;i<fileCont.size();i++) {
                if (UID.equals(fileCont.get(i).get(0))) {
                    fileCont.get(i).set(index, newData);
                } else {
                    userCheck++;
                }
            }

            String[] update = new String[fileCont.size()];
            ArrayList<String> alToList = new ArrayList<>();
            for (int i=0;i<fileCont.size();i++) {
                String[] dataJoin = new String[fileCont.get(i).size()];
                dataJoin = fileCont.get(i).toArray(dataJoin);
                String temp = String.join(";", dataJoin);
                alToList.add(temp);
            }

            update = alToList.toArray(update);

            br.close();
            fh.initialize(file, update);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}