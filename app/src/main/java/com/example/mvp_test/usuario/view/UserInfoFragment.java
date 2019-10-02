package com.example.mvp_test.usuario.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.bumptech.glide.Glide;
import com.example.mvp_test.R;
import com.example.mvp_test.usuario.model.User;
import com.example.mvp_test.usuario.interfaces.UserContract;


public class UserInfoFragment extends Fragment implements UserContract.UserViewContract {

    private ProgressBar progressbar;
    private ViewGroup content;
    private TextView nameTextView, lastNameTextView;
    private UserContract.UserPresenterContract presenter;
    private ImageView photoImage;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_user_info, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        progressbar = view.findViewById(R.id.progress);
        content = view.findViewById(R.id.content_info);
        nameTextView = view.findViewById(R.id.name);
        lastNameTextView = view.findViewById(R.id.lastname);
        photoImage = view.findViewById(R.id.photo);


        //presenter.loadUser();
    }

    @Override
    public void setPresenter(UserContract.UserPresenterContract presenter) {
        this.presenter = presenter;
    }

    @Override
    public void load(final boolean loading) {

        if (isAdded()) {
            content.setVisibility(loading ? View.GONE : View.VISIBLE);
            progressbar.setVisibility(loading ? View.VISIBLE : View.GONE);
        }

    }

    @Override
    public void showUserInformation(User user) {
        if (isAdded()) {
            if (user != null) {
                nameTextView.setText(user.getName());
                lastNameTextView.setText(user.getLastName());
            }
        }
    }

    @Override
    public void displayMessage(String message) {
        if (isAdded()) {
            Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void displayImage(String url) {
        if (isAdded() && getContext() != null) {
                Glide.with(getContext())
                        .load(url)
                        .centerCrop()
                        .into(photoImage);

        }

    }
}
