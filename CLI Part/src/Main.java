import java.io.FileReader;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
public class Main {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);//to get 4 parameters for the configuration file
        try {
            System.out.println("Total number of Tickets:");
            int totalTickets = input.nextInt();

            System.out.println("Ticket Release Rate:");
            int ticketReleaseRate = input.nextInt();

            System.out.println("Customer Retrieval Rate:");
            int customerRetrievalRate = input.nextInt();
            System.out.println("sss");

            System.out.println("Maximum Ticket Capacity:");
            int maxTicketCapacity = input.nextInt();

            Configuration config = new Configuration(totalTickets, ticketReleaseRate,
                    customerRetrievalRate, maxTicketCapacity);

            File config_file = new File("configuration.txt"); //created a text file to get the data for backend
            FileWriter fileWriter = new FileWriter(config_file);
            fileWriter.write("Total number of tickets:"+totalTickets+"\n");
            fileWriter.write("Ticket release rate:"+ticketReleaseRate+"\n");
            fileWriter.write("Retrieval rate:"+customerRetrievalRate+"\n");
            fileWriter.write("Maximum Capacity:"+maxTicketCapacity+"\n");
            fileWriter.close();

        }catch(Exception e){
            System.out.println(e);
        }

    }
}
