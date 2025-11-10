package org.example.com.labseven.labseven;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FlowerService {

    private final FlowerRepository repository;

    // Конвертация Entity → DTO
    public FlowerDTO toDto(Flower flower) {
        if (flower == null) return null;
        return FlowerDTO.builder()
                .id(flower.getId())
                .name(flower.getName())
                .color(flower.getColor())
                .price(flower.getPrice())
                .build();
    }

    // Конвертация DTO → Entity
    public Flower toEntity(FlowerDTO dto) {
        if (dto == null) return null;
        return Flower.builder()
                .name(dto.getName())
                .color(dto.getColor())
                .price(dto.getPrice())
                .build();
    }

    // CREATE
    public FlowerDTO create(FlowerDTO dto) {
        Flower flower = toEntity(dto);
        Flower saved = repository.save(flower);
        return toDto(saved);
    }

    // READ ALL
    public List<FlowerDTO> getAll() {
        return repository.findAll().stream()
                .map(this::toDto)
                .toList();
    }

    // READ BY ID
    public Optional<FlowerDTO> getById(Long id) {
        return repository.findById(id).map(this::toDto);
    }

    // UPDATE
    public Optional<FlowerDTO> update(Long id, FlowerDTO dto) {
        return repository.findById(id).map(flower -> {
            flower.setName(dto.getName());
            flower.setColor(dto.getColor());
            flower.setPrice(dto.getPrice());
            Flower updated = repository.save(flower);
            return toDto(updated);
        });
    }

    // DELETE
    public void delete(Long id) {
        repository.deleteById(id);
    }
}