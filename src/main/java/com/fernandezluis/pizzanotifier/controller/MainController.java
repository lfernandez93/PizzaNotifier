package com.fernandezluis.pizzanotifier.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.fernandezluis.pizzanotifier.domain.Subscriber;
import com.fernandezluis.pizzanotifier.service.SubscriberService;
import com.fernandezluis.pizzanotifier.service.impl.SubscriberServiceImpl;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Luis
 */
@Controller("/")
public class MainController {

    @Autowired
    SubscriberService subsService;

    @RequestMapping("/")
    public String getIndex() {
        return "index";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String saveSubscription(@Valid Subscriber subscriber, BindingResult bidingResult, Model model) {
        System.out.println("holasds");
        System.out.println(subscriber.getEmail());
        if (bidingResult.hasErrors()) {
            model.addAttribute("error", true);
            return "redirect:/";
        }
        model.addAttribute("error", false);
        subsService.save(subscriber);
        return "redirect:/saved";
    }

    @RequestMapping("/saved")
    public String saved() {
        return "saved";
    }

    @RequestMapping("/list")
    public @ResponseBody
    List<Subscriber> getAll() {
        return subsService.list();
    }
}
