package com.tts.WeatherApp.controller;

import com.tts.WeatherApp.model.Request;
import com.tts.WeatherApp.model.Response;
import com.tts.WeatherApp.model.ZipCode;
import com.tts.WeatherApp.repo.ZipCodeRepository;

import com.tts.WeatherApp.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class WeatherController {
    @Autowired
    private WeatherService weatherService;

    @GetMapping
    public String getIndex(Model model) {
        model.addAttribute("request", new Request());
        model.addAttribute("recentSearches", weatherService.getRecentSearches());
        return "index";
    }

    @PostMapping
    public String postIndex(Request request, Model model) {
        Response data = weatherService.getForecast(request.getZipCode());
        model.addAttribute("data", data);
        return "index";
    }
}
