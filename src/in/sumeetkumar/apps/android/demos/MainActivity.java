package in.sumeetkumar.apps.android.demos;
import java.util.ArrayList;

import android.os.Bundle;
import android.app.ListActivity;
import android.widget.ArrayAdapter;

public class MainActivity extends ListActivity {

	 protected static final String TAG = "RANGE_SEEKER";

	//LIST OF ARRAY STRINGS WHICH WILL SERVE AS LIST ITEMS
    ArrayList<String> listItems=new ArrayList<String>();

    //DEFINING STRING ADAPTER WHICH WILL HANDLE DATA OF LISTVIEW
    ArrayAdapter<String> adapter;

    //RECORDING HOW MUCH TIMES BUTTON WAS CLICKED
    int clickCounter=0;

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_main);
        
        listItems.add("Clicked : "+clickCounter++);
        
        adapter=new ArrayAdapter<String>(this,
            android.R.layout.simple_list_item_1,
            listItems);
        setListAdapter(adapter);
    }
}
