package it.pagopa.pn.radd.bff.repository;

import it.pagopa.pn.radd.bff.entity.DocumentModel;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Mono;

@ContextConfiguration (classes = {DocumentRepositoryImpl.class})
@ExtendWith (SpringExtension.class)
class DocumentRepositoryImplTest {
	@Autowired
	private DocumentRepositoryImpl documentRepositoryImpl;

	/**
	 * Method under test: {@link DocumentRepositoryImpl#findByFileKey(String)}
	 */
	@Test
	@Disabled ("TODO: Complete this test")
	void testFindByFileKey () {

		String fileKey = "";

		// Act
		Mono<DocumentModel> actualFindByFileKeyResult = this.documentRepositoryImpl.findByFileKey(fileKey);

	}
}

