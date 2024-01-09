package productapp.orderapplication;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "product-microservice", url = "http://localhost:8081")
public interface ProductFeignClient {

    @GetMapping("/products/{productId}")
    String getProductDetails(@PathVariable Long productId);
}
