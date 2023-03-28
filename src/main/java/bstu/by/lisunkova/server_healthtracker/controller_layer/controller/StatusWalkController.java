package bstu.by.lisunkova.server_healthtracker.controller_layer.controller;


import bstu.by.lisunkova.server_healthtracker.controller_layer.mapping.StatusWalkMapping;
import bstu.by.lisunkova.server_healthtracker.model.dto.StatusWalkDto;
import bstu.by.lisunkova.server_healthtracker.model.entity.Achievement;
import bstu.by.lisunkova.server_healthtracker.model.entity.StatusWalk;
import bstu.by.lisunkova.server_healthtracker.model.repository.AchievementRepository;
import bstu.by.lisunkova.server_healthtracker.model.repository.StatusWalkRepository;
import bstu.by.lisunkova.server_healthtracker.model.service.AchievementService;
import bstu.by.lisunkova.server_healthtracker.model.service.StatusWalkService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("status")
public class StatusWalkController extends CommonController<StatusWalk, StatusWalkRepository, StatusWalkDto
        , StatusWalkService, StatusWalkMapping> {

    public StatusWalkController(StatusWalkMapping mapper, StatusWalkService service) {
        super(mapper, service);
    }
}
