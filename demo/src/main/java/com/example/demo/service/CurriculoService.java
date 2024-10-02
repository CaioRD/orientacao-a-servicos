package com.example.demo.service;

import com.example.demo.models.CurriculoModel;
import com.example.demo.repository.CurriculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CurriculoService {

    @Autowired
    private CurriculoRepository curriculoRepository;

    public List<CurriculoModel> findAll() {
        return curriculoRepository.findAll();
    }

    public Optional<CurriculoModel> findById(Long id) {
        return curriculoRepository.findById(id);
    }

    public CurriculoModel save(CurriculoModel curriculo) {
        return curriculoRepository.save(curriculo);
    }

    public void deleteById(Long id) {
        curriculoRepository.deleteById(id);
    }
}
