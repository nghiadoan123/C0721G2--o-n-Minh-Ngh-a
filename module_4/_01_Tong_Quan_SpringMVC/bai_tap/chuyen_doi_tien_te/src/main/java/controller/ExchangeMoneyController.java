package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ExchangeMoneyController {

    @GetMapping({"","/converter"})
    public String showList(){
        return "index";
    }

    @PostMapping("/converter")
    public String exchange(@RequestParam(name = "usd") double usd, @RequestParam(name = "exchangeRate") double exchangeRate , Model model){
        double result = usd*exchangeRate;
        model.addAttribute("exchangeResult",result);
        return "result"; // chuyển về trang result
//        return "index"; //chuyển về trang index
    }
}

