import java.util.Scanner;
import java.util.logging.Logger;

public class Vendor implements Runnable{
    private String name;
    private int added_tickets;

    private Ticketpool pool;
    private Logger log;

    public Vendor(String name, int added_tickets, Ticketpool pool, Logger log) {
        this.name = name;
        this.added_tickets = added_tickets;
        this.pool = pool;
        this.log = log;
    }

    public int getAdded_tickets() {
        return added_tickets;
    }

    public void setAdded_tickets(int added_tickets) {
        this.added_tickets = added_tickets;
    }

    @Override
    public void run() {

        java.util.Random random = new java.util.Random();

        // Generate a random number of iterations (e.g., between 1 and 10)
        int iterations = random.nextInt(10) + 1; // Random iterations between 1 and 10

        for (int i = 0; i < iterations; i++) {
            // Generate a random value below 10
            int value = random.nextInt(pool.getConfiguration().getTicketReleaseRate())+1;

            synchronized (pool) {
                pool.setAdded(pool.getAdded() + value);
                pool.setTotal(pool.getTotal()+value);
                log.info("Vendor "+this.name+" added "+value+" Tickets to the pool");

            }// Random value between 0 and 9


            try {
                Thread.sleep(random.nextInt(1000)); // Random short delay
            } catch (InterruptedException e) {
                e.printStackTrace();
            }





        }
    }
}
