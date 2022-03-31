package com.Players.player;
import com.Util.JSON_Handler;
import org.json.simple.JSONObject;

import java.util.ArrayList;


public class Player  {
    private static Player singleton = null;
    private String name;
    private ArrayList<String> currentInventory;
    //Will look to refactor this JSONObject
    private static JSONObject currentLocation = JSON_Handler.getJSON("locations.json", "json");
    private static JSONObject commands = JSON_Handler.getJSON("commands.json", "json");




    public static Player getInstance (String name, JSONObject location, JSONObject commands){
        if(singleton == null){
            singleton = new Player(name, location, commands );
    }
        return singleton;
    };

    Player(String name, JSONObject currentLocation, JSONObject commands) {
        setName(name);
        setCommands(commands);
        setLocation(currentLocation);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public JSONObject getLocation() {
        return currentLocation;
    }

    public void setLocation(JSONObject location) {
        this.currentLocation = location;
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
                ", currentLocation='" + currentLocation + '\'' +
                ", currentInventory=" + currentInventory +
                //This can be removed once the command list grows
                ", commands=" + commands +
                '}';
    }

    public static void main(String[] args) {
    //Small change
        Player player = getInstance("Bill", currentLocation, commands);
        System.out.println(player.getCommands());
        System.out.println(player.getLocation());
        System.out.println(player.getName());
    }
}
