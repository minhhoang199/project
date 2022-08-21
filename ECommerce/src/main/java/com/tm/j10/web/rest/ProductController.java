package com.tm.j10.web.rest;

import com.tm.j10.domain.Product;
import com.tm.j10.service.ProductService;
import com.tm.j10.service.impl.ProductServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/public/products")
public class ProductController {
    private ProductService productService;

    public ProductController(ProductServiceImpl ProductServiceImpl) {
        this.productService = ProductServiceImpl;
    }

    @GetMapping("/category/{catid}")
    public ResponseEntity<Page<Product>> findAllByCategoryAndIsValid(
        @PathVariable("catid") Long categoryId,
        @RequestParam("isValid") Optional<Boolean> isValid,
        @RequestParam("pageNo") Optional<Integer> pageNo,
        @RequestParam("pageSize") Optional<Integer> pageSize
    ) {
        Pageable pageable = PageRequest.of(pageNo.orElse(0), pageSize.orElse(10));
        var ret = this.productService.findByCategoryAndIsValid(categoryId, isValid.orElse(true), pageable);
        return ResponseEntity.ok(ret);
    }
}
