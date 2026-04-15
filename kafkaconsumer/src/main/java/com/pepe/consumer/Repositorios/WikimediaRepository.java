package com.pepe.consumer.Repositorios;

import com.pepe.consumer.Modelos.RegistroWikimedia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WikimediaRepository extends JpaRepository<RegistroWikimedia, Long> {
}
