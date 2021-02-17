package com.github.klepus.ticketnotificationtelegrambot.service;

public interface SendBotMessageService {

    void sendMessage(String chatId, String message);
}
