package com.falabella.demo.service;

import com.falabella.demo.command.ProductForm;
import com.falabella.demo.model.Product;

import java.util.List;

public interface ProductService {

     List<Product> listAll();
     Product getById(Long id);
     Product saveOrUpdate(Product product);
     void delete(Long id);
     Product saveOrUpdateProductForm(ProductForm productForm);


}
