package com.example.bcck.Home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.bcck.R;

public class HomeFragment extends Fragment {

    // Cloud Storage Cards
    private CardView cardDropbox, cardGDrive, cardOneDrive1, cardOneDrive2;

    // Filter Buttons
    private Button btnAll, btnPopular, btnNewest;

    // PDF Items
    private CardView pdfItem1, pdfItem2, pdfItem3;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // Khởi tạo views
        initViews(view);

        // Gắn sự kiện cho nút chuông
        ImageView iconNoti = view.findViewById(R.id.iconNotification);

        iconNoti.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), NotificationActivity.class);
            startActivity(intent);
        });

        // Các hàm setup có sẵn
        setupCloudStorageCards();
        setupFilterButtons();
        setupPdfItems();

        return view;
    }

    private void initViews(View view) {
        // Cloud Storage Cards
        cardDropbox = view.findViewById(R.id.cardDropbox);
        cardGDrive = view.findViewById(R.id.cardGDrive);
        cardOneDrive1 = view.findViewById(R.id.cardOneDrive1);
        cardOneDrive2 = view.findViewById(R.id.cardOneDrive2);

        // Filter Buttons
        btnAll = view.findViewById(R.id.btnAll);
        btnPopular = view.findViewById(R.id.btnPopular);
        btnNewest = view.findViewById(R.id.btnNewest);

        // PDF Items
        pdfItem1 = view.findViewById(R.id.pdfItem1);
        pdfItem2 = view.findViewById(R.id.pdfItem2);
        pdfItem3 = view.findViewById(R.id.pdfItem3);
    }

    private void setupCloudStorageCards() {
        // Dropbox Card Click
        cardDropbox.setOnClickListener(v -> {
            Toast.makeText(getContext(), "Đang mở Dropbox...", Toast.LENGTH_SHORT).show();
            // TODO: Mở màn hình Dropbox files
        });

        // Google Drive Card Click
        cardGDrive.setOnClickListener(v -> {
            Toast.makeText(getContext(), "Đang mở Google Drive...", Toast.LENGTH_SHORT).show();
            // TODO: Mở màn hình Google Drive files
        });

        // OneDrive 1 Card Click
        cardOneDrive1.setOnClickListener(v -> {
            Toast.makeText(getContext(), "Đang mở Nirwna - OneDrive...", Toast.LENGTH_SHORT).show();
            // TODO: Mở màn hình OneDrive files
        });

        // OneDrive 2 Card Click
        cardOneDrive2.setOnClickListener(v -> {
            Toast.makeText(getContext(), "Đang mở PIDT - OneDrive...", Toast.LENGTH_SHORT).show();
            // TODO: Mở màn hình OneDrive files
        });
    }

    private void setupFilterButtons() {
        // Button Tất Cả
        btnAll.setOnClickListener(v -> {
            selectFilterButton(btnAll);
            Toast.makeText(getContext(), "Hiển thị tất cả tài liệu", Toast.LENGTH_SHORT).show();
            // TODO: Load all documents
        });

        // Button Phổ Biến
        btnPopular.setOnClickListener(v -> {
            selectFilterButton(btnPopular);
            Toast.makeText(getContext(), "Hiển thị tài liệu phổ biến", Toast.LENGTH_SHORT).show();
            // TODO: Load popular documents
        });

        // Button Mới Nhất
        btnNewest.setOnClickListener(v -> {
            selectFilterButton(btnNewest);
            Toast.makeText(getContext(), "Hiển thị tài liệu mới nhất", Toast.LENGTH_SHORT).show();
            // TODO: Load newest documents
        });
    }

    private void selectFilterButton(Button selectedButton) {
        // Reset tất cả buttons về màu xám
        btnAll.setBackgroundTintList(getResources().getColorStateList(android.R.color.darker_gray, null));
        btnAll.setTextColor(0xFF000000);

        btnPopular.setBackgroundTintList(getResources().getColorStateList(android.R.color.darker_gray, null));
        btnPopular.setTextColor(0xFF000000);

        btnNewest.setBackgroundTintList(getResources().getColorStateList(android.R.color.darker_gray, null));
        btnNewest.setTextColor(0xFF000000);

        // Highlight button được chọn
        selectedButton.setBackgroundTintList(getResources().getColorStateList(android.R.color.holo_blue_dark, null));
        selectedButton.setTextColor(0xFFFFFFFF);
    }

    private void setupPdfItems() {
        // PDF Item 1 Click
        pdfItem1.setOnClickListener(v -> {
            Toast.makeText(getContext(), "Mở: Lập Trình Hướng Đối Tượng Chương I", Toast.LENGTH_SHORT).show();
            // TODO: Mở PDF viewer hoặc download
            openPdfDetail("Lập Trình Hướng Đối Tượng Chương I", "156", "29", "4.3");
        });

        // PDF Item 2 Click
        pdfItem2.setOnClickListener(v -> {
            Toast.makeText(getContext(), "Mở: Lập trình Điện Thoại Di Động Chương II", Toast.LENGTH_SHORT).show();
            openPdfDetail("Lập trình Điện Thoại Di Động Chương II", "156", "29", "4.3");
        });

        // PDF Item 3 Click
        pdfItem3.setOnClickListener(v -> {
            Toast.makeText(getContext(), "Mở: Lập trình Điện Thoại Di Động Chương III", Toast.LENGTH_SHORT).show();
            openPdfDetail("Lập trình Điện Thoại Di Động Chương III", "412", "89", "4.9");
        });
    }

    private void openPdfDetail(String title, String downloads, String likes, String rating) {
        // TODO: Chuyển sang PdfDetailActivity hoặc PdfDetailFragment
        // Intent intent = new Intent(getActivity(), PdfDetailActivity.class);
        // intent.putExtra("title", title);
        // intent.putExtra("downloads", downloads);
        // intent.putExtra("likes", likes);
        // intent.putExtra("rating", rating);
        // startActivity(intent);

        Toast.makeText(getContext(),
                "Tài liệu: " + title + "\n" +
                        "Downloads: " + downloads + " | Likes: " + likes + " | Rating: " + rating,
                Toast.LENGTH_LONG).show();
    }


}