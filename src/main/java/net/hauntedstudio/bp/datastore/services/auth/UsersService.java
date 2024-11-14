package net.hauntedstudio.bp.datastore.services.auth;

import net.hauntedstudio.bp.datastore.entity.Users;
import net.hauntedstudio.bp.datastore.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    @Autowired
    private UsersRepository userRepository;

    public void createUser(Users userEntity) {
        userRepository.saveAndFlush(userEntity);
    }

    public Users getUserByLnchuuid(String lnchuuid) {
        return userRepository.findByLnchuuid(lnchuuid);
    }
}
