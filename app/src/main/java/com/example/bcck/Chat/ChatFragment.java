package com.example.bcck.Chat;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bcck.HomeActivity;
import com.example.bcck.R;

import java.util.ArrayList;
import java.util.List;

public class ChatFragment extends Fragment {

    private RecyclerView recyclerViewChats;
    private ChatAdapter chatAdapter;
    private List<ChatItem> chatList;
    private List<ChatItem> filteredChatList;

    private EditText searchBox;
    private ImageView btnBack, iconSettings, iconNotification, iconProfile;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chat, container, false);

        initViews(view);
        setupRecyclerView();
        setupSearch();
        setupButtons();
        loadChatData();

        return view;
    }

    private void initViews(View view) {
        recyclerViewChats = view.findViewById(R.id.recyclerViewChats);
        searchBox = view.findViewById(R.id.searchBox);
        btnBack = view.findViewById(R.id.btnBack);
        iconSettings = view.findViewById(R.id.iconSettings);
        iconNotification = view.findViewById(R.id.iconNotification);
        iconProfile = view.findViewById(R.id.iconProfile);
    }

    private void setupRecyclerView() {
        recyclerViewChats.setLayoutManager(new LinearLayoutManager(getContext()));

        chatList = new ArrayList<>();
        filteredChatList = new ArrayList<>();

        chatAdapter = new ChatAdapter(filteredChatList, chatItem -> {
            // Khi click vào chat → Mở màn hình ChatDetailActivity
            Intent intent = new Intent(getActivity(), ChatDetailActivity.class);
            intent.putExtra("chatName", chatItem.getChatName());
            intent.putExtra("isGroup", chatItem.isGroup());
            startActivity(intent);
        });

        recyclerViewChats.setAdapter(chatAdapter);
    }

    private void setupSearch() {
        searchBox.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                filterChats(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });
    }

    private void setupButtons() {
        btnBack.setOnClickListener(v -> {
            // Thay 'MainActivity.class' bằng tên file Activity trang chủ của bạn
            Intent intent = new Intent(getActivity(), HomeActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            if (getActivity() != null) {
                getActivity().finish();
            }
        });

        iconSettings.setOnClickListener(v -> {
            Toast.makeText(getContext(), "Cài đặt", Toast.LENGTH_SHORT).show();
        });

        iconNotification.setOnClickListener(v -> {
            Toast.makeText(getContext(), "Thông báo", Toast.LENGTH_SHORT).show();
        });

        iconProfile.setOnClickListener(v -> {
            Toast.makeText(getContext(), "Cá nhân", Toast.LENGTH_SHORT).show();
        });
    }

    private void loadChatData() {
        // Dữ liệu mẫu
        chatList.clear();
        chatList.add(new ChatItem(
                "Nhóm Học Tập OOAD01",
                "Mọi người đã về usecase chưa",
                "10:30",
                "OOA",
                true
        ));

        chatList.add(new ChatItem(
                "TS. Nguyễn Quốc Hùng",
                "Em nhớ làm bài tập thầy giao...",
                "09:15",
                "QH",
                false
        ));

        chatList.add(new ChatItem(
                "Nhóm Lập Trình Di Động",
                "Ai đã làm xong bài tập chưa?",
                "Hôm qua",
                "NT",
                true
        ));

        chatList.add(new ChatItem(
                "ThS. Đỗ Phú Huy",
                "Lớp học tuần sau nghỉ nhé các em",
                "Hôm qua",
                "ML",
                false
        ));

        chatList.add(new ChatItem(
                "Nhóm Cơ Sở Dữ Liệu",
                "Meeting lúc 2h chiều nha mọi người",
                "T2",
                "N",
                true
        ));

        filteredChatList.clear();
        filteredChatList.addAll(chatList);
        chatAdapter.notifyDataSetChanged();
    }

    private void filterChats(String query) {
        filteredChatList.clear();

        if (query.isEmpty()) {
            filteredChatList.addAll(chatList);
        } else {
            String lowerQuery = query.toLowerCase();
            for (ChatItem chat : chatList) {
                if (chat.getChatName().toLowerCase().contains(lowerQuery) ||
                        chat.getLastMessage().toLowerCase().contains(lowerQuery)) {
                    filteredChatList.add(chat);
                }
            }
        }

        chatAdapter.notifyDataSetChanged();
    }
}