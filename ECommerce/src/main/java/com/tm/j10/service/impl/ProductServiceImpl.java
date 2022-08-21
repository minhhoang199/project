package com.tm.j10.service.impl;

import com.tm.j10.domain.Product;
import com.tm.j10.repository.ProductRepository;
import com.tm.j10.service.ProductService;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link Product}.
 */
@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    private final Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product save(Product product) {
        log.debug("Request to save Product : {}", product);
        return productRepository.save(product);
    }

    @Override
    public Product update(Product product) {
        log.debug("Request to save Product : {}", product);
        return productRepository.save(product);
    }

    @Override
    public Optional<Product> partialUpdate(Product product) {
        log.debug("Request to partially update Product : {}", product);

        return productRepository
            .findById(product.getId())
            .map(existingProduct -> {
                if (product.getName() != null) {
                    existingProduct.setName(product.getName());
                }
                if (product.getProductCode() != null) {
                    existingProduct.setProductCode(product.getProductCode());
                }
                if (product.getProductSKU() != null) {
                    existingProduct.setProductSKU(product.getProductSKU());
                }
                if (product.getPrice() != null) {
                    existingProduct.setPrice(product.getPrice());
                }
                if (product.getFinalPrice() != null) {
                    existingProduct.setFinalPrice(product.getFinalPrice());
                }
                if (product.getReleaseDateUnix() != null) {
                    existingProduct.setReleaseDateUnix(product.getReleaseDateUnix());
                }
                if (product.getReleaseType() != null) {
                    existingProduct.setReleaseType(product.getReleaseType());
                }
                if (product.getDesigner() != null) {
                    existingProduct.setDesigner(product.getDesigner());
                }
                if (product.getDescription() != null) {
                    existingProduct.setDescription(product.getDescription());
                }
                if (product.getModelHeight() != null) {
                    existingProduct.setModelHeight(product.getModelHeight());
                }
                if (product.getModelWeight() != null) {
                    existingProduct.setModelWeight(product.getModelWeight());
                }
                if (product.getMaterial() != null) {
                    existingProduct.setMaterial(product.getMaterial());
                }
                if (product.getSlug() != null) {
                    existingProduct.setSlug(product.getSlug());
                }
                if (product.getIsValid() != null) {
                    existingProduct.setIsValid(product.getIsValid());
                }
                if (product.getIsEnable() != null) {
                    existingProduct.setIsEnable(product.getIsEnable());
                }
                if (product.getStatus() != null) {
                    existingProduct.setStatus(product.getStatus());
                }
                if (product.getCreatedBy() != null) {
                    existingProduct.setCreatedBy(product.getCreatedBy());
                }
                if (product.getCreatedDate() != null) {
                    existingProduct.setCreatedDate(product.getCreatedDate());
                }
                if (product.getModifiedBy() != null) {
                    existingProduct.setModifiedBy(product.getModifiedBy());
                }
                if (product.getModifiedDate() != null) {
                    existingProduct.setModifiedDate(product.getModifiedDate());
                }

                return existingProduct;
            })
            .map(productRepository::save);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Product> findAll(Pageable pageable) {
        log.debug("Request to get all Products");
        return productRepository.findAll(pageable);
    }

    public Page<Product> findAllWithEagerRelationships(Pageable pageable) {
        return productRepository.findAllWithEagerRelationships(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Product> findOne(Long id) {
        log.debug("Request to get Product : {}", id);
        return productRepository.findOneWithEagerRelationships(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Product : {}", id);
        productRepository.deleteById(id);
    }


    @Override
    public Page<Product> findByCategoryAndIsValid(Long categoryId, Boolean isValid, Pageable pageable){
        if (categoryId == 0) {
            throw new RuntimeException("Category Id can not be 0");
        }
        if (categoryId < 0) {
            throw new RuntimeException("Category Id can not be negative");
        }
        return this.productRepository.findByCategoryAndIsValid(categoryId, isValid, pageable);
    }
}
