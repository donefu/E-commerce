package com.example.demo.controllers;

import com.example.demo.domain.InhousePart;
import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Part;
import com.example.demo.service.*;
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
public class AddOutsourcedPartController {
    @Autowired
    private ApplicationContext context;

    @GetMapping("/showFormAddOutPart")
    public String showFormAddOutsourcedPart(Model theModel){
        Part part=new OutsourcedPart();
        theModel.addAttribute("outsourcedpart",part);
        return "OutsourcedPartForm";
    }

    @PostMapping("/showFormAddOutPart")
    public String submitForm(@Valid @ModelAttribute("outsourcedpart") OutsourcedPart part, BindingResult bindingResult, Model theModel) {
        theModel.addAttribute("outsourcedpart", part);

        if (bindingResult.hasErrors()) {
            return "OutsourcedPartForm";
        }
        else {
            if (!part.isInvvalid()) {
                bindingResult.rejectValue("inv", "Wrong Inv", "Inventory must in range of min and max");
                if (part.getInv() < part.getMinValue()) {
                    bindingResult.rejectValue("inv", "SmallerThanMinInv", "Inventory needs to be bigger than minimum");
                } else if (part.getInv() > part.getMaxValue()) {
                    bindingResult.rejectValue("inv", "BiggerThanMaxInv", "Inventory needs to be smaller than maximum");
                }
                return "OutsourcedPartForm";
            }
            OutsourcedPartService outSourcedRepo = context.getBean(OutsourcedPartServiceImpl.class);
            OutsourcedPart outPart = outSourcedRepo.findById((int) part.getId());
            if (outPart != null) {
                part.setProducts(outPart.getProducts());
            }
            outSourcedRepo.save(part);
            return "confirmationaddpart";
        }
    }


}
