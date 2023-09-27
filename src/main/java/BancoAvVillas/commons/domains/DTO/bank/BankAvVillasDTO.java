package BancoAvVillas.commons.domains.DTO.bank;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class BankAvVillasDTO{
    private String bankAvVillasCodeSwift;
    private String bankAvVillasName;
    private String bankAvVillasType;
    private String bankAvVillasIdFiscal;
    private String bankAvVillasContact;
    private String bankAvVillasService;
}