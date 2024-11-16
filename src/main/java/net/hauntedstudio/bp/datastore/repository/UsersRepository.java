package net.hauntedstudio.bp.datastore.repository;

import net.hauntedstudio.bp.datastore.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long> {
    Users findByLnchuuid(String lnchuuid);
    boolean existsByLnchuuid(String lnchuuid);
}
