import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


public class DeleteConsumer{
    private static Record [][][][][] file = new Record [10][4][10][20][3];
    

    public static String ToBeReplaced(int cid) throws IOException{
       
        BufferedReader reader = new BufferedReader(new FileReader("Feb.txt")); 
        // PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("Feb.txt")));
        cid = cid - 1;
        int temp = 0;

        String result = "";
        for (int block = 0; block < 10; block++) {
            for (int subblock = 0; subblock < 4; subblock++) {
                for (int street = 0; street < 10; street++) {
                    for (int house = 0; house < 20; house++) {
                        for (int portion = 0; portion < 3; portion++) {
                            file[block][subblock][street][house][portion] = new Record();
                            reader.readLine();
                            temp++;


                            if (cid == temp) {
                                
                                String reqstring = reader.readLine();
                                result = result + reqstring;
                            }
                        }
                    }
                }
            }
        }
        reader.close();
        // System.out.println(result);
        return result;

    }
    public static String toBeReplacedWith(int cid) throws IOException{
       
        BufferedReader reader = new BufferedReader(new FileReader("Feb.txt")); 
        // PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("Feb.txt")));
        cid = cid - 1;
        int temp = 0;

        String result = "";
        for (int block = 0; block < 10; block++) {
            for (int subblock = 0; subblock < 4; subblock++) {
                for (int street = 0; street < 10; street++) {
                    for (int house = 0; house < 20; house++) {
                        for (int portion = 0; portion < 3; portion++) {
                            file[block][subblock][street][house][portion] = new Record();
                            reader.readLine();
                            temp++;


                            if (cid == temp) {
                                
                                String str1 = "x";
                                String str2 = reader.readLine();
                                
                                StringBuffer sb = new StringBuffer();
                                
                                sb.append(str1);
                                sb.append(str2);
                                
                                String reqstring = sb.toString();
                                result = result + reqstring;
                                
                            }
                        }
                    }
                }
            }
        }
        reader.close();
        // System.out.println(result);
        return result;
    }

    public static void doIt() {

        List<String> lines = new ArrayList<String>();
        String line = null;

        try {
            File f1 = new File("Feb.txt");
            FileReader fr = new FileReader(f1);

            BufferedReader br = new BufferedReader(fr);
            
            while ((line = br.readLine()) != null) {
                if (line.contains(ToBeReplaced(24000)))
                    line = line.replace((ToBeReplaced(24000)), (toBeReplacedWith(24000)));
                lines.add(line);
            }
            fr.close();
            br.close();
    
            FileWriter fw = new FileWriter(f1);
            PrintWriter out = new PrintWriter(fw);
            
            for(String s : lines)
                out.println(s);
                
            out.flush();
            out.close();
            
        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}