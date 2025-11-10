package org.example.com.labseven.labseven;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FlowerDTO {
    private Long id;
    private String name;
    private String color;
    private double price;
}