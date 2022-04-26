package tk.reelboost;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.ParseMode;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class reelboost extends TelegramLongPollingBot {
    @Override
    public String getBotUsername() {
        return "reelboost_bot";
    }

    @Override
    public String getBotToken() {
        return "/*bot-tocken*/";
    }

    @Override
    public void onUpdateReceived(Update update) {

    System.out.println(update.getMessage().getText());
    System.out.println();

        Message message = update.getMessage();

        SendMessage sendMessage = new SendMessage();

    String command = update.getMessage().getText();
    if (command.equals("/list") || command.equals("/list@reelboost_bot")){

        sendMessage.setText("i'll send you the list .Checkout our privat chat.");
        sendMessage.setParseMode(ParseMode.MARKDOWN);
        sendMessage.setChatId(String.valueOf(message.getChatId()));
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

        sendMessage.setText("here is your list");
        sendMessage.setParseMode(ParseMode.MARKDOWN);
        sendMessage.setChatId(String.valueOf(message.getFrom().getId()));
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    if (update.hasMessage() && update.getMessage().hasText()){

            String frstname = update.getMessage().getFrom().getFirstName();
            String lstname = update.getMessage().getFrom().getLastName();
            String usrname =update.getMessage().getFrom().getUserName();
            long chatid =update.getMessage().getChatId();
            System.out.println(chatid);

            sendMessage.setText(frstname+" "+lstname+" "+usrname+" chatID:"+chatid);
            sendMessage.setParseMode(ParseMode.MARKDOWN);
            sendMessage.setChatId(String.valueOf(message.getChatId()));
            try {
                execute(sendMessage);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }


    }//if ends

    }
}
