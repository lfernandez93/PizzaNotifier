/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fernandezluis.pizzanotifier.service.impl;

import com.fernandezluis.pizzanotifier.domain.Subscriber;
import com.fernandezluis.pizzanotifier.repository.SubscriberRepository;
import com.fernandezluis.pizzanotifier.service.SubscriberService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Luis Fernandez
 */
@Service
@Transactional
public class SubscriberServiceImpl implements SubscriberService {

    @Autowired
    SubscriberRepository subsRepository;

    @Override
    public void save(Subscriber subscriber) {
        subsRepository.save(subscriber);
    }

    @Override
    public List<Subscriber> list() {
        return subsRepository.listAll();
    }

}
