package com.players.npc;

public class Friend1 implements Friend{
    private String name = null;

    public Friend1(){

    }
    public Friend1(String name) {
        setName(name);
    }

    @Override
    public void move() {
        System.out.println(getName() + " is moving");
    }
    @Override
    public void talk() {
        System.out.println(getName() + " is talking");
    }

    @Override
    public void think() {
        System.out.println(getName() + " is thinking....");
    }

    @Override
    public void doAction() {
        System.out.println(getName() + " is doing something....");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return super.getClass().getSimpleName() + ": " +  getName();
    }
}