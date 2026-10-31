package imageclassifier.model;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import  org.springframework.web.multipart.MultipartFile;

public record Prediction(String label, double confidence) {}