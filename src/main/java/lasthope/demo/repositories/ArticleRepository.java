package lasthope.demo.repositories;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import lasthope.demo.domain.Article;

@Repository
public interface ArticleRepository extends ElasticsearchRepository<Article, Long> {

}
