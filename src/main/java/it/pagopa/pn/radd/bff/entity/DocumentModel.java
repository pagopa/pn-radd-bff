package it.pagopa.pn.radd.bff.entity;

import it.pagopa.pn.radd.bff.constant.DocumentConstant;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Data
@DynamoDbBean
public class DocumentModel {
	@Getter (onMethod = @__ ({
			@DynamoDbPartitionKey,
			@DynamoDbAttribute (DocumentConstant.FILE_KEY)
			}))
	private String fileKey;

	@Getter (onMethod = @__ ({
			@DynamoDbAttribute (DocumentConstant.TTL)
	}))
	private long ttl;
}
