package kg.easy.loginservice.mappers;

import kg.easy.loginservice.models.dto.RoleDto;
import kg.easy.loginservice.models.entities.Role;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RoleMapper {

    RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);

    Role roleDtoToRole(RoleDto roleDto);
    RoleDto roleToRoleDto(Role role);
}
