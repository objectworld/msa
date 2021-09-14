package org.objectworld.shopping.web;

import org.objectworld.shopping.dto.ProductDto;
import org.objectworld.shopping.service.ProductService;
import org.springframework.web.bind.annotation.*;

import static org.objectworld.shopping.common.Web.API;

import java.util.List;

/**
 * @author Nebrass Lamouchi
 */
@RestController
@RequestMapping(API + "/products")
public class ProductResource {

    private final ProductService productService;

    public ProductResource(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<ProductDto> findAll() {
        return this.productService.findAll();
    }

    @GetMapping("/{id}")
    public ProductDto findById(@PathVariable Long id) {
        return this.productService.findById(id);
    }

    @PostMapping
    public ProductDto create(@RequestBody ProductDto productDto) {
        return this.productService.create(productDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.productService.delete(id);
    }
}
