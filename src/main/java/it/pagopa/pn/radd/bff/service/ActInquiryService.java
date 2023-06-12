package it.pagopa.pn.radd.bff.service;

import it.pagopa.pn.radd.bff.client.PnRaddFsuClient;
import it.pagopa.pn.radd.bff.converter.ActInquiryConverter;
import it.pagopa.pn.radd.bff.generated.openapi.server.v1.dto.ActInquiryResponse;
import lombok.CustomLog;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
@CustomLog
public class ActInquiryService {

    private final PnRaddFsuClient pnRaddFsuClient;
    private final ActInquiryConverter actInquiryConverter;

    public Mono<ActInquiryResponse> actInquiry(String uid, String recipientTaxId, String recipientType, String qrCode) {
        return pnRaddFsuClient.actInquiry(uid, recipientTaxId, recipientType, qrCode)
                .map(actInquiryConverter::actInquiryDtoToResponse);
    }
}
