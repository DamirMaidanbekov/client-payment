package kz.dar.university.model;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Document(indexName = "payment")
public class PaymentModel {

    @Id
    @NotNull
    private String id;

    @NotNull(message = "Client ID is required")
    private String clientId;

    @NotNull(message = "Service description is required")
    private String serviceDescription;

    @NotNull(message = "Amount is required")
    private Double amount;

    private String status; // например, "Paid" или "Unpaid"
}
