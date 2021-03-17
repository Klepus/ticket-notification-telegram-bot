package com.github.klepus.ticketnotificationtelegrambot.bot;

import com.github.klepus.ticketnotificationtelegrambot.command.CommandContainer;
import com.github.klepus.ticketnotificationtelegrambot.service.SendBotMessageServiceImpl;
import com.github.klepus.ticketnotificationtelegrambot.service.TelegramUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

import static com.github.klepus.ticketnotificationtelegrambot.command.CommandName.NO;

@Component
public class TicketNotificationTelegramBot extends TelegramLongPollingBot {

    @Value("${bot.username}")
    private String userName;

    @Value("${bot.token}")
    private String token;

    public static String COMMAND_PREFIX = "/";

    private final CommandContainer commandContainer;

    @Autowired
    public TicketNotificationTelegramBot(TelegramUserService telegramUserService) {
        this.commandContainer = new CommandContainer(new SendBotMessageServiceImpl(this), telegramUserService);
    }

    @Override
    public void onUpdateReceived(Update update) {
        if(update.hasMessage() && update.getMessage().hasText()) {
            String message = update.getMessage().getText().trim();

            if (message.startsWith(COMMAND_PREFIX)) {
                String commandIdentifier = message.split(" ")[0].toLowerCase();
                commandContainer.retrieveCommand(commandIdentifier).execute(update);
            } else {
                commandContainer.retrieveCommand(NO.getCommandName()).execute(update);
            }
        }
    }

    @Override
    public String getBotUsername() {
        return userName;
    }

    @Override
    public String getBotToken() {
        return token;
    }
}
