package com.iced.hf2020.Utilities;

import java.util.List;

public class Order {

    private List<Item> items;
    private double cost;

    public Order(List<Item> items, double cost) {
        this.items = items;
        this.cost = cost;
    }

    public Order() {
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public class Item {
        private String item;
        private double cost;
        private int count;

        public Item(String item, double cost, int count) {
            this.item = item;
            this.cost = cost;
            this.count = count;
        }

        public String getItem() {
            return item;
        }

        public void setItem(String item) {
            this.item = item;
        }

        public double getCost() {
            return cost;
        }

        public void setCost(double cost) {
            this.cost = cost;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }
    }
}
