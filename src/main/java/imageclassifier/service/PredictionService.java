package imageclassifier.service;

import imageclassifier.model.Prediction;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

public class PredictionService {

    public static Prediction predict(){
        return new Prediction("cat", 0.947);
    }

    public static Prediction predict(MultipartFile image){
        if(image == null || image.isEmpty()){
            throw new IllegalArgumentException("Nenhuma imagem foi enviada.");
        }

        String contentType = image.getContentType();
        if(contentType == null || !contentType.startsWith("image/")){
            throw new IllegalArgumentException("O arquivo enviado não é uma imagem.");
        }

        long maxSize = 5 * 1024 * 1024;
        if(image.getSize() > maxSize){
            throw new IllegalArgumentException("A imagem não pode ter mais que 5 MB.");
        }

        return new Prediction("cat", 0.947);
    }
}
