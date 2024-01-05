package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import com.example.demo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.example.demo.domain.Product;
import java.util.Optional;


@Controller
public class BuyNowProductController {

    private final ProductRepository productRepository;
    @Autowired
    public BuyNowProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    @PostMapping("/buyProduct")
    public String buyProduct(@RequestParam Long productID) {
        Optional<Product> optionalProduct = productRepository.findById(productID);

        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();

            if (product.getInv() > 0) {
                // Decrease inventory by 1
                product.setInv(product.getInv() - 1);
                productRepository.save(product);

                // Redirect to success page
                return "redirect:/purchaseSuccess";
            } else {
                // Redirect to error page (out of stock)
                return "redirect:/purchaseError";
            }
        } else {
            // Redirect to error page (product not found)
            return "redirect:/purchaseError";
        }
    }

    @GetMapping("/purchaseSuccess")
    public String displayPurchaseSuccess() {
        return "purchaseSuccess"; // Create purchaseSuccess.html
    }

    @GetMapping("/purchaseError")
    public String displayPurchaseError() {
        return "purchaseError"; // Create purchaseError.html
    }
}
