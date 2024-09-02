package example.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReviewMessage {
    private long id;
    private String title;
    private String description;
    private double rating;
    private long companyId;
}
