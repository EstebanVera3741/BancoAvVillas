package BancoAvVillas.WebApi.member.implement;

import BancoAvVillas.WebApi.member.IMemberAvVillasWebApi;
import BancoAvVillas.commons.constans.endpoint.member.IMemberAvVillasEndPoint;
import BancoAvVillas.commons.domains.DTO.member.MemberAvVillasDTO;
import BancoAvVillas.commons.domains.responseDTO.GenericResponseDTO;
import BancoAvVillas.service.member.implement.MemberAvVillasService;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(IMemberAvVillasEndPoint.MEMBER_BASE_URL)
@Log4j2
public class MemberAvVillasWebApi implements IMemberAvVillasWebApi {

    private final MemberAvVillasService memberAvVillasService;

    public MemberAvVillasWebApi(MemberAvVillasService memberAvVillasService) {
        this.memberAvVillasService = memberAvVillasService;
    }

    @Override
    @PostMapping(IMemberAvVillasEndPoint.MEMBER_CREATE)
    public ResponseEntity<GenericResponseDTO> createMember(@RequestBody MemberAvVillasDTO memberAvVillasDTO) {
        return this.memberAvVillasService.createMember(memberAvVillasDTO);
    }

    @Override
    @GetMapping(IMemberAvVillasEndPoint.MEMBERS_READ)
    public ResponseEntity<GenericResponseDTO> readMembers() {
        return this.memberAvVillasService.readMembers();
    }
}