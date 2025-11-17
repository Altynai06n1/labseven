package org.example.com.labseven.labseven;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryRepository repository;
    private final CategoryMapper mapper;

    @PostMapping
    public CategoryDTO create(@RequestBody CategoryDTO dto) {
        return mapper.toDto(repository.save(mapper.toEntity(dto)));
    }

    @GetMapping
    public List<CategoryDTO> getAll() {
        return repository.findAll().stream()
                .map(mapper::toDto)
                .toList();
    }

    @GetMapping("/{id}")
    public CategoryDTO getById(@PathVariable Long id) {
        return mapper.toDto(repository.findById(id).orElseThrow());
    }
}
