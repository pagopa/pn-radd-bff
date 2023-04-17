package it.pagopa.pn.radd.bff.service;

import it.pagopa.pn.radd.bff.client.PnRaddFsuClient;
import it.pagopa.pn.radd.bff.converter.TransactionManagementConverter;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {ActTransactionManagementService.class})
@ExtendWith(SpringExtension.class)
class ActTransactionManagementControllerServiceTest {
    @Autowired
    private ActTransactionManagementService actTransactionManagementService;

    @MockBean
    private PnRaddFsuClient pnRaddFsuClient;

    @MockBean
    private TransactionManagementConverter transactionManagementConverter;

}

