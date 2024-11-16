package net.hauntedstudio.bp.datastore.services.user;

import net.hauntedstudio.bp.datastore.entity.CharacterSlotEntity;
import net.hauntedstudio.bp.datastore.repository.CharacterSlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CharacterSlotService {

    @Autowired
    private CharacterSlotRepository characterSlotRepository;

    public void createCharacterSlot(CharacterSlotEntity characterSlotEntity) {
        characterSlotRepository.saveAndFlush(characterSlotEntity);
    }

    public CharacterSlotEntity getCharacterSlotByUserId(String userId) {
        return characterSlotRepository.findByUser_id(userId);
    }


}
