package kz.dar.academy.backend.model;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@NotNull
@Data
public class PostResponse {
    private String postId;
    private ClientResponse client;
    private ClientResponse receiver;
    private String postItem;
    private String status;
}
