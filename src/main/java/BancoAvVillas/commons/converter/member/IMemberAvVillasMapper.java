package BancoAvVillas.commons.converter.member;

import BancoAvVillas.commons.domains.DTO.member.MemberAvVillasDTO;
import BancoAvVillas.commons.domains.entity.member.MemberAvVillasEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface IMemberAvVillasMapper {
    IMemberAvVillasMapper INSTANCE = Mappers.getMapper(IMemberAvVillasMapper.class);

    MemberAvVillasDTO convertEntityToDTO(MemberAvVillasEntity memberAvVillasEntity);
    MemberAvVillasEntity convertDTOToEntity(MemberAvVillasDTO memberAvVillasDTO);
}