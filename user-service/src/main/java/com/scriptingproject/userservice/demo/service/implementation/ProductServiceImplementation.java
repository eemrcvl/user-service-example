package com.scriptingproject.userservice.demo.service.implementation;

import com.scriptingproject.userservice.demo.domain.Product;
import com.scriptingproject.userservice.demo.domain.ProductRepository;
import com.scriptingproject.userservice.demo.service.ProductService;

import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImplementation implements ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImplementation(ProductRepository productRepository){
        this.productRepository=productRepository;
    }
    @Override
    public Product saveProduct(Product product) {
        return this.productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        Product updatedProduct=productRepository.save(product);
        return updatedProduct;
    }

    //@Override
    //public Product findProductByName(String name) {
      //  Product product=productRepository.f(id).get();
       // return product;
    //}

    @Override
    public void deleteProduct(Integer id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> getProducts() {
        Iterable<Product> products=productRepository.findAll();
        return Lists.newArrayList(products);
    }
}
