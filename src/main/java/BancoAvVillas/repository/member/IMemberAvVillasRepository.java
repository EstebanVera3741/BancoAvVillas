package BancoAvVillas.repository.member;

import BancoAvVillas.commons.domains.entity.member.MemberAvVillasEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IMemberAvVillasRepository extends JpaRepository<MemberAvVillasEntity, String> {
    @Override
    Optional<MemberAvVillasEntity> findById(String memberAvVillasIdentification);
}