package com.ecommerce.productservice.service;

import com.ecommerce.productservice.dto.GetProductDto;
import com.ecommerce.productservice.exceptions.NotFoundExceptions;
import com.ecommerce.productservice.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service

public class ProductService {
    public GetProductDto getProductById(Long id) throws NotFoundExceptions {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://fakestoreapi.com/products/" + id;
        Product product = restTemplate.getForObject(url, Product.class);
        System.out.println(product);
        if(product == null){
            throw new NotFoundExceptions();
        }

        return convertToDto(product);
    }

    private static GetProductDto convertToDto(Product product) {
        GetProductDto obj = new GetProductDto();
        obj.setPrice(product.getPrice());
        obj.setName(product.getTitle());
        obj.setDescription(product.getDescription());
        return obj;
    }

    public List<GetProductDto> getAllProducts() {
        RestTemplate restTemplate = new RestTemplate();

        String url = "http://fakestoreapi.com/products";
        Product[] products = restTemplate.getForObject(url, Product[].class);

        List<GetProductDto> returnedProducts = new ArrayList<>();
        for(Product product : products) {
            returnedProducts.add(convertToDto(product));
        }
        return returnedProducts;
    }
}
