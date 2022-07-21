package com.rodrigorenck.store.dao;

import com.rodrigorenck.store.entity.Product;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class ProductDao {

    private EntityManager entityManager;

    public ProductDao(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    public void register(Product product){
        entityManager.persist(product);
    }
    public void remove(Product product){
        product = entityManager.merge(product);
        entityManager.remove(product);
    }
    //JPA does the JOIN by itself
    public List<Product> findByCategoryName(String name){
        String jpql = "SELECT p FROM Product p WHERE p.category.name = :name";
        return entityManager.createQuery(jpql, Product.class).setParameter("name", name).getResultList();
    }

    public Product findByProductName(String name){
        String jpql = "SELECT p FROM Product p WHERE p.name = :name";
        return entityManager.createQuery(jpql, Product.class).setParameter("name", name).getSingleResult();
    }

    public Product findById(Long id){
        return entityManager.find(Product.class, id);
    }

    public BigDecimal findPriceByProductName(String name){
        String jpql = "SELECT p.price FROM Product p WHERE p.name = :name";
        return entityManager.createQuery(jpql, BigDecimal.class).setParameter("name", name).getSingleResult();
    }

    public List<Product> findAll(){
        String jpql = "SELECT p FROM Product p";
        return entityManager.createQuery(jpql, Product.class).getResultList();
    }

}
