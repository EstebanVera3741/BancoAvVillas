package BancoAvVillas.WebApi.member;

import BancoAvVillas.commons.domains.DTO.member.MemberAvVillasDTO;
import BancoAvVillas.commons.domains.responseDTO.GenericResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface IMemberAvVillasWebApi {

    @PostMapping()
    ResponseEntity<GenericResponseDTO> createMember(@RequestBody MemberAvVillasDTO memberAvVillasDTO);
    @GetMapping()
    ResponseEntity<GenericResponseDTO> readMembers();
}
