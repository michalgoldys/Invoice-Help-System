package pl.michalgoldys.InvoiceHelpSystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/app/")
public class MainController {

    @Autowired
    AccountingOrderService accountingOrderService;

    @Autowired
    CompanySaveInterface companySaveInterface;
    @Autowired
    Company company;

    @GetMapping("/index")
    private String mainPage(Model model){

        model.addAttribute("AccountingOrderList", accountingOrderService.findAll());

        return "index.html";
    }

    @GetMapping("/orderDetails/{id}")
    private String orderDetails(@PathVariable long id,
                                Model model){

        model.addAttribute("AccountingOrderObject", accountingOrderService.findById(id));

        return "orderDetails.html";
    }

    @GetMapping("/companySettings")
    private String companySettings(Model model){

        model.addAttribute("company", Company.getInstance());

        return "companySettings.html";
    }

    @PostMapping("/companySettings")
    private String companySettingsPost(Company company){

        Company.getInstance().setCompanyCity(company.getCompanyCity());
        Company.getInstance().setCompanyName(company.getCompanyName());
        Company.getInstance().setCompanyPostalCode(company.getCompanyPostalCode());
        Company.getInstance().setCompanyStreet(company.getCompanyStreet());
        Company.getInstance().setCompanyTaxNumber(company.getCompanyTaxNumber());

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
