package it.pagopa.pn.radd.bff.queue.consumer;

import it.pagopa.pn.api.dto.events.GenericEvent;
import it.pagopa.pn.api.dto.events.StandardEventHeader;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class PnRaddBffEvent implements GenericEvent<StandardEventHeader, PnRaddBffEvent.Payload> {
    private StandardEventHeader header;
    private Payload payload;

    @Data
    public static class Payload {
        private @NotEmpty String key;
        private @NotEmpty String versionId;
        private @NotEmpty String documentType;
        private @NotEmpty String documentStatus;
        private @NotEmpty String contentType;
        private @NotEmpty String checksum;
        private String retentionUntil;
        private @NotEmpty String clientShortCode;
    }
}
