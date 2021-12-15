package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class DictionaryController {
    @GetMapping("")
    public String showList(){
        return "index";
    }

    @PostMapping ("/dictionary")
    public String result(@RequestParam String search, Model model){
        Map<String,String> dictionary = new HashMap<>();
        dictionary.put("hello", "Xin chào");
        dictionary.put("how", "Thế nào");
        dictionary.put("book", "Quyển vở");
        dictionary.put("computer", "Máy tính");


        String result = dictionary.get(search);
        if (result != null) {
            model.addAttribute("result",result);
           return "index";
        } else {
            return "error";
        }
    }
}
