package eco.app.api_ecommerce_application.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@AllArgsConstructor @NoArgsConstructor @Data @ToString
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id ;
    @Column(name = "NAME")
    private String name ;
    @Column(name = "PRICE")
    private  double price ;
    @Column(name = "PROMOTION")
    private boolean promotion ;
}
