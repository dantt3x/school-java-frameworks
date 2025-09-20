package com.example.demo.controllers;

import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.service.PartService;
import com.example.demo.service.PartServiceImpl;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 *
 *
 */
@Controller
public class BuyProductNow {
    @Autowired
    private ApplicationContext context;

    @GetMapping("/buyProductNow")
    public String buyNow(@RequestParam("productID") int itemID, Model model) {
        ProductService productService = context.getBean(ProductServiceImpl.class);
        Product product = productService.findById(itemID);
        String purchaseResult = "purchaseFailed";

        if (product == null) { return purchaseResult; }

        if (product.getInv() > 0) {
            product.setInv(product.getInv() - 1);
            productService.save(product);
            purchaseResult = "purchaseSuccess";
        }

        return purchaseResult;
    }

    @GetMapping("/buyPartNow")
    public String buyPartNow(@RequestParam("productID") int itemID, Model model) {
        PartService partService = context.getBean(PartServiceImpl.class);
        Part part = partService.findById(itemID);
        String purchaseResult = "purchaseFailed";

        if (part == null) { return purchaseResult; }

        try {
            if (part.getInv() > 0) {
                part.setInv(part.getInv() - 1);
                partService.save(part);
                purchaseResult = "purchaseSuccess";
            }
        }
        catch (Exception e) {}
        return purchaseResult;
    }

    @GetMapping("/purchaseFailed")
    public String purchaseFailed(Model model) {
        return "purchaseFailed";
    }

    @GetMapping("/purchaseSuccess")
    public String purchaseSuccess(Model model) {
        System.out.println("purchaseSuccess");
        return "purchaseSuccess";
    }
}
