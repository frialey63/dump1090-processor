package org.codebrewer.dump1090processor;

import org.codebrewer.dump1090processor.basestation.integration.BaseStationMessageEndpoint;
import org.codebrewer.dump1090processor.basestation.integration.BaseStationMessageEndpointAssert;

public class Assertions {

    public static BaseStationMessageEndpointAssert assertThat(BaseStationMessageEndpoint actual) {
        return new BaseStationMessageEndpointAssert(actual);
    }

}
