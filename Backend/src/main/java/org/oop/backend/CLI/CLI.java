package org.oop.backend.CLI;

import org.oop.backend.BackendApplication;
import org.oop.backend.controller.ConfigController;
import org.oop.backend.controller.CustomerController;
import org.oop.backend.controller.TicketPoolController;
import org.oop.backend.controller.VendorController;
import org.oop.backend.dto.CustomerDto;
import org.oop.backend.model.Customer;
import org.oop.backend.model.Configuration;
import org.oop.backend.model.TicketPool;
import org.oop.backend.model.Vendor;
import org.oop.backend.repository.ConfigurationRepository;
import org.oop.backend.repository.CustomerRepository;
import org.oop.backend.repository.TicketPoolRepository;
import org.oop.backend.repository.VendorRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

//import java.lang.module.Configuration;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CLI {

    public static void main(String[] args) {
        System.setProperty("logging.level.root", "OFF");  //to turn of the cli loggers
        System.setProperty("logging.level.org.springframework.boot", "OFF");
        System.setProperty("logging.level.org.springframework.web", "OFF");

        ConfigurableApplicationContext context = SpringApplication.run(BackendApplication.class, args);
        CustomerController Customer_Controller = context.getBean(CustomerController.class);
        VendorRepository vendor_repository = context.getBean(VendorRepository.class);
        VendorController Vendor_Controller = context.getBean(VendorController.class);
        TicketPoolController ticketPoolController= context.getBean(TicketPoolController.class);
        CustomerController myController = context.getBean(CustomerController.class);
        CustomerRepository customerRepository=context.getBean(CustomerRepository.class);
        ConfigController configController=context.getBean(ConfigController.class);
        ConfigurationRepository configurationRepository=context.getBean(ConfigurationRepository.class);
        TicketPoolRepository ticketPoolRepository = context.getBean(TicketPoolRepository.class);
        //to import the properties from the backend

        Boolean cont = true; // the boolean variable to run the loop



        System.out.println("Welcome to the ticket system..! :)");

        while(cont) {
            Scanner input = new Scanner(System.in);//for the inputs of the system
            System.out.println("*****************\n" +  //Main menu
                                "1)Create Configuration File\n"+
                                "2)View Configuration File\n"+
                                "3)Track Ticket Pool\n"+
                                "4)Customer Panel\n" +
                                "5)Vendor panel\n"+
                                "6)Quit\n"+
                                "*****************");
            String value = input.nextLine();  //this variable will be checked below for find the selected option
            switch (value) {
                case "1":
                    System.out.println("Total_number_of_tickets:");//asks for variables to create the config file
                    Integer Total_number_of_tickets = input.nextInt();
                    System.out.println("Ticket_release_rate:");
                    Integer Ticket_release_rate = input.nextInt();
                    System.out.println("Retrieval_rate:");
                    Integer Retrieval_rate = input.nextInt();
                    System.out.println("Maximum_Capacity:");
                    Integer maximum_Capacity = input.nextInt();

                    Configuration configuration = new Configuration(Total_number_of_tickets,Ticket_release_rate,
                            Retrieval_rate,maximum_Capacity);  //This creates a new configuration file for the session
                    configurationRepository.save(configuration);

                    TicketPool new_ticketPool = new TicketPool(Total_number_of_tickets,0,0);
                    ticketPoolRepository.save(new_ticketPool);
                    //This creates a new ticket pool along with the configuration file for the new session

                    break;

                case "2":
                        Configuration configuration1 = configController.getLatest();//Shows the current config file
                        System.out.println("-------Current Configuration Settings-------" +
                                "           \nTotal number of Tickets: "+configuration1.getTotal_number_of_tickets()+
                                            "\nTicket Release rate: "+configuration1.getTicket_release_rate()+
                                            "\nRetrieval Rate: "+configuration1.getRetrieval_rate()+
                                            "\nMaximum Capacity: "+configuration1.getMaximum_Capacity()+
                                            "\n-------------------------------------------");
                    break;
                case "3":

                    Boolean ticket_pool_loop = true; //this variable is used to run the ticket tracking loop

                    while(ticket_pool_loop){

                        for(int i = 0;i<5;i++){//after 5 iterations it will ask to continue or not
                            TicketPool ticketPool = ticketPoolController.getTheLatestTicketPool();
                            System.out.println("++++++++++++++++\n" +
                                                "Available Tickets: "+ticketPool.getAvailableTickets()+
                                                "\nAdded Tickets: "+ticketPool.getAddedTickets()+
                                                "\nRemoved Tickets: "+ticketPool.getRemovedTickets()+
                                                "\n++++++++++++++++");
                            try {
                                Thread.sleep(4000);//sleeps for 4 seconds
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }

                        try
                        {   System.out.println("continue:(y/n)");  // ask for continue the ticket track loop
                            String response = input.nextLine();
                            if(response.equalsIgnoreCase("y")){
                                ticket_pool_loop = true;
                            } else if (response.equalsIgnoreCase("n")) {
                                ticket_pool_loop = false;
                            }else{
                                System.out.println("Please enter a valid input...!");
                                ticket_pool_loop = true;//if the input is invalid loop will continue
                            }
                            ticket_pool_loop = input.nextBoolean();
                        }catch(InputMismatchException e){
                            System.out.println("Invalid input: "+e.getMessage());
                            ticket_pool_loop = false;
                        }

                    }
                    break;

                case "4":

                    System.out.println("*****************\n" +  //Main menu
                            "1)Create new Customer\n"+
                            "2)Log in\n"+
                            "*****************");
                    String customer_response = input.nextLine();

                    switch(customer_response){
                        case "1":
                            try{
                                System.out.println("Enter username");
                                String new_username = input.nextLine();
                                System.out.println("Enter password");
                                String new_password = input.nextLine();
                                Customer new_customer= new Customer(new_username,new_password,true,0);
                                customerRepository.save(new_customer);
                                System.out.println("New Customer added to the database..!");
                            }catch(Exception e){
                                System.out.println("Error: "+e.getMessage());
                            }
                        break;

                        case"2":

                            System.out.println("Enter username");
                            String username = input.nextLine();

                            Customer exsisting_customer = customerRepository.findCustomerByUsername(username);
                            System.out.println(exsisting_customer.getPassword());
                            System.out.println("Enter password");

                            String password = input.nextLine();
                            if(password.equals(exsisting_customer.getPassword())){
                                System.out.println("Successfully logged in");
                                System.out.println("Enter ticket amount to buy");

                                Integer ticket_amount = input.nextInt();
                                Configuration latest_config = configController.getLatest();


                                if(ticket_amount<=latest_config.getRetrieval_rate()){
                                    exsisting_customer.setTicketsBought(exsisting_customer.getTicketsBought()
                                            +ticket_amount);
                                    customerRepository.save(exsisting_customer);
                                    System.out.println("Record updated...!");
                                }else{System.out.println("Enter a valid ticket amount..!");}

                            }else{
                                System.out.println("Wrong password..!");
                            }

                            break;
                    }
                    break;
                case"5":

                    System.out.println("*****************\n" +  //Main menu
                            "1)Create new Vendor\n"+
                            "2)Log in\n"+
                            "*****************");
                    String vendor_response = input.nextLine();

                    switch(vendor_response){
                        case "1":
                            try{
                                System.out.println("Enter username");
                                String new_username = input.nextLine();
                                System.out.println("Enter password");
                                String new_password = input.nextLine();
                                Integer new_tickets_added = 0;

                                Vendor new_vendor= new Vendor(new_username,new_password,new_tickets_added);
                                vendor_repository.save(new_vendor);
                                System.out.println("New Vendor added to the database..!");
                            }catch(Exception e){
                                System.out.println("Error: "+e.getMessage());
                            }
                            break;

                        case"2":

                            System.out.println("Enter username");
                            String vendor_username = input.nextLine();

                            Vendor exsisting_vendor = vendor_repository.findVendorByUsername(vendor_username);
                            System.out.println("Enter password");
                            String password = input.nextLine().trim();
                            if(password.equals(exsisting_vendor.getPassword())){
                                System.out.println("Successfully logged in");
                                System.out.println("Enter ticket amount to add");

                                Integer ticket_amount = input.nextInt();
                                Configuration latest_config = configController.getLatest();


                                if(ticket_amount<latest_config.getRetrieval_rate()){
                                    exsisting_vendor.setTicketsAdded(exsisting_vendor.getTicketsAdded()
                                            +ticket_amount);
                                    vendor_repository.save(exsisting_vendor);
                                }else{System.out.println("Enter a valid ticket amount..!");}

                            }else{
                                System.out.println("Wrong password..!");
                            }

                            break;
                    }
                    break;

                case"6":
                    cont = false;
                    break;

                default:
                    System.out.println("Enter a valid input...!");

            }

        }
        context.close();
        System.exit(0);//to close the backend

    }
}
