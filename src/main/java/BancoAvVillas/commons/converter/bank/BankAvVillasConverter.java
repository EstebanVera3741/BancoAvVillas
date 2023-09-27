package BancoAvVillas.commons.converter.bank;

import BancoAvVillas.commons.domains.DTO.bank.BankAvVillasDTO;
import BancoAvVillas.commons.domains.entity.bank.BankAvVillasEntity;
import BancoAvVillas.commons.constans.response.GeneralResponse;
import BancoAvVillas.commons.helpers.HelperMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class BankAvVillasConverter {

    public BankAvVillasDTO convertEntityToDTO(BankAvVillasEntity bankAvVillasEntity) {
        BankAvVillasDTO bankAvVillasDTO = new BankAvVillasDTO();
        try {
            bankAvVillasDTO = HelperMapper.modelMapper().map(bankAvVillasEntity, BankAvVillasDTO.class);
        } catch (Exception e) {
            log.error(GeneralResponse.DOCUMENT_FAIL + e);
        }
        return bankAvVillasDTO;
    }

    public BankAvVillasEntity convertDTOToEntity(BankAvVillasDTO bankAvVillasDTO) {
        BankAvVillasEntity bankAvVillasEntity = new BankAvVillasEntity();
        try {
            bankAvVillasEntity = HelperMapper.modelMapper().map(bankAvVillasDTO, BankAvVillasEntity.class);
        } catch (Exception e) {
            log.error(GeneralResponse.DOCUMENT_FAIL + e);
        }
        return bankAvVillasEntity;
    }
}