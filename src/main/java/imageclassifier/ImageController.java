package imageclassifier;

import imageclassifier.model.Prediction;
import imageclassifier.service.PredictionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class ImageController {

    @GetMapping("/test")
    public String test(){
        return "Image Classifier funcionando!";
    }

    @GetMapping("/predict")
    public Prediction predict() {
        return PredictionService.predict();
    }

    @PostMapping("/predict")
    public Prediction predictImage(@RequestParam("image") MultipartFile image){
        return PredictionService.predict(image);
    }
}
