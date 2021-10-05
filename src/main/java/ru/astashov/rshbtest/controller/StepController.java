package ru.astashov.rshbtest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.astashov.rshbtest.service.StepBeginService;
import ru.astashov.rshbtest.util.Step;

import java.util.List;

@RestController
@RequestMapping("v1")
public class StepController {

    private final StepBeginService stepBeginService;

    public StepController(StepBeginService stepBeginService) {
        this.stepBeginService = stepBeginService;
    }

    @GetMapping(path = "credit-app/{appNum}/steps")
    public List<Step> findStepsByCreditApp(@PathVariable("appNum") Long appNum) {
        return stepBeginService.findStepsByCreditApp(appNum);
    }

}
