package org.example.com.labseven.labseven;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FlowerService {

    private final FlowerRepository repository;
    private final CategoryRepository categoryRepository;
    private final ReviewRepository reviewRepository;
    private final FlowerMapper mapper;

    public FlowerDTO create(FlowerDTO dto) {
        Flower flower = mapper.toEntity(dto);

        if (dto.getCategories() != null) {
            flower.setCategories(
                    dto.getCategories().stream()
                            .map(c -> categoryRepository.findById(c.getId()).orElse(null))
                            .collect(java.util.stream.Collectors.toSet())
            );
        }

        Flower saved = repository.save(flower);
        return mapper.toDto(saved);
    }

    public List<FlowerDTO> getAll() {
        return mapper.toDtoList(repository.findAll());
    }

    public Optional<FlowerDTO> getById(Long id) {
        return repository.findById(id).map(mapper::toDto);
    }

    public Optional<FlowerDTO> update(Long id, FlowerDTO dto) {
        return repository.findById(id).map(flower -> {

            Flower updated = mapper.toEntity(dto);
            updated.setId(flower.getId());

            if (dto.getCategories() != null) {
                updated.setCategories(
                        dto.getCategories().stream()
                                .map(c -> categoryRepository.findById(c.getId()).orElse(null))
                                .collect(java.util.stream.Collectors.toSet())
                );
            }

            updated = repository.save(updated);
            return mapper.toDto(updated);
        });
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
