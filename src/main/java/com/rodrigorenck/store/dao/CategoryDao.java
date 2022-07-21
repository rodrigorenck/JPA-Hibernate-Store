package com.rodrigorenck.store.dao;

import com.rodrigorenck.store.entity.Category;
import com.rodrigorenck.store.entity.Product;

import javax.persistence.EntityManager;
import java.util.List;

public class CategoryDao {

    private EntityManager entityManager;

    public CategoryDao(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public void register(Category category){
        entityManager.persist(category);
    }
    public void remove(Category category){
        entityManager.remove(category);
    }

    public Category findById(Long id){
        return entityManager.find(Category.class, id);
    }

    public Category findByName(String name){
        String jpql = "SELECT c FROM Category c WHERE c.name = :name";
        return entityManager.createQuery(jpql, Category.class).setParameter("name", name).getSingleResult();
    }

    public List<Category> findAll(){
        String jpql = "SELECT c FROM Category c";
        return entityManager.createQuery(jpql, Category.class).getResultList();
    }
}
