package com.falabella.demo.service;

import com.falabella.demo.command.ProductForm;
import com.falabella.demo.converter.ProductFormToProduct;
import com.falabella.demo.model.Product;
import com.falabella.demo.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductService{

    private ProductRepository productRepository;
    private ProductFormToProduct productFormToProduct;

    @Autowired
    public ProductServiceImpl(ProductFormToProduct productFormToProduct, ProductRepository productRepository)
    {
        this.productFormToProduct = productFormToProduct;
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> listAll() {
        List<Product> products = new ArrayList<>();
        productRepository.findAll().forEach(products::add);
        return products;
    }

    @Override
    public Product getById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product saveOrUpdate(Product product) {
        productRepository.save(product);
        return product;
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product saveOrUpdateProductForm(ProductForm productForm) {
        Product savedProduct = saveOrUpdate(productFormToProduct.convert(productForm));

        System.out.println("Saved Product Id: " + savedProduct.getId());
        return savedProduct;
    }
}
