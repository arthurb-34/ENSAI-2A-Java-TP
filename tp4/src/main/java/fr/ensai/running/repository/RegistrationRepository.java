package fr.ensai.running.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.ensai.running.model.Athlete;
import fr.ensai.running.model.Competition;
import fr.ensai.running.model.Registration;

public interface RegistrationRepository extends JpaRepository<Registration, Long> {

    /**
     * Find a Registration by Athlete and Competition
     * 
     * @param athlete     the athlete
     * @param competition the competition
     * @return Optional<Registration>
     */
    Optional<Registration> findByAthleteAndCompetition(Athlete athlete, Competition competition);

    /**
     * Find Athlete IDs by Competition ID
     * 
     * @param idCompetition the competition id
     * @return List of Athlete IDs
     */
    @Query("SELECT r.athlete.id FROM Registration r WHERE r.competition.id = :idCompetition")
    List<Long> findAthleteIdByCompetitionId(Long idCompetition);
}
