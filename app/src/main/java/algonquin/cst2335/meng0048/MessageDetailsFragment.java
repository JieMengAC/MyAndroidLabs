package algonquin.cst2335.meng0048;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.fragment.app.Fragment;

import algonquin.cst2335.meng0048.databinding.DetailsLayoutBinding;

public class MessageDetailsFragment extends Fragment {

    ChatMessage selected;
    public MessageDetailsFragment(ChatMessage message){
        selected = message;
    }


    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
         super.onCreateView(inflater, container, savedInstanceState);

        DetailsLayoutBinding binding = DetailsLayoutBinding.inflate(inflater);
        binding.messageDetail.setText(selected.message);
        binding.timeDetail.setText(selected.timeSent);
        binding.IDDetail.setText("ID = " + selected.id);

        return binding.getRoot();
    }
}
