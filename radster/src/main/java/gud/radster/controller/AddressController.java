package gud.radster.controller;

import gud.radster.config.EndpointURLs;
import gud.radster.persistance.entity.AddressEntity;
import gud.radster.persistance.entity.TemplateEntity;
import gud.radster.persistance.repository.AddressEntityRepository;
import gud.radster.persistance.repository.TemplateEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost", maxAge = 3600)
@RestController
public class AddressController {

    @Autowired
    AddressEntityRepository repository;


    @RequestMapping(
            value = EndpointURLs.ADDRESS,
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<AddressEntity> getAll() {
        return repository.findAll();
    }

    @RequestMapping(
            value = EndpointURLs.ADDRESS,
            method = RequestMethod.GET,
            params = {"id"},
            produces = MediaType.APPLICATION_JSON_VALUE)
    public AddressEntity getById(@RequestParam("id") String id){
        return repository.findById(id).orElse(null);
    }

//    @RequestMapping(
//            value = EndpointURLs.TEMPLATE_ENTITIES,
//            method = RequestMethod.PUT,
//            produces = MediaType.APPLICATION_JSON_VALUE,
//            consumes = MediaType.APPLICATION_JSON_VALUE)
//    public List<TemplateEntity> postTemplateEntities(@RequestBody List<TemplateEntity> body){
//        repository.deleteAll();
//        repository.saveAll(body);
//        return repository.findAll();
//    }
}
