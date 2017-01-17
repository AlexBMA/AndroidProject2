package com.example.alexandru.justjava;

import android.content.SyncStatusObserver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.widget.TextView;

import java.text.NumberFormat;

import static android.R.attr.y;
import static android.R.id.message;

public class MainActivity extends AppCompatActivity {

    int quantity = 0;
    int price = 5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {

        String message = createOrderSummary();
        displayMessage(message);

    }

    /**
     * Calculates the price of the order based on the current quantity.
     *
     * @return the price
     */
    private int calculatePrice() {

        return quantity * price;
    }

    /**
     * Creates a summary for the order
     * @return text summary
     */

    private String createOrderSummary() {
        String name = "Alex Burghelea";

        String message = "Name: " + name +
                "\nQuantity: " + quantity +
                "\nTotal: " + calculatePrice() +
                "$" + "\nThank you";

        return message;
    }

    /**
     * This is the increment method
     */
    public void increment(View view) {

        quantity++;
        display(quantity);
        // displayPrice(quantity*price);
    }

    /**
     * This is the decrement method
     */
    public void decrement(View view) {
        if (quantity > 1) {
            quantity--;
        }

        display(quantity);
        // displayPrice(quantity*price);
    }


    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.order_summary_text_view);
        quantityTextView.setText("" + number);
    }



    /**
     * This method displays a message on the screen
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }

}
