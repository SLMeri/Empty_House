package com.players.player;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.util.JSON_Handler;
import org.json.simple.JSONObject;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class Player  {

    private static Player singleton = null;
    private String name;
    //Will look to refactor this JSONObject
    private static JSONObject commands = JSON_Handler.getJSON("PlayerCommands.JSON", "json");
    private JSONObject inventory = JSON_Handler.getJSON("Items.Json", "json");
    private static JSONObject location = JSON_Handler.getJSON("Locations.Json", "json");


    public static Player getInstance (String name, JSONObject location, JSONObject commands){
        if(singleton == null){
            singleton = new Player(name, location, commands );
    }
        return singleton;
    };

    Player(String name, JSONObject location, JSONObject commands) {
        setName(name);
        setCommands(commands);
        setLocation(location);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public JSONObject getInventory() {
        return inventory;
    }

    public void setInventory(JSONObject inventory) {
        this.inventory = inventory;
    }

    public JSONObject getLocation() {
        return location;
    }

    public void setLocation(JSONObject location) {
        this.location = location;
    }

    public JSONObject getCommands() {
        if(commands.isEmpty()){
            System.out.println("No commands available");
        }
        return commands;
    }

    public void setCommands(JSONObject commands) {
        this.commands = commands;
    }

    @Override
    public String toString() {
        return super.getClass().getSimpleName() + "{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", inventory=" + inventory +
                //This can be removed once the command list grows
                ", commands=" + commands +
                '}';
    }

    public static void main(String[] args) {

        Player player = getInstance("Bill", location, commands);
        System.out.println(player.getCommands());
        System.out.println(player.getLocation());
        System.out.println(player.getInventory());
        System.out.println(player);


//        Reader reader;
//        try {
//            reader = new FileReader("src/com/Assets/json/PlayerCommands.JSON");
//            Gson gson = new Gson();
//            Type collectionType = new TypeToken<List<String>>(){}.getType();
//            List<String> collection = gson.fromJson(reader, collectionType);
//
//            System.out.println(collection);
//
//        }catch(FileNotFoundException e){
//            e.printStackTrace();
//        }
    }
}
