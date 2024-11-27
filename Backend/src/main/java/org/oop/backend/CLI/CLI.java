package org.oop.backend.CLI;

import org.oop.backend.BackendApplication;
import org.oop.backend.controller.CustomerController;
import org.oop.backend.controller.VendorController;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

public class CLI {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(BackendApplication.class, args);

        CustomerController Customer_Controller = context.getBean(CustomerController.class);
        VendorController Vendor_Controller = context.getBean(VendorController.class);
        CustomerController myController = context.getBean(CustomerController.class);


    }
}
