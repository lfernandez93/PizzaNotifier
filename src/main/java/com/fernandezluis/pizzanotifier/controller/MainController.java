package com.fernandezluis.pizzanotifier.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.fernandezluis.pizzanotifier.domain.Subscriber;
import com.fernandezluis.pizzanotifier.service.SubscriberService;
import com.fernandezluis.pizzanotifier.service.impl.SubscriberServiceImpl;
import com.fernandezluis.pizzanotifier.utils.MailSender;
import java.util.List;
import javax.ejb.EJB;
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
    
    @Autowired
    MailSender mailSender;
    
    @RequestMapping("/")
    public String getIndex() {
        return "index";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String saveSubscription(@Valid Subscriber subscriber, BindingResult bidingResult, Model model) {
        if (bidingResult.hasErrors()) {
            model.addAttribute("error", true);
            return "redirect:/";
        }
        model.addAttribute("error", false);
        subsService.save(subscriber);
        mailSender.sendMail("PizzaNotifier@mum.edu", subscriber.getEmail(), "Thanks for your subscription.", "Subscription completed");
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
