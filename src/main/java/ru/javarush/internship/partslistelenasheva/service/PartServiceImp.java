package ru.javarush.internship.partslistelenasheva.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.javarush.internship.partslistelenasheva.entity.PartEntity;
import ru.javarush.internship.partslistelenasheva.repository.PartRepository;
import java.util.List;

@Service
public class PartServiceImp implements PartService{

    private PartRepository fRepository;

    @Autowired
    public void setRepository(PartRepository aRepository) {
        fRepository = aRepository;
    }

    @Override
    public List<PartEntity> findAllParts() {
        return fRepository.findAll();
    }

    @Override
    public List<PartEntity> findAllNecessary() {
        return fRepository.findAllNecessary();
    }

    @Override
    public List<PartEntity> findAllOptional() {
        return fRepository.findAllOptional();
    }

    @Override
    public boolean isPartnameUnique(Integer id, String name) {
        boolean lResult = false;
        List<PartEntity> lList = fRepository.isPartnameUnique(name.toUpperCase());
        if (id != null && lList.size() == 1
                && id.equals(lList.get(0).getId())){
            lResult = true;
        } else {
            lResult = lList.size() == 0;
        }

        return lResult;
    }

    @Override
    public List<PartEntity> findListPartEntityByPartNameContains(String name) {
        return fRepository.findListPartEntityByPartNameContains(name);
    }

    @Override
    public Integer getMinCountComputer() {
        return fRepository.getMinCountComputer();
    }

    @Override
     public void savePart(PartEntity aPart) {
        fRepository.save(aPart);
    }

    @Override
    public void deletePart(Integer aPartId) {
        fRepository.deleteById(aPartId);
    }

    @Override
    public PartEntity findPartById(Integer aPartId) {
        return fRepository.getOne(aPartId);
    }


}
