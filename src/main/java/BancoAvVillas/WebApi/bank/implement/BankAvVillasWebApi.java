package BancoAvVillas.WebApi.bank.implement;

import BancoAvVillas.WebApi.bank.IBankAvVillasWebApi;
import BancoAvVillas.commons.constans.endpoint.bank.IBankAvVillasEndPoint;
import BancoAvVillas.commons.domains.responseDTO.GenericResponseDTO;
import BancoAvVillas.service.bank.implement.BankAvVillasService;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(IBankAvVillasEndPoint.BANK_BASE_URL)
@Log4j2
public class BankAvVillasWebApi implements IBankAvVillasWebApi {

    private final BankAvVillasService bankAvVillasService;

    public BankAvVillasWebApi(BankAvVillasService bankAvVillasService) {
        this.bankAvVillasService = bankAvVillasService;
    }

    @Override
    @GetMapping(IBankAvVillasEndPoint.BANK_INFORMATION)
    public ResponseEntity<GenericResponseDTO> readInformationBank() {
        return this.bankAvVillasService.readInformationBank();
    }
}