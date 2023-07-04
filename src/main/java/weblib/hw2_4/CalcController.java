package weblib.hw2_4;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/calculator")
public class CalcController {
    private final CalcServiceImpl calcService;

    public CalcController(CalcServiceImpl calcService) {
        this.calcService = calcService;
    }
    @GetMapping()
    public String welcomeCalc() {
        return "Добро пожаловать в Калькулятор";
    }

}
