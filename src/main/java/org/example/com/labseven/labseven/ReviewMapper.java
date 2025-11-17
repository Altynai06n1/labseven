package org.example.com.labseven.labseven;

import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface ReviewMapper {

    ReviewDTO toDto(Review review);

    Review toEntity(ReviewDTO dto);
}
