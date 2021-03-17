package com.github.klepus.ticketnotificationtelegrambot.repository;

import com.github.klepus.ticketnotificationtelegrambot.repository.entity.TelegramUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TelegramUserRepository extends JpaRepository<TelegramUser, String> {

    List<TelegramUser> findAllByActiveTrue();

}
