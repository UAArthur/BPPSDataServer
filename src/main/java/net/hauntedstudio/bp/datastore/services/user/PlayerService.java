package net.hauntedstudio.bp.datastore.services.user;

import net.hauntedstudio.bp.datastore.entity.PlayerEntity;
import net.hauntedstudio.bp.datastore.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    public void createPlayer(PlayerEntity playerEntity) {
        playerRepository.saveAndFlush(playerEntity);
    }

    public PlayerEntity getPlayerByUserId(String userId) {
        return playerRepository.findByUser_id(userId);
    }
}
