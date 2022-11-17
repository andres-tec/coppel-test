package com.coppeltestmg.coppeltest2.service;

import com.coppeltestmg.coppeltest2.entity.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios, Long> {

    public List<Usuarios> findAllByNombre(String Nombre);

}
