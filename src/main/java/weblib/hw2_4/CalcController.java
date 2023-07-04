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

    @GetMapping(path = "/multiply")
    public String multiply(@RequestParam int num1, @RequestParam int num2) {
        return String.format("%s * %s = %s", num1, num2, calcService.multiply(num1, num2));
    }

    @GetMapping(path = "/divide")
    public String divide(@RequestParam int num1, @RequestParam int num2){
        if (num2 == 0) {
            return "На 0 делить нельзя";
        }
        return String.format("%s / %s = %s", num1, num2, calcService.divide(num1, num2));
    }
}
