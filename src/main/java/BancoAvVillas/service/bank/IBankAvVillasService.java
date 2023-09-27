package BancoAvVillas.service.bank;

import BancoAvVillas.commons.domains.responseDTO.GenericResponseDTO;
import org.springframework.http.ResponseEntity;

public interface IBankAvVillasService {
    ResponseEntity<GenericResponseDTO> readInformationBank();
}
