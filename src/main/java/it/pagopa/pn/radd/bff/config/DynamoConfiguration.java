package it.pagopa.pn.radd.bff.config;

import it.pagopa.pn.radd.bff.log.AwsClientLoggerInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.DefaultCredentialsProvider;
import software.amazon.awssdk.core.client.config.ClientOverrideConfiguration;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedAsyncClient;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbAsyncClient;

@Slf4j
@Configuration
public class DynamoConfiguration {
	private final String awsRegion;

	public DynamoConfiguration (@Value ("${aws.region}") String awsRegion) {
		this.awsRegion = awsRegion;
	}

	@Bean
	public DynamoDbEnhancedAsyncClient dynamoDb () {
		DynamoDbAsyncClient asyncClient = DynamoDbAsyncClient.builder()
				.region(Region.of(awsRegion))
				.credentialsProvider(DefaultCredentialsProvider.create())
				.overrideConfiguration(ClientOverrideConfiguration.builder()
						.addExecutionInterceptor(new AwsClientLoggerInterceptor())
						.build())
				.build();
		return DynamoDbEnhancedAsyncClient.builder()
				.dynamoDbClient(asyncClient)
				.build();
	}
}
