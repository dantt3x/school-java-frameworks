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

import java.util.ArrayList;
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
        List<OutsourcedPart> outsourcedParts = (List<OutsourcedPart>) outsourcedPartRepository.findAll();
        List<Product> products = (List<Product>) productRepository.findAll();

        if (outsourcedParts.isEmpty()){
            OutsourcedPart GPU = new OutsourcedPart();
            GPU.setName("NVIDIA GPU RTX");
            GPU.setMinInv(0);
            GPU.setMaxInv(10);
            GPU.setInv(3);
            GPU.setPrice(599.99);
            GPU.setCompanyName("NVIDIA");
            GPU.setId(100L);

            OutsourcedPart CPU = new OutsourcedPart();
            CPU.setName("Intel Core I7");
            CPU.setMinInv(0);
            CPU.setMaxInv(10);
            CPU.setInv(8);
            CPU.setPrice(175.99);
            CPU.setCompanyName("Intel");
            CPU.setId(101L);

            OutsourcedPart PowerSupply = new OutsourcedPart();
            PowerSupply.setName("EVGA 750W Power Supply");
            PowerSupply.setMinInv(0);
            PowerSupply.setMaxInv(10);
            PowerSupply.setInv(6);
            PowerSupply.setPrice(350.00);
            PowerSupply.setCompanyName("EVGA");
            PowerSupply.setId(102L);

            OutsourcedPart Motherboard = new OutsourcedPart();
            Motherboard.setName("ASUS Prime Motherboard");
            Motherboard.setMinInv(0);
            Motherboard.setMaxInv(10);
            Motherboard.setInv(5);
            Motherboard.setPrice(150);
            Motherboard.setCompanyName("ASUS");
            Motherboard.setId(103L);

            OutsourcedPart RAM = new OutsourcedPart();
            RAM.setName("Corsair DDR5 Ram");
            RAM.setMinInv(0);
            RAM.setMaxInv(10);
            RAM.setInv(5);
            RAM.setPrice(135);
            RAM.setCompanyName("Corsair");
            RAM.setId(104L);

            outsourcedPartRepository.save(GPU);
            outsourcedPartRepository.save(CPU);
            outsourcedPartRepository.save(PowerSupply);
            outsourcedPartRepository.save(Motherboard);
            outsourcedPartRepository.save(RAM);
        }

        if (products.isEmpty()){
            Product Prebuilt_1 = new Product("Gaming PC", 1399.99,10);
            Product Prebuilt_2 = new Product("Affordable Gaming PC", 899.99,10);
            Product Prebuilt_3 = new Product("Video Editing PC", 1299.99,10);
            Product Prebuilt_4 = new Product("All-Rounder PC", 1499.99,10);
            Product Prebuilt_5 = new Product("Gaming Laptop", 1199.99,10);

            productRepository.save(Prebuilt_1);
            productRepository.save(Prebuilt_2);
            productRepository.save(Prebuilt_3);
            productRepository.save(Prebuilt_4);
            productRepository.save(Prebuilt_5);
        }

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
        for(OutsourcedPart part:outsourcedParts){
            System.out.println(part.getName()+" "+part.getCompanyName());
        }

        /*
        Product bicycle= new Product("bicycle",100.0,15);
        Product unicycle= new Product("unicycle",100.0,15);
        productRepository.save(bicycle);
        productRepository.save(unicycle);
        */

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Products"+productRepository.count());
        System.out.println(productRepository.findAll());
        System.out.println("Number of Parts"+partRepository.count());
        System.out.println(partRepository.findAll());

    }
}
