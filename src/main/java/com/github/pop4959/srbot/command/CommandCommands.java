package com.github.pop4959.srbot.command;

import com.github.pop4959.srbot.Data;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class CommandCommands extends BotCommand {

    public CommandCommands() {
        super("commands");
    }

    public void execute(MessageReceivedEvent event, String[] args) {
        List<String> commands = new ArrayList<>();
        for (Object o : ((JSONObject) Data.asJSON(COMMANDS_FILE, "")).keySet()) {
            commands.add((String) o);
        }
        event.getChannel().sendMessage("Available commands: " + commands.toString().replaceAll("[\\[\\]]", "")).queue();
    }

}