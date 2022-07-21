package com.rodrigorenck.store.test;

import com.rodrigorenck.store.dao.ProductDao;
import com.rodrigorenck.store.entity.Product;
import com.rodrigorenck.store.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class UpdateData {

    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.createEntityManager();

        entityManager.getTransaction().begin();

        ProductDao productDao = new ProductDao(entityManager);
        Product iphone11 = productDao.findByProductName("Iphone 11");
        System.out.println(iphone11.getPrice()); //prints 1200 which was the old price

        iphone11.setPrice(new BigDecimal("1000"));//update the price

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
