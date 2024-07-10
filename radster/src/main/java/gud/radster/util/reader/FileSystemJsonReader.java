package gud.radster.util.reader;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import gud.radster.persistance.entity.AddressEntity;
import gud.radster.persistance.repository.AddressEntityRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.List;

@Component
@Slf4j
public class FileSystemJsonReader implements DataReader<AddressEntity> {
    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    AddressEntityRepository repo;

    @Value("${gud.load.data.endpoint}")
    private String filePathString;

    @PostConstruct
    @Override
    public List<AddressEntity> readAll() {
        try {
            readToDatabase();
        } catch (Exception e) {
            log.error("There was a problem to read file {}", filePathString);
            return Collections.emptyList();
        }
        return repo.findAll();
    }

    public void readToDatabase() throws Exception {
        List<AddressEntity> list = objectMapper.readValue(getClass().getResourceAsStream(filePathString), new TypeReference<List<AddressEntity>>() {
        });
        repo.saveAll(list);

    }
}
