/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fernandezluis.pizzanotifier.timer;

import java.util.Date;
import javax.ejb.Schedule;
import javax.ejb.Stateless;

/**
 *
 * @author 984201
 */
@Stateless
public class PizzaTimer {

    @Schedule(minute = "59", second = "30", dayOfMonth = "4", month = "*", year = "*", hour = "13", dayOfWeek = "Wed", persistent = false)
    
    public void myTimer() {
        System.out.println("hello");
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
