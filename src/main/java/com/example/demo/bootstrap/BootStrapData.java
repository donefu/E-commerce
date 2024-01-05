package com.example.demo.bootstrap;

import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.OutsourcedPartRepository;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.service.OutsourcedPartService;
import com.example.demo.service.OutsourcedPartServiceImpl;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 *
 *
 *
 *
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final PartRepository partRepository;
    private final ProductRepository productRepository;

    private final OutsourcedPartRepository outsourcedPartRepository;

    public BootStrapData(PartRepository partRepository, ProductRepository productRepository, OutsourcedPartRepository outsourcedPartRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
        this.outsourcedPartRepository=outsourcedPartRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        partRepository.deleteAll();
        productRepository.deleteAll();
        outsourcedPartRepository.deleteAll();
       /*
        OutsourcedPart o= new OutsourcedPart();
        o.setCompanyName("Western Governors University");
        o.setName("out test");
        o.setInv(5);
        o.setPrice(20.0);
        o.setId(100L);
        outsourcedPartRepository.save(o);
        OutsourcedPart thePart=null;
        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            if(part.getName().equals("out test"))thePart=part;
        }

        System.out.println(thePart.getCompanyName());
        */
        List<OutsourcedPart> outsourcedParts = (List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for (OutsourcedPart part : outsourcedParts) {
            System.out.println(part.getName() + "" + part.getCompanyName());
        }
        if (partRepository.count() == 0 && productRepository.count() == 0) {
            // PARTS
            OutsourcedPart o = new OutsourcedPart();
            o.setCompanyName("MSI");
            o.setName("MSI MPG B550 GAMING PLUS");
            o.setInv(5);
            o.setPrice(149.0);
            o.setId(100L);
            outsourcedPartRepository.save(o);
            o.setCompanyName("NVIDIA");
            o.setName("Founders Edition NVIDIA GeForce RTX 4090 24GB GDDR6X Graphics Card");
            o.setInv(15);
            o.setPrice(2299.99);
            o.setId(101L);
            outsourcedPartRepository.save(o);
            o.setCompanyName("Corsair");
            o.setName("Corsair Vengeance RGB Pro 32GB (2x16GB) 2666");
            o.setInv(7);
            o.setPrice(72.99);
            o.setId(102L);
            outsourcedPartRepository.save(o);
            o.setCompanyName("Thermaltake");
            o.setName("Thermaltake Smart 700W ATX 80 Plus Power Supply");
            o.setInv(12);
            o.setPrice(54.99);
            o.setId(103L);
            outsourcedPartRepository.save(o);
            o.setCompanyName("Asus");
            o.setName("Asus ROG Ryujin II 240 ARGB Cooling Fan/Pump");
            o.setInv(6);
            o.setPrice(299.69);
            o.setId(104L);
            outsourcedPartRepository.save(o);

            // PRODUCTS
            Product RDY_Y60 = new Product("RDY Y60 002", 1899, 5);
            Product RDY_Y61 = new Product("Gaming RDY SLMBG221", 1299, 15);
            Product RDY_Y62 = new Product("RDY Trace 7MP 001", 1599, 7);
            Product RDY_Y63 = new Product("RDY Y40P 001", 1099, 10);
            Product RDY_Y64 = new Product("Creator RDY Y40BG201", 3000, 3);

            productRepository.save(RDY_Y60);
            productRepository.save(RDY_Y61);
            productRepository.save(RDY_Y62);
            productRepository.save(RDY_Y63);
            productRepository.save(RDY_Y64);

        }

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Products" + productRepository.count());
        System.out.println(productRepository.findAll());
        System.out.println("Number of Parts" + partRepository.count());
        System.out.println(partRepository.findAll());

    }
}
