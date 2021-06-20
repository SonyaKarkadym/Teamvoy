package com.example.demo.controllers;

import com.example.demo.dao.ClientOrderDao;
import com.example.demo.models.ClientOrder;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/invalidOrders")
public class deleteInvalidOrders {
    private ClientOrderDao clientOrderDao;

    @DeleteMapping("/delete")
    public void delete(){
        Date realTime = new Date();
        List<ClientOrder> list = clientOrderDao.findAll();
        for(ClientOrder el:list){
            if(realTime.after(el.getDueDateTime())){
                clientOrderDao.delete(el);
            }
        }
    }
}
