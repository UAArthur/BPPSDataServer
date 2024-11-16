package net.hauntedstudio.bp.datastore.repository;

import net.hauntedstudio.bp.datastore.entity.CharacterSlotEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CharacterSlotRepository extends JpaRepository<CharacterSlotEntity, String> {

    @Query("select c from CharacterSlotEntity c where c.user_id = ?1")
    CharacterSlotEntity findByUser_id(String user_id);
}
