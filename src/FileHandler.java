import java.awt.Component;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class FileHandler {
    public void createFile(String[] file) {
        try {
            for (String name : file) {
                File f = new File(name);
                if (f.createNewFile()) {
                    // System.out.println("File created: " + f.getName());
                } else {
                    // System.out.println("File already exist");
                }
            }
        } catch (IOException e) {
            System.out.println("An error occured.");
        }
    }

    public void deleteFile(String[] file) {
        try {
            for (String name : file) {
                File f = new File(name);
                if (f.delete()) {
                    // System.out.println("File deleted: " + f.getName());
                } else {
                    // System.out.println("File not found or already deleted");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String> toArray(String file) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            ArrayList<String> fileCont = new ArrayList<>();
            String line = br.readLine();
        
            while (line != null) {
                fileCont.add(line);
                line = br.readLine();
            }

            br.close();
            return fileCont;
            
        } catch (Exception e) {
            ArrayList<String> fileCont = new ArrayList<>();
            e.printStackTrace();
            return fileCont;
        }
    }

    public ArrayList<ArrayList<String>> to2dArray(String file) {
        ArrayList<ArrayList<String>> list = new ArrayList<>();

        try {
            ArrayList<String> fileCont = new ArrayList<>(toArray(file));

            for (String n : fileCont) {
                ArrayList<String> datas = new ArrayList<>();
                String[] data = n.split(";");
                for (String p : data) {
                    datas.add(p);
                }
                list.add(datas);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }


    public void write(String file, String data) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            bw.write(data);
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void append(String file, String data) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
            bw.write(data);
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void initialize(String file, String[] item) {
        FileHandler fh = new FileHandler();
        String items = String.join("\n", item);
        fh.write(file, items);
    }
    
    public static String[][] readFile(String path, int column, Component parent) {
        ArrayList<String[]> data = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == column) {
                    data.add(parts);
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(parent, "File not found", "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }

        String[][] result = new String[data.size()][column];
        
        for (int i = 0; i < data.size(); i++) {
            result[i] = data.get(i);
        }
        
        return result;
    }
}
