package edu.aritra.web.service;

import org.springframework.stereotype.Service;

@Service
public class ExampleService {
    public String execute() {
        System.out.println("executing service");
        String msg = "service executed";
        System.out.println(msg);
        return msg;
    }
}
