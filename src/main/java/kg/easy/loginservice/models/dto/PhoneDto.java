package kg.easy.loginservice.models.dto;


import lombok.Data;

@Data
public class PhoneDto {
    private Long id;
    private String msisdn;
    private boolean active;
}
