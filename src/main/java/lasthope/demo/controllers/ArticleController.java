package lasthope.demo.controllers;

import java.io.IOException;

import javax.validation.constraints.NotNull;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import lasthope.demo.dto.ArticleDetailsDto;
import lasthope.demo.services.ArticleService;

@RestController("/article")
public class ArticleController {

    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @PostMapping("/upload")
    public void upload(@RequestParam("file") @NotNull MultipartFile file) throws IOException {
        articleService.upload(file, new ArticleDetailsDto());
    }

    @GetMapping("/test")
    public void test() {
        System.out.println("ok");
    }


}
