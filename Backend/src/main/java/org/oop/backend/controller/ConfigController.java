package org.oop.backend.controller;


import org.oop.backend.service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("api/config")
public class ConfigController {
    @Autowired
    private ConfigService configService;


    @GetMapping("/read")
    public ResponseEntity<String> readFile(){
        try{
            String content = configService.readFile();
            return ResponseEntity.ok(content);

        }catch(IOException e ){
            System.out.println(e);

        }
        return null;
    }
    @GetMapping("/rate")
    public int readSingle(){
        int value = configService.getRetrievalRate();
        return value;
    }



}
