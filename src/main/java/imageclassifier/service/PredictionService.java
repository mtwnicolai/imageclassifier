package imageclassifier.service;

import imageclassifier.model.Prediction;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

@Service
public class PredictionService {

    private static final long maxSize = 5 * 1024 * 1024;
    public Prediction predict(MultipartFile image) {

        validateUpload(image);
        BufferedImage decoded = decode(image);
        return new Prediction("cat", 0.947);
    }

    private void validateUpload(MultipartFile image){
        if(image == null || image.isEmpty()){
            throw new IllegalArgumentException("Nenhuma imagem foi enviada.");
        }

        if(image.getSize() > maxSize){
            throw new IllegalArgumentException("A imagem não pode ter mais que 5 MB.");
        }
    }

    private BufferedImage decode (MultipartFile image){
        try (InputStream in = image.getInputStream()) {
            BufferedImage decoded = ImageIO.read(in);

            if(decoded == null) {
                throw new IllegalArgumentException(
                        "O arquivo enviado não é uma imagem válida (aceitos: JPG, PNG, GIF, BMP).");
            }
            return decoded;
        } catch (IOException e){
            throw new IllegalArgumentException("Não foi póssivel ler a imagem enviada.");
        }
    }
}
