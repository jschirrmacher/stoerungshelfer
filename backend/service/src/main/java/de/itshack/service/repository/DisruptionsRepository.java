package de.itshack.service.repository;

import de.itshack.service.entity.DisruptionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DisruptionsRepository extends JpaRepository<DisruptionEntity, UUID> {
}
