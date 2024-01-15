// CartActivity.java
package com.androidafe.dobazar.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.androidafe.dobazar.R;
import com.androidafe.dobazar.adapters.CartAdapter;
import com.androidafe.dobazar.databinding.ActivityCartBinding;
import com.androidafe.dobazar.room.CartDB;
import com.androidafe.dobazar.room.Carts;
import com.androidafe.dobazar.utils.AuthDB;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CartActivity extends AppCompatActivity {

    private ActivityCartBinding binding;
    private List<Carts> carts;
    private CartAdapter cartAdapter;
    private CartDB db;
    private TextView totalPriceView;

    private Button buyNowBtn;
;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCartBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        totalPriceView = findViewById(R.id.totalPrice);
        carts = new ArrayList<>();
        buyNowBtn = findViewById(R.id.buyNowBtn);

        buyNowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent orderIntent = new Intent(CartActivity.this , OrderSuccess.class );
                startActivity(orderIntent);
            }
        });

        binding.back.setOnClickListener(v -> onBackPressed());

        AuthDB authDB = new AuthDB(getApplicationContext());
        String username = authDB.getUserName();

        // Check if it's the same user or a new user
        if (!authDB.isSameUser()) {
            // Different user, create a new database
            createNewDatabase(username);
        } else {
            // Same user, open the previous database
            openPreviousDatabase(username);
        }
    }

    private void createNewDatabase(String username) {
        String dbName = username + "_cart_db";
        // Store the new database name
        SharedPreferences.Editor editor = getSharedPreferences("dbStatus", MODE_PRIVATE).edit();
        editor.putString("username", username);
        editor.apply();

        // Create the new database
        db = Room.databaseBuilder(getApplicationContext(), CartDB.class, dbName).build();

        loadAndDisplayData();
    }

    private void openPreviousDatabase(String username) {
        String dbName = username + "_cart_db";

        db = Room.databaseBuilder(getApplicationContext(), CartDB.class, dbName).build();

        ExecutorService service = Executors.newSingleThreadExecutor();
        service.execute(() -> {
            carts = db.userDao().getCarts();

            runOnUiThread(() -> {
                loadAndDisplayData();
            });
        });
    }

    private void loadAndDisplayData() {
        cartAdapter = new CartAdapter(carts, CartActivity.this, totalPriceView);
        RecyclerView cartRecyclerView = findViewById(R.id.cartRecylerView); // Replace with the actual ID
        cartRecyclerView.setLayoutManager(new LinearLayoutManager(CartActivity.this));
        cartRecyclerView.setAdapter(cartAdapter);

        // Calculate total price and set it in the TextView
        double totalPrice = cartAdapter.calculateTotalPrice();
        totalPriceView.setText(String.format("%.2f", totalPrice) + " vnd");
    }


}
