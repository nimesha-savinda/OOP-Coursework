import java.util.Scanner;

public class  Customer implements Runnable {
    private String username;
    private int tickets_removed;

    private Ticketpool pool;

    public Customer(String username, int tickets_removed,Ticketpool ticketpool) {
        this.username = username;
        this.tickets_removed = tickets_removed;
        this.pool = ticketpool;
    }

    public String getUsername() {
        return username;
    }

    public Ticketpool getPool() {
        return pool;
    }

    public int getTickets_removed() {
        return tickets_removed;
    }

    public void setTickets_removed(int tickets_removed) {
        this.tickets_removed = tickets_removed;
    }

    @Override
    public void run() {
        java.util.Random random = new java.util.Random();

        // Generate a random number of iterations (e.g., between 1 and 10)
        int iterations = random.nextInt(10) + 1; // Random iterations between 1 and 10

        for (int i = 0; i < iterations; i++) {
            // Generate a random value below 10
            int value = random.nextInt(10)+1; // Random value between 0 and 9

            // Perform the operations

            synchronized (pool) {
                pool.setRemoved(pool.getRemoved() + value);

            }
            System.out.println("customer "+getUsername()+" "+value+" Tickets bought");
//            System.out.println(getPool().toString());
            try {
                Thread.sleep(random.nextInt(1000)); // Random short delay
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}
