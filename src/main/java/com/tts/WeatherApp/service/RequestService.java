package com.tts.WeatherApp.service;

import com.tts.WeatherApp.model.Request;
import com.tts.WeatherApp.model.RequestDisplay;

import java.util.List;

public interface RequestService {
    List<RequestDisplay> findAll();
    Request findById(long id);
    List<RequestDisplay> formatRequests(List<Request> requests);
    List<RequestDisplay> formatTimestamps(List<Request> requests);
    void save(Request request);
}
