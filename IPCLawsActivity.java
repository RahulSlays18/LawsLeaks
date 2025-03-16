package com.pandeyrahul.lawleaks.DATA;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;
import com.pandeyrahul.lawleaks.R;

public class IPCLawsActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private IPCAdapter adapter;
    private List<IPCItem> ipcList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ipc_laws);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        loadIPCData();
    }

    private void loadIPCData() {
        String jsonString = JSONHelper.loadJSONFromAsset(this, "ipc.json");

        if (jsonString == null) {
            Log.e("JSON_ERROR", "JSON file not found or empty!");
            return;
        }

        try {
            JSONArray jsonArray = new JSONArray(jsonString);
            ipcList.clear();

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                ipcList.add(IPCItem.fromJson(jsonObject));
            }

            adapter = new IPCAdapter(ipcList);
            recyclerView.setAdapter(adapter);

            Log.d("JSON_SUCCESS", "IPC Data Loaded Successfully!");

        } catch (JSONException e) {
            Log.e("JSON_ERROR", "Error parsing JSON", e);
        }
    }
}