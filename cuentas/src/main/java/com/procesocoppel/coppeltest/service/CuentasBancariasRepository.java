package com.procesocoppel.coppeltest.service;

import com.procesocoppel.coppeltest.document.CuentasBancarias;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CuentasBancariasRepository extends MongoRepository<CuentasBancarias, String> {

    public List<CuentasBancarias> findAllByIdUsuario (Long idUsuario);//declare mi propia consulta

}
