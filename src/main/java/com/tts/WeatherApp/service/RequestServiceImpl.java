package com.tts.WeatherApp.service;

import com.tts.WeatherApp.model.Request;
import com.tts.WeatherApp.model.RequestDisplay;
import com.tts.WeatherApp.repo.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.ocpsoft.prettytime.PrettyTime;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class RequestServiceImpl implements RequestService{
    @Autowired
    private RequestRepository requestRepository;

   public RequestServiceImpl(RequestRepository requestRepository){
       this.requestRepository = requestRepository;
   }

   @Override
    public List<RequestDisplay> findAll() {
       List<Request> requests = requestRepository.findAllByOrderByCreatedAtDesc();
       return formatRequests(requests);
   }

   @Override
   public Request findById(long id){
       return requestRepository.findById(id);
   }

    @Override
    public List<RequestDisplay> formatRequests(List<Request> requests) {
        List<RequestDisplay> displayRequests = formatTimestamps(requests);
        return displayRequests;
    }

    @Override
    public List<RequestDisplay> formatTimestamps(List<Request> requests) {
       List<RequestDisplay> response = new ArrayList<>();
       PrettyTime prettyTime = new PrettyTime();
       SimpleDateFormat simpleDate = new SimpleDateFormat("M/d/yy");
       Date now = new Date();

       for (Request request : requests) {
           RequestDisplay requestDisplay = new RequestDisplay();
           requestDisplay.setZipCode(request.getZipCode());
           long diffinMillies = Math.abs(now.getTime() - request.getCreatedAt().getTime());
           long diff = TimeUnit.DAYS.convert(diffinMillies, TimeUnit.MILLISECONDS);
           if(diff > 3){
               requestDisplay.setDate(simpleDate.format(request.getCreatedAt()));
           } else {
               requestDisplay.setDate(prettyTime.format(request.getCreatedAt()));
           }
           response.add(requestDisplay);
       }
       return response;
    }

    @Override
    public void save(Request request) {
        requestRepository.save(request);
    }
}
