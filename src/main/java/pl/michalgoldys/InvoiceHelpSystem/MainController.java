package pl.michalgoldys.InvoiceHelpSystem;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/app/")
public class MainController {

    @Autowired
    AccountingOrderService accountingOrderService;

    @Autowired
    ClosingOrderServiceImpl closingOrderServiceImpl;

    @Autowired
    PrincipalDetailsUsernameService principalDetailsUsernameService;
    @Autowired
    CompanyService companyService;

    @GetMapping("/index")
    private String mainPage(Model model){

        model.addAttribute("AccountingOrderList", accountingOrderService.findAll());
        model.addAttribute("currentUser", principalDetailsUsernameService.getCurrentUsername());

        return "index.html";
    }

    @GetMapping("/orderDetails/{id}")
    private String orderDetails(@PathVariable long id,
                                Model model){

        model.addAttribute("AccountingOrderObject", accountingOrderService.findById(id));

        return "orderDetails.html";
    }

    @PostMapping("/orderDetails/{id}")
    private String orderDetailsClosing(@PathVariable long id){

        closingOrderServiceImpl.close(id);

        return "redirect:/app/index.html";
    }

    @GetMapping("/companySettings")
    private String companySettings(Model model){

        model.addAttribute("company", companyService.companyGetterService());

        return "companySettings.html";
    }

    @PostMapping("/companySettings")
    private String companySettingsPost(Company company){

        companyService.companySaveService(company);

        return "redirect:/app/index";
    }
    @GetMapping("/addNewOrder")
    private String newOrderForm(){
        return "newOrder.html";
    }

    @PostMapping("addNewOrder")
    private String newOrderCreation(AccountingOrder accountingOrder){

        return "redirect:/index.html";
    }
}
