package org.codebrewer.dump1090processor.basestation.repository;

import org.codebrewer.dump1090processor.basestation.entity.Aircraft;
import org.springframework.data.repository.CrudRepository;

/**
 * Interface to a repository for the {@link Aircraft} entity class.
 */
public interface AircraftRepository extends CrudRepository<Aircraft, String> {
}
