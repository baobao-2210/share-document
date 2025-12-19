package com.example.bcck.Profile;

import android.content.Intent;
<<<<<<< HEAD
=======
<<<<<<< HEAD
import android.os.Bundle;
=======
<<<<<<< HEAD
>>>>>>> 602d07c9f229f76660daa22c1f0a5b42902b6642
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
<<<<<<< HEAD
=======
=======
import android.os.Bundle;
>>>>>>> 21ea585 (update button)
>>>>>>> 764e31a0499ea9fc9ebef8490cc31b8688c58892
>>>>>>> 602d07c9f229f76660daa22c1f0a5b42902b6642
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
<<<<<<< HEAD
=======
<<<<<<< HEAD
import android.widget.Toast;
=======
<<<<<<< HEAD
>>>>>>> 602d07c9f229f76660daa22c1f0a5b42902b6642
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.PickVisualMediaRequest;
import androidx.activity.result.contract.ActivityResultContracts;
<<<<<<< HEAD
=======
=======
import android.widget.Toast;
>>>>>>> 21ea585 (update button)
>>>>>>> 764e31a0499ea9fc9ebef8490cc31b8688c58892
>>>>>>> 602d07c9f229f76660daa22c1f0a5b42902b6642
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 602d07c9f229f76660daa22c1f0a5b42902b6642
import com.bumptech.glide.Glide;
>>>>>>> 764e31a0499ea9fc9ebef8490cc31b8688c58892
import com.example.bcck.R;
import com.example.bcck.library.ThuVienActivity;

public class ProfileFragment extends Fragment {

<<<<<<< HEAD
    private ImageView btnBack, btnSettings, btnEditAvatar;
    private ConstraintLayout btnDocuments, btnPosts, btnLibrary, btnDownloadHistory;
    private ConstraintLayout btnMyDocuments, btnUpdateInfo, btnSecurity;
=======
    // Khai báo View theo đúng ID trong XML mới
    private ImageView btnBack, btnSettings, btnEditAvatar, imgAvatar;
    private TextView tvName, tvClass, tvDepartment, tvYear, tvEmail, tvTitle;
    private ConstraintLayout btnUpdateInfo, btnDocuments, btnPosts, btnLibrary, btnDownloadHistory, btnMyDocuments, btnSecurity;
    private ProgressBar progressBarAvatar;

    // Firebase
    private FirebaseAuth mAuth;
    private FirebaseFirestore db;
    private String currentUserId;

    // --- BỘ CHỌN ẢNH (Không cần xin quyền) ---
    ActivityResultLauncher<PickVisualMediaRequest> pickMedia =
            registerForActivityResult(new ActivityResultContracts.PickVisualMedia(), uri -> {
                if (uri != null) {
                    // Người dùng chọn ảnh xong -> Gọi hàm xử lý
                    xuLyVaLuuAnh(uri);
                } else {
                    Log.d("Profile", "Không chọn ảnh nào");
                }
            });
<<<<<<< HEAD
=======
=======
import com.example.bcck.R;
import com.example.bcck.library.ThuVienActivity;

public class ProfileFragment extends Fragment {

    private ImageView btnBack, btnSettings, btnEditAvatar;
    private ConstraintLayout btnDocuments, btnPosts, btnLibrary, btnDownloadHistory;
    private ConstraintLayout btnMyDocuments, btnUpdateInfo, btnSecurity;
>>>>>>> 21ea585 (update button)
>>>>>>> 764e31a0499ea9fc9ebef8490cc31b8688c58892
>>>>>>> 602d07c9f229f76660daa22c1f0a5b42902b6642

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

<<<<<<< HEAD
=======
<<<<<<< HEAD
        // Lấy nút từ layout fragment
        ConstraintLayout btnLibrary = view.findViewById(R.id.btnLibrary);
=======
<<<<<<< HEAD
>>>>>>> 602d07c9f229f76660daa22c1f0a5b42902b6642
        // 1. Khởi tạo Firebase
        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();

        if (mAuth.getCurrentUser() != null) {
            currentUserId = mAuth.getCurrentUser().getUid();
        }

        // 2. Ánh xạ và cài đặt nút bấm
        initViews(view);
        setupButtons();
>>>>>>> 764e31a0499ea9fc9ebef8490cc31b8688c58892

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

<<<<<<< HEAD
=======
        // Ánh xạ Thông tin User
        tvName = view.findViewById(R.id.tvName);
        tvClass = view.findViewById(R.id.tvClass);
        tvDepartment = view.findViewById(R.id.tvDepartment);
        tvYear = view.findViewById(R.id.tvYear);
        tvEmail = view.findViewById(R.id.tvEmail);

        // Ánh xạ Menu Card 1 (Tài liệu, Bài đăng...)
<<<<<<< HEAD
=======
=======
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

>>>>>>> 21ea585 (update button)
>>>>>>> 764e31a0499ea9fc9ebef8490cc31b8688c58892
>>>>>>> 602d07c9f229f76660daa22c1f0a5b42902b6642
        btnDocuments = view.findViewById(R.id.btnDocuments);
        btnPosts = view.findViewById(R.id.btnPosts);
        btnLibrary = view.findViewById(R.id.btnLibrary);
        btnDownloadHistory = view.findViewById(R.id.btnDownloadHistory);
        btnMyDocuments = view.findViewById(R.id.btnMyDocuments);
<<<<<<< HEAD

        // Ánh xạ Menu Card 2 (Cập nhật, Bảo mật)
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD

        // Ánh xạ Menu Card 2 (Cập nhật, Bảo mật)
=======
>>>>>>> 21ea585 (update button)
>>>>>>> 764e31a0499ea9fc9ebef8490cc31b8688c58892
>>>>>>> 602d07c9f229f76660daa22c1f0a5b42902b6642
        btnUpdateInfo = view.findViewById(R.id.btnUpdateInfo);
        btnSecurity = view.findViewById(R.id.btnSecurity);
    }

    private void setupButtons() {
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 602d07c9f229f76660daa22c1f0a5b42902b6642
        // Nút Back -> Về Home
>>>>>>> 764e31a0499ea9fc9ebef8490cc31b8688c58892
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

<<<<<<< HEAD
        // Các nút khác (Demo Toast)
        btnDocuments.setOnClickListener(v -> {
            Intent intent = new Intent(requireContext(), com.example.bcck.library.ThuVienActivity.class);
            startActivity(intent);
        });

        btnPosts.setOnClickListener(v -> {
            Intent intent = new Intent(requireContext(), com.example.bcck.poster.MyPostsActivity.class);
            startActivity(intent);
        });

        btnLibrary.setOnClickListener(v -> {
            Intent intent = new Intent(requireContext(), com.example.bcck.library.ThuVienActivity.class);
            startActivity(intent);
        });

        btnDownloadHistory.setOnClickListener(v ->
                Toast.makeText(getContext(), "Lịch sử tải xuống", Toast.LENGTH_SHORT).show());

        btnMyDocuments.setOnClickListener(v -> {
            Intent intent = new Intent(requireContext(), com.example.bcck.poster.MyPostsActivity.class);
            startActivity(intent);
        });

        btnSecurity.setOnClickListener(v ->
                Toast.makeText(getContext(), "Bảo mật và quyền riêng tư", Toast.LENGTH_SHORT).show());

        btnSettings.setOnClickListener(v -> Toast.makeText(getContext(), "Cài đặt", Toast.LENGTH_SHORT).show());
    }
=======
        btnDocuments.setOnClickListener(v -> {
            Toast.makeText(getContext(), "Tài liệu", Toast.LENGTH_SHORT).show();
        });
>>>>>>> 602d07c9f229f76660daa22c1f0a5b42902b6642

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

<<<<<<< HEAD
        btnSecurity.setOnClickListener(v -> {
            Toast.makeText(getContext(), "Bảo mật và quyền riêng tư", Toast.LENGTH_SHORT).show();
        });
=======
            // 4. Lưu vào Firestore
            Map<String, Object> data = new HashMap<>();
            data.put("avatarUrl", base64String);

            // Dùng SetOptions.merge() để: Nếu chưa có hồ sơ thì TẠO MỚI, có rồi thì CẬP NHẬT
            db.collection("users").document(currentUserId)
                    .set(data, SetOptions.merge())
                    .addOnSuccessListener(aVoid -> {
                        Toast.makeText(getContext(), "Đổi ảnh thành công!", Toast.LENGTH_SHORT).show();

                        // Hiển thị ảnh mới ngay lập tức
                        Glide.with(this)
                                .load(imageBytes) // Glide load trực tiếp từ byte array
                                .circleCrop()
                                .into(imgAvatar);

                        progressBarAvatar.setVisibility(View.GONE); // Tắt loading
                    })
                    .addOnFailureListener(e -> {
                        Toast.makeText(getContext(), "Lỗi: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                        progressBarAvatar.setVisibility(View.GONE);
                    });

        } catch (IOException e) {
            e.printStackTrace();
            progressBarAvatar.setVisibility(View.GONE);
            Toast.makeText(getContext(), "Lỗi đọc file ảnh", Toast.LENGTH_SHORT).show();
        }
    }

    // Hàm phụ trợ để thu nhỏ ảnh (Giữ nguyên tỷ lệ khung hình)
    public static Bitmap scaleDown(Bitmap realImage, float maxImageSize, boolean filter) {
        float ratio = Math.min(
                (float) maxImageSize / realImage.getWidth(),
                (float) maxImageSize / realImage.getHeight());
        int width = Math.round((float) ratio * realImage.getWidth());
        int height = Math.round((float) ratio * realImage.getHeight());

        return Bitmap.createScaledBitmap(realImage, width, height, filter);
    }

    // --- TẢI DỮ LIỆU TỪ FIREBASE ---
    private void getUserProfile() {
        if (currentUserId == null) return;

        db.collection("users").document(currentUserId).get()
                .addOnSuccessListener(documentSnapshot -> {
                    if (documentSnapshot.exists()) {
                        User user = documentSnapshot.toObject(User.class);
                        if (user != null) {
                            updateUI(user);
                        }
                    }
                })
                .addOnFailureListener(e -> Log.e("Profile", "Lỗi tải dữ liệu", e));
    }

    private void updateUI(User user) {
        if (getContext() == null) return;

        // Set text
        // Kiểm tra null để tránh hiện "null" lên màn hình
        tvName.setText("Họ và tên : " + (user.getFullName() != null ? user.getFullName() : "..."));
        tvClass.setText("Lớp : " + (user.getClassName() != null ? user.getClassName() : "..."));
        tvDepartment.setText("Khoa : " + (user.getDepartment() != null ? user.getDepartment() : "..."));
        tvYear.setText("Khóa : " + (user.getCourseYear() != null ? user.getCourseYear() : "..."));
        tvEmail.setText("Email : " + (user.getEmail() != null ? user.getEmail() : "..."));

        // Xử lý hiển thị ảnh
        String avatarData = user.getAvatarUrl();
        if (avatarData != null && !avatarData.isEmpty()) {
            // Trường hợp 1: Nếu là link http (Cách cũ hoặc link mạng)
            if (avatarData.startsWith("http")) {
                Glide.with(this).load(avatarData).circleCrop().into(imgAvatar);
            }
            // Trường hợp 2: Nếu là chuỗi Base64 (Cách mới tiết kiệm tiền)
            else {
                try {
                    byte[] imageByteArray = Base64.decode(avatarData, Base64.DEFAULT);
                    Glide.with(this)
                            .load(imageByteArray)
                            .circleCrop()
                            .placeholder(android.R.drawable.ic_menu_myplaces)
                            .into(imgAvatar);
                } catch (IllegalArgumentException e) {
                    Log.e("Profile", "Lỗi giải mã ảnh Base64");
                }
            }
        }
<<<<<<< HEAD
=======
=======
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
>>>>>>> 21ea585 (update button)
>>>>>>> 764e31a0499ea9fc9ebef8490cc31b8688c58892
>>>>>>> 602d07c9f229f76660daa22c1f0a5b42902b6642
    }
}
