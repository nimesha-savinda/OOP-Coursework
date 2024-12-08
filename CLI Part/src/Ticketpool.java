public class Ticketpool {
    private int total;
    private int added;
    private int removed;
    private Configuration configuration;


    public Ticketpool(int total, int added, int removed, Configuration configuration) {
        this.total = total;
        this.added = added;
        this.removed = removed;
        this.configuration = configuration;
    }

    public synchronized int getTotal() {
        return total;
    }

    public synchronized void setTotal(int total) {
        this.total = total;
    }

    public synchronized int getAdded() {
        return added;
    }

    public synchronized void setAdded(int added) {
        this.added = added;
    }

    public synchronized int getRemoved() {
        return removed;
    }

    public synchronized void setRemoved(int removed) {
        this.removed = removed;
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public synchronized String toString() {
        return "Ticketpool{" +
                "total=" + total +
                ", added=" + added +
                ", removed=" + removed +
                '}';
    }
}
