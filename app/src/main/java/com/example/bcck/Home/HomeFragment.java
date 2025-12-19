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
<<<<<<< HEAD

import com.example.bcck.R;
=======
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bcck.R;
import com.example.bcck.data.DocumentSort;
import com.example.bcck.data.FirestoreDocumentRepository;
import com.example.bcck.data.SampleDocumentsSeeder;
import com.example.bcck.poster.Document;
import com.example.bcck.poster.DocumentAdapter;
import com.example.bcck.poster.DocumentDetailActivity;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;
import android.content.pm.ApplicationInfo;
>>>>>>> 21ea585 (update button)

public class HomeFragment extends Fragment {

    // Cloud Storage Cards
    private CardView cardDropbox, cardGDrive, cardOneDrive1, cardOneDrive2;

    // Filter Buttons
    private Button btnAll, btnPopular, btnNewest;

<<<<<<< HEAD
    // PDF Items
    private CardView pdfItem1, pdfItem2, pdfItem3;
=======
    private RecyclerView recyclerViewHomeDocuments;
    private DocumentAdapter documentAdapter;
    private final List<Document> homeDocuments = new ArrayList<>();
    private ImageView addIcon;

    private final FirestoreDocumentRepository documentRepository = new FirestoreDocumentRepository();
>>>>>>> 21ea585 (update button)

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
<<<<<<< HEAD
        setupPdfItems();
=======
        setupRecyclerView();
        setupSeedButton();
        loadTopDocuments(DocumentSort.ALL);
>>>>>>> 21ea585 (update button)

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

<<<<<<< HEAD
        // PDF Items
        pdfItem1 = view.findViewById(R.id.pdfItem1);
        pdfItem2 = view.findViewById(R.id.pdfItem2);
        pdfItem3 = view.findViewById(R.id.pdfItem3);
=======
        addIcon = view.findViewById(R.id.addIcon);
        recyclerViewHomeDocuments = view.findViewById(R.id.recyclerViewHomeDocuments);
>>>>>>> 21ea585 (update button)
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
<<<<<<< HEAD
            // TODO: Load all documents
=======
            loadTopDocuments(DocumentSort.ALL);
>>>>>>> 21ea585 (update button)
        });

        // Button Phổ Biến
        btnPopular.setOnClickListener(v -> {
            selectFilterButton(btnPopular);
            Toast.makeText(getContext(), "Hiển thị tài liệu phổ biến", Toast.LENGTH_SHORT).show();
<<<<<<< HEAD
            // TODO: Load popular documents
=======
            loadTopDocuments(DocumentSort.POPULAR);
>>>>>>> 21ea585 (update button)
        });

        // Button Mới Nhất
        btnNewest.setOnClickListener(v -> {
            selectFilterButton(btnNewest);
            Toast.makeText(getContext(), "Hiển thị tài liệu mới nhất", Toast.LENGTH_SHORT).show();
<<<<<<< HEAD
            // TODO: Load newest documents
=======
            loadTopDocuments(DocumentSort.NEWEST);
>>>>>>> 21ea585 (update button)
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

<<<<<<< HEAD
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
=======
    private void setupRecyclerView() {
        recyclerViewHomeDocuments.setLayoutManager(new LinearLayoutManager(getContext()));

        documentAdapter = new DocumentAdapter(homeDocuments, new DocumentAdapter.OnDocumentClickListener() {
            @Override
            public void onDocumentClick(Document document) {
                openDocumentDetail(document);
            }

            @Override
            public void onMoreClick(Document document) {
                Toast.makeText(getContext(), "Options cho: " + document.getTitle(), Toast.LENGTH_SHORT).show();
            }
        });

        recyclerViewHomeDocuments.setAdapter(documentAdapter);
    }

    private void setupSeedButton() {
        if (addIcon == null) return;

        addIcon.setOnClickListener(v -> {
            boolean isDebuggable = false;
            if (getContext() != null) {
                int flags = getContext().getApplicationInfo().flags;
                isDebuggable = (flags & ApplicationInfo.FLAG_DEBUGGABLE) != 0;
            }

            if (!isDebuggable) {
                Toast.makeText(getContext(), "Chức năng này chỉ bật trong debug.", Toast.LENGTH_SHORT).show();
                return;
            }

            Toast.makeText(getContext(), "Đang tạo dữ liệu mẫu CNTT...", Toast.LENGTH_SHORT).show();
            SampleDocumentsSeeder.seedComputerSciencePdfs(FirebaseFirestore.getInstance(), new SampleDocumentsSeeder.SeedCallback() {
                @Override
                public void onSuccess(int upsertedCount) {
                    if (!isAdded()) return;
                    Toast.makeText(getContext(), "Đã tạo " + upsertedCount + " tài liệu mẫu.", Toast.LENGTH_SHORT).show();
                    // Sample mới seed có uploadTimestamp mới nhất -> chuyển sang "Mới Nhất" để dễ thấy ngay trên đầu list.
                    selectFilterButton(btnNewest);
                    loadTopDocuments(DocumentSort.NEWEST);
                }

                @Override
                public void onError(@NonNull Exception error) {
                    if (!isAdded()) return;
                    Toast.makeText(getContext(), "Tạo dữ liệu mẫu lỗi: " + error.getMessage(), Toast.LENGTH_LONG).show();
                }
            });
        });
    }

    private void loadTopDocuments(@NonNull DocumentSort sort) {
        documentRepository.loadTopDocuments(sort, 30, new FirestoreDocumentRepository.LoadDocumentsCallback() {
            @Override
            public void onSuccess(@NonNull List<Document> documents) {
                if (!isAdded()) return;

                homeDocuments.clear();
                homeDocuments.addAll(documents);
                documentAdapter.notifyDataSetChanged();
            }

            @Override
            public void onError(@NonNull Exception error) {
                if (!isAdded()) return;
                Toast.makeText(getContext(), "Lỗi tải dữ liệu: " + error.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    private void openDocumentDetail(@NonNull Document document) {
        Intent intent = new Intent(getActivity(), DocumentDetailActivity.class);
        intent.putExtra(DocumentDetailActivity.EXTRA_DOCUMENT, document);
        startActivity(intent);
    }


}
>>>>>>> 21ea585 (update button)
