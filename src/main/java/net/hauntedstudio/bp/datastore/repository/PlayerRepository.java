package net.hauntedstudio.bp.datastore.repository;

import net.hauntedstudio.bp.datastore.entity.PlayerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PlayerRepository extends JpaRepository<PlayerEntity, String> {

    @Query("select p from PlayerEntity p where p.user_id = ?1")
    PlayerEntity findByUser_id(String user_id);
}

