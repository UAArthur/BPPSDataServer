package net.hauntedstudio.bp.datastore.services.user;

import net.hauntedstudio.bp.datastore.entity.UserEntity;
import net.hauntedstudio.bp.datastore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void createUser(UserEntity userEntity) {
        userRepository.saveAndFlush(userEntity);
    }

}
