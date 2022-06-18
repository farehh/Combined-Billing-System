import java.security.SecureRandom;

public class RandomReadings {
    private static SecureRandom random = new SecureRandom();

    public static double electricity(double previous_reading){
        // random option for conditional readings (Consumptions)
        int option = random.nextInt(4);

        // Returning random readings incremented to previous reading 
        if(option == 0){ 
            return (previous_reading + random.nextDouble(100)); // Less than 100
        } else if (option == 1){
            return (previous_reading + (100 + random.nextDouble(100)));  // Between 100-199
        } else if (option == 2){
            return (previous_reading + (200 + random.nextDouble(100))); // Between 200-300
        } else {
            return (previous_reading + (300 + random.nextDouble(700)));  // Above 300 Flat (But Less than 1000)
        }
    }
    
    public static double gas(double previous_reading){
        // random option for conditional readings (Consumptions)
        int option = random.nextInt(6);

        // Returning random readings incremented to previous reading 
        if(option == 0){ 
            return (previous_reading + random.nextDouble(50)); // Less than 50
        } else if (option == 1){
            return (previous_reading + (50 + random.nextDouble(50)));  // From 50 to 99
        } else if (option == 2){
            return (previous_reading + (100 + random.nextDouble(100))); // From 100 to 199
        } else if (option == 3){
            return (previous_reading + (200 + random.nextDouble(100)));  // From 200 to 299
        } else if (option == 4){
            return (previous_reading + (300 + random.nextDouble(100)));  // From 300 to 399
        } else {
            return (previous_reading + (400 + random.nextDouble(600)));  // Above 400 Flat (But Less than 1000)
        }

    }

    public static double water(double previous_reading){
        // random option for conditional readings (Consumptions)
        int option = random.nextInt(3);

        // Returning random readings incremented to previous reading 
        if(option == 0){ 
            return (previous_reading + random.nextDouble(1001)); // Up to 1000.xx liters 
        } else if (option == 1){
            return (previous_reading + (1001 + random.nextDouble(1001)));  // 1001-2000.xx liters
        } else {
            return (previous_reading + (2001 + random.nextDouble(8000)));  // Above 2000 liters (But Less than 10000)
        }
    }
    

    public class media {
        public static double local_calls(double previous_reading){
            // Returning random readings incremented to previous reading 
            return (previous_reading + random.nextDouble((1001))); // Up to 1000 minutes 
        }

        public static double international_calls(double previous_reading){
            // Returning random readings incremented to previous reading 
            return (previous_reading + random.nextDouble((251))); // Up to 250 minutes
        }

        public static double internet(double previous_reading){
            // Returning random readings incremented to previous reading 
            return (previous_reading + random.nextDouble((101))); // Up to 100 GB
        }
    }
}
