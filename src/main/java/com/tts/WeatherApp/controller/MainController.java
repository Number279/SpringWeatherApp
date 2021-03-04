package com.tts.WeatherApp.controller;

import com.tts.WeatherApp.model.Request;
import com.tts.WeatherApp.model.RequestDisplay;
import com.tts.WeatherApp.service.RequestService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Data
@Controller
@ControllerAdvice
public class MainController {
    @Autowired
    RequestService requestService;

//    @ModelAttribute("requests")
//    public List<RequestDisplay> requests() {
//
//        return requestService.findAll(); }
    @GetMapping(value = {"/history"})
    public String getRequests(Model model){
        List<RequestDisplay> requests = new ArrayList<>();
        requests = requestService.findAll();
        model.addAttribute("requestList", requests);
        return "history";
    }
}
