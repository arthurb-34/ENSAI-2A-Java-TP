package fr.ensai.running.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Registration {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_registration")
    private long idRegistration;

    @ManyToOne
    @JoinColumn(name = "id_athlete", referencedColumnName = "id_athlete")
    private Athlete athlete;

    @ManyToOne
    @JoinColumn(name = "id_competition", referencedColumnName = "id_competition")
    private Competition competition;

    private LocalDate registrationDate;

    @Override
    public String toString() {
        return "Registration [idRegistration=" + idRegistration + ", athlete=" + athlete + ", competition="
                + competition
                + ", registrationDate=" + registrationDate + "]";
    }
}
