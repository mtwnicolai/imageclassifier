package imageclassifier.service;

import imageclassifier.model.Prediction;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class PredictionService {

    private static final long maxSize = 5 * 1024 * 1024;
    public Prediction predict(MultipartFile image) {

        validate(image);
        return new Prediction("cat", 0.947);
    }

    private void validate(MultipartFile image){
        if(image == null || image.isEmpty()){
            throw new IllegalArgumentException("Nenhuma imagem foi enviada.");
        }

        String contentType = image.getContentType();
        if(contentType == null || !contentType.startsWith("image/")){
            throw new IllegalArgumentException("O arquivo enviado não é uma imagem.");
        }

        if(image.getSize() > maxSize){
            throw new IllegalArgumentException("A imagem não pode ter mais que 5 MB.");
        }
    }
}
