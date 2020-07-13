package kg.easy.loginservice.services.impl;

import kg.easy.loginservice.dao.AccountRepository;
import kg.easy.loginservice.exceptions.ResourceNotFoundException;
import kg.easy.loginservice.mappers.AccountMapper;
import kg.easy.loginservice.models.dto.AccountDto;
import kg.easy.loginservice.models.entities.Account;
import kg.easy.loginservice.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;
    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account = AccountMapper.INSTANCE.accountDtoToAccount(accountDto);
        account = accountRepository.save(account);
        return AccountMapper.INSTANCE.accountToAccountDto(account);
    }

    @Override
    public AccountDto updateAccount(AccountDto accountDto) {

        Account account = accountRepository.findById(accountDto.getId()).orElseThrow(() -> new ResourceNotFoundException("Аккаунт пользователя не найден! - " + accountDto.getLogin()));


        account.setLogin(accountDto.getLogin());
        account.setPassword(accountDto.getPassword());

        account = accountRepository.save(account);

        return AccountMapper.INSTANCE.accountToAccountDto(account);
    }
}
