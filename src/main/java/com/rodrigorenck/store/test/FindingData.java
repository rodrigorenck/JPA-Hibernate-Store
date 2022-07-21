package com.rodrigorenck.store.test;

import com.rodrigorenck.store.dao.CategoryDao;
import com.rodrigorenck.store.dao.ProductDao;
import com.rodrigorenck.store.entity.Category;
import com.rodrigorenck.store.entity.Product;
import com.rodrigorenck.store.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class FindingData {

    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.createEntityManager();
        ProductDao productDao = new ProductDao(entityManager);
        CategoryDao categoryDao = new CategoryDao(entityManager);

        entityManager.getTransaction().begin();

        Category category = categoryDao.findById(1L);
        System.out.println(category.getName());

        Category category2 = categoryDao.findByName("SMARTPHONES");
        System.out.println(category.getId());

        List<Product> products = productDao.findByCategoryName("SMARTPHONES");
        products.forEach(p -> System.out.println(p.getName()));

        BigDecimal price = productDao.findPriceByProductName("Iphone 11");
        System.out.println(price);

        List<Product> allProducts = productDao.findAll();
        allProducts.forEach(p -> System.out.println(p.getName()));

        List<Category> allCategory = categoryDao.findAll();
        allCategory.forEach(c -> System.out.println(c.getName()));

        entityManager.close();
    }
}
