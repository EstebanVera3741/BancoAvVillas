package BancoAvVillas.service.member.implement;

import BancoAvVillas.commons.constans.response.GeneralResponse;
import BancoAvVillas.commons.constans.response.bank.IBankAvVillasResponse;
import BancoAvVillas.commons.constans.response.member.IMemberAvVillasResponse;
import BancoAvVillas.commons.converter.bank.IBankAvVillasMapper;
import BancoAvVillas.commons.converter.member.IMemberAvVillasMapper;
import BancoAvVillas.commons.converter.member.IMemberAvVillasMapperImpl;
import BancoAvVillas.commons.domains.DTO.member.MemberAvVillasDTO;
import BancoAvVillas.commons.domains.entity.bank.BankAvVillasEntity;
import BancoAvVillas.commons.domains.entity.member.MemberAvVillasEntity;
import BancoAvVillas.commons.domains.responseDTO.GenericResponseDTO;
import BancoAvVillas.commons.exception.Advice.BankAvVillasControllerAdvice;
import BancoAvVillas.commons.exception.BankAvVillasGeneralException;
import BancoAvVillas.repository.member.IMemberAvVillasRepository;
import BancoAvVillas.service.member.IMemberAvVillasService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MemberAvVillasService implements IMemberAvVillasService {

    private final IMemberAvVillasRepository iMemberAvVillasRepository;

    public MemberAvVillasService(IMemberAvVillasRepository iMemberAvVillasRepository) {
        this.iMemberAvVillasRepository = iMemberAvVillasRepository;
    }

    @Override
    public ResponseEntity<GenericResponseDTO> createMember(MemberAvVillasDTO memberAvVillasDTO) {
        try {
            Optional<MemberAvVillasEntity> memberAvVillasEntityExist =
                    this.iMemberAvVillasRepository.findById(memberAvVillasDTO.getMemberAvVillasIdentification());
            if (!memberAvVillasEntityExist.isPresent()){
                Period age = Period.between(memberAvVillasDTO.getMemberAvVillasDateBirth(), LocalDate.now());
                memberAvVillasDTO.setMemberAvVillasAge(age.getYears());
                BankAvVillasEntity bankAvVillasEntity = IBankAvVillasMapper.INSTANCE.convertDTOToEntity(memberAvVillasDTO.getBankAvVillasDTO());
                MemberAvVillasEntity memberAvVillasEntity = IMemberAvVillasMapper.INSTANCE.convertDTOToEntity(memberAvVillasDTO);
                memberAvVillasEntity.setBankAvVillasEntity(bankAvVillasEntity);
                this.iMemberAvVillasRepository.save(memberAvVillasEntity);
                return ResponseEntity.ok(GenericResponseDTO.builder()
                        .message(GeneralResponse.OPERATION_SUCCESS)
                        .objectResponse(IMemberAvVillasResponse.MEMBER_SUCCESS)
                        .statusCode(HttpStatus.OK.value())
                        .build());
            }else {
                throw new BankAvVillasGeneralException(IMemberAvVillasResponse.MEMBERSHIP_EXIST);
            }
        }catch (Exception e) {
            throw new BankAvVillasGeneralException(IMemberAvVillasResponse.MEMBERSHIP_EXIST);
        }
    }

    @Override
    public ResponseEntity<GenericResponseDTO> readMembers() {
        try{
            List<MemberAvVillasEntity> listMemberExist = this.iMemberAvVillasRepository.findAll();
            if(!listMemberExist.isEmpty()){
                return ResponseEntity.ok(GenericResponseDTO.builder()
                        .message(IMemberAvVillasResponse.MEMBERS_OUR_SUCCESS)
                        .objectResponse(listMemberExist.stream()
                                .map(IMemberAvVillasMapper.INSTANCE::convertEntityToDTO)
                                .collect(Collectors.toList()))
                        .statusCode(HttpStatus.OK.value())
                        .build());
            }else {
                throw new BankAvVillasGeneralException(IMemberAvVillasResponse.MEMBERS_OUR_FAIL);
            }
        }catch (Exception e){
            throw new BankAvVillasGeneralException(IMemberAvVillasResponse.MEMBERS_OUR_FAIL);
        }
    }
}