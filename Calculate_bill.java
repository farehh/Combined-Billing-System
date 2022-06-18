/**
 * Calculates Utility Bills
 * @author @hammadsaedi 
*/
public class Calculate_bill {

    /**
     * Calculates Electricity Bill
     * @param units consumed
     * @return Electricity Bill
    */
    public static double electricity(double units){
        // returning calculated bill depending upon consumptions
        if(units < 100){ 
            return (units * 10); // Less than 100 Flat Rs.10/- per unit
        } else if (units <= 199){
            return (1000 + (units - 100) * 15); // From 100 to 199 (Rs.1000/- + for units > 100, Rs.15/- per unit)
        } else if (units <= 300){
            return (3000 + (units - 200) * 18); // From 200 to 300 (Rs.3000/- + for units > 200, Rs.18/- per unit)
        } else {
            return (units * 25); // Above 300 Flat Rs.25/- per unit
        }
    }
    
    /**
     * Calculates Gas Bill
     * @param units consumed
     * @return Gas Bill
    */
    public static double gas(double units){
        // Gas Charges
        double gcv = 1056.0, meter_rent = 40.00, gst = 40.77;
        // One million British Thermal Units
        double MMBtu = ((units/100)*gcv)/281.7385;

        if(units<50){ // Less than 50
            return (MMBtu * 121.0 + meter_rent + gst);
        } else if(units<100){ // From 50 to 99 
            return (MMBtu * 300.0 + meter_rent + gst);
        } else if(units<200){ // From 100 to 199
            return (MMBtu * 553.0 + meter_rent + gst);
        } else if(units<300){ // From 200 to 299
            return (MMBtu * 738.0 + meter_rent + gst);
        } else if(units<400){ // From 300 to 399
            return (MMBtu * 1107.0 + meter_rent + gst);
        } else { // From 400
            return (MMBtu * 1460.0 + meter_rent + gst);
        }
    }

    /**
     * Calculate bill of water consumptions
     * @param units consumed
     * @return Water Bill
    */
    public static double water(double units){
        // returning calculated bill depending upon consumptions
        if(units <= 1000){ 
            return 400; // Up to 1000 liters Rs. 400/-
        } else if (units <= 2000){
            return 1000; // 1001-2000 liters Rs. 1000/-
        } else {
            return (1000 + units* 1.5); // Above 2000 liters Rs. 1000/- plus Rs. 1.5/liter
        }
    }


    /**
     * Calculates Media (Local Calls, International Calls and Internet) Bills
     * @author @hammadsaedi
    */
    public class media {

        /**
         * Calculate Local Calls Bill
         * @param minutes consumed
         * @return Local Calls Bill
        */
        public static double local_calls(double minutes){
            // returning total bill
            return minutes * 5; // Rs.5/- per minutes
        }

        /**
         * Calculates International Calls Bill
         * @param minutes consumed
         * @return International Calls Bill
        */
        public static double international_calls(double minutes){
            // returning total bill
            return minutes * 7; // Rs.7/- per minutes
        }

        /**
         * Calculates Internet Bill
         * @param GB consumed
         * @return Internet Bill
        */
        public static double internet(double GB){
            // returning total bill
            return GB * 10; // Rs. 10/- per GB
        }
    }
}