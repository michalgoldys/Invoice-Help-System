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

    @Autowired
    AccountingOrderSaveService accountingOrderSaveService;

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
        model.addAttribute("currentUser", principalDetailsUsernameService.getCurrentUsername());

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
        model.addAttribute("currentUser", principalDetailsUsernameService.getCurrentUsername());

        return "companySettings.html";
    }

    @PostMapping("/companySettings")
    private String companySettingsPost(Company company){

        companyService.companySaveService(company);

        return "redirect:/app/index";
    }
    @GetMapping("/neworder")
    private String newOrderForm(Order order, Contractor contractor, ContractorContactDetails contractorContactDetails, OrderDetails orderDetails, Model model){

        model.addAttribute("currentUser", principalDetailsUsernameService.getCurrentUsername());

        return "neworder.html";
    }

    @PostMapping("/neworder")
    private String newOrderCreation(Order order, Contractor contractor, ContractorContactDetails contractorContactDetails, OrderDetails orderDetails){

        order.setOrderDetails(orderDetails);
        orderDetails.setOrder(order);

        log.info("Object from spring auto data binding: " + order.toString() + contractor.toString() + contractorContactDetails.toString() + orderDetails.toString());

        AccountingOrder accountingOrder = new AccountingOrder(order, contractor, contractorContactDetails);
        log.info("Accounting Order new Object: " + accountingOrder.toString());
        accountingOrderSaveService.save(accountingOrder);

        return "redirect:/app/index";
    }
}
