package com.example.bcck.poster;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;
import android.widget.Toast;

import com.example.bcck.Chat.ChatActivity;
import com.example.bcck.Chat.ChatDetailActivity;
import com.example.bcck.Chat.ChatFragment;
import com.example.bcck.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DocumentDetailActivity extends AppCompatActivity {

    public static final String EXTRA_DOCUMENT = "DOCUMENT_DETAIL";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_detail);

        Document document = (Document) getIntent().getSerializableExtra(EXTRA_DOCUMENT);

        if (document != null) {

            // 1. THAM CHIẾU TẤT CẢ CÁC VIEWS (KHAI BÁO MỘT LẦN)
            TextView tvAuthorName = findViewById(R.id.tvAuthorName);
            TextView tvDocumentTitle = findViewById(R.id.tvDocumentTitle);
            TextView tvFileType = findViewById(R.id.tvFileType);
            TextView tvSubject = findViewById(R.id.tvSubject);
            TextView tvTeacher = findViewById(R.id.tvTeacher);
            TextView tvCourse = findViewById(R.id.tvCourse);
            TextView tvYear = findViewById(R.id.tvYear);
            TextView tvUploader = findViewById(R.id.tvUploader);
            TextView tvUploadDate = findViewById(R.id.tvUploadDate);
            TextView tvDownloads = findViewById(R.id.tvDownloads);
            TextView tvRating = findViewById(R.id.tvRating);

            // Tham chiếu các nút thao tác
            Button btnDownload = findViewById(R.id.btnDownload);
            Button btnShare = findViewById(R.id.btnShare);
            Button btnPreview = findViewById(R.id.btnPreview);
            Button btnMessage = findViewById(R.id.btnMessage);
            // KHAI BÁO btnClose LẦN DUY NHẤT Ở ĐÂY
            ImageView btnClose = findViewById(R.id.btnClose);

            // 2. GÁN DỮ LIỆU HIỂN THỊ
            tvAuthorName.setText(document.getAuthorName());
            tvDocumentTitle.setText(document.getTitle());
            tvFileType.setText(document.getDocType());
            tvSubject.setText(document.getSubject());
            tvTeacher.setText(document.getTeacher());
            tvCourse.setText(document.getMajor());
            tvYear.setText("Năm học: " + document.getYear());
            tvUploader.setText("Đăng bởi: " + document.getUploaderName());

            String dateString = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
                    .format(new Date(document.getUploadTimestamp()));
            tvUploadDate.setText("Ngày đăng: " + dateString);

            tvDownloads.setText(String.valueOf(document.getDownloads()));
            tvRating.setText(String.format("%.1f", document.getRating()));


            // 3. GÁN ONCLICK LISTENER (Các nút thao tác)

            // Nút Tải xuống
            btnDownload.setOnClickListener(v -> {
                handleDownload(document);
            });

            // Nút Chia sẻ
            btnShare.setOnClickListener(v -> {
                handleShare(document);
            });

            // Nút Xem trước
            btnPreview.setOnClickListener(v -> {
                handlePreview(document);
            });

            // Nút Nhắn tin
            btnMessage.setOnClickListener(v -> {
                handleMessage(document);
            });

            // Nút Thoát/Đóng (btnClose)
            btnClose.setOnClickListener(v -> {
                finish(); // <-- Thao tác đóng Activity
            });

        } else {
            finish();
        }
    }


    private void handleDownload(Document document) {

        if (document.getFileUrl() == null || document.getFileUrl().isEmpty()) {
            Toast.makeText(this, "File không tồn tại!", Toast.LENGTH_SHORT).show();
            return;
        }

        // ✅ FIX CLOUDINARY LINK
        String downloadUrl = document.getFileUrl()
                .replace("/raw/upload/", "/raw/upload/fl_attachment/");

        Uri uri = Uri.parse(downloadUrl);

        String fileName = document.getTitle();
        if (!fileName.toLowerCase().endsWith(".pdf")) {
            fileName += ".pdf";
        }

        DownloadManager.Request request = new DownloadManager.Request(uri);
        request.setTitle(fileName);
        request.setDescription("Đang tải tài liệu...");
        request.setNotificationVisibility(
                DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED
        );

        request.setMimeType("application/pdf");
        request.allowScanningByMediaScanner();

        request.setDestinationInExternalPublicDir(
                Environment.DIRECTORY_DOWNLOADS,
                fileName
        );

        DownloadManager manager =
                (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);

        if (manager != null) {
            manager.enqueue(request);
            Toast.makeText(this, "Đang tải xuống...", Toast.LENGTH_SHORT).show();
        }
    }


    private void handleShare(Document document) {
        Intent sendIntent = new Intent(Intent.ACTION_SEND);
        sendIntent.setType("text/plain");
        sendIntent.putExtra(Intent.EXTRA_SUBJECT, "Chia sẻ tài liệu: " + document.getTitle());
        sendIntent.putExtra(Intent.EXTRA_TEXT, "Hãy xem tài liệu này: " + document.getTitle() +
                "\nLink tải (nếu có): https://docs.google.com/document/create?hl=vi");
        startActivity(Intent.createChooser(sendIntent, "Chia sẻ tài liệu qua..."));
    }

    private void handlePreview(Document document) {

        if (document.getFileUrl() == null || document.getFileUrl().isEmpty()) {
            Toast.makeText(this, "Không có file!", Toast.LENGTH_SHORT).show();
            return;
        }

        // Google PDF Viewer
        String googleViewerUrl =
                "https://drive.google.com/viewerng/viewer?embedded=true&url="
                        + document.getFileUrl();

        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(googleViewerUrl));

        try {
            startActivity(intent);
        } catch (Exception e) {
            Toast.makeText(this, "Không thể xem trước file PDF", Toast.LENGTH_SHORT).show();
        }
    }



    private void handleMessage(Document document) {
        // Lấy thông tin cần thiết từ Document
        String receiverName = document.getUploaderName();
        // Giả sử có hàm getUploaderId() trong lớp Document
        String receiverId = document.getUploaderId();
        // Kiểm tra dữ liệu và khởi chạy Activity
        if (receiverName != null && !receiverName.isEmpty() && receiverId != null && !receiverId.isEmpty()) {

            // 1. Tạo Intent
            // CHÚ Ý: Đảm bảo đã import com.example.bcck.chat.ChatActivity;
            Intent intent = new Intent(this, ChatDetailActivity.class);

            // 2. Truyền dữ liệu người nhận.
            // SỬ DỤNG CÁC KEY MÀ ChatActivity CỦA BẠN DÙNG ĐỂ NHẬN DỮ LIỆU.
            intent.putExtra("RECEIVER_NAME", receiverName);
            intent.putExtra("RECEIVER_ID", receiverId);

            // 3. Khởi chạy
            startActivity(intent);

        } else {
            Toast.makeText(this, "Không thể xác định người nhận để chat.", Toast.LENGTH_SHORT).show();
        }
    }

}