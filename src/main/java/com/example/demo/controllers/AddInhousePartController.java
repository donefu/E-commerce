package com.example.demo.controllers;

import com.example.demo.domain.InhousePart;
import com.example.demo.domain.Part;
import com.example.demo.service.InhousePartService;
import com.example.demo.service.InhousePartServiceImpl;
import com.example.demo.service.PartService;
import com.example.demo.service.PartServiceImpl;
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

/**
 *
 *
 *
 *
 */
@Controller
public class AddInhousePartController {
    @Autowired
    private ApplicationContext context;
    @GetMapping("/showFormAddInPart")
    public String showFormAddInhousePart(Model theModel) {
        theModel.addAttribute("inhousepart", new InhousePart());
        return "InhousePartForm";
    }

    @PostMapping("/showFormAddInPart")
    public String submitForm(
            @Valid @ModelAttribute("inhousepart") InhousePart part,
            BindingResult theBindingResult,
            Model theModel) {
        theModel.addAttribute("inhousepart", part);
        if (theBindingResult.hasErrors()) {
            return "InhousePartForm";
        }
        else {
            if (!part.isInvvalid()) {
                theBindingResult.rejectValue("inv", "Wrong Inv", "Inventory must in range of min and max");
                if (part.getInv() < part.getMinValue()) {
                    theBindingResult.rejectValue("inv", "SmallerThanMinInv", "Inventory needs to be bigger than minimum");
                } else if (part.getInv() > part.getMaxValue()) {
                    theBindingResult.rejectValue("inv", "BiggerThanMaxInv", "Inventory needs to be smaller than maximum");
                }
                return "InhousePartForm";
            }
            InhousePartService inhouseRepo = context.getBean(InhousePartServiceImpl.class);
            InhousePart inPart = inhouseRepo.findById((int) part.getId());
            if (inPart != null) {
                part.setProducts(inPart.getProducts());
            }
            inhouseRepo.save(part);
            return "confirmationaddpart";
        }
    }
}
