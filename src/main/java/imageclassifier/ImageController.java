package imageclassifier;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ImageController {

    @GetMapping("/test")
    public String test(){
        return "Image Classifier funcionando!";
    }
}
