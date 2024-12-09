import com.google.gson.Gson;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Logger;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;

public class Simulation {
    public static void main(String[] args){

        Gson gson = new Gson();
        //file path of the local json file
        String filePath = "D:\\IIT\\Courseworks\\L05\\OOP\\OOP-Coursework\\CLI Part\\configuration.json";

        Logger logger = Logger.getLogger("SimulationLogger");

        FileHandler fileHandler = null;
        try {
            fileHandler = new FileHandler("simulation_operations.log", true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        fileHandler.setFormatter(new SimpleFormatter());
        logger.addHandler(fileHandler);
        logger.info("\nTicketing Simulation started.!");


        Configuration configuration = null;

        try  {
            // parse json and map to configuration object
            FileReader reader = new FileReader(filePath);
            configuration = gson.fromJson(reader, Configuration.class);
            System.out.println("configuration.json imported..!"+configuration.getTotalTickets()+" Tickets available");

        } catch (IOException e) {
            System.out.println("Failed to import configuration file "+e.getMessage());
        }
        //creates a ticket pool object according to the imported configuration.json
        Ticketpool t1 = new Ticketpool(configuration.getTotalTickets(), 0,0,configuration);

        //Customers and Vendors
        Customer c1 = new Customer("John",0,t1,logger);
        Customer c2 = new Customer("Arthur",0,t1,logger);
        Customer c3 = new Customer("Peter",0,t1,logger);
        Vendor v1 = new Vendor("Patrick",0,t1,logger);
        Vendor v2 = new Vendor("Charles",0,t1,logger);
        Vendor v3 = new Vendor("David",0,t1,logger);

        //Customer and Vendor Threads
        Thread customerThread1 = new Thread(c1);
        Thread customerThread2 = new Thread(c2);
        Thread customerThread3 = new Thread(c3);
        Thread vendorThread1 = new Thread(v1);
        Thread vendorThread2 = new Thread(v2);
        Thread vendorThread3 = new Thread(v3);


        customerThread1.start();
        customerThread2.start();
        customerThread3.start();
        vendorThread1.start();
        vendorThread2.start();
        vendorThread3.start();

        try {
            customerThread1.join();//to ensure every thread has executed
            customerThread2.join();
            customerThread3.join();
            vendorThread1.join();
            vendorThread2.join();
            vendorThread3.join();
        } catch (InterruptedException e) {
            System.out.println("Error while executing threads "+e.getMessage());
        }
        System.out.println(t1.toString());
        logger.info("Ticketing Simulation ended.!");
    }
}
