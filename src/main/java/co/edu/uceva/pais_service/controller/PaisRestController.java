package co.edu.uceva.pais_service.controller;
import co.edu.uceva.pais_service.model.entities.Pais;
import co.edu.uceva.pais_service.model.service.IPaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/pais-service")
public class PaisRestController {
    @Autowired
    IPaisService paisService;

    /**
     *EndPoint para recibir  un saludo
     * @param nombre Es el nombre que envian desde la url
     * @return Un saludo
     */
    @GetMapping("/Pais/{nombre}")
    public String imprimir(@PathVariable("nombre") String nombre){//TODO Hacer un saludo personalizado con el nombre

        return "Pais "+ nombre;
    }
    @GetMapping("/paises")
    public List<Pais> listar() {
        return paisService.findAll();
    }
    @GetMapping("/paises/{id}")
    public Pais buscrPais(@PathVariable("id")Long id){//pathvariable es para sacar de la url esa palabra id
        return paisService.findById(id);

    }
    @PostMapping("/paises")
    public Pais crearPais(@RequestBody Pais pais){//request peticion del navegador body cuerpo
        return paisService.save(pais);
    }
    @DeleteMapping("/paises/{id}")
    public void borrarPais(@PathVariable("id")Long id){ //long id misma variables id
        Pais pais;
        pais = paisService.findById(id);//pasi service busque pais con id tal
         paisService.delete(pais);//pais service borra el pais
    }
    @PutMapping("/paises")
    public Pais actualizarPais(@RequestBody Pais pais) {
        return paisService.update(pais);
    }
}
