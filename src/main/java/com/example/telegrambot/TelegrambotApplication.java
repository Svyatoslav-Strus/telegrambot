package com.example.telegrambot;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiException;

public class TelegrambotApplication {

	public static void main(String[] args) {

		//SpringApplication.run(TelegrambotApplication.class, args);
		ApiContextInitializer.init();

		TelegramBotsApi telegramBotsApi = new TelegramBotsApi();

		try {
			telegramBotsApi.registerBot(new Bot());
		} catch (TelegramApiException e) {
			e.printStackTrace();
		}
	}
}
