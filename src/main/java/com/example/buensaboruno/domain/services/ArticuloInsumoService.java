package com.example.buensaboruno.domain.services;

import com.example.buensaboruno.domain.entities.ArticuloInsumo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ArticuloInsumoService extends BaseService<ArticuloInsumo, Long>{
    List<ArticuloInsumo> search(String string) throws Exception;
    Page<ArticuloInsumo> search(String string, Pageable pageable) throws Exception;
}
