package eco.app.api_ecommerce_application.web;

import eco.app.api_ecommerce_application.entities.Product;
import eco.app.api_ecommerce_application.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/ecommerce")
public class ProductController {
    @Autowired
    private ProductRepository productRepository ;

    @GetMapping(path = "/products" , produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Product> productList(){
        return productRepository.findAll();
    }
    @PostMapping(path = "/products" , produces = {MediaType.APPLICATION_JSON_VALUE})
    public Product saveProduct(@RequestBody Product product){
        return productRepository.save(product);
    }
    @PutMapping(path = "/products/{id}" , produces = {MediaType.APPLICATION_JSON_VALUE})
    public Product updateProduct(@PathVariable Long id , @RequestBody Product product){
        product.setId(id);
        return productRepository.save(product);
    }
    @DeleteMapping(path = "products/{id}"  , produces = {MediaType.APPLICATION_JSON_VALUE})
    public void deleteProduct(@PathVariable Long id){
        productRepository.deleteById(id);
    }
    @GetMapping(path = "/products")
    public List<Product> searchProduct(@RequestParam String name){
        return productRepository.findByName("%"+name+"%");
    }
}
