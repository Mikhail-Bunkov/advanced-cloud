package com.flamexander.cloud.service.product;

import com.flamexander.cloud.common.ProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    private static final Function<Product, ProductDto> mapper = p -> new ProductDto(p.getId(), p.getTitle(), p.getPrice());

    @GetMapping
    public List<ProductDto> findAll() {
        return productService.findAll().stream().map(mapper).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ProductDto findById(@PathVariable Long id) {
        return mapper.apply(productService.findById(id).get());
    }
}
