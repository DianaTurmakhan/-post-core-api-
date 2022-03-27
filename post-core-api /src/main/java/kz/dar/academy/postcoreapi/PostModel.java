package kz.dar.academy.postcoreapi;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class PostModel {
    @NotNull
    String postID;
    @NotNull
    String clientId;
    @NotNull
    String postRecipientId;
    @NotNull(message="Item name must be there")
    @Size(min=2, max=20,message ="Item name should be min length of 2 and maximum length of 20")
    String postItem;
    String status;
}
