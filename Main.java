import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    private static Record [][][][][] file = new Record [10][4][10][20][3];
    static HashMap<Integer, String> names = new HashMap<Integer, String>();
    HashMap<Integer, Double[][]> bill = new HashMap<Integer, Double[][]>();

    private static Cookies cookies = new Cookies();

    // Write the new array to the file.
    public static void PushData(String fileName) throws IOException{
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(fileName + ".txt")));

        for (int block = 0; block < 10; block++) {
            for (int subblock = 0; subblock < 4; subblock++) {
                for (int street = 0; street < 10; street++) {
                    for (int house = 0; house < 20; house++) {
                        for (int portion = 0; portion < 3; portion++) {
                            String record = "";
                            for (int utility = 0; utility < 4; utility++) {
                                for (int category = 0; category < file[block][subblock][street][house][portion].reading[utility].length; category++) {
                                    record += file[block][subblock][street][house][portion].reading[utility][category] + " ";
                                    record += file[block][subblock][street][house][portion].bill[utility][category] + " ";
                                }
                            }
                            writer.println(record);
                        }
                    }
                }
            }
        }
        
        writer.flush();
        
        writer.close();
        

    }
    
    
    // Take readings and calculate bills 
    public static void BillCalculation() throws IOException{ // Whole Sector
        for (int block = 0; block < 10; block++) {
            for (int subblock = 0; subblock < 4; subblock++) {
                for (int street = 0; street < 10; street++) {
                    for (int house = 0; house < 20; house++) {
                        for (int portion = 0; portion < 3; portion++) {
                            // Portion
                            BillCalculation(block, subblock, street, house, portion);
                        }
                    }
                }
            }
        }
    }

    public static void BillCalculation(char block) throws IOException{ // Specific Block
        for (int subblock = 0; subblock < 4; subblock++) {
            for (int street = 0; street < 10; street++) {
                for (int house = 0; house < 20; house++) {
                    for (int portion = 0; portion < 3; portion++) {
                        // Portion
                        BillCalculation(block, subblock, street, house, portion);
                    }
                }
            }
        }
    }

    public static void BillCalculation(char block, int subblock) throws IOException{ // Specific SubBlock
        for (int street = 0; street < 10; street++) {
            for (int house = 0; house < 20; house++) {
                for (int portion = 0; portion < 3; portion++) {
                    // Portion
                    BillCalculation(block, subblock, street, house, portion);
                }
            }
        }
    }

    public static void BillCalculation(char block, int subblock, int street) throws IOException{ // Specific Street
        for (int house = 0; house < 20; house++) {
            for (int portion = 0; portion < 3; portion++) {
                // Portion
                BillCalculation(block, subblock, street, house, portion);
            }
        }
    }
    

    public static void BillCalculation(char block, int subblock, int street, int house) throws IOException{ // Specific House
        for (int portion = 0; portion < 3; portion++) {
            // Portion
            BillCalculation(block, subblock, street, house, portion);
        }
    }
    

    // Take readings and calculate bills 
    public static void BillCalculation(int block, int subblock, int street, int house, int portion) throws IOException{

        double previousReading = 0, newReading = 0, monthlyBill = 0;

        for (int utility = 0; utility < 4 ; utility++) {
            for (int category = 0; category < file[block][subblock][street][house][portion].reading[utility].length; category++) {
                // Getting the prevoius reading.
            previousReading = file[block][subblock][street][house][portion].reading[utility][category];
            
            // new readings
            switch(utility){
                case 0:
                    newReading = Math.round(RandomReadings.electricity(previousReading)*100)/100d;
                    monthlyBill = Math.round(CalculateBill.electricity(newReading - previousReading)*100)/100d;
                    break;
                case 1:
                    newReading = Math.round(RandomReadings.gas(previousReading)*100)/100d;
                    monthlyBill = Math.round(CalculateBill.gas(newReading - previousReading)*100)/100d;
                    break;
                case 2:
                    newReading = Math.round(RandomReadings.water(previousReading)*100)/100d; 
                    monthlyBill =Math.round(CalculateBill.water(newReading - previousReading)*100)/100d;
                    break;
                case 4:
                    switch(category){
                        case 0:
                            newReading = Math.round(RandomReadings.media.local_calls(previousReading)*100)/100d; 
                            monthlyBill = Math.round(CalculateBill.media.local_calls(newReading - previousReading)*100)/100d;
                            break;
                        case 1:
                            newReading = Math.round(RandomReadings.media.international_calls(previousReading)*100)/100d; 
                            monthlyBill = Math.round(CalculateBill.media.international_calls(newReading - previousReading)*100)/100d;
                            break;
                        case 2:
                            newReading = Math.round(RandomReadings.media.internet(previousReading)*100)/100d; 
                            monthlyBill = Math.round(CalculateBill.media.internet(newReading - previousReading)*100)/100d;
                            break;
                    }
                    
            }

            // Saving in Record File (Array)
            file[block][subblock][street][house][portion].reading[utility][category] = newReading;
            file[block][subblock][street][house][portion].bill[utility][category] = monthlyBill;
            }
        }

    }




    // Reading data from previous month
    
    public static void PullPreviousReadings(String fileName) throws IOException{
        BufferedReader reader = new BufferedReader(new FileReader(fileName + ".txt"));
        String record = " ";
        String[] record_array;

        for (int block = 0; block < 10; block++) {
            for (int subblock = 0; subblock < 4; subblock++) {
                for (int street = 0; street < 10; street++) {
                    for (int house = 0; house < 20; house++) {
                        for (int portion = 0; portion < 3; portion++) {
                            record = reader.readLine();
                            record_array = record.split(" ");
                            for (int i = 0, utility = 0; i < 8; i+=2, utility++) {
                                for (int category = 0; category < file[block][subblock][street][house][portion].reading[utility].length; category++) {
                                    file[block][subblock][street][house][portion].reading[utility][category] = Double.parseDouble(record_array[i]);
                                    file[block][subblock][street][house][portion].bill[utility][category] = Double.parseDouble(record_array[i + 1]);
                                }
                            }
                            
                        }
                    }
                }
            }
        }

        reader.close();

    }
    
    // Creating method to assign and get ID with repsect to name in file. 
    // Line number == id;
    public static void PullUserIDs() throws IOException{

        BufferedReader reader = new BufferedReader(new FileReader("names.txt")); 
        int id = 0;
        for (int block = 0; block < 10; block++) {
            for (int subblock = 0; subblock < 4; subblock++) {
                for (int street = 0; street < 10; street++) {
                    for (int house = 0; house < 20; house++) {
                        for (int portion = 0; portion < 3; portion++) {
                            id++;
                            file[block][subblock][street][house][portion] = new Record();
                            file[block][subblock][street][house][portion].id = id;
                        }
                    }
                }
            }
        }

        // int c_id = file[9][3][9][19][2].id;
        // System.out.println(c_id);
        reader.close();

    }
        // Creating method to load names.
        public static void PullName() throws IOException{
            
            int id = 0;
            BufferedReader reader = new BufferedReader(new FileReader("names.txt")); 
            
            for (int block = 0; block < 10; block++) {
                for (int subblock = 0; subblock < 4; subblock++) {
                    for (int street = 0; street < 10; street++) {
                        for (int house = 0; house < 20; house++) {
                            for (int portion = 0; portion < 3; portion++) {
                                id++;
                                file[block][subblock][street][house][portion] = new Record();
                                file[block][subblock][street][house][portion].id = id;
                                file[block][subblock][street][house][portion].name = reader.readLine();
                                
                            }
                        }
                    }
                }
            }
    
            reader.close();
            
            
        }

    // OverLoading names method to get name of speific cosnumer from ID.
    // Creating method to load names.
    public static void PullName(int cid) throws IOException{
        cid = cid - 1;
        int id = 0;
        BufferedReader reader = new BufferedReader(new FileReader("names.txt")); 
        
        for (int block = 0; block < 10; block++) {
            for (int subblock = 0; subblock < 4; subblock++) {
                for (int street = 0; street < 10; street++) {
                    for (int house = 0; house < 20; house++) {
                        for (int portion = 0; portion < 3; portion++) {
                            id++;
                            file[block][subblock][street][house][portion] = new Record();
                            file[block][subblock][street][house][portion].id = id;
                            file[block][subblock][street][house][portion].name = reader.readLine();
                            
                            if (id == cid){
                                System.out.println(reader.readLine());
                                
                            }
                        }
                    }
                }
            }
        }

        reader.close();
        
        
    }


    public static void updateCookies(){
        int currentMonth = cookies.getCurrentMonth();
        int currentYear = cookies.getCurrentYear();

        cookies.setPreviousMonth(currentMonth);
        cookies.setPreviousYear(currentYear);

        if (currentMonth == 11){
            currentMonth = -1;
            currentYear++;
        }

        cookies.setCurrentMonth(currentMonth + 1);
        cookies.setCurrentYear(currentYear);
    }

    private static String indexToMonthName(int index){
        switch(index){
            case 0: return "January";
            case 1: return "February";
            case 2: return "March";
            case 3: return "April";
            case 4: return "May";
            case 5: return "June";
            case 6: return "July";
            case 7: return "August";
            case 8: return "September";
            case 9: return "October";
            case 10: return "November";
            case 11: return "December";
        }
        return "Not Initialized";
    }


    public static void getCredentials() throws IOException{

        Scanner input = new Scanner(System.in);
        System.out.print("Enter the ID: ");
        int reqid = input.nextInt();

        int id = 0;
        BufferedReader reader = new BufferedReader(new FileReader("names.txt")); 
        for (int block = 0; block < 10; block++) {
            for (int subblock = 0; subblock < 4; subblock++) {
                for (int street = 0; street < 10; street++) {
                    for (int house = 0; house < 20; house++) {
                        for (int portion = 0; portion < 3; portion++) {
                            file[block][subblock][street][house][portion] = new Record();
                            id++;

                            if (reqid == id){
                                // System.out.println("Id found");
                                System.out.print("The address is: ");
                                System.out.printf("Sector %s, subblock %s, street %s, house %s, portion %s\n",block + 1, subblock + 1,street + 1,house + 1,portion + 1);
                                System.out.print("Name of consumer is: ");
                                PullName(reqid);
                                
                                
                            }
                        }
                    }
                }
            }
        }
        input.close();
        reader.close();

    
    }


    public static void PrintBill() throws IOException{

        // Scanner input = new Scanner(System.in);
        // System.out.print("Enter your id to print bill: ");
        // int id = input.nextInt();

        getCredentials();
    


        // input.close();
    }

    // Bill
    /**
     * 1- Bill Display:
     *      Name: 
     *      ID: 
     *      Address:        (ID --- Address, Adress Indices)
     *      Combined Bill: (Table Form)
     * 
     * 
     * @param args
     * @throws IOException
    */

    public static void initializeMap(){
        int id = 0;
        for (int block = 0; block < 10; block++) {
            for (int subblock = 0; subblock < 4; subblock++) {
                for (int street = 0; street < 10; street++) {
                    for (int house = 0; house < 20; house++) {
                        for (int portion = 0; portion < 3; portion++) {
                            names.put(id, file[block][subblock][street][house][portion].name);
                            // this.bill.put(id, file[block][subblock][street][house][portion].bill);
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        
    //     Scanner input = new Scanner(System.in);
    //     System.out.print("Enter consumer id to be deleted: ");
    //     int cid = input.nextInt();

    //     DeleteConsumer.doIt(cid);

    //     input.close();'
            PullUserIDs(); // CLass instances
            PullName();
            initializeMap();
            

            // PrintBill();
            // PullPreviousReadings("Feb");
            // BillCalculation(9,3,9,19,2);
            // PushData("March");

            System.out.println(names.get(1));
            // System.out.println(file[9][3][9][19][1].name);
            
            // System.out.println(file[9][3][9][19][2].bill[0][0]);
    }
}