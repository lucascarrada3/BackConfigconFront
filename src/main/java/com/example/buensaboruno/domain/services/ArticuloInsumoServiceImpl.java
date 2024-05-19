package com.example.buensaboruno.domain.services;

import com.example.buensaboruno.domain.entities.ArticuloInsumo;
import com.example.buensaboruno.repositories.ArticuloInsumoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticuloInsumoServiceImpl extends BaseServiceImpl<ArticuloInsumo, Long> implements ArticuloInsumoService{
    @Autowired
    ArticuloInsumoRepository articuloInsumoRepository;


    @Autowired
    public ArticuloInsumoServiceImpl(ArticuloInsumoRepository baseRepository) {
        super(baseRepository);
    }

    @Override
    public List<ArticuloInsumo> search(String string) throws Exception {
        return null;
    }

    @Override
    public Page<ArticuloInsumo> search(String string, Pageable pageable) throws Exception {
        return null;
    }
}
