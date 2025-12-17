package com.example.bcck.Chat;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bcck.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class ChatDetailActivity extends AppCompatActivity {

    private static final String TAG = "ChatDebug"; // Thêm TAG để dễ filter Log

    private RecyclerView recyclerViewMessages;
    private MessageAdapter messageAdapter;
    private List<Message> messageList;
    private EditText etMessage;
    private ImageView btnSend;
    private LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_detail);

        String chatName = getIntent().getStringExtra("chatName");

        TextView tvTitle = findViewById(R.id.tvChatDetailTitle);
        ImageView btnBack = findViewById(R.id.btnBackChatDetail);
        recyclerViewMessages = findViewById(R.id.recyclerViewMessages);
        etMessage = findViewById(R.id.etMessage);
        btnSend = findViewById(R.id.btnSend);

        tvTitle.setText(chatName);
        btnBack.setOnClickListener(v -> finish());

        setupRecyclerView();
        loadSampleMessages();

        btnSend.setOnClickListener(v -> sendMessage());
    }

    private void setupRecyclerView() {
        messageList = new ArrayList<>();
        messageAdapter = new MessageAdapter(messageList);

        layoutManager = new LinearLayoutManager(this);
        layoutManager.setStackFromEnd(true);

        recyclerViewMessages.setLayoutManager(layoutManager);
        recyclerViewMessages.setAdapter(messageAdapter);

        Log.d(TAG, "RecyclerView setup complete");
    }

    private void loadSampleMessages() {
        messageList.add(new Message("Chào mọi người!", "Nguyễn Văn A", "10:00", false));
        messageList.add(new Message("Hi bạn!", "Me", "10:01", true));
        messageList.add(new Message("Hôm nay làm bài tập chưa?", "Trần Thị B", "10:05", false));
        messageList.add(new Message("Tôi làm xong rồi", "Me", "10:06", true));

        messageAdapter.notifyDataSetChanged();

        Log.d(TAG, "Sample messages loaded. Total: " + messageList.size());

        if (messageList.size() > 0) {
            recyclerViewMessages.scrollToPosition(messageList.size() - 1);
        }
    }

    private void sendMessage() {
        String messageText = etMessage.getText().toString().trim();

        Log.d(TAG, "========== SEND MESSAGE START ==========");
        Log.d(TAG, "Input text: '" + messageText + "'");
        Log.d(TAG, "Is empty: " + messageText.isEmpty());

        if (!messageText.isEmpty()) {
            // Lấy thời gian hiện tại
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm", Locale.getDefault());
            String currentTime = sdf.format(new Date());

            Log.d(TAG, "Current time: " + currentTime);

            // Tạo tin nhắn mới
            Message newMessage = new Message(messageText, "Me", currentTime, true);

            Log.d(TAG, "Message object created");
            Log.d(TAG, "Before add - List size: " + messageList.size());

            // Thêm vào danh sách
            messageList.add(newMessage);

            Log.d(TAG, "After add - List size: " + messageList.size());
            Log.d(TAG, "Last message: " + messageList.get(messageList.size() - 1).getText());

            // Cập nhật adapter
            messageAdapter.notifyItemInserted(messageList.size() - 1);
            Log.d(TAG, "notifyItemInserted called for position: " + (messageList.size() - 1));

            // Thử cả notifyDataSetChanged
            // messageAdapter.notifyDataSetChanged();
            // Log.d(TAG, "notifyDataSetChanged called");

            // Scroll xuống tin nhắn mới
            recyclerViewMessages.post(() -> {
                Log.d(TAG, "Scrolling to position: " + (messageList.size() - 1));
                recyclerViewMessages.smoothScrollToPosition(messageList.size() - 1);
            });

            // Xóa nội dung input
            etMessage.setText("");
            etMessage.clearFocus();

            Log.d(TAG, "Input cleared");
        } else {
            Log.w(TAG, "Message is empty, not sending");
        }

        Log.d(TAG, "========== SEND MESSAGE END ==========");
    }
}