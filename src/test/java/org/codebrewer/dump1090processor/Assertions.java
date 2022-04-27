package org.codebrewer.dump1090processor;

import org.codebrewer.dump1090processor.basestation.entity.BaseStationMessage;
import org.codebrewer.dump1090processor.basestation.entity.BaseStationMessageAssert;
import org.codebrewer.dump1090processor.basestation.integration.BaseStationMessageEndpoint;
import org.codebrewer.dump1090processor.basestation.integration.BaseStationMessageEndpointAssert;

public class Assertions {

    public static BaseStationMessageEndpointAssert assertThat(BaseStationMessageEndpoint actual) {
        return new BaseStationMessageEndpointAssert(actual);
    }

    public static BaseStationMessageAssert assertThat(BaseStationMessage actual) {
        return new BaseStationMessageAssert(actual);
    }

}
