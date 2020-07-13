package kg.easy.loginservice.models.dto;

import lombok.Data;

@Data
public class UserDto {

    private Long id;
    private String name;
    private String address;
    private RoleDto role;
    private AccountDto account;
    private boolean active;
}
