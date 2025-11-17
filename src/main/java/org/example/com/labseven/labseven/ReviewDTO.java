package org.example.com.labseven.labseven;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReviewDTO {
    private Long id;
    private String comment;
    private int rating;
}
