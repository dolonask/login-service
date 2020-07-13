package kg.easy.loginservice.dao;

import kg.easy.loginservice.models.dto.SessionDto;
import kg.easy.loginservice.models.dto.UserDto;
import kg.easy.loginservice.models.entities.Session;
import kg.easy.loginservice.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface SessionRepository extends JpaRepository<Session, Long> {

    Session findByUserAndEndDateIsAfter(User user, Date endDate);
    Session findByToken(String token);

}
