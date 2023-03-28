package bstu.by.lisunkova.server_healthtracker.model.service;


import bstu.by.lisunkova.server_healthtracker.model.entity.Step;
import bstu.by.lisunkova.server_healthtracker.model.repository.StepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StepService {

    protected final StepRepository repository;

    public StepService(StepRepository repository) {
        this.repository = repository;
    }

    public List<Step> viewAll(){
        return repository.findAll();
    }

    public List<Step> getStepsByUserIdAndDate(String user_id, String date){
        return repository.findStepsByUserIdAndAndDateId(user_id, date);
    }

    public List<Step> getStepsForComparisonBetweenTwoUsersInDate(String user1, String user2, String date){
        return repository.findStepsWithTwoUsersByDate(user1, user2, date);
    }
}
