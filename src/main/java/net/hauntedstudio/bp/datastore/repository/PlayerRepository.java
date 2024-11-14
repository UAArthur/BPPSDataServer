package net.hauntedstudio.bp.datastore.repository;

import net.hauntedstudio.bp.datastore.entity.PlayerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<PlayerEntity, String> {
}
