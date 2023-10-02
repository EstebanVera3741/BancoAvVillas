package BancoAvVillas.service.member;

import BancoAvVillas.commons.domains.DTO.member.MemberAvVillasDTO;
import BancoAvVillas.commons.domains.responseDTO.GenericResponseDTO;
import org.springframework.http.ResponseEntity;

public interface IMemberAvVillasService {

    ResponseEntity<GenericResponseDTO> createMember(MemberAvVillasDTO memberAvVillasDTO);
    ResponseEntity<GenericResponseDTO> readMembers();
}
