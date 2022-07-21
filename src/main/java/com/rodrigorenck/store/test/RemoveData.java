package com.rodrigorenck.store.test;

import com.rodrigorenck.store.dao.CategoryDao;
import com.rodrigorenck.store.dao.ProductDao;
import com.rodrigorenck.store.entity.Category;
import com.rodrigorenck.store.entity.Product;
import com.rodrigorenck.store.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class RemoveData {

    public static void main(String[] args) {

        EntityManager entityManager = JPAUtil.createEntityManager();

        ProductDao productDao = new ProductDao(entityManager);
        CategoryDao categoryDao = new CategoryDao(entityManager);

        entityManager.getTransaction().begin();

        Product pillow_case = productDao.findByProductName("Pillow Case");
        Category home = categoryDao.findByName("HOME");

        categoryDao.remove(home);
        productDao.remove(pillow_case);

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
