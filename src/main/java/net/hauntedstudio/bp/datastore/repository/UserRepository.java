package net.hauntedstudio.bp.datastore.repository;

import net.hauntedstudio.bp.datastore.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
