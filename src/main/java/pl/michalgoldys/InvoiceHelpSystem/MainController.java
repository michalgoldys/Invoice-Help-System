package pl.michalgoldys.InvoiceHelpSystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/app/")
public class MainController {

    @Autowired
    AccountingOrderService accountingOrderService;

    @GetMapping("/index")
    private String mainPage(Model model){

        model.addAttribute("AccountingOrderList", accountingOrderService.findAll());

        return "index.html";
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
