package org.oop.backend.service;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class ConfigService {
    private int totalTickets;
    private int ticketReleaseRate;
    private int retrievalRate;
    private int maxCapacity;
    private static final String FILE_PATH = "D:/IIT/Courseworks/L05/OOP/OOP-Coursework/configuration.txt";

    public String readFile() throws IOException {
        Path filePath = Paths.get(FILE_PATH);
//        File newFile = new File(FILE_PATH);
//        FileReader newReader = new FileReader(newFile);
//        String Line = String.valueOf(newReader.read());
        return Files.readString(filePath);
    }

    @PostConstruct //to load the file before the programme starts
    public void LoadInfo(){ //to get values from the config.txt

        try{
            if (!Files.exists(Paths.get(FILE_PATH))) {
                System.out.println("File does not exist at the specified path: " + FILE_PATH);
                return;
            }
            BufferedReader newReader = new BufferedReader(new FileReader(new File(FILE_PATH)));
            String line;
            while ((line = newReader.readLine()) != null) {
                if (line.startsWith("Total number of tickets:")) {
                    totalTickets = Integer.parseInt(line.split(":")[1].trim());
                } else if (line.startsWith("Ticket release rate:")) {
                    ticketReleaseRate = Integer.parseInt(line.split(":")[1].trim());
                } else if (line.startsWith("Retrieval rate:")) {
                    retrievalRate = Integer.parseInt(line.split(":")[1].trim());
                } else if (line.startsWith("Maximum Capacity:")) {
                    maxCapacity = Integer.parseInt(line.split(":")[1].trim());
                    System.out.println(maxCapacity);
                }
            }
        }catch(IOException e){
            System.out.println("Error");
        }

    }
    public int getTotalTickets()
    {
        return totalTickets;
    }

    public int getTicketReleaseRate() {
        return ticketReleaseRate;
    }

    public int getRetrievalRate() {
        return retrievalRate;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }}
