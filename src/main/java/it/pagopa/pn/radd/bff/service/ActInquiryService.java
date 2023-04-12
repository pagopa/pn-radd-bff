package it.pagopa.pn.radd.bff.service;

import it.pagopa.pn.radd.bff.client.PnRaddFsuClient;
import it.pagopa.pn.radd.bff.converter.ActInquiryConverter;
import it.pagopa.pn.radd.bff.rest.v1.dto.ActInquiryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ActInquiryService {

    private final PnRaddFsuClient pnRaddFsuClient;

    private final ActInquiryConverter actInquiryConverter;

    public Mono<ActInquiryResponse> actInquiry(String uid, String recipientTaxId, String recipientType, String qrCode) {
            return pnRaddFsuClient.actInquiry(uid, recipientTaxId, recipientType, qrCode)
                    .map(actInquiryConverter::actInquiryDtoToResponse);
    }
}
