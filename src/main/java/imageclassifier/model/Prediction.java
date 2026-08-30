package imageclassifier.model;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import  org.springframework.web.multipart.MultipartFile;

public class Prediction {
    private String label;
    private double confidence;

    public Prediction(String label, double confidence){
        this.label = label;
        this.confidence = confidence;
    }

    public String getLabel(){ return label; }
    public double getConfidence(){ return confidence; }
}
