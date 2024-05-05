package com.ecommerce.productservice.controller;

import com.ecommerce.productservice.dto.GetProductDto;
import com.ecommerce.productservice.exceptions.NotFoundExceptions;
import com.ecommerce.productservice.models.Product;
import com.ecommerce.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Register this is a rest controller
@RestController
//if any request on product is requested, this controller should be invoked, so use requestmapping
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;
    //Creating constructor so that we don't have to create object for productService

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{id}")
    // Response body GetDTO
    public @ResponseBody GetProductDto getProductById(@PathVariable("id") Long id) throws Exception {
        return productService.getProductById(id);
    }

    @GetMapping("")
    public @ResponseBody List<GetProductDto> getAllProducts(){
        return productService.getAllProducts();
    }

    @PostMapping("")
    public String createProduct(@RequestBody Product product){
        System.out.println(product.getCategory());
        System.out.println(product.getTitle());
        System.out.println(product.getPrice());
        return "Product Created";
    }
}
