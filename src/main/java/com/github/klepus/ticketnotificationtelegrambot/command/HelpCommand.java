package com.github.klepus.ticketnotificationtelegrambot.command;

import com.github.klepus.ticketnotificationtelegrambot.service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

import static com.github.klepus.ticketnotificationtelegrambot.command.CommandName.*;

public class HelpCommand implements Command {

    private final SendBotMessageService sendBotMessageService;

    public static final String HELP_MESSAGE = String.format("Дотупные команды:\n\n"
                    + "%s - начать работу со мной\n"
                    + "%s - приостановить работу со мной\n"
                    + "%s - посмотреть статистику использования бота\n"
                    + "%s - получить помощь в работе со мной\n\n",
            START.getCommandName(), STOP.getCommandName(), STAT.getCommandName(), HELP.getCommandName());

    public HelpCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), HELP_MESSAGE);
    }
}
