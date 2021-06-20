package com.example.demo.controllers;

import com.example.demo.dao.ClientOrderDao;
import com.example.demo.models.ClientOrder;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/orders")
public class OrderController {

    private ClientOrderDao clientOrderDao;

    @GetMapping("/all")
    public List findAll(){
        return clientOrderDao.findAll();
    }

    @PostMapping("/save")
    public void save(@RequestBody ClientOrder clientOrder) {
//        clientOrder.setItem("box");
//        clientOrder.setPrice(10);
//        clientOrder.setQuantity(3);
          Date dateTime = new Date();
          Date dueDateTime = new Date();
          Calendar cal = Calendar.getInstance();
          cal.setTime(dateTime);
          cal.add(Calendar.MINUTE, 10);
          dueDateTime = cal.getTime();
          clientOrder.setDateTime(dateTime);
          clientOrder.setDueDateTime(dueDateTime);
        clientOrderDao.save(clientOrder);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody int id){
        clientOrderDao.deleteById(id);
    }

    @PutMapping("/update")
    public void update(@RequestBody ClientOrder clientOrder){
        clientOrderDao.save(clientOrder);
    }
}
