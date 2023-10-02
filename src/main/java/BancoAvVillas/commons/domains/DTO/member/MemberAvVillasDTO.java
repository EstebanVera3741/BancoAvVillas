package BancoAvVillas.commons.domains.DTO.member;

import BancoAvVillas.commons.domains.DTO.bank.BankAvVillasDTO;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class MemberAvVillasDTO {
    private String memberAvVillasIdentification;
    private String memberAvVillasName;
    private LocalDate memberAvVillasDateBirth;
    private String memberAvVillasEmail;
    private String memberAvVillasPhoneNumber;
    private String memberAvVillasAddress;
    private String memberAvVillasTypeSex;
    private String memberAvVillasStatus;
    private Integer memberAvVillasAge;
    private LocalDate memberAvVillasDateMembership;
    @JsonIdentityReference(alwaysAsId = true)
    private BankAvVillasDTO bankAvVillasDTO;
}