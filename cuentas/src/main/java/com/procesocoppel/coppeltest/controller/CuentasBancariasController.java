package com.procesocoppel.coppeltest.controller;

import com.procesocoppel.coppeltest.document.CuentasBancarias;
import com.procesocoppel.coppeltest.service.CuentasBancariasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping(path = "/api/cuentas/")
public class CuentasBancariasController {

    private final CuentasBancariasService cuentasBancariasService;

    @Autowired
    public CuentasBancariasController(CuentasBancariasService cuentasBancariasService) {
        this.cuentasBancariasService = cuentasBancariasService;
    }

    @GetMapping
    public List<CuentasBancarias> getAllCtas(){
        return cuentasBancariasService.getCuentas();
    }
    @GetMapping(path = "{uuid}")//http://localhost:8080/api/cuentas/
    public List<CuentasBancarias> getCtasByUsrId(@PathVariable("uuid") Long id){
        return cuentasBancariasService.getByIdUsr(id);
    }

    @DeleteMapping//se requiere que se ingrese por medio de params los datos como el id de la cuenta y el del usuario para realizar la operacion
    public CuentasBancarias deleteCtaByUsrId(@RequestParam(required = true) String id, @RequestParam(required = true) Long uuid){
        return cuentasBancariasService.deleteByIdUsr(id,uuid);
    }

    @PutMapping(path = "{uuid}")//en esta seccion es importante poner dentro de body el id de la cuenta para que pueda realizar el update
    public CuentasBancarias updateCtaByUsrId(@PathVariable("uuid") Long id,@RequestBody CuentasBancarias cuentasBancarias ){
        return cuentasBancariasService.updateAccountByUsrId(id, cuentasBancarias);
    }

    @PostMapping
    public CuentasBancarias addNewAct(@RequestBody CuentasBancarias cuentasBancarias){
        return cuentasBancariasService.createNewAccount(cuentasBancarias);
    }



    @GetMapping(path = "getaccbyid/{id}")//http://localhost:8080/api/cuentas/
    public CuentasBancarias getAccByItsId(@PathVariable("id") String id){
        return cuentasBancariasService.searchAccByItsId(id);
    }




}
