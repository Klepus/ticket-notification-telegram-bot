package com.github.klepus.ticketnotificationtelegrambot.command;

import com.github.klepus.ticketnotificationtelegrambot.service.SendBotMessageService;
import com.github.klepus.ticketnotificationtelegrambot.service.TelegramUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.telegram.telegrambots.meta.api.objects.Update;

public class StopCommand implements Command {

    private final SendBotMessageService sendBotMessageService;
    private final TelegramUserService telegramUserService;

    public static final String STOP_MESSAGE = "Пока! Это стоп-сообщение";

    @Autowired
    public StopCommand(SendBotMessageService sendBotMessageService, TelegramUserService telegramUserService) {
        this.sendBotMessageService = sendBotMessageService;
        this.telegramUserService = telegramUserService;
    }

    @Override
    public void execute(Update update) {
        String chatId = update.getMessage().getChatId().toString();
        sendBotMessageService.sendMessage(chatId, STOP_MESSAGE);

        telegramUserService.findByChatId(chatId).ifPresent(user -> {
            user.setActive(false);
            telegramUserService.save(user);
        });
    }
}
