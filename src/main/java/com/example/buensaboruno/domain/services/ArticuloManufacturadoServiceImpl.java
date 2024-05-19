package com.example.buensaboruno.domain.services;

import com.example.buensaboruno.domain.entities.ArticuloManufacturado;
import com.example.buensaboruno.repositories.ArticuloManufacturadoRepository;
import com.example.buensaboruno.repositories.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticuloManufacturadoServiceImpl extends BaseServiceImpl<ArticuloManufacturado, Long> implements ArticuloManufacturadoService{
    @Autowired
    ArticuloManufacturadoRepository articuloManufacturadoRepository;
    @Autowired
    public ArticuloManufacturadoServiceImpl(BaseRepository<ArticuloManufacturado, Long> baseRepository) {
        super(baseRepository);
    }

    @Override
    public List<ArticuloManufacturado> search(String string) throws Exception {
        return null;
    }

    @Override
    public Page<ArticuloManufacturado> search(String string, Pageable pageable) throws Exception {
        return null;
    }
}
