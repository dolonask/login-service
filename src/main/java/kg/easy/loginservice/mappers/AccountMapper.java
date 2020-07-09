package kg.easy.loginservice.mappers;

import kg.easy.loginservice.models.dto.AccountDto;
import kg.easy.loginservice.models.entities.Account;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AccountMapper {

    AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);

    Account accountDtoToAccount(AccountDto accountDto);
    AccountDto accountToAccountDto(Account account);
}
