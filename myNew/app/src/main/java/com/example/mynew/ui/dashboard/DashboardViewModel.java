package com.example.mynew.ui.dashboard;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mynew.R;

public class DashboardViewModel extends ViewModel {

    private final MutableLiveData<String> mText;
    private final MutableLiveData<Integer> src;

    public DashboardViewModel() {
        mText = new MutableLiveData<>();
        src=new MutableLiveData<>();
        mText.setValue("This is dashboard fragment");
        src.setValue(R.mipmap.ic_launcher);

    }

    public LiveData<String> getText() {
        return mText;
    }
    public LiveData<Integer> getsrc(){return src;}
}