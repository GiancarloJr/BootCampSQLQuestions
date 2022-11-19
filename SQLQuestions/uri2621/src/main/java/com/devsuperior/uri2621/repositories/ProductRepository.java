package com.devsuperior.uri2621.repositories;

import com.devsuperior.uri2621.ProductMinDTO;
import com.devsuperior.uri2621.projections.ProductMinProjection;
import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.uri2621.entities.Product;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(nativeQuery = true,value = "SELECT products.name FROM products " +
            "INNER JOIN providers ON products.id_providers = providers.id " +
            "where products.amount BETWEEN  :min AND :max " +
            "AND providers.name like CONCAT(:beginName, '%')")
    List<ProductMinProjection> search1(Integer min, Integer max, String beginName);

    @Query("SELECT new com.devsuperior.uri2621.ProductMinDTO(obj.name) FROM Product obj " +
            "WHERE obj.amount BETWEEN  :min AND :max " +
            "AND obj.provider.name like CONCAT(:beginName, '%')")
    List<ProductMinDTO> search2(Integer min, Integer max, String beginName);

}
