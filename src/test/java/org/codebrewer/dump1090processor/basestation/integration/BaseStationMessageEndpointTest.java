/*
 * Copyright 2019, 2020 Mark Scott
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

package org.codebrewer.dump1090processor.basestation.integration;

import static org.codebrewer.dump1090processor.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;

import org.codebrewer.dump1090processor.basestation.entity.BaseStationMessage;
import org.codebrewer.dump1090processor.basestation.repository.AircraftRepository;
import org.codebrewer.dump1090processor.basestation.repository.BaseStationMessageRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class BaseStationMessageEndpointTest {
  private BaseStationMessage baseStationMessage;
  private BaseStationMessageRepository repository;
  private AircraftRepository aircraftRepository;
  private BaseStationMessageEndpoint endpoint;

  @BeforeEach
  void setUp() {
    baseStationMessage = Mockito.mock(BaseStationMessage.class);
    repository = Mockito.mock(BaseStationMessageRepository.class);
    aircraftRepository = Mockito.mock(AircraftRepository.class);
  }

  @Test
  void shouldNotPersistBaseStationMessagesIfMessagePersistenceDisabled() {
    endpoint = new BaseStationMessageEndpoint(repository, aircraftRepository, false);
    endpoint.consume(baseStationMessage);
    verifyNoInteractions(repository);
  }

  @Test
  void shouldPersistBaseStationMessagesIfMessagePersistenceEnabled() {
    endpoint = new BaseStationMessageEndpoint(repository, aircraftRepository, true);
    endpoint.consume(baseStationMessage);
    verify(repository, Mockito.times(1)).save(Mockito.eq(baseStationMessage));
  }

  @Test
  void shouldAllowMessagePersistenceToBeDisabled() {
    endpoint = new BaseStationMessageEndpoint(repository, aircraftRepository, true);
    assertThat(endpoint).isPersistMessages();
    endpoint.setPersistMessages(false);
    assertThat(endpoint).isNotPersistMessages();
    endpoint.consume(baseStationMessage);
    verifyNoInteractions(repository);
  }

  @Test
  void shouldAllowMessagePersistenceToBeEnabled() {
    endpoint = new BaseStationMessageEndpoint(repository, aircraftRepository, false);
    assertThat(endpoint).isNotPersistMessages();
    endpoint.setPersistMessages(true);
    assertThat(endpoint).isPersistMessages();
    endpoint.consume(baseStationMessage);
    verify(repository, Mockito.times(1)).save(Mockito.eq(baseStationMessage));
  }
}
