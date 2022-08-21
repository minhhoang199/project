package com.tm.j10.repository;

import com.tm.j10.domain.Product;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.hibernate.annotations.QueryHints;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

/**
 * Utility repository to load bag relationships based on https://vladmihalcea.com/hibernate-multiplebagfetchexception/
 */
public class ProductRepositoryWithBagRelationshipsImpl implements ProductRepositoryWithBagRelationships {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<Product> fetchBagRelationships(Optional<Product> product) {
        return product.map(this::fetchMedia).map(this::fetchTags);
    }

    @Override
    public Page<Product> fetchBagRelationships(Page<Product> products) {
        return new PageImpl<>(fetchBagRelationships(products.getContent()), products.getPageable(), products.getTotalElements());
    }

    @Override
    public List<Product> fetchBagRelationships(List<Product> products) {
        return Optional.of(products).map(this::fetchMedia).map(this::fetchTags).orElse(Collections.emptyList());
    }

    Product fetchMedia(Product result) {
        return entityManager
            .createQuery("select product from Product product left join fetch product.media where product is :product", Product.class)
            .setParameter("product", result)
            .setHint(QueryHints.PASS_DISTINCT_THROUGH, false)
            .getSingleResult();
    }

    List<Product> fetchMedia(List<Product> products) {
        HashMap<Object, Integer> order = new HashMap<>();
        IntStream.range(0, products.size()).forEach(index -> order.put(products.get(index).getId(), index));
        List<Product> result = entityManager
            .createQuery(
                "select distinct product from Product product left join fetch product.media where product in :products",
                Product.class
            )
            .setParameter("products", products)
            .setHint(QueryHints.PASS_DISTINCT_THROUGH, false)
            .getResultList();
        Collections.sort(result, (o1, o2) -> Integer.compare(order.get(o1.getId()), order.get(o2.getId())));
        return result;
    }

    Product fetchTags(Product result) {
        return entityManager
            .createQuery("select product from Product product left join fetch product.tags where product is :product", Product.class)
            .setParameter("product", result)
            .setHint(QueryHints.PASS_DISTINCT_THROUGH, false)
            .getSingleResult();
    }

    List<Product> fetchTags(List<Product> products) {
        HashMap<Object, Integer> order = new HashMap<>();
        IntStream.range(0, products.size()).forEach(index -> order.put(products.get(index).getId(), index));
        List<Product> result = entityManager
            .createQuery(
                "select distinct product from Product product left join fetch product.tags where product in :products",
                Product.class
            )
            .setParameter("products", products)
            .setHint(QueryHints.PASS_DISTINCT_THROUGH, false)
            .getResultList();
        Collections.sort(result, (o1, o2) -> Integer.compare(order.get(o1.getId()), order.get(o2.getId())));
        return result;
    }
}
