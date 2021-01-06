package Lab3;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class Product {

    private String name;
    private Date dateOfShipment;
    private Integer totalWeight;

}
