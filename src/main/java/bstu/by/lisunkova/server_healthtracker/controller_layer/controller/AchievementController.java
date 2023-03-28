package bstu.by.lisunkova.server_healthtracker.controller_layer.controller;


import bstu.by.lisunkova.server_healthtracker.controller_layer.mapping.AchievementMapping;
import bstu.by.lisunkova.server_healthtracker.model.dto.AchievementDto;
import bstu.by.lisunkova.server_healthtracker.model.entity.Achievement;
import bstu.by.lisunkova.server_healthtracker.model.repository.AchievementRepository;
import bstu.by.lisunkova.server_healthtracker.model.service.AchievementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("achieve")
public class AchievementController extends CommonController<Achievement, AchievementRepository, AchievementDto
        , AchievementService, AchievementMapping>{
    @Autowired
    public AchievementController(AchievementMapping mapper, AchievementService service) {
        super(mapper, service);
    }
}
