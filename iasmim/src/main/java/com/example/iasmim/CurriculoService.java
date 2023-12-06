package com.example.iasmim;

import com.example.iasmim.Curriculo;
import com.example.iasmim.CurriculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class CurriculoService {
    @Autowired
    private CurriculoRepository curriculoRepository;

    public List<Curriculo> listarCurriculos() {
        return curriculoRepository.findAll();
    }

    public Curriculo buscarCurriculo(Long id) {
        return curriculoRepository.findById(id).orElse(null);
    }

    public Curriculo cadastrarCurriculo(Curriculo curriculo) {
        return curriculoRepository.save(curriculo);
    }

    public Curriculo atualizarCurriculo(Long id, Curriculo curriculo) {
        curriculo.setId(id);
        return curriculoRepository.save(curriculo);
    }

    public void deletarCurriculo(Long id) {
        curriculoRepository.deleteById(id);
    }
}