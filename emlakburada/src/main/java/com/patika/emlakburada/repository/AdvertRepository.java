package com.patika.emlakburada.repository;

import com.patika.emlakburada.model.entity.Advert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdvertRepository extends JpaRepository<Advert, Long> {
}
