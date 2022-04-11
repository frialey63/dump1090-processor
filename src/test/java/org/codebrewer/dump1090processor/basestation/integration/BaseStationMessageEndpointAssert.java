package org.codebrewer.dump1090processor.basestation.integration;

import org.assertj.core.api.AbstractAssert;

public class BaseStationMessageEndpointAssert extends AbstractAssert<BaseStationMessageEndpointAssert, BaseStationMessageEndpoint> {

    public BaseStationMessageEndpointAssert(BaseStationMessageEndpoint actual) {
        super(actual, BaseStationMessageEndpointAssert.class);
    }

    public BaseStationMessageEndpointAssert isPersistMessages() {
        isNotNull();

        if (!actual.isPersistMessages()) {
            failWithMessage("Expected BaseStationMessageEndpoint to persist messages");
        }

        return this;
    }

    public BaseStationMessageEndpointAssert isNotPersistMessages() {
        isNotNull();

        if (actual.isPersistMessages()) {
            failWithMessage("Expected BaseStationMessageEndpoint to not persist messages");
        }

        return this;
    }
}
