package com.example.techprotocolfrontend.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
public class PostController {
final String API_SOME_GET ="http://localhost:2020/";
final String API_SOME_POST="http://localhost:2020/addPost";
private RestTemplate restTemplate = new RestTemplate();

        @PostMapping("/addNewPost")
        public String addNewPost(Model model, @RequestParam(value ="name") String name, @RequestParam(value = "postDescription") String postDescription, @RequestParam(value = "postDate") String postDate){
            System.out.println(name);

            Map<String,String> reqMap = new HashMap();
            reqMap.put("name", name);
            reqMap.put("postDescription", postDescription);
            reqMap.put("postDate", postDate);

            ResponseEntity res = restTemplate.postForEntity(API_SOME_POST,reqMap, String.class);
            model.addAttribute("status", res.getBody());
            return "Name: " + name + " Description: " + " " + postDescription + " Postdate" + " " + postDate + " ||  STATUS PÅ REQUEST: " + res.getBody();
            }



}
