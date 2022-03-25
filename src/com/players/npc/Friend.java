package com.players.npc;

import com.players.Character;

public class Friend implements Character {
    private String name = null;

    public Friend(){

    }

    public Friend(String name) {
        setName(name);
    }

    @Override
    public void move(){
        System.out.println(getName() + " is moving");
    };

    public void talk(){
        System.out.println(getName() + " is talking");
    };

    public void think(){
        System.out.println(getName() + " is thinking");
    };

    public void doAction(){
        System.out.println(getName() + " is doing something....");
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return super.getClass().getSimpleName() + ": " + getName();
    }
}
