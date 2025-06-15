package com.example.Springtask.service;

import com.example.Springtask.dto.Product;
import com.example.Springtask.repositery.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository pdr;
    public List<Product> getAllProducts(){
        return pdr.findAll();
    }
    public Product save(Product product){
        return pdr.save(product);
    }
}
