package BancoAvVillas.service.bank.implement;

import BancoAvVillas.commons.constans.response.GeneralResponse;
import BancoAvVillas.commons.constans.response.bank.IBankAvVillasResponse;
import BancoAvVillas.commons.domains.DTO.bank.BankAvVillasDTO;
import BancoAvVillas.commons.domains.entity.bank.BankAvVillasEntity;
import BancoAvVillas.commons.domains.responseDTO.GenericResponseDTO;
import BancoAvVillas.repository.bank.IBankAvVillasRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BankAvVillasServiceTest {

    @Mock
    private IBankAvVillasRepository iBankAvVillasRepository;
    private BankAvVillasService bankAvVillasService;
    @BeforeEach
    public void setup() throws Exception{
        MockitoAnnotations.openMocks(this).close();
        bankAvVillasService = new BankAvVillasService(iBankAvVillasRepository);
    }

    @Test
    public void readInformationBankTest(){
        List<BankAvVillasDTO> listBankDTO = new ArrayList<>();
        BankAvVillasDTO bankDTO = new BankAvVillasDTO("ADB", "Banco Av Villas",
                "CDT", "123", "Servicios", "ABD");
        listBankDTO.add(bankDTO);

        List<BankAvVillasEntity> listBankExist = new ArrayList<>();
        BankAvVillasEntity bankEntity = new BankAvVillasEntity("ADB", "Banco Av Villas",
                "CDT", "123", "Servicios", "ABD");
        listBankExist.add(bankEntity);

        when(iBankAvVillasRepository.findAll()).thenReturn(listBankExist);
        ResponseEntity<GenericResponseDTO> response = bankAvVillasService.readInformationBank();

        assertEquals(IBankAvVillasResponse.BANK_SUCCESS, response.getBody().getMessage());
        assertEquals(listBankDTO, response.getBody().getObjectResponse());
        assertEquals(HttpStatus.OK.value(), response.getStatusCodeValue());
    }
}