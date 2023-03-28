package bstu.by.lisunkova.server_healthtracker.model.service;


import bstu.by.lisunkova.server_healthtracker.model.entity.Achievement;
import bstu.by.lisunkova.server_healthtracker.model.entity.Term;
import bstu.by.lisunkova.server_healthtracker.model.repository.AchievementRepository;
import bstu.by.lisunkova.server_healthtracker.model.repository.TermRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TermService extends CommonService<Term, TermRepository>{

    @Autowired
    TermService(TermRepository repository){super(repository);}

}
