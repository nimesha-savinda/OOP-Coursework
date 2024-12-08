import com.google.gson.Gson;
import java.io.FileReader;
import java.io.IOException;

public class Simulation {
    public static void main(String[] args){

        Gson gson = new Gson();
        //file path of the local json file
        String filePath = "D:\\IIT\\Courseworks\\L05\\OOP\\OOP-Coursework\\CLI Part\\configuration.json";

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
        Customer c1 = new Customer("John",0,t1);
        Customer c2 = new Customer("Arthur",0,t1);
        Vendor v1 = new Vendor("John",0,t1);
        Vendor v2 = new Vendor("John",0,t1);

        //Customer and Vendor Threads
        Thread customerThread1 = new Thread(c1);
        Thread customerThread2 = new Thread(c2);
        Thread vendorThread1 = new Thread(v1);
        Thread vendorThread2 = new Thread(v2);


        customerThread1.start();
        customerThread2.start();
        vendorThread1.start();
        vendorThread2.start();

        try {
            customerThread1.join();//to ensure every thread has executed
            customerThread2.join();
            vendorThread1.join();
            vendorThread2.join();
        } catch (InterruptedException e) {
            System.out.println("Error while executing threads "+e.getMessage());
        }
        System.out.println(t1.toString());
    }
}
