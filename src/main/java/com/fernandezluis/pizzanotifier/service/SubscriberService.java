/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fernandezluis.pizzanotifier.service;

import com.fernandezluis.pizzanotifier.domain.Subscriber;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author 984201
 */
public interface SubscriberService {

    public void save(Subscriber subscriber);

    public List<Subscriber> list();
}
