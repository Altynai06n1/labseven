package org.example.com.labseven.labseven;

import lombok.*;
import java.util.Set;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FlowerDTO {
    private Long id;
    private String name;
    private String color;
    private double price;

    private Set<CategoryDTO> categories;
    private List<ReviewDTO> reviews;
}
