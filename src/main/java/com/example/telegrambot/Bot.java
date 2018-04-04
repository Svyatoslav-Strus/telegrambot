package com.example.telegrambot;

import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import java.util.Set;

public class Bot extends TelegramLongPollingBot {

    @Override
    public void onUpdateReceived(Update update) {

        if (update.hasMessage() && update.getMessage().hasText()) {

            Set<String> firstSetBinance = new Binance().getSymbolSetBinance();

            Set<String> firstSetHuobi = new Huobi().getSymbolSetHuobi();

            Set<String> firstSetBittrex = new Bittrex().getSymbolSetBittrex();

            SendMessage message = new SendMessage() // Create a SendMessage object with mandatory fields
                    .setChatId(update.getMessage().getChatId())
                    .setText(   "Binance: " + String.valueOf(firstSetBinance.size()) + "   " +
                                "Huobi: " + String.valueOf(firstSetHuobi.size()) + "   " +
                                "Bittrex: " + String.valueOf(firstSetBittrex.size()));

            try {
                execute(message); // Call method to send the message
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }

            while (true) {

                System.out.println("check");

                try {
                    Thread.sleep(90000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                Set<String> symbolSetBinance = new Binance().getSymbolSetBinance();

                Set<String> symbolSetHuobi = new Huobi().getSymbolSetHuobi();

                Set<String> symbolSetBittrex = new Bittrex().getSymbolSetBittrex();

                firstSetBinance = getStringSet(update, firstSetBinance, symbolSetBinance);

                firstSetHuobi = getStringSet(update, firstSetHuobi, symbolSetHuobi);

                firstSetBittrex =getStringSet(update, firstSetBittrex, symbolSetBittrex);
            }
        }
    }

    private Set<String> getStringSet(Update update, Set<String> firstSet, Set<String> presentSet) {
        SendMessage message;
        if (firstSet.size() < presentSet.size()) {
            message = new SendMessage() // Create a SendMessage object with mandatory fields
                    .setChatId(update.getMessage().getChatId())
                    .setText(String.valueOf(""));
            try {
                execute(message); // Call method to send the message
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
        return presentSet;
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
