/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.fernandezluis.pizzanotifier.repository;

import com.fernandezluis.pizzanotifier.domain.Subscriber;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Luis Fernandez
 */
@Repository
public interface SubscriberRepository extends CrudRepository<Subscriber, Long>{
    
    @Query("SELECT v FROM Subscriber v")
    public List<Subscriber> listAll();
}
