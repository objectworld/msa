package org.objectworld.shopping.web;

import org.objectworld.shopping.dto.ReviewDto;
import org.objectworld.shopping.service.ReviewService;
import org.springframework.web.bind.annotation.*;

import static org.objectworld.shopping.common.Web.API;

import java.util.List;

/**
 * @author Nebrass Lamouchi
 */
@RestController
@RequestMapping(API + "/reviews")
public class ReviewResource {

    private final ReviewService reviewService;

    public ReviewResource(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping
    public List<ReviewDto> findAll() {
        return this.reviewService.findAll();
    }

    @GetMapping("/{id}")
    public ReviewDto findById(@PathVariable Long id) {
        return this.reviewService.findById(id);
    }

    @PostMapping
    public ReviewDto create(@RequestBody ReviewDto reviewDto) {
        return this.reviewService.create(reviewDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.reviewService.delete(id);
    }
}
