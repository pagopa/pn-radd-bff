# Mock-server

Mock-server è un componente in formato container utilizzato per realizzare velocemente mock per i servizi esterni
da utilizzare in ambienti di test o per mimare il servizio reale prima che questo sia disponibile.

Documentazione su https://www.mock-server.com/

## Avviare il mock-sever in locale
Per avviare in locale il mockserver utilizzare il comando `docker-compose mockserver up`

## Mock-server configuration

La configurazione del mock server è fatta tramite file json nella cartella _config/Mockserver/mock_rest_configs_.

### Mock per RADD

#### actDocumentInquiry

Path: `/radd-private/api/v1/act/inquiry`

Use cases:

| recipientTaxId   | Status Code | Valido                                              |
|------------------|-------------|-----------------------------------------------------|
| GNIGNI80A01H501R | 401         |                                                     |
| FNIFNA80A01H501G | 400         |                                                     |
| FRMTTR76M06B715E | 405         |                                                     |
| RFNNTR76M06B715E | 403         |                                                     |
| CIACIA80A01H501X | 500         |                                                     |
| GNIGNI80A01H501R | 200         | OK                                                  |
| RSSSRG80A01F839I | 200         | Stampa già eseguita                                 |
| VIAVIA90A01H501X | 200         | OK (startTransaction 500)                           |
| PLOMRC01P30L736Y | 200         | OK (startTransaction KO)                            |
| TSTGNN80A01F839X | 200         | OK (startTransaction Not Ready)                     |
| VTOMRC01P30L736Y | 200         | OK (completeTransaction KO)                         |
| LBOMRC01P30L736Y | 200         | OK (completeTransaction Transazione Inesistente)    |
| AEDMRC01P30L736Y | 200         | OK (completeTransaction Transazione Già Completata) |
| MADMRC01P30L736Y | 200         | OK (completeTransaction 500)                        |
| ZZAMRC01P30L736Y | 200         | OK (abortTransaction OK)                            |
| GTAMRC01P30L736Y | 200         | OK (abortTransaction KO)                            |
| ZTLMRC01P30L736Y | 200         | OK (abortTransaction Transazione Inesistente)       |
| DAMMRC01P30L736Y | 200         | OK (abortTransaction Transazione Già Completata)    |
| RADMRC01P30L736Y | 200         | OK (abortTransaction 500)                           |
| LNALNI80A01H501T | 200         | QrCode/CF non valido/i                              |
 | PPPPLT80A01H501V | 200         | Documenti non più disponibili                       | 
| BSTGNN80A01F839X | 200         | Stampa già eseguita                                 |
| BLOMRC01P30L736Y | 200         | KO                                                  |

### aorDocumentInquiry

Path: `/radd-private/api/v1/aor/inquiry`

Use cases:

| recipientTaxId   | Status Code | Valido                                              |
|------------------|-------------|-----------------------------------------------------|
| GNIGNI80A01H501R | 401         |                                                     |
| FNIFNA80A01H501G | 400         |                                                     |
| FRMTTR76M06B715E | 405         |                                                     |
| RFNNTR76M06B715E | 403         |                                                     |
| CIACIA80A01H501X | 500         |                                                     |
| GNIGNI80A01H501R | 200         | OK                                                  |
| RSSSRG80A01F839I | 200         | KO                                                  |
| VIAVIA90A01H501X | 200         | OK (startTransaction 500)                           |
| PLOMRC01P30L736Y | 200         | OK (startTransaction KO)                            |
| TSTGNN80A01F839X | 200         | OK (startTransaction Not Ready)                     |
| VTOMRC01P30L736Y | 200         | OK (completeTransaction KO)                         |
| LBOMRC01P30L736Y | 200         | OK (completeTransaction Transazione Inesistente)    |
| AEDMRC01P30L736Y | 200         | OK (completeTransaction Transazione Già Completata) |
| MADMRC01P30L736Y | 200         | OK (completeTransaction 500)                        |
| ZZAMRC01P30L736Y | 200         | OK (abortTransaction OK)                            |
| GTAMRC01P30L736Y | 200         | OK (abortTransaction KO)                            |
| ZTLMRC01P30L736Y | 200         | OK (abortTransaction Transazione Inesistente)       |
| DAMMRC01P30L736Y | 200         | OK (abortTransaction Transazione Già Completata)    |
| RADMRC01P30L736Y | 200         | OK (abortTransaction 500)                           |


### documentUpload

Path: `/radd-private/api/v1/documents/upload`

Use cases:

| Checksum                                                         | Status Code | Valido |
|------------------------------------------------------------------|-------------|--------|
| 708F4C8216F30FA6007F8E2F316ECC935D94057202FC5D8008BCCC118EA12560 | 401         |        |
| A932E7C87F471C1EE7A5E17F0EC746F628CF0D94F06CA5E12AF5D8173C3F694B | 400         |        |
| L122E7C87F471C1EE7A5E17F0EC746F628CF0D94F06CA5E12AF5D8173C3F694B | 403         |        |
| F61FC75C4D4B3A4A4D4E273F08A6E8C299372DFD873A814ED6B92159D7A9F9F1 | 405         |        |
| C6F02E6D8FBB89A2516F20D44729E6821E0D6E997C2D187E6D0C03353D8721D8 | 500         |        |
| 708F4C8216F30FA6007F8E2F316ECC935D94057202FC5D8008BCCC118EA12560 | 200         | OK     |
| 259D8BCEFFA054E79AB740847D6B8FAF1C92067E1F27CBEBCAD2C07D9B962A34 | 200         | KO     |

## actTransactionManagement

### startTransaction

Path: `/radd-private/api/v1/act/transaction/start`

Use cases:

| recipientTaxId   | Status Code | Valido                                              |
|------------------|-------------|-----------------------------------------------------|
| GNIGNI80A01H501R | 401         |                                                     |
| FNIFNA80A01H501G | 400         |                                                     |
| FRMTTR76M06B715E | 405         |                                                     |
| RFNNTR76M06B715E | 403         |                                                     |
| VIAVIA80A01H501X | 500         |                                                     |
| GNIGNI80A01H501R | 200         | OK                                                  |
| VTOMRC01P30L736Y | 200         | OK (completeTransaction KO)                         |
| LBOMRC01P30L736Y | 200         | OK (completeTransaction Transazione Inesistente)    |
| AEDMRC01P30L736Y | 200         | OK (completeTransaction Transazione Già Completata) |
| MADMRC01P30L736Y | 200         | OK (completeTransaction 500)                        |
| GTAMRC01P30L736Y | 200         | OK (abortTransaction KO)                            |
| ZTLMRC01P30L736Y | 200         | OK (abortTransaction Transazione Inesistente)       |
| DAMMRC01P30L736Y | 200         | OK (abortTransaction Transazione Già Completata)    |
| RADMRC01P30L736Y | 200         | OK (abortTransaction 500)                           |
| PLOMRC01P30L736Y | 200         | KO                                                  |
| TSTGNN80A01F839X | 200         | NotReady                                            |

### completeTransaction

Path: `/radd-private/api/v1/act/transaction/complete`

Use cases:

| operationId                          | Status Code | Valido                     |
|--------------------------------------|-------------|----------------------------|
| 9795ea34-e4e9-11ed-b5ea-0242ac120002 | 401         |                            |
| c447c68d-6d22-4c95-9f2b-f53f8d9392ee | 400         |                            |
| 76e3d28f-70e4-4d2b-b4f1-cad4c4f20a0e | 405         |                            |
| f59f05e6-9d88-4c7d-9bb3-75c9828f9995 | 403         |                            |
| 70d5f0c2-0c5c-4745-b5a5-5b0fb15d694d | 500         |                            |
| 9795ea34-e4e9-11ed-b5ea-0242ac120002 | 200         | OK                         |
| 4d4c70e7-8a69-4a60-b2e2-0a36b8d17bc5 | 200         | KO                         |
| 9da7a31a-c29c-4760-91b8-7d2f59d27734 | 200         | Transazione inesistente    |
| 6ee9f7d9-6b3e-431a-a39f-70f098b66002 | 200         | Transazione già completata |

### abortTransaction

Path: `/radd-private/api/v1/act/transaction/abort`

Use cases:

| operationId                          | Status Code | Valido                     |
|--------------------------------------|-------------|----------------------------|
| 8ed10708-e511-11ed-b5ea-0242ac120002 | 401         |                            |
| 8ed10ae6-e511-11ed-b5ea-0242ac120002 | 400         |                            |
| 8ed109c4-e511-11ed-b5ea-0242ac120002 | 405         |                            |
| 8ed1083e-e511-11ed-b5ea-0242ac120002 | 403         |                            |
| 8ed105dc-e511-11ed-b5ea-0242ac120002 | 500         |                            |
| 8ed10708-e511-11ed-b5ea-0242ac120002 | 200         | OK                         |
| 8ed0f8da-e511-11ed-b5ea-0242ac120002 | 200         | KO                         |
| 8ed1024e-e511-11ed-b5ea-0242ac120002 | 200         | Transazione inesistente    |
| 8ed10442-e511-11ed-b5ea-0242ac120002 | 200         | Transazione già completata |

## aorTransactionManagement
### startTransaction

Path: `/radd-private/api/v1/aor/transaction/start`

Use cases:

| recipientTaxId   | Status Code | Valido                                              |
|------------------|-------------|-----------------------------------------------------|
| GNIGNI80A01H501R | 401         |                                                     |
| FNIFNA80A01H501G | 400         |                                                     |
| FRMTTR76M06B715E | 405         |                                                     |
| RFNNTR76M06B715E | 403         |                                                     |
| VIAVIA90A01H501X | 500         |                                                     |
| GNIGNI80A01H501R | 200         | OK                                                  |
| VTOMRC01P30L736Y | 200         | OK (completeTransaction KO)                         |
| LBOMRC01P30L736Y | 200         | OK (completeTransaction Transazione Inesistente)    |
| AEDMRC01P30L736Y | 200         | OK (completeTransaction Transazione Già Completata) |
| MADMRC01P30L736Y | 200         | OK (completeTransaction 500)                        |
| GTAMRC01P30L736Y | 200         | OK (abortTransaction KO)                            |
| ZTLMRC01P30L736Y | 200         | OK (abortTransaction Transazione Inesistente)       |
| DAMMRC01P30L736Y | 200         | OK (abortTransaction Transazione Già Completata)    |
| RADMRC01P30L736Y | 200         | OK (abortTransaction 500)                           |
| PLOMRC01P30L736Y | 200         | KO                                                  |
| TSTGNN80A01F839X | 200         | NotReady                                            |

### completeTransaction

Path: `/radd-private/api/v1/aor/transaction/complete`

Use cases:

| operationId                          | Status Code | Valido                     |
|--------------------------------------|-------------|----------------------------|
| 9795ea34-e4e9-11ed-b5ea-0242ac120002 | 401         |                            |
| c447c68d-6d22-4c95-9f2b-f53f8d9392ee | 400         |                            |
| 76e3d28f-70e4-4d2b-b4f1-cad4c4f20a0e | 405         |                            |
| f59f05e6-9d88-4c7d-9bb3-75c9828f9995 | 403         |                            |
| 70d5f0c2-0c5c-4745-b5a5-5b0fb15d694d | 500         |                            |
| 9795ea34-e4e9-11ed-b5ea-0242ac120002 | 200         | OK                         |
| 4d4c70e7-8a69-4a60-b2e2-0a36b8d17bc5 | 200         | KO                         |
| 9da7a31a-c29c-4760-91b8-7d2f59d27734 | 200         | Transazione inesistente    |
| 6ee9f7d9-6b3e-431a-a39f-70f098b66002 | 200         | Transazione già completata |

### abortTransaction

Path: `/radd-private/api/v1/aor/transaction/abort`

Use cases:

| operationId                          | Status Code | Valido                     |
|--------------------------------------|-------------|----------------------------|
| 8ed10708-e511-11ed-b5ea-0242ac120002 | 401         |                            |
| 8ed10ae6-e511-11ed-b5ea-0242ac120002 | 400         |                            |
| 8ed109c4-e511-11ed-b5ea-0242ac120002 | 405         |                            |
| 8ed1083e-e511-11ed-b5ea-0242ac120002 | 403         |                            |
| 8ed105dc-e511-11ed-b5ea-0242ac120002 | 500         |                            |
| 8ed10708-e511-11ed-b5ea-0242ac120002 | 200         | OK                         |
| 8ed0f8da-e511-11ed-b5ea-0242ac120002 | 200         | KO                         |
| 8ed1024e-e511-11ed-b5ea-0242ac120002 | 200         | Transazione inesistente    |
| 8ed10442-e511-11ed-b5ea-0242ac120002 | 200         | Transazione già completata |


## notificationInquiry
### operationAct

Path: `/radd-private/api/v1/act/operations/by-id/{operationId}`

Use cases:

| operationId                      | Status Code | Valido                     |
|----------------------------------|-------------|----------------------------|
| 76d9a1f225f24c24a05e00a0d9a9aaba | 401         |                            |
| 2c12e95533d0444991e8f18bb232a44b | 400         |                            |
| 4926a0b4c4fc4d4f9a5bc5e5f5aefb47 | 403         |                            |
| 95150da94bc24a52a839628d9f9c37d8 | 404         |                            |
| 12550da94bc24a52a839628d9f9c37d8 | 405         |                            |
| 9415a0b4c4fc4d4f9a5bc5e5f5aefb47 | 500         |                            |
| 2bb5c29e0cf411ed861d0242ac120002 | 200         | OK                         |
| 67d8a1f225f24c13a05e00a0d8a8aaba | 200         | KO                         |
| 78c1f2769c8e4ba084a62e778a143d67 | 200         | Nessun elemento associato  |

### operationAor

Path: `/radd-private/api/v1/aor/operations/by-id/{operationId}`

Use cases:

| operationId                      | Status Code | Valido                     |
|----------------------------------|-------------|----------------------------|
| 76d9a1f225f24c24a05e00a0d9a9aaba | 401         |                            |
| 2c12e95533d0444991e8f18bb232a44b | 400         |                            |
| 4926a0b4c4fc4d4f9a5bc5e5f5aefb47 | 403         |                            |
| 95150da94bc24a52a839628d9f9c37d8 | 404         |                            |
| 12550da94bc24a52a839628d9f9c37d8 | 405         |                            |
| 9415a0b4c4fc4d4f9a5bc5e5f5aefb47 | 500         |                            |
| 2bb5c29e0cf411ed861d0242ac120002 | 200         | OK                         |
| 67d8a1f225f24c13a05e00a0d8a8aaba | 200         | KO                         |
| 78c1f2769c8e4ba084a62e778a143d67 | 200         | Nessun elemento associato  |

### operationsAct

Path: `/radd-private/api/v1/act/operations/by-iun/`

Use cases:

| iun                       | Status Code | Valido                    |
|---------------------------|-------------|---------------------------|
| GKMK-SPNV-BFYT-202209-F-1 | 401         |                           |
| RJLM-QGXC-HPZD-202209-G-1 | 400         |                           |
| NXPT-VWUD-LAIY-202209-H-1 | 405         |                           |
| FZEB-JKRA-COGW-202209-I-1 | 403         |                           |
| JTXA-EQYU-CRZG-202209-O-1 | 404         |                           |
| MTIS-UYFH-DPVC-202209-J-1 | 500         |                           |
| LJLH-GNTJ-DVXR-202209-J-1 | 200         | OK                        |
| LXNR-QPMS-OGTW-202209-K-1 | 200         | KO                        |
| BVMK-NSRI-HFOL-202209-N-1 | 200         | Nessun Elemento Associato |

### operationsAor

Path: `/radd-private/api/v1/aor/operations/by-iun/`

Use cases:

| iun                       | Status Code | Valido                    |
|---------------------------|-------------|---------------------------|
| GKMK-SPNV-BFYT-202209-F-1 | 401         |                           |
| RJLM-QGXC-HPZD-202209-G-1 | 400         |                           |
| NXPT-VWUD-LAIY-202209-H-1 | 405         |                           |
| FZEB-JKRA-COGW-202209-I-1 | 403         |                           |
| JTXA-EQYU-CRZG-202209-O-1 | 404         |                           |
| MTIS-UYFH-DPVC-202209-J-1 | 500         |                           |
| LJLH-GNTJ-DVXR-202209-J-1 | 200         | OK                        |
| LXNR-QPMS-OGTW-202209-K-1 | 200         | KO                        |
| BVMK-NSRI-HFOL-202209-N-1 | 200         | Nessun Elemento Associato |

### operationsActDetails

Path: `/radd-private/api/v1/act/operations/by-internalId/{internalId}`

Use cases:

| InternalId                              | Status Code | Valido                    |
|-----------------------------------------|-------------|---------------------------|
| PF-06c64ca7-8b20-4b7f-9b6a-11f91315b89c | 401         |                           |
| PF-1f994c71-e5d5-4e5c-a9a9-23ebad4d30d2 | 400         |                           |
| PG-4fa4e3a8-19f2-46e3-ba81-9f1aebbc44ec | 405         |                           |
| PF-5c584ee7-09e8-4027-b1f9-c19a9a8e79b1 | 403         |                           |
| PG-81a2f2dc-5109-4659-b9a8-8e52ce89a03a | 404         |                           |
| PF-a5068d34-2677-4bfa-b0b9-945f0d37d7c5 | 500         |                           |
| PF-4fc75df3-0913-407e-bdaa-e50329708b7d | 200         | OK                        |
| PF-d0556f95-6de8-4a92-aa2e-5479f6a1d6d7 | 200         | KO                        |
| PF-e6c22e6b-1276-44a6-a50a-5c0e4639425d | 200         | Nessun Elemento Associato |

### operationsAorDetails

Path: `/radd-private/api/v1/aor/operations/by-internalId/{internalId}`

Use cases:

| InternalId                              | Status Code | Valido                    |
|-----------------------------------------|-------------|---------------------------|
| PF-06c64ca7-8b20-4b7f-9b6a-11f91315b89c | 401         |                           |
| PF-1f994c71-e5d5-4e5c-a9a9-23ebad4d30d2 | 400         |                           |
| PG-4fa4e3a8-19f2-46e3-ba81-9f1aebbc44ec | 405         |                           |
| PF-5c584ee7-09e8-4027-b1f9-c19a9a8e79b1 | 403         |                           |
| PG-81a2f2dc-5109-4659-b9a8-8e52ce89a03a | 404         |                           |
| PF-a5068d34-2677-4bfa-b0b9-945f0d37d7c5 | 500         |                           |
| PF-4fc75df3-0913-407e-bdaa-e50329708b7d | 200         | OK                        |
| PF-d0556f95-6de8-4a92-aa2e-5479f6a1d6d7 | 200         | KO                        |
| PF-e6c22e6b-1276-44a6-a50a-5c0e4639425d | 200         | Nessun Elemento Associato |

### document-ready

Path: `/radd-web/document-ready/{fileKey}`

Use cases:

| fileKey                                                     | Status Code | Valido |
|-------------------------------------------------------------|-------------|--------|
| PN_RADD_FSU_ATTACHMENT-21703b4070084bb5b79662abd5fec424.zip | 500         |        |
| PN_RADD_FSU_ATTACHMENT-22703b4070084bb5b79662abd5fec424.zip | 404         |        |
| PN_RADD_FSU_ATTACHMENT-19703b4070084bb5b79662abd5fec424.zip | 200         | OK     |
| PN_RADD_FSU_ATTACHMENT-20703b4070084bb5b79662abd5fec424.zip | 200         | KO     |