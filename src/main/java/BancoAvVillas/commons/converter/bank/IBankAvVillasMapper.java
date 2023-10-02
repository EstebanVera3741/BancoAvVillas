package BancoAvVillas.commons.converter.bank;

import BancoAvVillas.commons.domains.DTO.bank.BankAvVillasDTO;
import BancoAvVillas.commons.domains.entity.bank.BankAvVillasEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface IBankAvVillasMapper {
    IBankAvVillasMapper INSTANCE = Mappers.getMapper( IBankAvVillasMapper.class );

    BankAvVillasDTO convertEntityToDTO(BankAvVillasEntity bankAvVillasEntity);
    BankAvVillasEntity convertDTOToEntity(BankAvVillasDTO bankAvVillasDTO);
}
