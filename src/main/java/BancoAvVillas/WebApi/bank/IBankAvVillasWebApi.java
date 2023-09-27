package BancoAvVillas.WebApi.bank;

import BancoAvVillas.commons.domains.responseDTO.GenericResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

public interface IBankAvVillasWebApi {

    @GetMapping()
    ResponseEntity<GenericResponseDTO> readInformationBank();
}
