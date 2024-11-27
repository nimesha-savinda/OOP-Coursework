import java.io.*;

public class Configuration {    //Configuration class
    private int totalTickets;
    private int ticketReleaseRate;
    private int customerRetrievalRate;
    private int maxTicketCapacity;
    private static final String FILE_PATH = "D:/IIT/Courseworks/L05/OOP/OOP-Coursework/updated.txt";

    public Configuration(int totalTickets, int ticketReleaseRate, int customerRetrievalRate, int maxTicketCapacity) {
        this.totalTickets = totalTickets;
        this.ticketReleaseRate = ticketReleaseRate;
        this.customerRetrievalRate = customerRetrievalRate;
        this.maxTicketCapacity = maxTicketCapacity;
    }

    public void run(){
        try {

            BufferedReader newRead = new BufferedReader(new FileReader(new File(FILE_PATH)));
            System.out.println("][][][][][][][][][][][][][][][][]");
            System.out.println(newRead.readLine());
            System.out.println(newRead.readLine());
            System.out.println(newRead.readLine());
            newRead.close();
            System.out.println("][][][][][][][][][][][][][][][][]");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public int getTotalTickets() {
        return totalTickets;
    }

    public void setTotalTickets(int totalTickets) {
        this.totalTickets = totalTickets;
    }

    public int getTicketReleaseRate() {
        return ticketReleaseRate;
    }

    public void setTicketReleaseRate(int ticketReleaseRate) {
        this.ticketReleaseRate = ticketReleaseRate;
    }

    public int getCustomerRetrievalRate() {
        return customerRetrievalRate;
    }

    public void setCustomerRetrievalRate(int customerRetrievalRate) {
        this.customerRetrievalRate = customerRetrievalRate;
    }

    public int getMaxTicketCapacity() {
        return maxTicketCapacity;
    }

    public void setMaxTicketCapacity(int maxTicketCapacity) {
        this.maxTicketCapacity = maxTicketCapacity;
    }
}
