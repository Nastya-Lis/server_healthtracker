package bstu.by.lisunkova.server_healthtracker.controller_layer.controller;


import bstu.by.lisunkova.server_healthtracker.controller_layer.mapping.StepMapping;
import bstu.by.lisunkova.server_healthtracker.controller_layer.mapping.TermMapping;
import bstu.by.lisunkova.server_healthtracker.controller_layer.mapping.UserMapping;
import bstu.by.lisunkova.server_healthtracker.model.dto.StepDto;
import bstu.by.lisunkova.server_healthtracker.model.dto.TermDto;
import bstu.by.lisunkova.server_healthtracker.model.repository.StepRepository;
import bstu.by.lisunkova.server_healthtracker.model.repository.TermRepository;
import bstu.by.lisunkova.server_healthtracker.model.service.StepService;
import bstu.by.lisunkova.server_healthtracker.model.service.TermService;
import bstu.by.lisunkova.server_healthtracker.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("term")
public class TermController {
    @Autowired
    StepMapping stepMapping;
    @Autowired
    StepService stepService;
    @Autowired
    TermRepository termRepository;
    @Autowired
    TermService termService;
    @Autowired
    TermMapping termMapping;

    @GetMapping("/all")
    public List<TermDto> getAll(){
        return termMapping.entitiesToDtoes(termService.viewAll());
    }
}
