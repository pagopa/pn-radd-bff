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
			@DynamoDbAttribute (DocumentConstant.DOCUMENT_ID)
			}))
	private String documentId;

	@Getter (onMethod = @__ ({
			@DynamoDbSortKey,
			@DynamoDbAttribute (DocumentConstant.SORT_ID)
	}))
	private String sortId;

	@Getter(onMethod = @__({
			@DynamoDbAttribute(DocumentConstant.PAGEABLE),
			@DynamoDbSecondaryPartitionKey (indexNames = DocumentConstant.GSI_PAGEABLE_ID)
	}))
	private String pageable = DocumentConstant.PAGEABLE_VALUE;
}
