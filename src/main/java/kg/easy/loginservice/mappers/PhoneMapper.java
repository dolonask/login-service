package kg.easy.loginservice.mappers;

import kg.easy.loginservice.models.dto.PhoneDto;
import kg.easy.loginservice.models.entities.Phone;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PhoneMapper {

    PhoneMapper INSTANCE = Mappers.getMapper(PhoneMapper.class);

    Phone phoneDtoToPhone(PhoneDto phoneDto);
    PhoneDto phoneToPhoneDto(Phone phone);


}
