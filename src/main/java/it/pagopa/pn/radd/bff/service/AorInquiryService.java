package it.pagopa.pn.radd.bff.service;

import it.pagopa.pn.radd.bff.client.PnRaddFsuClient;
import it.pagopa.pn.radd.bff.converter.AorInquiryConverter;
import it.pagopa.pn.radd.bff.generated.openapi.server.v1.dto.AORInquiryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class AorInquiryService {

    private final PnRaddFsuClient pnRaddFsuClient;
    private final AorInquiryConverter aorInquiryConverter;

    public Mono<AORInquiryResponse> aorInquiry(String uid, String recipientTaxId, String recipientType) {
        return pnRaddFsuClient.aorInquiry(uid, recipientTaxId, recipientType)
                .map(aorInquiryConverter::aorInquiryDtoToResponse);
    }
}
