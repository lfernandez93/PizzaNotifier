package com.fernandezluis.pizzanotifier.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Luis
 */

@Controller("/")
public class MainController {
    @RequestMapping("/")
    public String getIndex(){
        return "index";
    }
}
