package BancoAvVillas.service.bank.implement;

import BancoAvVillas.commons.constans.response.GeneralResponse;
import BancoAvVillas.commons.constans.response.bank.IBankAvVillasResponse;
import BancoAvVillas.commons.converter.bank.IBankAvVillasMapper;
import BancoAvVillas.commons.domains.entity.bank.BankAvVillasEntity;
import BancoAvVillas.commons.domains.responseDTO.GenericResponseDTO;
import BancoAvVillas.commons.exception.BankAvVillasGeneralException;
import BancoAvVillas.repository.bank.IBankAvVillasRepository;
import BancoAvVillas.service.bank.IBankAvVillasService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BankAvVillasService implements IBankAvVillasService {

    private final IBankAvVillasRepository iBankAvVillasRepository;

    public BankAvVillasService(IBankAvVillasRepository iBankAvVillasRepository) {
        this.iBankAvVillasRepository = iBankAvVillasRepository;
    }

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
            throw new BankAvVillasGeneralException(IBankAvVillasResponse.BANK_FAIL);
        }
    }
}