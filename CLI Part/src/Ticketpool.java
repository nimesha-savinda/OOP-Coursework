public class Ticketpool {
    private int total =0;
    private int added;
    private int removed;

    public Ticketpool(int total, int added, int removed) {
        this.total = total;
        this.added = added;
        this.removed = removed;
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

    @Override
    public synchronized String toString() {
        return "Ticketpool{" +
                "total=" + total +
                ", added=" + added +
                ", removed=" + removed +
                '}';
    }
}
