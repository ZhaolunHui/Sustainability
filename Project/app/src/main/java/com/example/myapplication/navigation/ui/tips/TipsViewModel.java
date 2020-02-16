package com.example.myapplication.navigation.ui.tips;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TipsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public TipsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Harmful chemicals and greenhouse gasses are released from rubbish in landfill sites. Recycling helps to reduce the pollution caused by waste.");
    }

    public LiveData<String> getText() {
        return mText;
    }
}