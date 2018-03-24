package com.example.telegrambot;

import com.example.telegrambot.binance.domain.general.Symbol;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.util.List;

public class Bot extends TelegramLongPollingBot {

    @Override
    public void onUpdateReceived(Update update) {

        if (update.hasMessage() && update.getMessage().hasText()) {

            List<Symbol> firstListBinance = new Binance().getSymbolListBinance();
            List<com.example.telegrambot.huobi.response.Symbol> firstListHuobi = new Huobi().getSymbolListHuobi();

            SendMessage message = new SendMessage() // Create a SendMessage object with mandatory fields
                    .setChatId(update.getMessage().getChatId())
                    .setText("Binance: " + String.valueOf(firstListBinance.size()) + "   " +
                                "Huobi: " + String.valueOf(firstListHuobi.size()));

            try {
                execute(message); // Call method to send the message
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }

            while (true) {

                try {
                    Thread.sleep(60000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                List<Symbol> symbolList = new Binance().getSymbolListBinance();

                if (firstListBinance.size() != symbolList.size()) {
                    message = new SendMessage() // Create a SendMessage object with mandatory fields
                            .setChatId(update.getMessage().getChatId())
                            .setText(String.valueOf(symbolList.get(symbolList.size() - 1)));
                    firstListBinance = symbolList;
                    try {
                        execute(message); // Call method to send the message
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                } else {
                    message = new SendMessage() // Create a SendMessage object with mandatory fields
                            .setChatId(update.getMessage().getChatId())
                            .setText("NOTHING");
                    try {
                        execute(message); // Call method to send the message
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    @Override
    public String getBotUsername() {
        return "apichecker_bot";
    }

    @Override
    public String getBotToken() {
        return "551457647:AAHd9ZYeifrF-Lkc4bf2GriFDR6gAwzbsQo";
    }
}
