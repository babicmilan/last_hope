package lasthope.demo.domain;

import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "article", type = "pdf", shards = 1)
public class Article {

    private Long id;

    private String name;

    private String title;

    private String authorName;

    private String authorSurname;

    private String keyWords;

    @Field(type = FieldType.Text, analyzer = "serbian_analyzer")
    private String content;

    private String scientificField;

}
