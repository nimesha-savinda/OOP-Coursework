
# Ticket Pool Simulation

A multithreaded Java program simulating a ticket pool system where:

- **Customers** can buy tickets.
- **Vendors** can add tickets.
- **Actions** are performed randomly and concurrently.

The simulation demonstrates multithreading, random task execution, and logging to a text file.

# Features

- **Concurrency:** Customers and vendors act concurrently, modifying the ticket pool.
- **Random Actions:** Each thread randomly decides its actions during execution.
- **Thread-Safe Operations:** Synchronization ensures consistent updates to shared resources.
- **Logging:** All actions and final simulation results are written to a log file (simulation_logs.txt).

# Classes Overview

**1.Ticketpool**

Manages the shared ticket pool, providing methods to:

- Add tickets to the pool
- Buy tickets from the pool.
- Retrieve the current state of the ticket pool.

**2. Customer**

Represents a customer trying to buy tickets.

- Runs as a thread.
- Performs random actions such as attempting to buy tickets or remaining idle.


**3.Vendor**

Represents a vendor adding tickets to the pool.

- Runs as a thread.
- Performs random actions such as adding tickets or remaining idle.

**4.Simulation**

Controls the execution of the program.

- Creates and starts threads for customers and vendors.
- Ensures threads execute in a random order.
- Logs all actions and final simulation results to simulation_logs.txt.


## Steps to Run

1.Clone or Download the Repository:

```bash
  git clone https://github.com/nimesha-savinda/OOP-Coursework.git
```
2.Navigate to the Project Directory:

```bash
  cd "CLI Part/src"
```

3.Compile the Program:

```bash
  javac *.java
```
4.Run the Program:

```bash
  javac *.java
```
5.View the Logs:

```bash
  Open simulation_logs.txt
```

## Sample Output

```java
configuration.json imported..! 100 Tickets available
Customer John bought 8 tickets.
Vendor Patrick added 5 tickets to the pool.
Vendor Charles added 7 tickets to the pool.
Customer Arthur bought 3 tickets.
Customer Peter bought 9 tickets.
Vendor David added 6 tickets to the pool.
Customer John bought 4 tickets.
Customer Arthur bought 6 tickets.
Vendor Patrick added 8 tickets to the pool.
Vendor Charles added 10 tickets to the pool.
Customer Peter bought 5 tickets.
Vendor David added 3 tickets to the pool.
Ticketpool{totalTickets=100, availableTickets=92, removedTickets=35}
```
# Author

Nimesha Savinda Dahanayaka

UoW id: w2053095

IIT id: 20232317

