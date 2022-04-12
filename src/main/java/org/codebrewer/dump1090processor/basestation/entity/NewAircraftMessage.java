/*
 * Copyright 2018, 2019, 2020 Mark Scott
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.codebrewer.dump1090processor.basestation.entity;

import java.time.Instant;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Class for BaseStation "new aircraft message" entities.
 */
@Entity
@DiscriminatorValue("AIR")
public class NewAircraftMessage extends BaseStationMessage {
  @SuppressWarnings("unused")
  NewAircraftMessage() {
    // No-arg constructor required by Hibernate
    super();
  }

  private NewAircraftMessage(Builder builder) {
    super(builder);
  }

  /**
   * A builder for the {@code NewAircraftMessage} entity type.
   */
  public static class Builder extends BaseStationMessage.Builder<NewAircraftMessage, Builder> {

    /**
     * Sole constructor for this class, with parameters for properties common to all BaseStation
     * message types and to this type.
     *
     * @param icaoAddress the 24 bit address assigned by the ICAO to an aircraft transponder,
     * represented as a 6 digit hexadecimal number, not null
     * @param timestamp the instant at which the message was received, not null
     */
    public Builder(String icaoAddress, Instant timestamp) {
      super(icaoAddress, timestamp);
    }

    @Override
    public NewAircraftMessage build() {
      return new NewAircraftMessage(this);
    }

    @Override
    protected Builder self() {
      return this;
    }
  }

@Override
public String toString() {
    return "NewAircraftMessage [toString()=" + super.toString() + "]";
}


}
