package org.learning.notes.repository;

import org.learning.notes.model.Notes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface NotesRepository extends JpaRepository<Notes, UUID> {
}
