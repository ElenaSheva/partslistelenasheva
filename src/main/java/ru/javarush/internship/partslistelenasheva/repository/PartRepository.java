package ru.javarush.internship.partslistelenasheva.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.javarush.internship.partslistelenasheva.entity.PartEntity;

import java.util.List;

@Repository
public interface PartRepository extends JpaRepository<PartEntity, Integer> {

    @Query("select u from PartEntity u order by u.fPartname ")
    List<PartEntity> findAll();

    @Query("select u from PartEntity u where u.fPartname LIKE CONCAT('%',:teilname,'%') order by u.fPartname ")
    List<PartEntity> findListPartEntityByPartNameContains(@Param("teilname") String teilname);

    @Query("select MIN(u.fQuantity) from PartEntity u where u.fNecessary = 1 ")
    Integer getMinCountComputer();

    @Query("select u from PartEntity u where u.fNecessary = 1 order by u.fPartname ")
    List<PartEntity> findAllNecessary();

    @Query("select u from PartEntity u where u.fNecessary = 0 order by u.fPartname ")
    List<PartEntity> findAllOptional();

    @Query("select u from PartEntity u where UPPER(u.fPartname) = :name")
    List<PartEntity> isPartnameUnique(@Param("name") String name);
}
