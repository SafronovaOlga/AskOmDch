package org.example;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {

  //  public class WebsiteAvailabilityChecker {
        public static void main(String[] args) {
            String websiteURL = "https://askomdch.com/"; // Замените на URL вашего веб-сайта

            try {
                // Создаем объект URL для заданного веб-сайта
                URL url = new URL(websiteURL);

                // Открываем соединение с веб-сайтом
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();

                // Устанавливаем метод запроса (GET - получение страницы)
                connection.setRequestMethod("GET");

                // Устанавливаем таймаут соединения (например, 10 секунд)
                connection.setConnectTimeout(10000);

                // Получаем код ответа от веб-сервера
                int responseCode = connection.getResponseCode();

                // Проверяем код ответа (код 200 означает успешный запрос)
                if (responseCode == 200) {
                    System.out.println("Сайт доступен. Код ответа: " + responseCode);
                } else {
                    System.out.println("Сайт недоступен. Код ответа: " + responseCode);
                }

                // Закрываем соединение
                connection.disconnect();

            } catch (IOException e) {
                System.out.println("Ошибка при проверке доступности сайта: " + e.getMessage());
            }
        }
  //  }

}