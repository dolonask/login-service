package kg.easy.loginservice.mappers;

import kg.easy.loginservice.models.dto.SessionDto;
import kg.easy.loginservice.models.entities.Session;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SessionMapper {

    SessionMapper INSTANCE = Mappers.getMapper(SessionMapper.class);

    Session sessionDtoToSession(SessionDto sessionDto);
    SessionDto sessionToSessionDto(Session session);
}
