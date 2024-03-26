package com.eazybytes.accounts.service;

import com.eazybytes.accounts.model.Accounts;
import com.eazybytes.accounts.repository.AccountsRepository;
import com.eazybytes.accounts.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class AccountsService {
    private static final Logger logger = LoggerFactory.getLogger(AccountsService.class);

    @Autowired
    private AccountsRepository accountsRepository;

    @Autowired
    private CustomerRepository customerRepository;

    public List<Accounts> getAllAccounts() {
        logger.info("Fetching all accounts");
        List<Accounts> allAccounts = new ArrayList<>();
        accountsRepository.findAll().forEach(allAccounts::add);
        logger.debug("Number of accounts fetched: {}", allAccounts.size());
        return allAccounts;
    }

    public Accounts getAccountsById(long id) {
        logger.info("Fetching account by ID: {}", id);
        return accountsRepository.findById(id).orElse(null);
    }

    public String save(Accounts accounts) {
        logger.info("Saving new account for customer ID: {}", accounts.getCustomerId());
        if (customerRepository.existsById(accounts.getCustomerId())) {
            accounts.setCreateDt(LocalDate.now());
            accountsRepository.save(accounts);
            logger.debug("Account saved: {}", accounts);
            return "saved";
        } else {
            logger.warn("Failed to save account, customer ID not found: {}", accounts.getCustomerId());
            return "failed, customer not found!";
        }
    }

    public String updateAccount(long id, Accounts updateAccounts) {
        logger.info("Updating account with ID: {}", id);
        return accountsRepository.findById(id).map(existingAccount -> {
            updateAccounts.setAccountNumber(id);
            updateAccounts.setCreateDt(LocalDate.now());
            accountsRepository.save(updateAccounts);
            logger.debug("Account updated: {}", updateAccounts);
            return "update successful!";
        }).orElse("account not found!");
    }

    @Transactional
    public List<String> saveAll(List<Accounts> accountsList) {
        logger.info("Saving multiple accounts, count: {}", accountsList.size());
        List<String> responseList = new ArrayList<>();
        accountsList.forEach(account -> {
            accountsRepository.save(account);
            responseList.add("Account saved with account number: " + account.getAccountNumber());
            logger.debug("Account saved: {}", account);
        });
        return responseList;
    }

    public String deleteAccount(Long id) {
        logger.info("Deleting account with ID: {}", id);
        accountsRepository.deleteById(id);
        logger.debug("Account deleted with ID: {}", id);
        return "deleted!";
    }

    @Transactional
    public String deleteAllByIds(List<Long> accountIds) {
        logger.info("Deleting accounts with IDs: {}", accountIds);
        try {
            accountsRepository.deleteAllById(accountIds);
            logger.debug("Accounts deleted with IDs: {}", accountIds);
            return "Accounts deleted successfully";
        } catch (Exception e) {
            logger.error("Error during deleting accounts with IDs: {}", accountIds, e);
            return "Error during deleting accounts";
        }
    }

    public String deleteAllAccounts() {
        logger.info("Deleting all accounts");
        try {
            accountsRepository.deleteAll();
            logger.debug("All accounts have been deleted successfully");
            return "All accounts have been deleted successfully";
        } catch (Exception e) {
            logger.error("Error during deleting all accounts", e);
            return "Error during deleting all accounts";
        }
    }
}
