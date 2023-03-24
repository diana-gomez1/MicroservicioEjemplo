package co.edu.uceva.pais_service.model.service;

import co.edu.uceva.pais_service.model.dao.IPaisDao;
import co.edu.uceva.pais_service.model.entities.Pais;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * Esta clase implementa el servicio de pais
 * un servicio es un objeto controlado por el contenedor de Spring
 */
@Service
public class PaisServiceImpl implements IPaisService{
    @Autowired
    IPaisDao paisDao;
    @Override
    public Pais save(Pais pais) {
          return paisDao.save(pais);
    }

    @Override
    public void delete(Pais pais) {
        paisDao.delete(pais);
    }

    @Override
    public Pais update(Pais pais) {
        return paisDao.save(pais);
    }

    @Override
    public List<Pais> findAll() {
        return (List<Pais>)  paisDao.findAll();
    }

    @Override
    public Pais findById(Long id) {
    //opcionales : objeto que puede retornar un objeto o un mensaje de error 85
        return (Pais) paisDao.findById(id).get();
    }
}
