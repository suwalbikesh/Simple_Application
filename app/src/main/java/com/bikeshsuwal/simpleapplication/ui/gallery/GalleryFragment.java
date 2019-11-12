package com.bikeshsuwal.simpleapplication.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bikeshsuwal.simpleapplication.R;
import com.bikeshsuwal.simpleapplication.adapters.ContactsAdapter;
import com.bikeshsuwal.simpleapplication.model.Contacts;

import java.util.ArrayList;
import java.util.List;

public class GalleryFragment extends Fragment {
    private RecyclerView recyclerView;

    private GalleryViewModel galleryViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                ViewModelProviders.of(this).get(GalleryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);
        recyclerView = root.findViewById(R.id.recyclerView);

        //create list to display on recycle view
        List<Contacts> contactsList = new ArrayList<>();
        contactsList.add(new Contacts("Dahayang","98545464324",R.drawable.dahayang));
        contactsList.add(new Contacts("Bhuwan","98545464324",R.drawable.bhuwan));
        contactsList.add(new Contacts("saugat","98545464324",R.drawable.saugat));
        contactsList.add(new Contacts("Dahayang","98545464324",R.drawable.dahayang));
        contactsList.add(new Contacts("Bhuwan","98545464324",R.drawable.bhuwan));
        contactsList.add(new Contacts("saugat","98545464324",R.drawable.saugat));
        contactsList.add(new Contacts("Dahayang","98545464324",R.drawable.dahayang));
        contactsList.add(new Contacts("Bhuwan","98545464324",R.drawable.bhuwan));
        contactsList.add(new Contacts("saugat","98545464324",R.drawable.saugat));

        ContactsAdapter contactsAdapter = new ContactsAdapter(getActivity(),contactsList);
        recyclerView.setAdapter(contactsAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return root;
    }
}