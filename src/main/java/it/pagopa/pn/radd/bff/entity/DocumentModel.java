package it.pagopa.pn.radd.bff.entity;

import it.pagopa.pn.radd.bff.constant.DocumentConstant;
import lombok.Data;
import lombok.Getter;
import org.springframework.cache.annotation.Cacheable;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.*;

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
