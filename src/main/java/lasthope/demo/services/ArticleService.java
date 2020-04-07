package lasthope.demo.services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import lasthope.demo.domain.Article;
import lasthope.demo.dto.ArticleDetailsDto;
import lasthope.demo.repositories.ArticleRepository;

@Service
public class ArticleService {

    @Value("${upload.directory}")
    private String uploadDirectory;

    private final ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public void upload(MultipartFile file, ArticleDetailsDto articleDetailsDto) throws IOException {

        String filePath = uploadDirectory.concat(uploadDirectory).concat(StringUtils.cleanPath(file.getOriginalFilename()));
        Files.copy(file.getInputStream(), Paths.get(filePath), StandardCopyOption.REPLACE_EXISTING);

        articleRepository.save(mapToArticle(articleDetailsDto, filePath));
    }

    private Article mapToArticle(ArticleDetailsDto articleDetailsDto, String filePath) throws IOException {
        Article article = new Article();
        article.setContent(extractContent(filePath));
        return article;
    }

    private String extractContent(String filePath) throws IOException {
        PDDocument document = PDDocument.load(new File(filePath));
        return new PDFTextStripper().getText(document);
    }

}
