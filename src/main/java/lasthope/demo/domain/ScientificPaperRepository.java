package lasthope.demo.domain;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScientificPaperRepository extends ElasticsearchRepository<Article, Long> {

}
