package com.tts.WeatherApp.repo;

import com.tts.WeatherApp.model.Request;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequestRepository extends CrudRepository<Request, Long> {
    List<Request> findAll();
    Request findById(long id);
    List<Request> findAllByOrderByCreatedAtDesc();
}
