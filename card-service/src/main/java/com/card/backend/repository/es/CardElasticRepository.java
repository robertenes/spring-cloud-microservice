package com.card.backend.repository.es;

import com.card.backend.model.es.CardModel;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardElasticRepository extends ElasticsearchRepository<CardModel, String> {
}
