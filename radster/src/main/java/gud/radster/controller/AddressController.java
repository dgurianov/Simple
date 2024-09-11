package gud.radster.controller;

import gud.radster.config.EndpointURLs;
import gud.radster.persistance.entity.AddressBucket;
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

import java.util.ArrayList;
import java.util.List;
//URL should match with the URL that is hoted by Apache , to go through CORS
@CrossOrigin(origins = "http://localhost", maxAge = 3600)
@RestController
public class AddressController {

    @Autowired
    AddressEntityRepository repository;


    @RequestMapping(
            value = EndpointURLs.ADDRESS,
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public AddressBucket getAll() {
        return new AddressBucket(repository.findAll());
    }

    @RequestMapping(
            value = EndpointURLs.ADDRESS,
            method = RequestMethod.GET,
            params = {"id"},
            produces = MediaType.APPLICATION_JSON_VALUE)
    public AddressEntity getById(@RequestParam("id") String id){
        return repository.findById(id).orElse(null);
    }

    @RequestMapping(
            value = EndpointURLs.ADDRESS,
            method = RequestMethod.GET,
            params = {"offset","amount"},
            produces = MediaType.APPLICATION_JSON_VALUE)
    public AddressBucket getNextSet(@RequestParam("offset") int offset,
                                    @RequestParam("amount") int amount
    ){
        List<AddressEntity> all = repository.findAll();
        if(
                all.size() == offset //Start is out of range of elements
            ||  amount <= 0   // No items required
            ||  offset < 0    //Wrong start position
            ||  offset + amount > all.size()  // End ouf selection goes out of available range
        )  return new AddressBucket(new ArrayList<>());

        if(all.size() <= amount ) return new AddressBucket(all.subList(offset-1,all.size()-1)); // If requested 5 elemets out of 3 , return all elements that left after  offset
        if(offset ==0 ) return new AddressBucket(all.subList(0,amount-1)); // Special case when offset can spill out of the range.

        return new AddressBucket(all.subList(offset-1,(offset-1)+amount)); // Return next amount of elements  starting from offset element ID
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
