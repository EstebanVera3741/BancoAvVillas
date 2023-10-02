package BancoAvVillas.commons.domains.entity.bank;

import BancoAvVillas.commons.domains.entity.member.MemberAvVillasEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Builder(builderMethodName = "newInstance")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "bank_av_villas")
public class BankAvVillasEntity {

    @Id
    @Column(name = "bank_av_villas_swift")
    private String bankAvVillasCodeSwift;

    @Column(name = "bank_av_villas_name")
    private String bankAvVillasName;

    @Column(name = "bank_av_villas_type")
    private String bankAvVillasType;

    @Column(name = "bank_av_villas_id_fiscal")
    private String bankAvVillasIdFiscal;

    @Column(name = "bank_av_villas_contact")
    private String bankAvVillasContact;

    @Column(name = "bank_av_villas_service")
    private String bankAvVillasService;

    @OneToMany(mappedBy = "BankAvVillasEntity")
    @JsonIgnore
    private List<MemberAvVillasEntity> listMemberEntity;
}