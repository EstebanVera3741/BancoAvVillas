package BancoAvVillas.commons.domains.responseDTO;

import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class GenericResponseDTO implements Serializable {
    public String message;
    public Object objectResponse;
    public Integer objectId;
    public Integer statusCode;
}