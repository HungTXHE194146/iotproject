package com.iot.iotprojectnew.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping({"/", ""})
public class UIController {

    @GetMapping
    public String index() {
        return "index";
    }

}
