package com.mschool.mschoolapi.repositoriestest;

import com.mschool.mschoolapi.models.Utilisateur;
import com.mschool.mschoolapi.repositories.UtilisateurRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UtilisateurRepositoryIntegrationTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Test
    public void whenFindByUsernameAndPassword_thenReturnUtilisateur() {
        // given
        Utilisateur mouhamed = new Utilisateur("mouhamed", "passer@123");
        entityManager.persist(mouhamed);
        entityManager.flush();

        // when
        Utilisateur found = utilisateurRepository.getUtilisateurByUsernameAndPassword(mouhamed.getUsername(), mouhamed.getPassword()).orElse(new Utilisateur());

        // then
        assertThat(found.getUsername()).isEqualTo(mouhamed.getUsername());
        assertThat(found.getPassword()).isEqualTo(mouhamed.getPassword());
    }
}
