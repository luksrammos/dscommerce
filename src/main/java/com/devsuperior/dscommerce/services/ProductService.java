package com.devsuperior.dscommerce.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dscommerce.dto.ProductDTO;
import com.devsuperior.dscommerce.entities.Product;
import com.devsuperior.dscommerce.repositories.ProductRepositoriy;

@Service
public class ProductService {
   
  @Autowired
  private ProductRepositoriy repositoriy;  

  @Transactional(readOnly = true)
  public ProductDTO findById(Long id){
    Product product = repositoriy.findById(id).get();
    return new ProductDTO(product);     
  }

  @Transactional(readOnly = true)
  public Page<ProductDTO> findAll(Pageable pageable){
    Page<Product> result = repositoriy.findAll(pageable);
    return result.map(x -> new ProductDTO(x));
  }
}