package productapp.orderapplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private ProductFeignClient productFeignClient;

    @PostMapping
    public String placeOrder(@RequestBody String orderInfo) {
        String productDetails = productFeignClient.getProductDetails(1L);
        return "Order placed: " + orderInfo + "\n" + "Product Details: " + productDetails;
    }

    @GetMapping("/{orderId}")
    public String getOrder(@PathVariable Long orderId) {
        return "Order details for ID " + orderId;
    }

    @GetMapping("/product/{productId}")
    public String getOrdersForProduct(@PathVariable Long productId) {
        // Logic to retrieve orders for a specific product
        return "Orders for Product ID " + productId;
        }

}
