package com.rodrigorenck.store.test;

import com.rodrigorenck.store.dao.CategoryDao;
import com.rodrigorenck.store.dao.ProductDao;
import com.rodrigorenck.store.entity.Category;
import com.rodrigorenck.store.entity.Product;
import com.rodrigorenck.store.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class PersistingData {

    public static void main(String[] args) {

        Category category = new Category("HOME");

        Product product = new Product("Pillow Case", "Comfortable", new BigDecimal("30"), category);
        EntityManager entityManager = JPAUtil.createEntityManager();

        ProductDao productDao = new ProductDao(entityManager);
        CategoryDao categoryDao = new CategoryDao(entityManager);

        entityManager.getTransaction().begin();

        categoryDao.register(category);
        productDao.register(product);
        entityManager.getTransaction().commit();
        entityManager.close();




    }
}
