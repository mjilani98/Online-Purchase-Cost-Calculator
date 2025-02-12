package com.example.hw2q2;

public class DeliveryCost {

    private double price;

    private boolean warranty;

    private boolean insurance;

    private String delivery;

    public DeliveryCost(double price,boolean warranty,boolean insurance,String delivery)
    {
        this.price = price;
        this.warranty = warranty;
        this.insurance=insurance;
        this.delivery=delivery;
    }

    public double getCost()
    {
        double total =0 ;

        //if the customer added a warranty , 10% of the price will be added to the total
        if(warranty == true)
            total += (price*0.10);

        //if the customer added an insurance , 5% of the price will be added to the total
        if(insurance == true)
            total += (price*0.05);

        //if the user choose a normal delivery , it costs $5
        if(delivery == "Normal")
            total += 5;
        //if the user choose a second day delivery , it costs $10
        else if (delivery == "Second day")
        {
            total += 10;
        }
        //if the user choose a next day delivery , it costs $20
        else if (delivery == "Next day")
        {
            total += 20;
        }

        //adding the price to the total , which is total cost of delivery
        total += price;

        return total;
    }
}
