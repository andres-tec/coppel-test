package com.coppeltestmg.coppeltest2.service;

import com.coppeltestmg.coppeltest2.CoppelTest2Application;
import com.coppeltestmg.coppeltest2.entity.Usuarios;
import com.coppeltestmg.coppeltest2.model.Cuentas;
import com.coppeltestmg.coppeltest2.model.UsuariosModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
@Service
public class UsuariosService {
    private static final Logger log = LoggerFactory.getLogger(UsuariosService.class);
    @Autowired
    private final UsuariosRepository usuariosRepository;

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Autowired
    public UsuariosService(UsuariosRepository usuariosRepository) {
        this.usuariosRepository = usuariosRepository;
    }
    ArrayList<Cuentas> cuenta=new ArrayList<>();


    @Bean//seccion donde hacemos el api request hacia la otra base de datos y nos carga la informacion disponicble
    public CommandLineRunner run(RestTemplate restTemplate) throws Exception {


        return args -> {
            ResponseEntity<Cuentas[]> response =
                    restTemplate.getForEntity(
                            "http://localhost:8080/api/cuentas/",
                            Cuentas[].class);
            Cuentas[] cuentas = response.getBody();
            //Arrays.stream(cuentas).forEach(cuentascopy.add(cuentas));
            for (int i = 0; i < cuentas.length; i++) {
                Cuentas cuentascopy =new Cuentas();
                cuentascopy.setId(cuentas[i].getId());
                cuentascopy.setIdUsuario(cuentas[i].getIdUsuario());

                cuentascopy.setBanco(cuentas[i].getBanco());
                cuentascopy.setMonto(cuentas[i].getMonto());
                cuentascopy.setNombreDeLaCuenta(cuentas[i].getNombreDeLaCuenta());
                cuentascopy.setTipo(cuentas[i].getTipo());

                cuenta.add(cuentascopy);
            }

            for (int i=0; i< cuenta.size();i++)
            {
                System.out.println("valor2: "+ cuenta.get(i));
            }

        };
    }

    public List<Usuarios> getAllUsr() {
        return usuariosRepository.findAll();
    }

    public Usuarios getByIdUsr(Long id) {
        return usuariosRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("El ID: " + id + " no existe en la base de datos"));
    }

    public Usuarios deleteByIdUsr(Long uuid) {
        Usuarios tempUsr = null;
        if (usuariosRepository.existsById(uuid)) {
            tempUsr = usuariosRepository.findById(uuid).get();
            usuariosRepository.deleteById(uuid);
        } else {
            System.out.println("El Usuario que intenta Eliminar no existe");
        }
        return tempUsr;
    }

    public Usuarios addNewUsr(Usuarios usuarios) {
        return usuariosRepository.save(usuarios);
    }

    public Usuarios updateUsrById(Long uuid, Usuarios usuarios) {
        Usuarios usrTemp = null;

        if (usuariosRepository.existsById(uuid)) {
            usrTemp = usuariosRepository.findById(uuid).get();
            usrTemp.setNombre(usuarios.getNombre());
            usrTemp.setApellido_Paterno(usuarios.getApellido_Paterno());
            usrTemp.setApellido_Materno(usuarios.getApellido_Materno());
            usrTemp.setEdad(usuarios.getEdad());
            usrTemp.setTelefono(usuarios.getTelefono());
            usrTemp.setCorreo_Electronico(usuarios.getCorreo_Electronico());
            usrTemp.setDireccion_Id(usuarios.getDireccion_Id());
            usuariosRepository.save(usrTemp);
        } else {
            System.out.println("El ID: " + uuid + " No existe");
        }
        return usrTemp;
    }


    public List<Usuarios> getUsrByName(String name) {
        List<Usuarios> usuarios = null;
        usuarios = usuariosRepository.findAllByNombre(name);
        if (usuarios.size() > 0) {
            return usuarios;
        } else {
            System.out.println("No existe ninguna coincidencia con el Nombre: " + name);
        }
        return usuarios;
    }


    //aqui se crea un cliente feign para mostrar al cliente y la coleccion de cuentas
    public List<UsuariosModel> mostrarUsuario() {
        List<UsuariosModel> usuarios = new ArrayList<>();
        List<Usuarios> usuariosList = null;
        try {
            usuariosList = usuariosRepository.findAll();
        } catch (Exception e) {
            throw e;
        }
        if (usuariosList.size() > 0) {
            usuariosList.stream().forEach(ul -> {
                UsuariosModel usuariosModel = new UsuariosModel();
                usuariosModel.setUuid(ul.getUuid());
                usuariosModel.setNombre(ul.getNombre());
                usuariosModel.setApellido_Paterno(ul.getApellido_Paterno());
                usuariosModel.setApellido_Materno(ul.getApellido_Materno());
                usuariosModel.setEdad(ul.getEdad());
                usuariosModel.setCorreo_Electronico(ul.getCorreo_Electronico());
                usuariosModel.setTelefono(ul.getTelefono());
                usuariosModel.setDireccion_Id(ul.getDireccion_Id());
                Cuentas ctasUsr = new Cuentas();
                List<Cuentas> cuentasTotal =new ArrayList<>();
                try {


                        for (int i=0; i< cuenta.size(); i++)
                        {


                            if (ul.getUuid() == cuenta.get(i).getIdUsuario()  ) {
                                ctasUsr.setId(cuenta.get(i).getId());
                                ctasUsr.setIdUsuario(cuenta.get(i).getIdUsuario());
                                ctasUsr.setBanco(cuenta.get(i).getBanco());
                                ctasUsr.setMonto(cuenta.get(i).getMonto());
                                ctasUsr.setTipo(cuenta.get(i).getTipo());
                                ctasUsr.setNombreDeLaCuenta(cuenta.get(i).getNombreDeLaCuenta());

                                cuentasTotal.add(ctasUsr);
                            }
                        }

                } catch (Exception e) {
                    throw e;
                }
                usuariosModel.setCuentasbancarias(cuentasTotal);
                usuarios.add(usuariosModel);
            });
        }
        return usuarios;

    }
}