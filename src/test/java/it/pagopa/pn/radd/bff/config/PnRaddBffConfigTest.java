package it.pagopa.pn.radd.bff.config;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class PnRaddBffConfigTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>default or parameterless constructor of {@link PnRaddBffConfig}
     *   <li>{@link PnRaddBffConfig#setClientPnDataVaultBasepath(String)}
     *   <li>{@link PnRaddBffConfig#setClientPnRaddFsuBasepath(String)}
     *   <li>{@link PnRaddBffConfig#getClientPnDataVaultBasepath()}
     *   <li>{@link PnRaddBffConfig#getClientPnRaddFsuBasepath()}
     * </ul>
     */
    @Test
    void testConstructor() {
        PnRaddBffConfig actualPnRaddBffConfig = new PnRaddBffConfig();
        actualPnRaddBffConfig.setClientPnDataVaultBasepath("Client Pn Data Vault Basepath");
        actualPnRaddBffConfig.setClientPnRaddFsuBasepath("Client Pn Radd Fsu Basepath");
        assertEquals("Client Pn Data Vault Basepath", actualPnRaddBffConfig.getClientPnDataVaultBasepath());
        assertEquals("Client Pn Radd Fsu Basepath", actualPnRaddBffConfig.getClientPnRaddFsuBasepath());
    }
}

