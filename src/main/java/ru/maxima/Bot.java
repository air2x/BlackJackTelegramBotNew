package ru.maxima;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.maxima.model.Croupier;
import ru.maxima.model.Game;
import ru.maxima.model.Player;

import java.util.ArrayList;
import java.util.List;

public class Bot extends TelegramLongPollingBot {

    @Override
    public String getBotUsername() {
        return "BlackJackAir_bot";
    }

    @Override
    public String getBotToken() {
        return "6631972211:AAGmT1SUMj3go0mIeZWl2hIuSQvqwCmWotU";
    }

    private Game game;

    @Override
    public void onUpdateReceived(Update update) {
        var msg = update.getMessage();
        var user = msg.getFrom();
        var id = user.getId();

        if (msg.isCommand()) {
            if (msg.getText().equals("/newgame")) {
                game = new Game();
                Croupier croupier = new Croupier("croupier", 0L);
                game.addPlayer(croupier);
                game.addPlayer(new Player(user.getFirstName(), id));
                sendText(id, "Игра создана!");
            } else if (msg.getText().equals("/startgame")) {
                game.giveTwoRandomCardsEachPlayerOnStart();
                List<Long> players = game.getPlayersIds();
                for (Long playerId : players) {
                    sendText(playerId, "Игра начата!");
                    sendText(playerId, game.getPlayer(id).showCards());
                }
                sendText(id, "Вам нужна еще карта?");
//                askYesNo(id);
                game.oneCardIfPlayerNeed2(id);
            } else if (msg.getText().equals("/joingame")) {
                game.addPlayer(new Player(user.getFirstName(), id));
                sendText(id, "Вы присоединилсь к игре!");
            }
            return;
        }

        if ("Да".equalsIgnoreCase(msg.getText())) {
            sendText(id, game.oneCardIfPlayerNeed2(id));
            sendText(id, "Вам нужна еще карта?");
        } else if ("Нет".equalsIgnoreCase(msg.getText())) {
            sendText(id, "Скоро будут результаты, ожидайте.");
        }
//        if (callBackData.equals("YES_BUTTON")) {
//            sendText(id, game.oneCardIfPlayerNeed2(id));
//            sendText(id, "Вам нужна еще карта?");
//        } else if (callBackData.equals("NO_BUTTON")) {
//            sendText(id, "Скоро будут результаты, ожидайте.");
//        }
        if (game.isGameEnded()) {
            String result = game.determineWinner();
            List<Long> players = game.getPlayersIds();
            for (Long playerId : players) {
                sendText(playerId, result);
            }
        }


//        System.out.println(user.getFirstName() + " wrote " + msg.getText());
//        sendText(id, msg.getText());
    }

    public void sendText(Long who, String what) {
        SendMessage sm = SendMessage.builder()
                .chatId(who.toString()) //Who are we sending a message to
                .text(what).build();    //Message content
        try {
            execute(sm);                        //Actually sending the message
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);      //Any error will be printed here
        }
    }

//    private void askYesNo(long chatId) {
//        SendMessage sm = new SendMessage();
//        sm.setChatId(String.valueOf(chatId));
//        sm.setText("Вам нужна еще карта?");
//
//        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
//        List<List<InlineKeyboardButton>> rowsInLine = new ArrayList<>();
//        List<InlineKeyboardButton> rowInLine = new ArrayList<>();
//        var yesButton = new InlineKeyboardButton();
//        yesButton.setText("Да");
//        yesButton.setCallbackData("YES_BUTTON");
//
//        var noButton = new InlineKeyboardButton();
//        noButton.setText("Нет");
//        noButton.setCallbackData("NO_BUTTON");
//
//        rowInLine.add(yesButton);
//        rowInLine.add(noButton);
//
//        rowsInLine.add(rowInLine);
//
//        inlineKeyboardMarkup.setKeyboard(rowsInLine);
//        sm.setReplyMarkup(inlineKeyboardMarkup);
//
//        try {
//            execute(sm);                        //Actually sending the message
//        } catch (TelegramApiException e) {
//            throw new RuntimeException(e);      //Any error will be printed here
//        }
//    }
}
