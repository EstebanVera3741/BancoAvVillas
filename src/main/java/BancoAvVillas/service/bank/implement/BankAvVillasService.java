package BancoAvVillas.service.bank.implement;

import BancoAvVillas.commons.constans.response.GeneralResponse;
import BancoAvVillas.commons.constans.response.bank.IBankAvVillasResponse;
import BancoAvVillas.commons.converter.bank.BankAvVillasConverter;
import BancoAvVillas.commons.converter.bank.IBankAvVillasMapper;
import BancoAvVillas.commons.domains.entity.bank.BankAvVillasEntity;
import BancoAvVillas.commons.domains.responseDTO.GenericResponseDTO;
import BancoAvVillas.commons.exception.BankAvVillasGeneralException;
import BancoAvVillas.repository.bank.IBankAvVillasRepository;
import BancoAvVillas.service.bank.IBankAvVillasService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Log4j2
public class BankAvVillasService implements IBankAvVillasService {

    @Autowired
    private IBankAvVillasRepository iBankAvVillasRepository;
    @Autowired
    private BankAvVillasConverter bankAvVillasConverter;

    @Override
    public ResponseEntity<GenericResponseDTO> readInformationBank() {
        try {
            List<BankAvVillasEntity> listBankExist = this.iBankAvVillasRepository.findAll();
            if (!listBankExist.isEmpty()){
                return ResponseEntity.ok(GenericResponseDTO.builder()
                        .message(IBankAvVillasResponse.BANK_SUCCESS)
                        .objectResponse(listBankExist.stream()
                                .map(IBankAvVillasMapper.INSTANCE::convertEntityToDTO)
                                .collect(Collectors.toList()))
                        .statusCode(HttpStatus.OK.value())
                        .build());
            }else {
                throw new BankAvVillasGeneralException(IBankAvVillasResponse.BANK_FAIL);
            }
        }catch (Exception e) {
            log.error(GeneralResponse.INTERNAL_SERVER, e);
            throw new BankAvVillasGeneralException(GeneralResponse.INTERNAL_SERVER_ERROR);
        }
    }
}