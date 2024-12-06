package ua.joreikarr.todolistapp;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText editTextTask;
    private ListView listViewTasks;
    private List<String> tasks;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextTask = findViewById(R.id.editTextTask);
        listViewTasks = findViewById(R.id.listViewTasks);
        Button buttonAddTask = findViewById(R.id.buttonAddTask);

        tasks = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, tasks);
        listViewTasks.setAdapter(adapter);

        buttonAddTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String task = editTextTask.getText().toString();
                if (!task.isEmpty()) {
                    tasks.add(task);
                    adapter.notifyDataSetChanged();
                    editTextTask.setText("");
                }
            }
        });
    }
}
