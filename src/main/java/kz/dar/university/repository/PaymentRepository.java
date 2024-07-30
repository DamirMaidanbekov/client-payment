package kz.dar.university.repository;

import kz.dar.university.model.PaymentModel;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface PaymentRepository extends ElasticsearchRepository<PaymentModel, String> {
}

