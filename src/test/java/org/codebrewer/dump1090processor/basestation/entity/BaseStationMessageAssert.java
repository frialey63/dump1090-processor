package org.codebrewer.dump1090processor.basestation.entity;

import java.time.Instant;
import java.util.Objects;

import org.assertj.core.api.AbstractAssert;
import org.codebrewer.dump1090processor.basestation.domain.StatusMessageType;
import org.codebrewer.dump1090processor.basestation.domain.TransmissionType;
import org.geolatte.geom.G2D;
import org.geolatte.geom.Point;

public class BaseStationMessageAssert extends AbstractAssert<BaseStationMessageAssert, BaseStationMessage> {

    private static boolean floatsEqual(Float a, Float b, float tol) {
        if (a == null && b == null) {
            return true;
        } else if (a == null || b == null) {
            return false;
        }

        return a.floatValue() - b.floatValue() < tol;
    }

    private static boolean shortsEqual(Short a, Short b) {
        if (a == null && b == null) {
            return true;
        } else if (a == null || b == null) {
            return false;
        }

        return a.shortValue() == b.shortValue();
    }

    private static boolean booleansEqual(Boolean a, Boolean b) {
        if (a == null && b == null) {
            return true;
        } else if (a == null || b == null) {
            return false;
        }

        return a.booleanValue() == b.booleanValue();
    }

    public BaseStationMessageAssert(BaseStationMessage actual) {
        super(actual, BaseStationMessageAssert.class);
    }

    public BaseStationMessageAssert hasId(long id) {
        isNotNull();

        if (actual.getId() != id) {
            failWithMessage("Expected BaseStationMessage with Id of %d but was %d", id, actual.getId());
        }

        return this;
    }

    public BaseStationMessageAssert hasIcaoAddress(String icaoAdress) {
        isNotNull();

        if (!Objects.equals(actual.getIcaoAddress(), icaoAdress)) {
            failWithMessage("Expected BaseStationMessage with ICAO address of %s but was %s", icaoAdress, actual.getIcaoAddress());
        }

        return this;
    }

    public BaseStationMessageAssert hasTimestamp(Instant timestamp) {
        isNotNull();

        if (actual.getTimestamp().getEpochSecond() != timestamp.getEpochSecond()) {
            failWithMessage("Expected BaseStationMessage with timestamp of %s but was %s", timestamp, actual.getTimestamp());
        }

        return this;

    }

    public BaseStationMessageAssert hasCallSign(String callSign) {
        isNotNull();
        isInstanceOf(CallSignMessage.class);

        CallSignMessage callSignMessage = (CallSignMessage) actual;

        if (!Objects.equals(callSignMessage.getCallSign(), callSign)) {
            failWithMessage("Expected CallSignMessage with call sign of %s but was %s", callSign, callSignMessage.getCallSign());
        }

        return this;
    }

    public BaseStationMessageAssert hasTransmissionType(TransmissionType transmissionType) {
        isNotNull();
        isInstanceOf(TransmissionMessage.class);

        TransmissionMessage transmissionMessage = (TransmissionMessage) actual;

        if (transmissionMessage.getTransmissionType() != transmissionType) {
            failWithMessage("Expected TransmissionMessage with transmission type of %s but was %s", transmissionType, transmissionMessage.getTransmissionType());
        }

        return this;
    }

    public BaseStationMessageAssert hasAltitude(Float altitude) {
        isNotNull();
        isInstanceOf(TransmissionMessage.class);

        TransmissionMessage transmissionMessage = (TransmissionMessage) actual;

        if (!floatsEqual(transmissionMessage.getAltitude(), altitude,  0.1f)) {
            failWithMessage("Expected TransmissionMessage with altitude of %f but was %f", altitude, transmissionMessage.getAltitude());
        }

        return this;
    }

    public BaseStationMessageAssert hasGroundSpeed(Float groundSpeed) {
        isNotNull();
        isInstanceOf(TransmissionMessage.class);

        TransmissionMessage transmissionMessage = (TransmissionMessage) actual;

        if (!floatsEqual(transmissionMessage.getGroundSpeed(), groundSpeed,  0.1f)) {
            failWithMessage("Expected TransmissionMessage with ground speed of %f but was %f", groundSpeed, transmissionMessage.getGroundSpeed());
        }

        return this;
    }

    public BaseStationMessageAssert hasTrack(Float track) {
        isNotNull();
        isInstanceOf(TransmissionMessage.class);

        TransmissionMessage transmissionMessage = (TransmissionMessage) actual;

        if (!floatsEqual(transmissionMessage.getTrack(), track,  0.1f)) {
            failWithMessage("Expected TransmissionMessage with track of %f but was %f", track, transmissionMessage.getTrack());
        }

        return this;
    }

    public BaseStationMessageAssert hasPosition(Point<G2D> position) {
        isNotNull();
        isInstanceOf(TransmissionMessage.class);

        TransmissionMessage transmissionMessage = (TransmissionMessage) actual;

        if (!Objects.equals(transmissionMessage.getPosition(), position)) {
            failWithMessage("Expected TransmissionMessage with position of %s but was %s", position, transmissionMessage.getPosition());
        }

        return this;
    }

    public BaseStationMessageAssert hasVerticalRate(Short verticalRate) {
        isNotNull();
        isInstanceOf(TransmissionMessage.class);

        TransmissionMessage transmissionMessage = (TransmissionMessage) actual;

        if (!shortsEqual(transmissionMessage.getVerticalRate(), verticalRate)) {
            failWithMessage("Expected TransmissionMessage with vertical rate of %d but was %d", verticalRate, transmissionMessage.getVerticalRate());
        }

        return this;
    }

    public BaseStationMessageAssert hasSquawk(Short squawk) {
        isNotNull();
        isInstanceOf(TransmissionMessage.class);

        TransmissionMessage transmissionMessage = (TransmissionMessage) actual;

        if (!shortsEqual(transmissionMessage.getSquawk(), squawk)) {
            failWithMessage("Expected TransmissionMessage with squawk of %d but was %d", squawk, transmissionMessage.getSquawk());
        }

        return this;
    }

    public BaseStationMessageAssert hasAlert(Boolean alert) {
        isNotNull();
        isInstanceOf(TransmissionMessage.class);

        TransmissionMessage transmissionMessage = (TransmissionMessage) actual;

        if (!booleansEqual(transmissionMessage.getAlert(), alert)) {
            failWithMessage("Expected TransmissionMessage with alert of %b but was %b", alert, transmissionMessage.getAlert());
        }

        return this;
    }

    public BaseStationMessageAssert hasEmergency(Boolean emergency) {
        isNotNull();
        isInstanceOf(TransmissionMessage.class);

        TransmissionMessage transmissionMessage = (TransmissionMessage) actual;

        if (!booleansEqual(transmissionMessage.getEmergency(), emergency)) {
            failWithMessage("Expected TransmissionMessage with emergency of %b but was %b", emergency, transmissionMessage.getEmergency());
        }

        return this;
    }

    public BaseStationMessageAssert hasIdentActive(Boolean identActive) {
        isNotNull();
        isInstanceOf(TransmissionMessage.class);

        TransmissionMessage transmissionMessage = (TransmissionMessage) actual;

        if (!booleansEqual(transmissionMessage.getIdentActive(), identActive)) {
            failWithMessage("Expected TransmissionMessage with ident-active of %b but was %b", identActive, transmissionMessage.getIdentActive());
        }

        return this;
    }

    public BaseStationMessageAssert hasOnGround(Boolean onGround) {
        isNotNull();
        isInstanceOf(TransmissionMessage.class);

        TransmissionMessage transmissionMessage = (TransmissionMessage) actual;

        if (!booleansEqual(transmissionMessage.getOnGround(), onGround)) {
            failWithMessage("Expected TransmissionMessage with on-ground of %b but was %b", onGround, transmissionMessage.getOnGround());
        }

        return this;

    }

    public BaseStationMessageAssert hasStatusMessageType(StatusMessageType statusMessageType) {
        isNotNull();
        isInstanceOf(StatusMessage.class);

        StatusMessage statusMessage = (StatusMessage) actual;

        if (statusMessage.getStatusMessageType() != statusMessageType) {
            failWithMessage("Expected StatusMessage with status-message-type of %s but was %s", statusMessageType, statusMessage.getStatusMessageType());
        }

        return this;
    }

}
