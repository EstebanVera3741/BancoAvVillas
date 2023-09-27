package BancoAvVillas.repository.bank;

import BancoAvVillas.commons.domains.entity.bank.BankAvVillasEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBankAvVillasRepository extends JpaRepository<BankAvVillasEntity, String> { }