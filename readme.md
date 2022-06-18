# Problem Statement.

Using Java file IO, implement a small menu-driven database management system called Combined Billing System (CBS) for a housing project comprising of ten blocks ranging from block A to J, each block comprises of four sub-blocks 1 to 4, each sub-block comprises of ten streets 1 to 10, each street has 20 houses, each house comprises of three portions (Ground, 1st, and 2nd floor), and each portion have been provided four utilities (e.g. gas, electricity, water, and phone).  
 
The system will keep residents’ data month-wise in the data files (e.g. Jan2022, Feb2022 and so on) as records. Each record has fields; customer-ID (primary key), name, meter reading plus the bill amount for each of the four utilities. Note: the address will be generated in the chronological order of the houses using nested loops and is not stored in the data file. 
 
The bill calculation criteria/tariff for various utilities is given below: 
 
Utility 	            Units consumed 	                     Billing Criteria/tariff 
 
Electricity     	     Less than100 	                          Flat Rs.10/- per unit 
	                     Between 100-199 	Rs.1000/- + for units > 100, Rs.15/- per unit 
                         Between 200-300 	Rs.3000/- + for units > 200, Rs.18/- per unit 
                         Above 300 	        Flat Rs.25/- per unit 

Gas 	 	             Use https://www.suigasbill.net/ 

 Water 	                Up to 1000 liters 	                        Rs. 400/- 
                        1001-2000 liters 	                        Rs. 1000/- 
                        Above 2000 liters 	                Rs. 1000/- plus Rs. 1.5/liter 


Phone/internet 	Calls: 
    i) Local     
    ii) International Internet:  	
                                                                Rs.5/- per minutes 
                                                                Rs.7/- per minute 
                                                                Rs. 10/- per GB 
 
 
 
 	 	 	 
 	 
As discussed in the class and lab, at the start of each month the system will:  
1.	read the data from the previous month’s data file into a multidimensional array 
2.	get the current month’s readings from keyboard for each utility 
3.	calculate and display a combined bill for the residents of each portion based on the consumption of each utility and corresponding bill calculation criteria/tariff.  
create current month’s data file storing the residents’ records kept in the array and replacing both the previous month’s readings and bill amounts with the current month’s readings and bill amounts to be used in the next month. 
 
Apart from its primary objective described above, the system must have provisions for searching, modification/updation, deletion of any record as well as generate various reports such as: 
1.	the maximum and/or minimum bill for a specific  utility or house or street or sub-block, or block. 
2.	Month-wise billing report for a specific consumer for a specified period for all utilities 
3.	Month-wise billing report for a specific consumer for a specified period for a particular utility 
4.	Detailed report of consumers not using all or a specific utility between a specified period. 
5.	Yearly and half-yearly reports based on the total bill for each consumer. 
 
