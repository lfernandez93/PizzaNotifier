/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fernandezluis.pizzanotifier.timer;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 *
 * @author 984201
 */
@Singleton
@Startup
public class StartupSingleton {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @PostConstruct()
    public void init() {
        sendMail();
    }

    public void sendMail() {
        //put a sleep here to demonstrate async
        

    }
}
