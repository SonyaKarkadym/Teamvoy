package com.example.demo.controllers;

import com.example.demo.dao.ClientOrderDao;
import com.example.demo.models.ClientOrder;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@RequestMapping("/items")
public class LowestPriceItemController {

    private ClientOrderDao clientOrderDao;

    @GetMapping("/find")
    public void findItem(@RequestParam String item){
        List<ClientOrder> list = clientOrderDao.findAll();
        List<ClientOrder> list2 = list.stream()
                .filter(el -> el.getItem().equals(item))
                .filter(el -> el.getQuantity() > 0)
                .min(Comparator.comparing(ClientOrder::getPrice))
                .stream().collect(Collectors.toList());
        System.out.println(list2);
    }

}
