package com.procesocoppel.coppeltest.service;

import com.procesocoppel.coppeltest.document.CuentasBancarias;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.Callable;

@Service
public class CuentasBancariasService {
    private final CuentasBancariasRepository cuentasBancariasRepository;
    @Autowired
    public CuentasBancariasService(CuentasBancariasRepository cuentasBancariasRepository) {
        this.cuentasBancariasRepository = cuentasBancariasRepository;
    }
    public List<CuentasBancarias> getCuentas(){
        return cuentasBancariasRepository.findAll();
    }//funcion que te permite conseguir todos los registros de la base de datos.

    public List<CuentasBancarias> getByIdUsr(Long id)
    {
        return cuentasBancariasRepository.findAllByIdUsuario(id);
    }

    public CuentasBancarias deleteByIdUsr(String id ,Long uuid){
        CuentasBancarias tempcta= null;
        List<CuentasBancarias> ctasUser =null;
        ctasUser = cuentasBancariasRepository.findAllByIdUsuario(uuid);
        if (ctasUser.size() > 0 ){
            tempcta=null;
            tempcta = cuentasBancariasRepository.findById(id).get();
            if(tempcta.getIdUsuario()==uuid) {
                cuentasBancariasRepository.deleteById(id);
                System.out.println("Se ha eliminado la cta con Id: "+ id);
                return tempcta;
            }else {System.out.println("el Id: "+ uuid+" Del Usuario, no corresponde a la cuenta con ID:" + id);}
        }else {
            System.out.println("No hay cuentas asociadas a este Usuario");}
        return tempcta;
    }

    /*public CuentasBancarias addNewCtaToUsr(CuentasBancarias cuentasBancarias ){
        return usuariosRepository.save(usuarios);
    }*/

    public  CuentasBancarias updateAccountByUsrId(Long uuid,CuentasBancarias cuentasBancarias ){

        CuentasBancarias tempcta = null;
        List<CuentasBancarias> ctasUser =null;
        ctasUser = cuentasBancariasRepository.findAllByIdUsuario(uuid);
        if (ctasUser.size() > 0 ){
            tempcta=null;
            tempcta = cuentasBancariasRepository.findById(cuentasBancarias.getId()).get();
            if(tempcta.getIdUsuario()==uuid) {
                    tempcta.setBanco(cuentasBancarias.getBanco());
                    tempcta.setTipo(cuentasBancarias.getTipo());
                    tempcta.setMonto(cuentasBancarias.getMonto());
                    tempcta.setNombreDeLaCuenta(cuentasBancarias.getNombreDeLaCuenta());
                cuentasBancariasRepository.save(tempcta);
                System.out.println("Se ha actualizado la informacion de la cuenta con Id: "+ cuentasBancarias.getId());
                return tempcta;

            }else {System.out.println("el Id: "+ uuid+" Del Usuario, no corresponde a la cuenta con ID:" + cuentasBancarias.getId());}
        }else {
            System.out.println("No hay cuentas asociadas a este Usuario");}
        return tempcta;

    }
    public CuentasBancarias createNewAccount(CuentasBancarias cuentasBancarias){
            return cuentasBancariasRepository.save(cuentasBancarias);

    }

    public CuentasBancarias searchAccByItsId(String id){
         CuentasBancarias cuentasBancarias = null;
         if (cuentasBancariasRepository.existsById(id))
         {
             cuentasBancarias = cuentasBancariasRepository.findById(id).get();
             return cuentasBancarias;
         }else {System.out.println("No existe la cuenta");}
         return cuentasBancarias;
    }


}
