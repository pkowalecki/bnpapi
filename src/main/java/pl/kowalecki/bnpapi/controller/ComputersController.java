package pl.kowalecki.bnpapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.kowalecki.bnpapi.api.ApiController;
import pl.kowalecki.bnpapi.model.ComputersModel;
import pl.kowalecki.bnpapi.model.ComputersModels;
import pl.kowalecki.bnpapi.service.ComputersService;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

@Controller
public class ComputersController {

    @Autowired
    private ComputersService computersService;

    @Autowired
    private ApiController apiController;


    public ComputersController(ComputersService computersService, ApiController apiController) {
        this.computersService = computersService;
        this.apiController = apiController;
    }


    @GetMapping(value = "/")
    public String showComputers(Model model,
                                @Param("keyword") String keyword) {
        List<ComputersModel> computersModel = computersService.getComputerByName(keyword);
        model.addAttribute("computersModel", computersModel);
        model.addAttribute("keyword", keyword);
        return "computerList";
    }


    @GetMapping(value = "/addComputersForm")
    public String addComputer(Model model) {
        ComputersModel computersModel = new ComputersModel();
        model.addAttribute("computerModel", computersModel);
        return "addComputers";
    }

    @PostMapping(value = "/saveComputer")
    public String saveComputer(@ModelAttribute("computerModel") ComputersModel computersModel) {
        BigDecimal currency = apiController.getCurrency(computersModel.getDateAccounting());
        BigDecimal plnCurrency = computersModel.getPriceUSD().multiply(currency).setScale(2, RoundingMode.CEILING);
        computersService.addComputer(new ComputersModel(computersModel.getId(), computersModel.getName(), computersModel.getDateAccounting(), computersModel.getPriceUSD(), plnCurrency));
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") int id, Model model) {
        ComputersModel computersModel = computersService.getComputerById(id);
        BigDecimal currency = apiController.getCurrency(computersModel.getDateAccounting());
        BigDecimal plnCurrency = computersModel.getPriceUSD().multiply(currency).setScale(2, RoundingMode.CEILING);
        model.addAttribute("computerModel", new ComputersModel(computersModel.getId(), computersModel.getName(), computersModel.getDateAccounting(), computersModel.getPriceUSD(), plnCurrency));
        return "updateComputer";
    }

    @GetMapping("/deleteComputer/{id}")
    public String deleteComputer(@PathVariable(value = "id") int id) {
        this.computersService.deleteById(id);
        return "redirect:/";
    }

    @RequestMapping(value = "/returnXml", method = RequestMethod.GET, produces = {MediaType.APPLICATION_XML_VALUE}, headers = "Accept=application/xml")
    public ResponseEntity<ComputersModels> showXml() {

        ComputersModels computersModel = computersService.getAllComputersList();

        return ResponseEntity.ok(computersModel);
    }

}
