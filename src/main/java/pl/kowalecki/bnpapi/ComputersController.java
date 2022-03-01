package pl.kowalecki.bnpapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.kowalecki.bnpapi.model.ComputersModel;

import java.text.ParseException;
import java.util.List;

@Controller
public class ComputersController {

    @Autowired
    private ComputersService computersService;


    public ComputersController(ComputersService computersService) {
        this.computersService = computersService;
    }

    @GetMapping(value = "/computerList")
    public String showComputers(Model model) {
        List<ComputersModel> computersModel = computersService.getAllComputers();
        model.addAttribute("computersModels", computersModel);
        return "computerList";
    }
}
