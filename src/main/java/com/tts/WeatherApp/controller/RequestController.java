package com.tts.WeatherApp.controller;

import com.tts.WeatherApp.model.Request;
import com.tts.WeatherApp.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class RequestController {
    @Autowired
    RequestService requestService;

    @GetMapping("request/{id}")
    public String show(@PathVariable Long id, Model model){
        Request request = requestService.findById(id);
        model.addAttribute(request);
        return "request";
    }
}
