package com.coppeltestmg.coppeltest2.controller;

import com.coppeltestmg.coppeltest2.entity.Usuarios;
import com.coppeltestmg.coppeltest2.model.UsuariosModel;
import com.coppeltestmg.coppeltest2.service.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/usuario/")
public class UsuariosController {
    private final UsuariosService usuariosService;
    @Autowired
    public UsuariosController(UsuariosService usuariosService) {
        this.usuariosService = usuariosService;
    }

    @GetMapping
    public List<Usuarios> getAllUsrs(){
        return usuariosService.getAllUsr();
    }
    @GetMapping(path = "{uuid}")//http://localhost:8082/api/usuario/
    public Usuarios getUsrById(@PathVariable("uuid") Long id){
        return usuariosService.getByIdUsr(id);
    }

    @DeleteMapping(path = "{uuid}")
    public Usuarios deleteUsrById(@PathVariable("uuid") Long id){
        return usuariosService.deleteByIdUsr(id);
    }

    @PutMapping(path = "{uuid}")
    public Usuarios updateUsrById(@PathVariable("uuid") Long id,@RequestBody Usuarios usuarios ){
        return usuariosService.updateUsrById(id, usuarios);
    }

    @PostMapping
    public Usuarios addNewUsr(@RequestBody Usuarios usuarios){
        return usuariosService.addNewUsr(usuarios);
    }
    @GetMapping(path = "buscar/pornombre/{name}")//http://localhost:8082/api/usuario/
    public List<Usuarios> getUsrById(@PathVariable("name") String name){
        return usuariosService.getUsrByName(name);
    }

    @GetMapping(path = "feign/all/")//url para la consulta de todos los usuarios y sus cuentas correspondientes.
    public List<UsuariosModel> getAllFeign(){
        return usuariosService.mostrarUsuario();
    }

}