import com.google.gson.Gson;
import java.io.FileReader;
import java.io.IOException;

public class Simulation {
    public static void main(String[] args){

        Gson gson = new Gson();

        Ticketpool t1 = new Ticketpool(100,20,0);

        Customer c1 = new Customer("John",0,t1);
        Customer c2 = new Customer("Arthur",0,t1);
        Vendor v1 = new Vendor("John",0,t1);
        Vendor v2 = new Vendor("John",0,t1);

        Thread customerThread1 = new Thread(c1);
        Thread customerThread2 = new Thread(c2);
        Thread vendorThread1 = new Thread(v1);
        Thread vendorThread2 = new Thread(v2);


        customerThread1.start();
        customerThread2.start();
        vendorThread1.start();
        vendorThread2.start();

        try {
            customerThread1.join();
            customerThread2.join();
            vendorThread1.join();
            vendorThread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(t1.toString());
    }
}
