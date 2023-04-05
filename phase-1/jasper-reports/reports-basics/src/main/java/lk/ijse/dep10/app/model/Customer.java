package lk.ijse.dep10.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@AllArgsConstructor
@Data

public class Customer implements Serializable {
    private int id;
    private String name;
    private String address;


}
