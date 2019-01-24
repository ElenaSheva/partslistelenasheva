package ru.javarush.internship.partslistelenasheva.service;

import org.springframework.transaction.annotation.Transactional;
import ru.javarush.internship.partslistelenasheva.entity.PartEntity;

import java.util.List;


public interface PartService {
    List<PartEntity> findAllParts();
    List<PartEntity> findAllNecessary();
    List<PartEntity> findAllOptional();
    boolean isPartnameUnique(Integer id, String name);

    List<PartEntity> findListPartEntityByPartNameContains(String name);
    Integer getMinCountComputer();

    @Transactional
    void savePart(PartEntity aPart);

    @Transactional
    void deletePart(Integer aPartId);

    @Transactional
    PartEntity findPartById(Integer aPartId);
}
