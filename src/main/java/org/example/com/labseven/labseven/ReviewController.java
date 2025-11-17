package org.example.com.labseven.labseven;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewRepository repository;
    private final FlowerRepository flowerRepository;
    private final ReviewMapper mapper;

    @PostMapping("/{flowerId}")
    public ReviewDTO create(@PathVariable Long flowerId, @RequestBody ReviewDTO dto) {
        Review review = mapper.toEntity(dto);
        review.setFlower(flowerRepository.findById(flowerId).orElseThrow());
        return mapper.toDto(repository.save(review));
    }

    @GetMapping
    public List<ReviewDTO> getAll() {
        return repository.findAll().stream()
                .map(mapper::toDto)
                .toList();
    }

    @GetMapping("/{id}")
    public ReviewDTO getById(@PathVariable Long id) {
        return mapper.toDto(repository.findById(id).orElseThrow());
    }
}
