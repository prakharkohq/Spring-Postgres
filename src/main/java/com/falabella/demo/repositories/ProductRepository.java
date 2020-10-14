package com.falabella.demo.repositories;

import com.falabella.demo.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product,Long> {
}
