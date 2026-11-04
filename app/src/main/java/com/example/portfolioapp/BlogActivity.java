package com.example.portfolioapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.portfolioapp.databinding.ActivityBlogBinding;

import java.util.Arrays;
import java.util.List;

public class BlogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        ActivityBlogBinding binding = ActivityBlogBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(binding.getRoot(), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        binding.rvBlogPosts.setLayoutManager(new LinearLayoutManager(this));

        List<String> posts = Arrays.asList(
                "My First Android App",
                "Learning Java Programming",
                "Introduction to Git and GitHub",
                "My Software Engineering Journey"
        );

        BlogAdapter adapter = new BlogAdapter(posts);
        binding.rvBlogPosts.setAdapter(adapter);
    }
}