package BancoAvVillas.commons.domains.entity.member;

import BancoAvVillas.commons.domains.DTO.bank.BankAvVillasDTO;
import BancoAvVillas.commons.domains.entity.bank.BankAvVillasEntity;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;


@Builder(builderMethodName = "newInstance")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "member_av_villas")
public class MemberAvVillasEntity {

    @Id
    @Column(name = "member_av_villas_identification")
    private String memberAvVillasIdentification;

    @Column(name = "member_av_villas_name")
    private String memberAvVillasName;

    @Column(name = "member_av_villas_date_birth")
    private LocalDate memberAvVillasDateBirth;

    @Column(name = "member_av_villas_email")
    private String memberAvVillasEmail;

    @Column(name = "member_av_villas_phone_number")
    private String memberAvVillasPhoneNumber;

    @Column(name = "member_av_villas_address")
    private String memberAvVillasAddress;

    @Column(name = "member_av_villas_type_sex")
    private String memberAvVillasTypeSex;

    @Column(name = "member_av_villas_status")
    private String memberAvVillasStatus;

    @Column(name = "member_av_villas_age")
    private Integer memberAvVillasAge;

    @Column(name = "member_av_villas_date_membership")
    private LocalDate memberAvVillasDateMembership;

    @ManyToOne
    @JoinColumn(name = "bank_av_villas_swift")
    @JsonIgnore
    private BankAvVillasEntity BankAvVillasEntity;
}
