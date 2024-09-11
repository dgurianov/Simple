package gud.radster.persistance.entity;

import java.util.List;

public class AddressBucket {

    List<AddressEntity> addresses;

    public List<AddressEntity> getEntities() {
        return addresses;
    }

    public void setEntities(List<AddressEntity> entities) {
        this.addresses = entities;
    }

    public AddressBucket(List<AddressEntity> entities) {
        this.addresses = entities;
    }
}
