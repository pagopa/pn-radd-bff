package it.pagopa.pn.radd.bff.rest;

import io.swagger.annotations.Api;
import it.pagopa.pn.radd.bff.rest.v1.api.DocumentApi;
import it.pagopa.pn.radd.bff.rest.v1.dto.DocumentResponse;
import it.pagopa.pn.radd.bff.service.DocumentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;


@RestController
@Slf4j
@Api(tags = "Document")
@RequiredArgsConstructor
public class DocumentController implements DocumentApi {
	@Qualifier ("raddBffScheduler")
	private final Scheduler scheduler;

	private final DocumentService documentService;
	/**
	 * GET /radd-web/Document/{fileKey}
	 * API utilizzata per il polling dello stato di pronto relativo al caricamento di un documento.
	 *
	 * @param fileKey Identificativo del file (required)
	 * @return OK (status code 200)
	 *         or Not found (status code 404)
	 *         or Internal Server Error (status code 500)
	 */
	@Override
	public Mono<ResponseEntity<DocumentResponse>> getDocumentByFileKey(String fileKey, final ServerWebExchange exchange) {
		return documentService.getDocumentByFileKey(fileKey)
				.map(m -> ResponseEntity.status(HttpStatus.OK).body(m))
				.publishOn(scheduler);
	}
}
