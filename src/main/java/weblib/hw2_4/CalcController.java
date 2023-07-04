package weblib.hw2_4;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

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

    @GetMapping(path = "/plus")
    public String plus(@RequestParam int num1, @RequestParam int num2) {
        return String.format("%s + %s = %s", num1, num2, calcService.plus(num1, num2));
    }

    @GetMapping(path = "/minus")
    public String minus(@RequestParam int num1, @RequestParam int num2) {
        return String.format("%s - %s = %s", num1, num2, calcService.minus(num1, num2));
    }

}
