package com.example.bcck.Profile;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import com.example.bcck.R;
import com.example.bcck.library.ThuVienActivity;

public class ProfileFragment extends Fragment {

    private ImageView btnBack, btnSettings, btnEditAvatar;
    private ConstraintLayout btnDocuments, btnPosts, btnLibrary, btnDownloadHistory;
    private ConstraintLayout btnMyDocuments, btnUpdateInfo, btnSecurity;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        // Lấy nút từ layout fragment
        ConstraintLayout btnLibrary = view.findViewById(R.id.btnLibrary);

        // Xử lý khi nhấn nút
        btnLibrary.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), ThuVienActivity.class);
            startActivity(intent);
        });
        return view;
    }


    private void initViews(View view) {
        btnBack = view.findViewById(R.id.btnBack);
        btnSettings = view.findViewById(R.id.btnSettings);
        btnEditAvatar = view.findViewById(R.id.btnEditAvatar);

        btnDocuments = view.findViewById(R.id.btnDocuments);
        btnPosts = view.findViewById(R.id.btnPosts);
        btnLibrary = view.findViewById(R.id.btnLibrary);
        btnDownloadHistory = view.findViewById(R.id.btnDownloadHistory);
        btnMyDocuments = view.findViewById(R.id.btnMyDocuments);
        btnUpdateInfo = view.findViewById(R.id.btnUpdateInfo);
        btnSecurity = view.findViewById(R.id.btnSecurity);
    }

    private void setupButtons() {
        btnBack.setOnClickListener(v -> {
            if (getActivity() != null) {
                getActivity().onBackPressed();
            }
        });

        btnSettings.setOnClickListener(v -> {
            Toast.makeText(getContext(), "Cài đặt", Toast.LENGTH_SHORT).show();
        });

        btnEditAvatar.setOnClickListener(v -> {
            Toast.makeText(getContext(), "Chỉnh sửa ảnh đại diện", Toast.LENGTH_SHORT).show();
            // TODO: Mở gallery để chọn ảnh
        });

        btnDocuments.setOnClickListener(v -> {
            Toast.makeText(getContext(), "Tài liệu", Toast.LENGTH_SHORT).show();
        });

        btnPosts.setOnClickListener(v -> {
            Toast.makeText(getContext(), "Bài đăng", Toast.LENGTH_SHORT).show();
        });

        btnLibrary.setOnClickListener(v -> {
            Toast.makeText(getContext(), "Thư viện của tôi", Toast.LENGTH_SHORT).show();
        });

        btnDownloadHistory.setOnClickListener(v -> {
            Toast.makeText(getContext(), "Lịch sử tải xuống", Toast.LENGTH_SHORT).show();
        });

        btnMyDocuments.setOnClickListener(v -> {
            Toast.makeText(getContext(), "Tài liệu của tôi", Toast.LENGTH_SHORT).show();
        });

        btnUpdateInfo.setOnClickListener(v -> {
            Toast.makeText(getContext(), "Cập nhật thông tin", Toast.LENGTH_SHORT).show();
        });

        btnSecurity.setOnClickListener(v -> {
            Toast.makeText(getContext(), "Bảo mật và quyền riêng tư", Toast.LENGTH_SHORT).show();
        });
    }
}