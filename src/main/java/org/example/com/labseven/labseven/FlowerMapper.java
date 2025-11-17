package org.example.com.labseven.labseven;

import org.mapstruct.*;
import java.util.List;

@Mapper(componentModel = "spring")
public interface FlowerMapper {

    FlowerDTO toDto(Flower flower);

    Flower toEntity(FlowerDTO dto);

    List<FlowerDTO> toDtoList(List<Flower> flowers);
}
