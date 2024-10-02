package com.example.demo.repository;

import com.example.demo.models.CurriculoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurriculoRepository extends JpaRepository<CurriculoModel, Long> {
}
