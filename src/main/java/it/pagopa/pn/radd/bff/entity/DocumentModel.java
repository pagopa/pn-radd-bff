package it.pagopa.pn.radd.bff.entity;

import it.pagopa.pn.radd.bff.constant.DocumentConstant;
import lombok.Data;
import lombok.Getter;
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

	@Getter(onMethod = @__({
			@DynamoDbAttribute(DocumentConstant.PAGEABLE),
			@DynamoDbSecondaryPartitionKey (indexNames = DocumentConstant.GSI_PAGEABLE_ID)
	}))
	private String pageable = DocumentConstant.PAGEABLE_VALUE;
}
